/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.FeatureDao;
import com.ijse.neohomesrealestate.model.Feature;
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
public class FeatureDaoImpl implements FeatureDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public Serializable save(Feature feature) {
        return hibernateTemplate.save(feature);
    }

    @Override
    public boolean delete(Feature feature) {
        try{
            hibernateTemplate.delete(feature);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean update(Feature feature) {
        try{
            hibernateTemplate.update(feature);
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public List<Feature> find(String colomnName,List<String> value) {
        String qM = "";
        for (int i = 0; i < value.size()-1 ; i++) {
            qM += "?,";
        }
        qM += "?";
        
        List<Feature> findList = (List<Feature>) hibernateTemplate.find("from Feature where "+colomnName+" in("+ qM +")",value.toArray());
        return findList;
    }

    @Override
    public List<Feature> getAll() {
        return hibernateTemplate.loadAll(Feature.class);
    }
    
}
