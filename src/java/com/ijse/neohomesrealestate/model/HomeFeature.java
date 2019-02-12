/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vinod
 */
@Entity
public class HomeFeature {
    
    private Integer homeFeatureId;
    private String description;

    private Advertistment advertistment;
    private Feature feature;
    /**
     * @return the homeFeatureId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getHomeFeatureId() {
        return homeFeatureId;
    }

    /**
     * @param homeFeatureId the homeFeatureId to set
     */
    public void setHomeFeatureId(Integer homeFeatureId) {
        this.homeFeatureId = homeFeatureId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public Advertistment getAdvertistment() {
        return advertistment;
    }

    public void setAdvertistment(Advertistment advertistment) {
        this.advertistment = advertistment;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
   
}
