/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.dao;

import com.shm.careBridge.entities.Appointment;
import java.sql.PreparedStatement;
import java.sql.*;

/**
 *
 * @author akhlaq-aqidah
 */
public class AppointmentDao {
    
    private Connection connection;

    public AppointmentDao(Connection connection) {
        this.connection = connection;
    }
    
    
    
    public boolean bookANewAppointment(Appointment appointment){
        boolean isAppointmentBookedSuccessfully = false;
        
        
        try{
            
            
            
            
            
            
            
            String query = "INSERT INTO Appointment( previousSerialNo, visitType, isFeePaid, isReportPresent, Patient_has_Doctor_Patient_pid, Patient_has_Doctor_Doctor_regNoMBBS, appointmentDate, appointmentTime) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, "NULL");
            preparedStatement.setString(2, appointment.getVisitType());
            preparedStatement.setBoolean(3, appointment.isIsFeePaid());
            preparedStatement.setString(4, appointment.getPrescription());
            preparedStatement.setInt(5, appointment.getPatient_has_Doctor_Patient_pid());
            preparedStatement.setString(6, appointment.getPatient_has_Doctor_Doctor_regNoMBBS());
            preparedStatement.setDate(7, appointment.getAppointmentDate());
            preparedStatement.setDate(8, appointment.getAppointmentTime());
            
            preparedStatement.executeUpdate();
            isAppointmentBookedSuccessfully = true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return isAppointmentBookedSuccessfully;
    }
}
