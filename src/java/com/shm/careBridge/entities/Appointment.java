/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shm.careBridge.entities;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author akhlaq-aqidah
 */
public class Appointment {
    private int serialNo;
    private int previousSerialNo;
    private String visitType;
    private boolean isFeePaid;
    private String prescription;
    private boolean isReportPresent;
    private int Patient_has_Doctor_Patient_pid;
    private String Patient_has_Doctor_Doctor_regNoMBBS;
    private Date appointmentDate;
    private Date appointmentTime;
    private Timestamp create_time;

    public Appointment() {
    }

    public Appointment(int serialNo, int previousSerialNo, String visitType, boolean isFeePaid, String prescription, boolean isReportPresent, int Patient_has_Doctor_Patient_pid, String Patient_has_Doctor_Doctor_regNoMBBS, Date appointmentDate, Date appointmentTime, Timestamp create_time) {
        this.serialNo = serialNo;
        this.previousSerialNo = previousSerialNo;
        this.visitType = visitType;
        this.isFeePaid = isFeePaid;
        this.prescription = prescription;
        this.isReportPresent = isReportPresent;
        this.Patient_has_Doctor_Patient_pid = Patient_has_Doctor_Patient_pid;
        this.Patient_has_Doctor_Doctor_regNoMBBS = Patient_has_Doctor_Doctor_regNoMBBS;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.create_time = create_time;
    }

    

    
    
    
    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getPreviousSerialNo() {
        return previousSerialNo;
    }

    public void setPreviousSerialNo(int previousSerialNo) {
        this.previousSerialNo = previousSerialNo;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    

    public boolean isIsFeePaid() {
        return isFeePaid;
    }

    public void setIsFeePaid(boolean isFeePaid) {
        this.isFeePaid = isFeePaid;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public boolean isIsReportPresent() {
        return isReportPresent;
    }

    public void setIsReportPresent(boolean isReportPresent) {
        this.isReportPresent = isReportPresent;
    }

    public int getPatient_has_Doctor_Patient_pid() {
        return Patient_has_Doctor_Patient_pid;
    }

    public void setPatient_has_Doctor_Patient_pid(int Patient_has_Doctor_Patient_pid) {
        this.Patient_has_Doctor_Patient_pid = Patient_has_Doctor_Patient_pid;
    }

    public String getPatient_has_Doctor_Doctor_regNoMBBS() {
        return Patient_has_Doctor_Doctor_regNoMBBS;
    }

    public void setPatient_has_Doctor_Doctor_regNoMBBS(String Patient_has_Doctor_Doctor_regNoMBBS) {
        this.Patient_has_Doctor_Doctor_regNoMBBS = Patient_has_Doctor_Doctor_regNoMBBS;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    
    
    
}
