/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.HomeFeatureDao;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.model.HomeFeature;
import com.ijse.neohomesrealestate.service.HomeFeatureService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class HomeFeatureServiceImpl implements HomeFeatureService {

    @Autowired
    private HomeFeatureDao homeFeatureDao;

    @Override
    public String saveHomeFeatures(List<HomeFeature> features) {

        Serializable save = homeFeatureDao.save(features);
        if (save != null) {
            return "true";
        } else {
            return "Something went Wrong";
        }
    }

    @Override
    public List<Integer> searchAdvFeature(List<Advertistment> advertistments, List<Feature> searchFeatures) {
        return homeFeatureDao.getAdvFeature(advertistments, searchFeatures);
    }

    @Override
    public List<HomeFeature> searchOneAdvFeature(Advertistment advertistment) {
        return homeFeatureDao.getOneAdvFeatures(advertistment);
    }

}
