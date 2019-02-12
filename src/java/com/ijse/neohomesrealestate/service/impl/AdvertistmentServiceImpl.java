/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.AdvertistmentDao;
import com.ijse.neohomesrealestate.dto.AdvertistmentDto;
import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.model.HomeFeature;
import com.ijse.neohomesrealestate.model.HomePartition;
import com.ijse.neohomesrealestate.model.Image;
import com.ijse.neohomesrealestate.model.Parts;
import com.ijse.neohomesrealestate.model.Payment;
import com.ijse.neohomesrealestate.model.User;
import com.ijse.neohomesrealestate.service.AdvertistmentService;
import com.ijse.neohomesrealestate.service.FeatureService;
import com.ijse.neohomesrealestate.service.HomeFeatureService;
import com.ijse.neohomesrealestate.service.HomePartitionService;
import com.ijse.neohomesrealestate.service.ImageService;
import com.ijse.neohomesrealestate.service.PartitionService;
import com.ijse.neohomesrealestate.service.PaymentService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.swing.JOptionPane;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class AdvertistmentServiceImpl implements AdvertistmentService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private PartitionService partitionService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private AdvertistmentDao advertistmentDao;

    @Autowired
    private HomePartitionService homePartitionService;

    @Autowired
    private HomeFeatureService homeFeatureService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ServletContext servletContext;

    private String today;

    @Override
    public String postAddStp1(Advertistment advertistment) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd");
            Date date = new Date();
            today = sdf.format(date);
            advertistment.setDate(today);

            User user = (User) request.getSession().getAttribute("loggedUser");
            advertistment.setUser(user);

            request.getSession().setAttribute("newAdvertistment", advertistment);
            return "true";
        } catch (Exception c) {
            return "Somethings Wrong";
        }
    }

    @Override
    public String cancelAdd() {
        request.getSession().setAttribute("newAdvertistment", null);
        request.getSession().setAttribute("newAdvParts", null);
        request.getSession().setAttribute("newAdvFeatures", null);
        request.getSession().setAttribute("newAdvImages", null);
        return "home";
    }

    @Override
    public String postAddStp2(Advertistment advertistment, List<Object> partitionList,
            List<Integer> partitionCount, List<String> partitionDesc, List<String> advFeatures,
            List<MultipartFile> advImgs) {

        try {
            if (partitionList.size() == partitionCount.size()) {
                Advertistment newAdvertistment = (Advertistment) request.getSession().getAttribute("newAdvertistment");
                newAdvertistment.setDescription(advertistment.getDescription());
                newAdvertistment.setBuildingAge(advertistment.getBuildingAge());

                List<HomePartition> newAdvPartitions = setPartitions(partitionList, partitionCount, partitionDesc);
                List<HomeFeature> newAdvFeatures = setFeatures(advFeatures);
                List<byte[]> multipartTobytees = multipartTobytees(advImgs);
                request.getSession().setAttribute("newAdvertistment", newAdvertistment);
                request.getSession().setAttribute("newAdvParts", newAdvPartitions);
                request.getSession().setAttribute("newAdvFeatures", newAdvFeatures);
                request.getSession().setAttribute("newAdvImages", multipartTobytees);
                return "true";
            } else {
                return "Complete all under Partition section";
            }
        } catch (Exception e) {
            return "Something went Wrong";
        }

    }

    private ArrayList<byte[]> multipartTobytees(List<MultipartFile> advImgs) {
        ArrayList<byte[]> imgBytes = new ArrayList<>();

        try {
            for (MultipartFile advImg : advImgs) {
                byte[] bytes = advImg.getBytes();
                imgBytes.add(bytes);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return imgBytes;
    }

    private List<HomePartition> setPartitions(List<Object> partitionList, List<Integer> partitionCount,
            List<String> partitionDesc) {
        List<Parts> findPartition = partitionService.findPartition("partsName", partitionList);
        List<HomePartition> homePartitions = new ArrayList<>();

        for (int i = 0; i < partitionList.size(); i++) {
            HomePartition homePartition = new HomePartition();
            homePartition.setPartition(findPartition.get(i));
            homePartition.setPartCount(partitionCount.get(i));

            if (!partitionDesc.isEmpty()) {
                homePartition.setDescription(partitionDesc.get(0));
                partitionDesc.remove(0);
            }
            homePartitions.add(homePartition);

        }

        return homePartitions;
    }

    private List<HomeFeature> setFeatures(List<String> featureList) {
        List<HomeFeature> advFeatures = new ArrayList<>();

        if (!featureList.isEmpty()) {
            List<Feature> findFeatures = featureService.findFeatures("featureName", featureList);
            for (Feature findFeature : findFeatures) {
                HomeFeature homeFeature = new HomeFeature();
                homeFeature.setFeature(findFeature);
                advFeatures.add(homeFeature);
            }
        }
        return advFeatures;
    }

    @Override
    public String postAddFinal() {
        Advertistment newAdvertistment = (Advertistment) request.getSession().getAttribute("newAdvertistment");
        List<HomePartition> newPartitions = (List<HomePartition>) request.getSession().getAttribute("newAdvParts");
        List<HomeFeature> newFeatures = (List<HomeFeature>) request.getSession().getAttribute("newAdvFeatures");

        Serializable save = advertistmentDao.save(newAdvertistment);

        if (save != null) {
            List<Advertistment> lastAdv = advertistmentDao.findNoOfAdvertistment(0, 1);

            for (HomePartition newPartition : newPartitions) {
                newPartition.setAdvertistment(lastAdv.get(0));
            }

            for (HomeFeature newFeature : newFeatures) {
                newFeature.setAdvertistment(lastAdv.get(0));
            }

            List<Payment> newPayments = paymentService.setPayment(lastAdv.get(0), today);

            List<Image> newImages = imageService.setImagestoFolder(lastAdv.get(0));

            String saveHomePartitions = homePartitionService.saveHomePartitions(newPartitions);
            String saveHomeFeatures = homeFeatureService.saveHomeFeatures(newFeatures);
            String savePayments = paymentService.savePayments(newPayments);
            String saveImages = imageService.saveImages(newImages);
            loadAdvs();

            String[] partNames = new String[newPartitions.size()];
            for (int i = 0; i < newPartitions.size(); i++) {
                partNames[i] = newPartitions.get(i).getPartition().getPartsName();
            }
            newAdvertistment.setHomeFeatureList(newFeatures);
            newAdvertistment.setHomePartitionList(newPartitions);
            request.getSession().setAttribute("clickedAdv", newAdvertistment);
            request.getSession().setAttribute("clickedAdvParts", partNames);
            request.getSession().setAttribute("newAdvertistment", null);
            request.getSession().setAttribute("newAdvParts", null);
            request.getSession().setAttribute("newAdvFeatures", null);
            request.getSession().setAttribute("newAdvImages", null);
            return "true";
        } else {
            return "Something went Wrong";
        }
    }

    @Override
    public List<AdvertistmentDto> loadAdvs() {
        List<Advertistment> lastAdv = advertistmentDao.findNoOfAdvertistment(0, 6);
        List<AdvertistmentDto> advertistmentDtos = new ArrayList<>();

        for (Advertistment advertistment : lastAdv) {
            AdvertistmentDto advertistmentDto = new AdvertistmentDto();
            List<Image> advImages = imageService.getAdvImages(advertistment);
            List<HomePartition> advPartitions = homePartitionService.getAdvPartitions(advertistment);
            List<byte[]> advImagesByte = imageService.getAdvImagesByte(advImages);

            advertistment.setHomePartitionList(advPartitions);
            advertistmentDto.setAdvertistment(advertistment);
            advertistmentDto.setImageList(advImagesByte);
            advertistmentDtos.add(advertistmentDto);
        }

        servletContext.setAttribute("sixAds", advertistmentDtos);
        return advertistmentDtos;
    }

    @Override
    public List<AdvertistmentDto> searchAds(SearchAdvertistment searchAdvertistment) {
        List<Advertistment> findAdvs = advertistmentDao.find(searchAdvertistment);
        List<Advertistment> foundAdvs = new ArrayList<>();

        request.getSession().setAttribute("searchedLoad", searchAdvertistment);
        if (!findAdvs.isEmpty()) {

            List<Integer> bedBath = new ArrayList<>();
            bedBath = homePartitionService.getBedBath(findAdvs, searchAdvertistment);
            List<Feature> findFeatures = featureService.findFeatures("featureName", searchAdvertistment.getFeatures());
            List<Integer> searchAdvFeature = new ArrayList<>();
            if (!findFeatures.isEmpty()) {
                searchAdvFeature = homeFeatureService.searchAdvFeature(findAdvs, findFeatures);
            }

            if (!searchAdvFeature.isEmpty()) {
                bedBath.retainAll(searchAdvFeature);
            }

            for (Integer integer : bedBath) {
                for (Advertistment findAdv : findAdvs) {
                    if (findAdv.getAdvId().equals(integer)) {
                        foundAdvs.add(findAdv);
                    }
                }
            }
        }

        List<AdvertistmentDto> ads = new ArrayList<>();
        for (Advertistment foundAdv : foundAdvs) {

            AdvertistmentDto dto = new AdvertistmentDto();
            foundAdv.setHomePartitionList(homePartitionService.getAdvPartitions(foundAdv));
            dto.setAdvertistment(foundAdv);
            ads.add(dto);

        }
        request.getSession().setAttribute("searchedAdvs", ads);
        return ads;
    }

    @Override
    public Advertistment searchOneAdv(Advertistment advertistment) {
        List<Advertistment> findAdvertistment = advertistmentDao.findAdvertistment("advId", advertistment.getAdvId());
        List<HomePartition> advPartitions = homePartitionService.getAdvPartitions(advertistment);
        List<HomeFeature> advFeature = homeFeatureService.searchOneAdvFeature(advertistment);
        List<Image> advImages = imageService.getAdvImages(advertistment);
        String[] partNames = new String[advPartitions.size()];

        for (int i = 0; i < advPartitions.size(); i++) {
            partNames[i] = advPartitions.get(i).getPartition().getPartsName();
        }

        findAdvertistment.get(0).setHomePartitionList(advPartitions);
        findAdvertistment.get(0).setHomeFeatureList(advFeature);
        findAdvertistment.get(0).setImageList(advImages);

        request.getSession().setAttribute("clickedAdv", findAdvertistment.get(0));
        request.getSession().setAttribute("clickedAdvParts", partNames);
        return findAdvertistment.get(0);
    }
}
