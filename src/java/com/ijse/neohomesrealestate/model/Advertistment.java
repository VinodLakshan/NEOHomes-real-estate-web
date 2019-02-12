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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author vinod
 */
@Entity
public class Advertistment {
    
    private Integer advId;
    private String title;
    private String description;
    private String date;
    private String type;
    private String saleType;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String buildingAge;
    private double area;
    private double price;
    
    private User user;
    private List<Payment> paymentList = new ArrayList<>();
    private List<Image> imageList = new ArrayList<>();
    private List<HomePartition> homePartitionList = new ArrayList<>();
    private List<HomeFeature> homeFeatureList = new ArrayList<>();
    /**
     * @return the advId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getAdvId() {
        return advId;
    }

    /**
     * @param advId the advId to set
     */
    public void setAdvId(Integer advId) {
        this.advId = advId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<HomePartition> getHomePartitionList() {
        return homePartitionList;
    }

    public void setHomePartitionList(List<HomePartition> homePartitionList) {
        this.homePartitionList = homePartitionList;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<HomeFeature> getHomeFeatureList() {
        return homeFeatureList;
    }

    public void setHomeFeatureList(List<HomeFeature> homeFeatureList) {
        this.homeFeatureList = homeFeatureList;
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
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the buildingAge
     */
    public String getBuildingAge() {
        return buildingAge;
    }

    /**
     * @param buildingAge the buildingAge to set
     */
    public void setBuildingAge(String buildingAge) {
        this.buildingAge = buildingAge;
    }


}
