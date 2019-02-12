/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.ImageDao;
import com.ijse.neohomesrealestate.model.Advertistment;
import com.ijse.neohomesrealestate.model.Image;
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
public class ImageDaoImpl implements ImageDao{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean save(List<Image> images) {
        int count = 0;
        try {
            for (Image img : images) {
                hibernateTemplate.save(img);
                count++;
            }
        } catch (Exception e) {
            return false;
        }
        
        if (images.size() == count) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Image> getAdvImages(Advertistment advertistment) {
        List<Image> findList = (List<Image>) hibernateTemplate.find("from Image where advertistment_advId in(?)",advertistment.getAdvId());
        return findList;
    }
    
}
