/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.model.Feature;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface FeatureDao {
    
    Serializable save(Feature feature);
    boolean delete(Feature feature);
    boolean update(Feature feature);
    List<Feature> find(String colomnName,List<String> values);
    List<Feature> getAll();
    
}
