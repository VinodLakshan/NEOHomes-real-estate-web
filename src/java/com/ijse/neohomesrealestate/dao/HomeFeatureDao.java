/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.model.HomeFeature;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface HomeFeatureDao {

    boolean save(List<HomeFeature> features);

    List<Integer> getAdvFeature(List<Advertistment> advertistments, List<Feature> searchFeatures);
    
    List<HomeFeature> getOneAdvFeatures(Advertistment advertistment);
}
