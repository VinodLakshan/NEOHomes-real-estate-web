/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.model.Feature;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface FeatureService {
    
    public String saveFeature(Feature feature);
    public List<Feature> findFeatures(String colomnName,List<String> values);
    public String updateFeature(Feature feature);
    public List<Feature> getAllFeatures();
    
}
