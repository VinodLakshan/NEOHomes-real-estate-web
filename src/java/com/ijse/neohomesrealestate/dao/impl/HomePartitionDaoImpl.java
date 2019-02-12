/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.HomePartitionDao;
import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.HomePartition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinod
 */
@Repository
public class HomePartitionDaoImpl implements HomePartitionDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean save(List<HomePartition> parts) {
        int count = 0;
        try {
            for (HomePartition part : parts) {
                hibernateTemplate.save(part);
                count++;
            }
        } catch (Exception e) {
            return false;
        }

        if (parts.size() == count) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HomePartition> getAdvPartitions(Advertistment advertistment) {
        List<HomePartition> findList = (List<HomePartition>) hibernateTemplate.find("from HomePartition where advertistment_advId in(?)", advertistment.getAdvId());
        return findList;
    }

    @Override
    public List<Integer> getBedBath(List<Advertistment> findAdvs,int bedCount,int bathCount) {
        ArrayList<Integer> adIds = new ArrayList<>();
        String qM ="";
        for (Advertistment findAdv : findAdvs) {
           adIds.add(findAdv.getAdvId());
        }
        
        for (int i = 0; i < findAdvs.size()-1 ; i++) {
            qM += "?,";
        }
        qM += "?";

        List<HomePartition> findBeds = (List<HomePartition>) hibernateTemplate.find("from HomePartition where partition_partsId = 1 AND partCount >= "+bedCount+" AND advertistment_advId in ("+qM+")",adIds.toArray());
        List<HomePartition> findBaths = (List<HomePartition>) hibernateTemplate.find("from HomePartition where partition_partsId = 2 AND partCount >= "+bathCount+" AND advertistment_advId in ("+qM+")",adIds.toArray());
        
        adIds.removeAll(adIds);
        for (HomePartition findBed : findBeds) {
            for (HomePartition findBath : findBaths) {
                if (findBed.getAdvertistment().getAdvId().equals(findBath.getAdvertistment().getAdvId())) {
                    adIds.add(findBath.getAdvertistment().getAdvId());
                }
            }
        }
       return adIds;
    
    }

}
