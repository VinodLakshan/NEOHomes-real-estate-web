/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.FeatureDao;
import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.service.FeatureService;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService{

    @Autowired
    private FeatureDao featureDao;
    
    @Override
    public String saveFeature(Feature feature) {
        List<String> featureName = new ArrayList<>();
        featureName.add(feature.getFeatureName());
        List<Feature> find = findFeatures("featureName", featureName);
        
        if (find.isEmpty()) {
            Serializable save = featureDao.save(feature);
            if (save != null) {
                return "home";
            } else {
                return "Somethings went Wrong";
            }
        }else{
            return "Feature is already define";
        }
    }

    @Override
    public List<Feature> findFeatures(String colomnName, List<String> value) {
        if (value.isEmpty()) {
            value.add("");
        }
        return featureDao.find(colomnName, value);
    }

    @Override
    public String updateFeature(Feature feature) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Feature> getAllFeatures() {
        return featureDao.getAll();
    }
    
}
