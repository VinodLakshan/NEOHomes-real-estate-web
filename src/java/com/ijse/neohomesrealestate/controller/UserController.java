/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.controller;

import com.ijse.neohomesrealestate.model.User;
import com.ijse.neohomesrealestate.service.UserService;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vinod
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/saveUser"}, method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestParam(value = "txtName") String name,
            @RequestParam(value = "txtNic") String nic, @RequestParam(value = "txtUsername") String userName,
            @RequestParam(value = "txtGender") String gender, @RequestParam(value = "txtEmail") String email,
            @RequestParam(value = "txtAddress") String address, @RequestParam(value = "txtTelephone") String tel,
            @RequestParam(value = "txtPass1") String pass, @RequestParam("imgInput") MultipartFile file) {
        
        User user = new User();
        user.setName(name);
        user.setMyDesc("");
        user.setFacebook("");
        user.setTwitter("");
        user.setGoogleP("");
        user.setLinkedIn("");
        user.setNic(nic);
        user.setUserName(userName);
        user.setGender(gender);
        user.setEmail(email);
        user.setAddress(address);
        user.setTelephone(tel);
        user.setPass(pass);
        
        return new ResponseEntity<>(userService.saveUser(user, file),HttpStatus.OK);
    }

    @RequestMapping(value = {"/checkLogin"}, method = RequestMethod.POST)
    public ResponseEntity<?> checkLogin(@RequestParam(value = "txtUsernameLogin") String userName,
            @RequestParam(value = "txtPassLogin") String pass) {

        User user = new User();
        user.setUserName(userName);
        user.setPass(pass);
        return new ResponseEntity<>(userService.checkLogin(user), HttpStatus.OK);
    }

    @RequestMapping(value = {"/logOut"})
    public String checkLogin() {
        return userService.logOut();
    }

    public boolean checkUserLogged() {
        return userService.checkUserLogged();
    }

    @RequestMapping(value = {"/changePass"}, method = RequestMethod.POST)
    public ResponseEntity<?> changePass(@RequestParam(value = "txtOldPass") String oldPass,
            @RequestParam(value = "txtPass1") String pass) {

        return new ResponseEntity<>(userService.changePass(oldPass, pass), HttpStatus.OK);
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestParam(value = "txtUpdateName") String name,
            @RequestParam(value = "txtUpdateNic") String nic, @RequestParam(value = "txtUpdateTp") String tp,
            @RequestParam(value = "txtUpdateAddress") String address, @RequestParam(value = "txtUpdateEmail") String email,
            @RequestParam(value = "txtUpdateDesc") String myDesc, @RequestParam(value = "txtUpdateTw") String tw,
            @RequestParam(value = "txtUpdateFb") String fb, @RequestParam(value = "txtUpdateGp") String gp,
            @RequestParam(value = "txtUpdateLi") String li, @RequestParam("txtUpdateProImg") MultipartFile file) {
        
        User user = new User();
        user.setName(name);
        user.setNic(nic);
        user.setTelephone(tp);
        user.setAddress(address);
        user.setEmail(email);
        user.setMyDesc(myDesc);
        user.setTwitter(tw);
        user.setFacebook(fb);
        user.setGoogleP(gp);
        user.setLinkedIn(li);

        return new ResponseEntity<>(userService.updateUser(user,file), HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/previewProImg"}, method = RequestMethod.POST)
    public @ResponseBody byte[] previewProImg() {
        return userService.previewProImg();
    }
}
