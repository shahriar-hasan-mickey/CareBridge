/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.helper;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;
/**
 *
 * @author akhlaq-aqidah
 */
public class ConnectionProvider {
    private static Connection connection;
    
    public static Connection getConnection(){
        try{
            if(connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                String url = "jdbc:mysql://localhost:3306/CareBridge";
                String user = "user1";
                String password = "us4r1";
                
                connection = DriverManager.getConnection(url, user, password);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    
    }
}
