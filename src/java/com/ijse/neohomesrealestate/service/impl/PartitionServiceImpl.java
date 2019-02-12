/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.PartitionDao;
import com.ijse.neohomesrealestate.model.Parts;
import com.ijse.neohomesrealestate.service.PartitionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class PartitionServiceImpl implements PartitionService{

    @Autowired
    private PartitionDao partitionDao;
    
    @Override
    public String savePartition(Parts partition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Parts> findPartition(String colomnName, List<Object> value) {
        return partitionDao.find(colomnName, value);
    }

    @Override
    public String updatePartition(Parts partition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Parts> getAllPartition() {
        return partitionDao.getAll();
    }
    
}
