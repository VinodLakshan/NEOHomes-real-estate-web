/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.dao.impl;

import com.ijse.neohomesrealestate.dao.AdvertistmentDao;
import com.ijse.neohomesrealestate.dto.SearchAdvertistment;
import com.ijse.neohomesrealestate.model.Advertistment;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinod
 */
@Repository
public class AdvertistmentDaoImpl implements AdvertistmentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Serializable save(Advertistment advertistment) {
        return hibernateTemplate.save(advertistment);
    }

    @Override
    public boolean delete(Advertistment advertistment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Advertistment advertistment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Advertistment> find(SearchAdvertistment advertistment) {
        List<Advertistment> findList = (List<Advertistment>) hibernateTemplate.find("from Advertistment where saleType like(?) AND type like(?) AND state like(?) AND city like(?) AND"
                + " area >= '" + advertistment.getLowArea() + "' AND area <='" + advertistment.getHighArea() + "' AND "
                + "price BETWEEN '" + advertistment.getLowPrice() + "' AND '" + advertistment.getHighPrice() + "'",
                advertistment.getSaleType(), advertistment.getType(), advertistment.getState(), advertistment.getCity());
        
        return findList;
    }

    @Override
    public List<Advertistment> findNoOfAdvertistment(int bottom, int top) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Advertistment.class);
        criteria.addOrder(Order.desc("advId"));
        List<Advertistment> lastAdv = (List<Advertistment>) hibernateTemplate.findByCriteria(criteria, bottom, top);
        return lastAdv;
    }

    @Override
    public List<Advertistment> findAdvertistment(String colomnName,Object object) {
        List<Advertistment> findList = (List<Advertistment>) hibernateTemplate.find("from Advertistment where " + colomnName + " in(?)", object);
        return findList;
    }

}
