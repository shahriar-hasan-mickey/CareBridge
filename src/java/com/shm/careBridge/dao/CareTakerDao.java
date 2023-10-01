/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.dao;
import com.shm.careBridge.entities.CareTaker;
import java.sql.*;
/**
 *
 * @author akhlaq-aqidah
 */
public class CareTakerDao {
    private Connection connection;

    public CareTakerDao(Connection connection) {
        this.connection = connection;
    }

    public boolean saveCareTaker(CareTaker careTaker){
        boolean hasQueryExecutedSuccesfully = false;
        try{
            String query = "INSERT INTO CareTaker(username, email, password, firstName, lastName, contactNo, address, gender, profilePicture) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, careTaker.getUsername());
            preparedStatement.setString(2, careTaker.getEmail());
            preparedStatement.setString(3, careTaker.getPassword());
            preparedStatement.setString(4, careTaker.getFirstName());
            preparedStatement.setString(5, careTaker.getLastName());
            preparedStatement.setString(6, careTaker.getContactNo());
            preparedStatement.setString(7, careTaker.getAddress());
            preparedStatement.setString(8, careTaker.getGender());
            
            if(careTaker.getProfilePicture()==null){
                careTaker.setProfilePicture("default_profile_picture.png");
            }
            
            preparedStatement.setString(9, careTaker.getProfilePicture());
            
            preparedStatement.executeUpdate();
            hasQueryExecutedSuccesfully = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return hasQueryExecutedSuccesfully;
    }
    
    public CareTaker getCareTakerByEmailAndPassword(String email, String password) throws Exception{
        String query = "SELECT * FROM CareTaker WHERE email=? and password=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        CareTaker careTaker = null;
        if(resultSet.next()){
            careTaker = new CareTaker();
            careTaker.setCid(resultSet.getInt("cid"));
            careTaker.setCreate_time(resultSet.getTimestamp("create_time"));
            careTaker.setUsername(resultSet.getString("username"));
            careTaker.setPassword(resultSet.getString("password"));
            careTaker.setFirstName(resultSet.getString("firstName"));
            careTaker.setLastName(resultSet.getString("lastName"));
            careTaker.setGender(resultSet.getString("gender"));
            careTaker.setContactNo(resultSet.getString("contactNo"));
            careTaker.setAddress(resultSet.getString("address"));
            careTaker.setEmail(resultSet.getString("email"));
            careTaker.setProfilePicture(resultSet.getString("profilePicture"));
        }
        return careTaker;
    }
    
    public Boolean getCareTakerCountByContactNo(String contactNo) throws Exception{
        String query = "SELECT count(*) FROM CareTaker WHERE contactNo=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.setString(1, contactNo);
        
        Boolean recordExist = false;
        
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        
        if(resultSet.getInt(1)==1){
            recordExist = true;
        }else if(resultSet.getInt(1) == 0){
            recordExist = false;
        }
        
        return recordExist;
    }
    
    
    
    public boolean updateCareTakerDetials(CareTaker careTaker){
        boolean hasQueryExecutedSuccesfully = false;
        try{
            String query = "UPDATE CareTaker SET email=?, firstName=?, lastName=?, password=?, address=?, gender=?, profilePicture=?, contactNo=? WHERE id=?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, careTaker.getEmail());
            preparedStatement.setString(2, careTaker.getFirstName());
            preparedStatement.setString(3, careTaker.getLastName());
            preparedStatement.setString(4, careTaker.getPassword());
            preparedStatement.setString(5, careTaker.getAddress());
            preparedStatement.setString(6, careTaker.getGender());
            preparedStatement.setString(7, careTaker.getProfilePicture());
            preparedStatement.setString(8, careTaker.getContactNo());
            preparedStatement.setInt(9, careTaker.getCid());
            
            
            preparedStatement.executeUpdate();
            hasQueryExecutedSuccesfully = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return hasQueryExecutedSuccesfully;
    }
    
}
