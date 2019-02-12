/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.PaymentDao;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Payment;
import com.ijse.neohomesrealestate.model.PaymentType;
import com.ijse.neohomesrealestate.service.PaymentService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;
    
    @Override
    public String savePayments(List<Payment> payments) {
        Serializable save = paymentDao.save(payments);

        if (save != null) {
            return "true";
        } else {
            return "Something went Wrong";
        }
    }

    @Override
    public List<Payment> setPayment(Advertistment lastAdv, String today) {
        PaymentType type = new PaymentType();
        type.setPaymentTypeId(1);
        type.setPaymentTypeName("Credit Card");

        Payment payment = new Payment();
        payment.setAdvertistment(lastAdv);
        payment.setAmount(2000);
        payment.setDate(today);
        payment.setReason("Advertistment initial");
        payment.setPaymentType(type);

        List<Payment> newPayments = new ArrayList<>();
        newPayments.add(payment);
        return newPayments;
    }

}
