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
public class Image {
    
    private Integer imgId;
    private String imgPath;

    private Advertistment advertistment;
    /**
     * @return the imgId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getImgId() {
        return imgId;
    }

    /**
     * @param imgId the imgId to set
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

   

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Advertistment getAdvertistment() {
        return advertistment;
    }

    public void setAdvertistment(Advertistment advertistment) {
        this.advertistment = advertistment;
    }

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
}
