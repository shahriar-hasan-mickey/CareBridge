/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.dao;

import com.shm.careBridge.entities.Doctor;
//import com.shm.careBridge.entities.doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akhlaq-aqidah
 */
public class DoctorDao {

    private Connection connection;

    public DoctorDao(Connection connection) {
        this.connection = connection;
    }

    public boolean saveDoctor(Doctor doctor) {
        boolean hasQueryExecutedSuccesfully = false;
        try {
            String query = "INSERT INTO Doctor(dusername, email, password, firstName, lastName, address, specialization, bio, affiliation, regNoMBBS, gender, profilePicture, fullName) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, doctor.getDusername());
            preparedStatement.setString(2, doctor.getEmail());
            preparedStatement.setString(3, doctor.getPassword());
            preparedStatement.setString(4, doctor.getFirstName());
            preparedStatement.setString(5, doctor.getLastName());
            preparedStatement.setString(6, doctor.getAddress());
            preparedStatement.setString(7, doctor.getSpecialization());
            preparedStatement.setString(8, doctor.getBio());
            preparedStatement.setString(9, doctor.getAffiliation());
            preparedStatement.setString(10, doctor.getRegNoMBBS());
            preparedStatement.setString(11, doctor.getGender());

            if (doctor.getProfilePicture() == null) {
                doctor.setProfilePicture("default_profile_picture.png");
            }

            preparedStatement.setString(12, doctor.getProfilePicture());
            preparedStatement.setString(13, doctor.getFirstName() + " " + doctor.getLastName());
            preparedStatement.executeUpdate();
            hasQueryExecutedSuccesfully = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasQueryExecutedSuccesfully;
    }

    public Doctor getDoctorByEmailAndPassword(String email, String password) throws Exception {
        String query = "SELECT * FROM Doctor WHERE email=? and password=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        Doctor doctor = null;
        if (resultSet.next()) {
            doctor = new Doctor();
            doctor.setId(resultSet.getInt("id"));
            doctor.setCreate_time(resultSet.getTimestamp("create_time"));
            doctor.setDusername(resultSet.getString("dusername"));
            doctor.setPassword(resultSet.getString("password"));
            doctor.setFirstName(resultSet.getString("firstName"));
            doctor.setLastName(resultSet.getString("lastName"));
            doctor.setGender(resultSet.getString("gender"));
            doctor.setAffiliation(resultSet.getString("affiliation"));
            doctor.setAddress(resultSet.getString("address"));
            doctor.setEmail(resultSet.getString("email"));
            doctor.setBio(resultSet.getString("bio"));
            doctor.setRegNoMBBS(resultSet.getString("regNoMBBS"));
            doctor.setSpecialization(resultSet.getString("specialization"));
            doctor.setProfilePicture(resultSet.getString("profilePicture"));
        }
        return doctor;
    }

    public Boolean getDoctorCountByRegNoMBBS(String regNoMBBS) throws Exception {
        String query = "SELECT count(*) FROM Doctor WHERE regNoMBBS=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, regNoMBBS);

        Boolean recordExist = false;

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        if (resultSet.getInt(1) == 1) {
            recordExist = true;
        } else if (resultSet.getInt(1) == 0) {
            recordExist = false;
        }

        return recordExist;
    }

    public boolean updateDoctorDetials(Doctor doctor) {
        boolean hasQueryExecutedSuccesfully = false;
        try {
            String query = "UPDATE Doctor SET email=?, firstName=?, lastName=?, password=?, address=?, bio=?, gender=?, profilePicture=?, specialization=?, regNoMBBS=?, affiliation=? WHERE id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, doctor.getEmail());
            preparedStatement.setString(2, doctor.getFirstName());
            preparedStatement.setString(3, doctor.getLastName());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, doctor.getAddress());
            preparedStatement.setString(6, doctor.getBio());
            preparedStatement.setString(7, doctor.getGender());
            preparedStatement.setString(8, doctor.getProfilePicture());
            preparedStatement.setString(9, doctor.getSpecialization());
            preparedStatement.setString(10, doctor.getRegNoMBBS());
            preparedStatement.setString(11, doctor.getAffiliation());
            preparedStatement.setInt(12, doctor.getId());

            preparedStatement.executeUpdate();
            hasQueryExecutedSuccesfully = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasQueryExecutedSuccesfully;
    }

    public List<Doctor> getDoctorByNameRegX(String regXName) {
        List<Doctor> doctorList = new ArrayList<>();
        Doctor doctor = null;
        try {
            String searchQuery = "SELECT * FROM Doctor WHERE fullName LIKE ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
            
            preparedStatement.setString(1, "%"+regXName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Timestamp create_time = resultSet.getTimestamp("create_time");
                String dusername = resultSet.getString("dusername");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String gender = resultSet.getString("gender");
                String affiliation = resultSet.getString("affiliation");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String bio = resultSet.getString("bio");
                String regNoMBBS = resultSet.getString("regNoMBBS");
                String specialization = resultSet.getString("specialization");
                String profilePicture = resultSet.getString("profilePicture");
                String fullName = resultSet.getString("fullName");
                doctor = new Doctor(id, dusername, email, firstName, lastName, address, specialization, bio, affiliation, regNoMBBS, create_time, gender, profilePicture, fullName);



            doctorList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Doctor doctor = null;
        return doctorList;
    }

}
