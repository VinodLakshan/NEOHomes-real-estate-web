/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.service;

import com.ijse.neohomesrealestate.model.User;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
public interface UserService {

    public String saveUser(User user, MultipartFile file);

    public String updateUser(User user, MultipartFile file);

    public List<User> findUsers(String colomnName, Object value);

    public String checkLogin(User user);

    public String logOut();

    public boolean checkUserLogged();
    
    public byte[] previewProImg();

    public String changePass(String oldPass, String pass);

}
