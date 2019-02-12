/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.model.HomeFeature;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface HomeFeatureService {

    public String saveHomeFeatures(List<HomeFeature> features);

    public List<Integer> searchAdvFeature(List<Advertistment> advertistments, List<Feature> searchFeatures);

    public List<HomeFeature> searchOneAdvFeature(Advertistment advertistment);
}
