/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.dao;
import com.shm.careBridge.entities.Patient;
import java.sql.*;
/**
 *
 * @author akhlaq-aqidah
 */
public class PatientDao {
    private Connection connection;

    public PatientDao(Connection connection) {
        this.connection = connection;
    }

    public boolean savePatient(Patient patient){
        boolean hasQueryExecutedSuccesfully = false;
        try{
            String query = "INSERT INTO Patient(username, password, firstName, lastName, gender, emergencyContact, address, email, description, profilePicture) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, patient.getUsername());
            preparedStatement.setString(2, patient.getPassword());
            preparedStatement.setString(3, patient.getFirstName());
            preparedStatement.setString(4, patient.getLastName());
            preparedStatement.setString(5, patient.getGender());
            preparedStatement.setString(6, patient.getEmergencyContact());
            preparedStatement.setString(7, patient.getAddress());
            preparedStatement.setString(8, patient.getEmail());
            preparedStatement.setString(9, patient.getDescription());
//            preparedStatement.setString(10, patient.getCreate_time());
            
            if(patient.getProfilePicture()==null){
                patient.setProfilePicture("default_profile_picture.png");
            }
            
            preparedStatement.setString(10, patient.getProfilePicture());


            preparedStatement.executeUpdate();
            hasQueryExecutedSuccesfully = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return hasQueryExecutedSuccesfully;
    }
    
    public Patient getPaitentByEmailAndPassword(String email, String password) throws Exception{
        String query = "SELECT * FROM Patient WHERE email=? and password=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        Patient patient = null;
        if(resultSet.next()){
            patient = new Patient();
            patient.setPid(resultSet.getInt("pid"));
            patient.setUsername(resultSet.getString("username"));
            patient.setCreate_time(resultSet.getTimestamp("create_time"));
            patient.setPassword(resultSet.getString("password"));
            patient.setFirstName(resultSet.getString("firstName"));
            patient.setLastName(resultSet.getString("lastName"));
            patient.setGender(resultSet.getString("gender"));
            patient.setEmergencyContact(resultSet.getString("emergencyContact"));
            patient.setAddress(resultSet.getString("address"));
            patient.setEmail(resultSet.getString("email"));
            patient.setDescription(resultSet.getString("description"));
            patient.setProfilePicture(resultSet.getString("profilePicture"));
        }
        return patient;
    }
    
    
    public boolean updatePatientDetials(Patient patient){
        boolean hasQueryExecutedSuccesfully = false;
        try{
            String query = "UPDATE Patient SET email=?, firstName=?, lastName=?, password=?, address=?, emergencyContact=?, description=?, gender=?, profilePicture=? WHERE pid=?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, patient.getEmail());
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setString(4, patient.getPassword());
            preparedStatement.setString(5, patient.getAddress());
            preparedStatement.setString(6, patient.getEmergencyContact());
            preparedStatement.setString(7, patient.getDescription());
            preparedStatement.setString(8, patient.getGender());
            preparedStatement.setString(9, patient.getProfilePicture());
            preparedStatement.setInt(10, patient.getPid());
            
            
            preparedStatement.executeUpdate();
            hasQueryExecutedSuccesfully = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return hasQueryExecutedSuccesfully;
    }
    
}
