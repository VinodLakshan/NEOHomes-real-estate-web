/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.model.Parts;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface PartitionService {
    
    public String savePartition(Parts partition);
    public List<Parts> findPartition(String colomnName,List<Object> value);
    public String updatePartition(Parts partition);
    public List<Parts> getAllPartition();

}
