/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.HomePartition;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface HomePartitionService {
    
    public String saveHomePartitions(List<HomePartition> partitions);
    
    public List<HomePartition> getAdvPartitions(Advertistment advertistment);
    
    public List<Integer> getBedBath(List<Advertistment> advertistments,SearchAdvertistment advertistment);
}
