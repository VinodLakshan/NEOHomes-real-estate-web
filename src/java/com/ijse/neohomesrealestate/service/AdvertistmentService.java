/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.dto.AdvertistmentDto;
import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
public interface AdvertistmentService {

    public String postAddStp1(Advertistment advertistment);

    public String postAddStp2(Advertistment advertistment, List<Object> partitionList, List<Integer> partitionCount,
            List<String> partitionDesc, List<String> advFeatures, List<MultipartFile> advImgs);

    public String postAddFinal();

    public List<AdvertistmentDto> loadAdvs();

    public String cancelAdd();

    public List<AdvertistmentDto> searchAds(SearchAdvertistment searchAdvertistment);
    
    public Advertistment searchOneAdv(Advertistment advertistment);
}
