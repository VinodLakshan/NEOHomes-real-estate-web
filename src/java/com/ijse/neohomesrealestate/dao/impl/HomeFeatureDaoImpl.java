/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.HomeFeatureDao;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.model.HomeFeature;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinod
 */
@Repository
public class HomeFeatureDaoImpl implements HomeFeatureDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public boolean save(List<HomeFeature> features) {
        int count = 0;
        try {
            for (HomeFeature feature : features) {
                hibernateTemplate.save(feature);
                count++;
            }
        } catch (Exception e) {
            return false;
        }
        
        if (features.size() == count) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Integer> getAdvFeature(List<Advertistment> advertistments, List<Feature> searchFeatures) {
        ArrayList<Integer> feIds = new ArrayList<>();
        String qM ="";
        for (Feature feature : searchFeatures) {
           feIds.add(feature.getFeatureId());
        }
        
        for (int i = 0; i < searchFeatures.size()-1 ; i++) {
            qM += "?,";
        }
        qM += "?";
        
        List<HomeFeature> findFeature = (List<HomeFeature>) hibernateTemplate.find("from HomeFeature where feature_featureId in ("+qM+") GROUP BY advertistment_advId",feIds.toArray());
        feIds.removeAll(feIds);
        
        for (HomeFeature homeFeature : findFeature) {
            feIds.add(homeFeature.getAdvertistment().getAdvId());
        }
        return feIds;
    }

    @Override
    public List<HomeFeature> getOneAdvFeatures(Advertistment advertistment) {
        List<HomeFeature> findList = (List<HomeFeature>) hibernateTemplate.find("from HomeFeature where advertistment_advId in(?)", advertistment.getAdvId());
        return findList;
    }
    
}
