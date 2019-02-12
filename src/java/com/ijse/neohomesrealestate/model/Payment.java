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
public class Payment {
    
    private Integer payId;
    private String reason;
    private String date;
    private double amount;
    
    private Advertistment advertistment;
    private PaymentType paymentType;

    /**
     * @return the payId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getPayId() {
        return payId;
    }

    /**
     * @param payId the payId to set
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Advertistment getAdvertistment() {
        return advertistment;
    }

    public void setAdvertistment(Advertistment advertistment) {
        this.advertistment = advertistment;
    }

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
 
}
