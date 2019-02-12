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
public class PaymentType {
    
    private Integer paymentTypeId;
    private String paymentTypeName;

    private List<Payment> paymentList = new ArrayList<>();
    /**
     * @return the paymentTypeId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    /**
     * @param paymentTypeId the paymentTypeId to set
     */
    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    /**
     * @return the paymentTypeName
     */
    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    /**
     * @param paymentTypeName the paymentTypeName to set
     */
    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
    
}
