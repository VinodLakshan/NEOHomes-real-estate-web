/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.model.Parts;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface PartitionDao {
    
    Serializable save(Parts partitions);
    boolean delete(Parts partition);
    boolean update(Parts partition);
    List<Parts> find(String colomnName,List<Object> value);
    List<Parts> getAll();
    
}
