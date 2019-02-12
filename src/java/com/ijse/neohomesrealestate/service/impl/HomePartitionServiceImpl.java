/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.HomePartitionDao;
import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.HomePartition;
import com.ijse.neohomesrealestate.service.HomePartitionService;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class HomePartitionServiceImpl implements HomePartitionService {

    @Autowired
    private HomePartitionDao homePartitionDao;

    @Override
    public String saveHomePartitions(List<HomePartition> partitions) {
        
        boolean save = homePartitionDao.save(partitions);
        if (save) {
            return "true";
        } else {
            return "Something went Wrong";
        }
    }

    @Override
    public List<HomePartition> getAdvPartitions(Advertistment advertistment) {
        return homePartitionDao.getAdvPartitions(advertistment);
    }

    @Override
    public List<Integer> getBedBath(List<Advertistment> advertistments,SearchAdvertistment advertistment) {
        return homePartitionDao.getBedBath(advertistments,advertistment.getBed(), advertistment.getBath());
    }

}
