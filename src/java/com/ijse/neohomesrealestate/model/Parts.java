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
public class Parts {
    
    private Integer partsId;
    private String partsName;

    private List<HomePartition> homePartitionList = new ArrayList<>();
    
    

    @OneToMany(cascade = CascadeType.ALL)
    public List<HomePartition> getHomePartitionList() {
        return homePartitionList;
    }

    public void setHomePartitionList(List<HomePartition> homePartitionList) {
        this.homePartitionList = homePartitionList;
    }

    /**
     * @return the partsId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getPartsId() {
        return partsId;
    }

    /**
     * @param partsId the partsId to set
     */
    public void setPartsId(Integer partsId) {
        this.partsId = partsId;
    }

    /**
     * @return the partsName
     */
    public String getPartsName() {
        return partsName;
    }

    /**
     * @param partsName the partsName to set
     */
    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    
}
