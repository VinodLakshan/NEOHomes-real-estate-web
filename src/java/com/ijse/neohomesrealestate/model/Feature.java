/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vinod
 */
@Entity
public class Feature {
    
    private Integer featureId;
    private String featureName;

    private List<HomeFeature> homeFeatureList = new ArrayList<>();
    
    /**
     * @return the featureId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getFeatureId() {
        return featureId;
    }

    /**
     * @param featureId the featureId to set
     */
    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    /**
     * @return the featureName
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * @param featureName the featureName to set
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<HomeFeature> getHomeFeatureList() {
        return homeFeatureList;
    }

    public void setHomeFeatureList(List<HomeFeature> homeFeatureList) {
        this.homeFeatureList = homeFeatureList;
    }

    
}
