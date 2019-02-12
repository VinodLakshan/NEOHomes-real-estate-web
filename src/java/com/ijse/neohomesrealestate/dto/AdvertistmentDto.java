/*
 * To change this license header, choose License Headers in Project Properties.++5689
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dto;

import com.ijse.neohomesrealestate.model.Advertistment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinod
 */
public class AdvertistmentDto {
    
    
    private Advertistment advertistment;
    private List<byte[]> imageList = new ArrayList<>();

    /**
     * @return the advertistment
     */
    public Advertistment getAdvertistment() {
        return advertistment;
    }

    /**
     * @param advertistment the advertistment to set
     */
    public void setAdvertistment(Advertistment advertistment) {
        this.advertistment = advertistment;
    }

    /**
     * @return the imageList
     */
    public List<byte[]> getImageList() {
        return imageList;
    }

    /**
     * @param imageList the imageList to set
     */
    public void setImageList(List<byte[]> imageList) {
        this.imageList = imageList;
    }
    
    
}
