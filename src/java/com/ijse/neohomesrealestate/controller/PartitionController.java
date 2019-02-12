/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.controller;

import com.google.gson.Gson;
import com.ijse.neohomesrealestate.model.Parts;
import com.ijse.neohomesrealestate.service.PartitionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vinod
 */
@Controller
public class PartitionController {

    @Autowired
    private PartitionService partitionService;

    @RequestMapping(value = {"/getAllPartition"}, method = RequestMethod.POST)
    public ResponseEntity<?> getAllPartition() {

        List<Parts> allPartition = partitionService.getAllPartition();
        Object[][] array = new Object[allPartition.size()][2];
        Gson gson = new Gson();
        int count =0;
        for (Parts parts : allPartition) {
                array[count][0] = parts.getPartsId();
                array[count][1] = parts.getPartsName();
                count++;
        }
        return new ResponseEntity<>(gson.toJson(array), HttpStatus.OK);
    }
}
