/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.HomePartition;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface HomePartitionDao {

    boolean save(List<HomePartition> parts);

    List<HomePartition> getAdvPartitions(Advertistment advertistment);
    
    List<Integer> getBedBath(List<Advertistment> findAdvs,int bedCount,int bathCount);
}
