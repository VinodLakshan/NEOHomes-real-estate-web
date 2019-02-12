/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao;

import com.ijse.neohomesrealestate.model.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinod
 */
public interface UserDao {
    
    Serializable save(User user);
    boolean delete(User user);
    boolean update(User user);
    List<User> find(String colomnName, Object value);
    List<User> getAll();
}
