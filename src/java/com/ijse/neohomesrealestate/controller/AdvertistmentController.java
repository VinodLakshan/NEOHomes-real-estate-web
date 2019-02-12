/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.controller;

import com.ijse.neohomesrealestate.dto.AdvertistmentDto;
import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.service.AdvertistmentService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
@Controller
public class AdvertistmentController {

    @Autowired
    private AdvertistmentService advertistmentService;

    @RequestMapping(value = {"/postAddStep1"})
    public ResponseEntity<?> postAddStep1(@RequestParam(value = "txtPropertyTitle") String title,
            @RequestParam(value = "txtSaleType") String saleType, @RequestParam(value = "txtPropertyType") String propertyType,
            @RequestParam(value = "txtPrice") String price, @RequestParam(value = "txtArea") String area,
            @RequestParam(value = "txtAddress") String address, @RequestParam(value = "txtCity") String city,
            @RequestParam(value = "txtState") String state, @RequestParam(value = "txtZip") String zip) {

        Advertistment advertistment = new Advertistment();
        advertistment.setTitle(title);
        advertistment.setSaleType(saleType);
        advertistment.setType(propertyType);
        advertistment.setPrice(Double.parseDouble(price));
        advertistment.setArea(Double.parseDouble(area));
        advertistment.setAddress(address);
        advertistment.setCity(city);
        advertistment.setState(state);
        advertistment.setZip(zip);

        return new ResponseEntity<>(advertistmentService.postAddStp1(advertistment), HttpStatus.OK);
    }

    @RequestMapping(value = {"/cancelAdd"})
    private String cancelAdd() {
        return advertistmentService.cancelAdd();
    }

    @RequestMapping(value = {"/postAddStep2"})
    public ResponseEntity<?> postAddStep2(@RequestParam(value = "txtDesc") String desc,
            @RequestParam(value = "txtBAge") String bAge, @RequestParam(value = "cbFeatures") ArrayList<String> advFeatures,
            @RequestParam(value = "txtPartitionType") ArrayList<Object> partitionTypes, @RequestParam(value = "txtPartitionCount") ArrayList<Integer> partitionCount,
            @RequestParam(value = "txtPartitionDesc") ArrayList<String> partitionDesc, @RequestParam(value = "imgInput") ArrayList<MultipartFile> imgs) {

        partitionTypes.add(0, "Bed Rooms");
        partitionTypes.add(1, "Bath Rooms");
        partitionDesc.add(0, " ");
        partitionDesc.add(1, " ");
        advFeatures.remove(0);

        Advertistment advertistment = new Advertistment();
        advertistment.setDescription(desc);
        advertistment.setBuildingAge(bAge);

        String res = advertistmentService.postAddStp2(advertistment, partitionTypes, partitionCount, partitionDesc, advFeatures, imgs);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = {"/loadAdvs"})
    public ResponseEntity<?> loadAdvertistments() {
        return new ResponseEntity<>(advertistmentService.loadAdvs(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/postAddFinal"})
    public String postAddFinal() {
        return advertistmentService.postAddFinal();
    }

    @RequestMapping(value = {"/searchAdd"})
    public ResponseEntity<?> SearchAdd(@RequestParam(value = "tab") String saleType, @RequestParam(value = "txtSearchCity") String searchCity,
            @RequestParam(value = "txtSearchType") String searchType, @RequestParam(value = "txtSearchBed") String searchBed,
            @RequestParam(value = "txtSearchBath") String searchBath, @RequestParam(value = "searchFeature") ArrayList<String> searchFeatureList,
            @RequestParam(value = "txtPrice") ArrayList<String> searchPrice, @RequestParam(value = "txtArea") ArrayList<String> searchArea,
            @RequestParam(value = "txtSearchState") String searchState) {

        searchFeatureList.remove(0);
        SearchAdvertistment searchAdv = new SearchAdvertistment();

        searchAdv.setSaleType("%" + saleType + "%");
        searchAdv.setState("%" + searchState + "%");
        searchAdv.setCity("%" + searchCity + "%");
        searchAdv.setType("%" + searchType + "%");
        searchAdv.setBed(Integer.parseInt(searchBed));
        searchAdv.setBath(Integer.parseInt(searchBath));

        int lowPrice = Integer.parseInt(searchPrice.get(0).replaceAll("[$,]", ""));
        int highPrice = Integer.parseInt(searchPrice.get(1).replaceAll("[$,]", ""));
        searchAdv.setLowPrice(lowPrice);
        searchAdv.setHighPrice(highPrice);

        int lowArea = Integer.parseInt(searchArea.get(0).replaceAll("[sq ft]", ""));
        int highArea = Integer.parseInt(searchArea.get(1).replaceAll("[sq ft]", ""));
        searchAdv.setLowArea(lowArea);
        searchAdv.setHighArea(highArea);

        searchAdv.setFeatures(searchFeatureList);
        List<AdvertistmentDto> searchAds = advertistmentService.searchAds(searchAdv);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/viewAdd"})
    public ResponseEntity<?> viewAdd(@RequestParam(value = "id")String id) {
        Advertistment advertistment = new Advertistment();
        advertistment.setAdvId(Integer.parseInt(id));
        
        Advertistment searchOneAdv = advertistmentService.searchOneAdv(advertistment);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
