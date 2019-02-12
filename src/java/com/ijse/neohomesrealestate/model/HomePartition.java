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
public class HomePartition {

    private Integer homePartitionId;
    private String description;
    private Integer partCount;
     
    private Advertistment advertistment;
    private Parts partition;
    
    /**
     * @return the homePartitionId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getHomePartitionId() {
        return homePartitionId;
    }

    /**
     * @param homePartitionId the homePartitionId to set
     */
    public void setHomePartitionId(Integer homePartitionId) {
        this.homePartitionId = homePartitionId;
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

    /**
     * @return the partCount
     */
    public Integer getPartCount() {
        return partCount;
    }

    /**
     * @param partCount the area to set
     */
    public void setPartCount(Integer partCount) {
        this.partCount = partCount;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Advertistment getAdvertistment() {
        return advertistment;
    }

    public void setAdvertistment(Advertistment advertistment) {
        this.advertistment = advertistment;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Parts getPartition() {
        return partition;
    }

    public void setPartition(Parts partition) {
        this.partition = partition;
    }

}
