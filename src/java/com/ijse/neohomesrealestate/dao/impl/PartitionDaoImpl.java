/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.PartitionDao;
import com.ijse.neohomesrealestate.model.Parts;
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
public class PartitionDaoImpl implements PartitionDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public Serializable save(Parts partition) {
        return hibernateTemplate.save(partition);
    }

    @Override
    public boolean delete(Parts partition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Parts partition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Parts> find(String colomnName, List<Object> value) {
        String qM = "";
        for (int i = 0; i < value.size()-1 ; i++) {
            qM += "?,";
        }
        qM += "?";
        List<Parts> findList = (List<Parts>) hibernateTemplate.find("from Parts where " + colomnName + " in("+qM+")", value.toArray());
        return findList;
    }

    @Override
    public List<Parts> getAll() {
        return hibernateTemplate.loadAll(Parts.class);
    }
    
    
}
