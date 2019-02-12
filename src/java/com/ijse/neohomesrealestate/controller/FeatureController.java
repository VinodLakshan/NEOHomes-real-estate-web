/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.controller;

import com.ijse.neohomesrealestate.model.Feature;
import com.ijse.neohomesrealestate.service.FeatureService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vinod
 */
@Controller
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @Autowired
    private HttpServletRequest request;
    
    @RequestMapping(value = {"/getAllFeatures"}, method = RequestMethod.GET)
    public void getAllFeatures() {
        ArrayList<Feature> allFeatures = (ArrayList<Feature>) featureService.getAllFeatures();
        request.getSession().setAttribute("featureList", allFeatures);

    }
}
