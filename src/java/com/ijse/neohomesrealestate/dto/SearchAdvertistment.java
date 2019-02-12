/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dto;

import java.util.List;

/**
 *
 * @author vinod
 */
public class SearchAdvertistment {
    
    private String saleType;
    private String type;
    private String state;
    private String city;
    private int bed;
    private int bath;
    private int lowPrice;
    private int highPrice;
    private int lowArea;
    private int highArea;
    private List<String> features;

    /**
     * @return the saleType
     */
    public String getSaleType() {
        return saleType;
    }

    /**
     * @param saleType the saleType to set
     */
    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the bed
     */
    public int getBed() {
        return bed;
    }

    /**
     * @param bed the bed to set
     */
    public void setBed(int bed) {
        this.bed = bed;
    }

    /**
     * @return the bath
     */
    public int getBath() {
        return bath;
    }

    /**
     * @param bath the bath to set
     */
    public void setBath(int bath) {
        this.bath = bath;
    }

    /**
     * @return the lowPrice
     */
    public int getLowPrice() {
        return lowPrice;
    }

    /**
     * @param lowPrice the lowPrice to set
     */
    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * @return the highPrice
     */
    public int getHighPrice() {
        return highPrice;
    }

    /**
     * @param highPrice the highPrice to set
     */
    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    /**
     * @return the lowArea
     */
    public int getLowArea() {
        return lowArea;
    }

    /**
     * @param lowArea the lowArea to set
     */
    public void setLowArea(int lowArea) {
        this.lowArea = lowArea;
    }

    /**
     * @return the highArea
     */
    public int getHighArea() {
        return highArea;
    }

    /**
     * @param highArea the highArea to set
     */
    public void setHighArea(int highArea) {
        this.highArea = highArea;
    }

    /**
     * @return the features
     */
    public List<String> getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(List<String> features) {
        this.features = features;
    }
    
}
