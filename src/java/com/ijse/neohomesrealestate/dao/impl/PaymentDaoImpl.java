/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.PaymentDao;
import com.ijse.neohomesrealestate.model.Payment;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinod
 */
@Repository
public class PaymentDaoImpl implements PaymentDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean save(List<Payment> payments) {
        int count = 0;
        try {
            for (Payment pay : payments) {
                hibernateTemplate.save(pay);
                count++;
            }
        } catch (Exception e) {
            return false;
        }
        
        if (payments.size() == count) {
            return true;
        }else{
            return false;
        }
    }
    
}
