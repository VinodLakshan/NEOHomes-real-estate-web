/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Payment;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface PaymentService {
    
    public String savePayments(List<Payment> payments);
    
    public List<Payment> setPayment(Advertistment lastAdv, String today);
}
