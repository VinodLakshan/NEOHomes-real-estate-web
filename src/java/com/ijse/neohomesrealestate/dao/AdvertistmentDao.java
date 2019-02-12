/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface AdvertistmentDao {

    Serializable save(Advertistment advertistment);

    boolean delete(Advertistment advertistment);

    boolean update(Advertistment advertistment);

    List<Advertistment> find(SearchAdvertistment searchAdvertistment);
    
    List<Advertistment> findNoOfAdvertistment(int bottom,int top);

    List<Advertistment> findAdvertistment(String colomnName,Object object);
}
