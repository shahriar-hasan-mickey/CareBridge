/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.entities;

import java.sql.Timestamp;

/**
 *
 * @author akhlaq-aqidah
 */
public class CareTaker {
    private int cid;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String address;
    private Timestamp create_time;
    private String gender;
    private String profilePicture;

    public CareTaker(int cid, String username, String email, String password, String firstName, String lastName, String contactNo, String address, Timestamp create_time, String gender, String profilePicture) {
        this.cid = cid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.address = address;
        this.create_time = create_time;
        this.gender = gender;
        this.profilePicture = profilePicture;
    }

    public CareTaker(String username, String email, String password, String firstName, String lastName, String contactNo, String address, String gender, String profilePicture) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.address = address;
        this.gender = gender;
        this.profilePicture = profilePicture;
    }
    
    public CareTaker() {
    }

    

    public CareTaker(String username, String email, String password, String firstName, String lastName, String contactNo, String address, String gender) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.address = address;
        this.gender = gender;
    }
    
    
    
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    
}
