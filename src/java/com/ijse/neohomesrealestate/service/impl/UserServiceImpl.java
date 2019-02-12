/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service.impl;

import com.ijse.neohomesrealestate.dao.UserDao;
import com.ijse.neohomesrealestate.model.User;
import com.ijse.neohomesrealestate.service.ImageService;
import com.ijse.neohomesrealestate.service.UserService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ImageService imageService;
    
    @Autowired
    private HttpServletRequest request;

    @Override
    public String saveUser(User user, MultipartFile file) {
        List<User> findUser = findUsers("userName", user.getUserName());

        if (findUser.isEmpty()) {
            try {
                user.setImgPath(imageService.saveProImg(file, user.getUserName()));
            } catch (IOException ex) {
                return "Somethings went Wrong";
            }

            Serializable save = userDao.save(user);

            if (save != null) {
                request.getSession().setAttribute("loggedUser", user);
                return "true";
            } else {
                return "Somethings went Wrong";
            }

        } else {
            return "Username is not available";
        }

    }

    

    @Override
    public List<User> findUsers(String colomnName, Object value) {
        return userDao.find(colomnName, value);
    }

    @Override
    public String checkLogin(User user) {
        List<User> find = findUsers("userName", user.getUserName());
        if (!find.isEmpty()) {
            if (find.get(0).getPass().equals(user.getPass())) {
                request.getSession().setAttribute("loggedUser", find.get(0));
                return "true";
            }
        }
        return "false";
    }

    @Override
    public String logOut() {
        request.getSession().setAttribute("loggedUser", null);
        return "home";
    }

    @Override
    public boolean checkUserLogged() {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String changePass(String oldPass, String pass) {
        User user = (User) request.getSession().getAttribute("loggedUser");

        if (user.getPass().equals(oldPass)) {
            user.setPass(pass);
            boolean isUpdate = userDao.update(user);
            request.getSession().setAttribute("loggedUser", user);

            if (isUpdate) {
                return "passChanged";
            } else {
                return "Something went wrong";
            }
        } else {
            return "Current password did't match";
        }
    }

    @Override
    public String updateUser(User user, MultipartFile file) {
        User updateUser = (User) request.getSession().getAttribute("loggedUser");
        
        updateUser.setName(user.getName());
        updateUser.setNic(user.getNic());
        updateUser.setTelephone(user.getTelephone());
        updateUser.setAddress(user.getAddress());
        updateUser.setEmail(user.getEmail());
        updateUser.setMyDesc(user.getMyDesc());
        updateUser.setTwitter(user.getTwitter());
        updateUser.setFacebook(user.getFacebook());
        updateUser.setGoogleP(user.getGoogleP());
        updateUser.setLinkedIn(user.getLinkedIn());
        
        try {
            updateUser.setImgPath(imageService.saveProImg(file, user.getUserName()));
        } catch (IOException ex) {
            return "Something went Wrong";
        }
        
        updateUser.setUserId(updateUser.getUserId());

        if (userDao.update(updateUser)) {
            return "Details Updated";
        } else {
            return "Something went Wrong";
        }
    }

    @Override
    public byte[] previewProImg() {
        return imageService.previewProImg();
    }
    
}
