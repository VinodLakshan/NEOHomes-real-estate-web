/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.neohomesrealestate.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vinod
 */
@Entity
public class User {
    
    private Integer userId;
    private String name;
    private String myDesc;
    private String nic;
    private String gender;
    private String email;
    private String address;
    private String telephone;
    private String userName;
    private String pass;
    private String imgPath;
    private String twitter;
    private String facebook;
    private String googleP;
    private String linkedIn;

    private List<Advertistment> advertistmentList = new ArrayList<>();
    /**
     * @return the userId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<Advertistment> getadvertistmentList() {
        return advertistmentList;
    }

    public void setadvertistmentList(List<Advertistment> advertistmentList) {
        this.advertistmentList = advertistmentList;
    }

    /**
     * @return the myDesc
     */
    public String getMyDesc() {
        return myDesc;
    }

    /**
     * @param myDesc the myDesc to set
     */
    public void setMyDesc(String myDesc) {
        this.myDesc = myDesc;
    }

    /**
     * @return the twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * @param twitter the twitter to set
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * @return the facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * @return the googleP
     */
    public String getGoogleP() {
        return googleP;
    }

    /**
     * @param googleP the googleP to set
     */
    public void setGoogleP(String googleP) {
        this.googleP = googleP;
    }

    /**
     * @return the linkedIn
     */
    public String getLinkedIn() {
        return linkedIn;
    }

    /**
     * @param linkedIn the linkedIn to set
     */
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    } 

    /**
     * @return the imgPath
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
}
