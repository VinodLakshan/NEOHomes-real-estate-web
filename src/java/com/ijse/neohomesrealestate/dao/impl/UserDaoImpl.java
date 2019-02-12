/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.UserDao;
import com.ijse.neohomesrealestate.model.User;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinod
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Serializable save(User user) {
        return hibernateTemplate.save(user);
    }

    @Override
    public boolean delete(User user) {
        try {
            hibernateTemplate.delete(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean update(User user) {
        try {
            hibernateTemplate.update(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<User> find(String colomnName, Object value) {
        List<User> findList = (List<User>) hibernateTemplate.find("from User where " + colomnName + " in(?)", value);
        return findList;
    }

    @Override
    public List<User> getAll() {
        return hibernateTemplate.loadAll(User.class);
    }

}
