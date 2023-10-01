/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.entities;

import java.sql.*;

/**
 *
 * @author akhlaq-aqidah
 */
public class Patient {
    
    private int pid;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String emergencyContact;
    private String address;
    private Timestamp create_time;
    private String gender;
    private String description;
    private String profilePicture;

    public Patient(int pid, String username, String email, String password, String firstName, String lastName, String emergencyContact, String address, Timestamp create_time, String gender, String description, String profilePicture) {
        this.pid = pid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.create_time = create_time;
        this.gender = gender;
        this.description = description;
        this.profilePicture = profilePicture;
    }

    public Patient(String username, String email, String password, String firstName, String lastName, String emergencyContact, String address, String gender, String description, String profilePicture) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.gender = gender;
        this.description = description;
        this.profilePicture = profilePicture;
    }

    public Patient(String username, String email, String password, String firstName, String lastName, String emergencyContact, String address, String gender, String description) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emergencyContact = emergencyContact;
        this.address = address;
        this.gender = gender;
        this.description = description;
    }

    
    
    public Patient() {
    }

    

    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    
}
