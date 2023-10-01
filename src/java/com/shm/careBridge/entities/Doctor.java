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
public class Doctor {
    private int id;
    private String dusername;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String specialization;
    private String bio;
    private String affiliation;
    private String regNoMBBS;
    private Timestamp create_time;
    private String gender;
    private String profilePicture;
    private String fullName;

    public Doctor() {
    }
    
    public Doctor(int id, String dusername, String email, String firstName, String lastName, String address, String specialization, String bio, String affiliation, String regNoMBBS, Timestamp create_time, String gender, String profilePicture, String fullName) {
        this.id = id;
        this.dusername = dusername;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.specialization = specialization;
        this.bio = bio;
        this.affiliation = affiliation;
        this.regNoMBBS = regNoMBBS;
        this.create_time = create_time;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.fullName = fullName;
    }

    public Doctor(String dusername, String email, String password, String firstName, String lastName, String address, String specialization, String bio, String affiliation, String regNoMBBS, String gender, String profilePicture, String fullName) {
        this.dusername = dusername;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.specialization = specialization;
        this.bio = bio;
        this.affiliation = affiliation;
        this.regNoMBBS = regNoMBBS;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.fullName = fullName;
    }

    public Doctor(String dusername, String email, String password, String firstName, String lastName, String address, String specialization, String bio, String affiliation, String regNoMBBS, String gender) {
        this.dusername = dusername;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.specialization = specialization;
        this.bio = bio;
        this.affiliation = affiliation;
        this.regNoMBBS = regNoMBBS;
        this.gender = gender;
    }

    
    public Doctor(int id, String dusername, String email, String password, String firstName, String lastName, String address, String specialization, String bio, String affiliation, String regNoMBBS, Timestamp create_time, String gender, String profilePicture) {
        this.id = id;
        this.dusername = dusername;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.specialization = specialization;
        this.bio = bio;
        this.affiliation = affiliation;
        this.regNoMBBS = regNoMBBS;
        this.create_time = create_time;
        this.gender = gender;
        this.profilePicture = profilePicture;
    }
    
    
    public Doctor(int id, String dusername, String email, String password, String firstName, String lastName, String address, String specialization, String bio, String affiliation, String regNoMBBS, Timestamp create_time, String gender, String profilePicture, String fullName) {
        this.id = id;
        this.dusername = dusername;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.specialization = specialization;
        this.bio = bio;
        this.affiliation = affiliation;
        this.regNoMBBS = regNoMBBS;
        this.create_time = create_time;
        this.gender = gender;
        this.profilePicture = profilePicture;
        this.fullName = fullName;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDusername() {
        return dusername;
    }

    public void setDusername(String dusername) {
        this.dusername = dusername;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getRegNoMBBS() {
        return regNoMBBS;
    }

    public void setRegNoMBBS(String regNoMBBS) {
        this.regNoMBBS = regNoMBBS;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
}

   