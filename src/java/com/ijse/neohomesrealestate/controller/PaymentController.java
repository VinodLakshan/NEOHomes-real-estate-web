/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinod
 */
@Controller
public class PaymentController {
    
    @Autowired
    private AdvertistmentController advertistmentController;
    
    @RequestMapping(value = {"/advPayment"})
    public ResponseEntity<?> advPayment(){
        return new ResponseEntity<>(advertistmentController.postAddFinal(),HttpStatus.OK);
    }
}
