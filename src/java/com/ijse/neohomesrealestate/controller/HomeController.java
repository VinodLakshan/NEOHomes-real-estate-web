/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinod
 */
@Controller
public class HomeController {

    @Autowired
    private UserController userController;

    @Autowired
    private HttpServletRequest servletRequest;

    @RequestMapping(value = {"/home"})
    private String viewHome() {
        return "home";
    }

    @RequestMapping(value = {"/login-register"})
    private String viewLoginRegister() {
        boolean checkUserLogged = userController.checkUserLogged();
        if (!checkUserLogged) {
            return "login-register";
        } else {
            return "my-profile";
        }
    }
    
    @RequestMapping(value = {"/subProp-login"})
    private String viewSubmitPropertyLogin() {
        boolean checkUserLogged = userController.checkUserLogged();
        if (!checkUserLogged) {
            return "login-register";
        } else {
            return "submit-property";
        }
    }

    @RequestMapping(value = {"/my-profile"})
    private String showProfile() {
        return "my-profile";
    }

    @RequestMapping(value = {"/pay"})
    private String showPay() {
        return "payment";
    }
    
    @RequestMapping(value = {"/submit-property"})
    private String viewSubmitProperty() {
        return "submit-property";
    }

    @RequestMapping(value = {"/submit-property2"})
    private String viewSubmitProperty2() {
        return "submit-property_1";
    }

    @RequestMapping(value = {"/search-results"})
    private String viewSearchResults() {
        return "search-results";
    }

    @RequestMapping(value = {"/change-pw"})
    private String viewChangePw() {
        boolean checkUserLogged = userController.checkUserLogged();
        if (!checkUserLogged) {
            return "login-register";
        } else {
            return "change-password";
        }
    }

    @RequestMapping(value = {"/single-property"})
    private String viewSelectedProperty() {
        return "single-property";
    }

    @RequestMapping(value = {"/contact"})
    private String viewContactPage() {
        return "contact";
    }
    
}
