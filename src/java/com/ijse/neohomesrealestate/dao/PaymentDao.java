/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.model.Payment;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface PaymentDao {

    boolean save(List<Payment> payments);
}
