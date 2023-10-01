/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.shm.careBridge.servlets;

import com.shm.careBridge.dao.DoctorDao;
import com.shm.careBridge.entities.Doctor;
import com.shm.careBridge.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 *
 * @author akhlaq-aqidah
 */



@MultipartConfig
public class EditDoctorProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");
            String bio = request.getParameter("bio");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            Part profilePicture = request.getPart("profilePicture");
            String profilePictureName = profilePicture.getSubmittedFileName();
            String specialization = request.getParameter("specialization");
            String affiliation = request.getParameter("affiliation");
            String regNoMBBS = request.getParameter("regNoMBBS");


//TODO : INORDER TO ALLOW MULTIPART FORM DATA TO FOLLOWING ANNOTATION IS A MUST JUST BEFORE THE FUNCTION : @MultipartConfig
            
            if (email != "" & firstName != "" & password != "" & bio != "" & address != "" & gender != "" & profilePicture != null & profilePictureName != null & profilePictureName != "" & specialization!="" & regNoMBBS !="" & affiliation!="") {
                HttpSession session = request.getSession();
                Doctor doctor = (Doctor) session.getAttribute("currentDoctor");
                doctor.setEmail(email);
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setPassword(password);
                doctor.setAddress(address);
                doctor.setBio(bio);
                doctor.setGender(gender);
                doctor.setProfilePicture(profilePictureName);
                doctor.setSpecialization(specialization);
                doctor.setRegNoMBBS(regNoMBBS);
                doctor.setAffiliation(affiliation);

                DoctorDao doctorDao = new DoctorDao(ConnectionProvider.getConnection());
                
                
//Checking if provided regNo exists or not
                Boolean regNoMBBSExist = doctorDao.getDoctorCountByRegNoMBBS(regNoMBBS);
                if(!regNoMBBSExist){
                    Boolean updateStatus = doctorDao.updateDoctorDetials(doctor);

                    if (updateStatus) {
                        out.println("Updated Successfully");
                    } else {
                        out.println("Something Went Wrong");
                    }
                }else{
                    String output = String.format("Registration No. %s aready Exists, Enter a valid Registration No", regNoMBBS);
                    out.println(output);
                }
            } else {
                out.println("Required Fields cannot be empty");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
