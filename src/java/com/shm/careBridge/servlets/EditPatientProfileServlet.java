/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.shm.careBridge.servlets;

import com.shm.careBridge.dao.PatientDao;
import com.shm.careBridge.entities.Patient;
import com.shm.careBridge.entities.PromptMessage;
import com.shm.careBridge.helper.ConnectionProvider;
import com.shm.careBridge.helper.Helper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;

/**
 *
 * @author akhlaq-aqidah
 */
@MultipartConfig
@WebServlet(name = "EditPatientProfileServlet", urlPatterns = {"/EditPatientProfileServlet"})
public class EditPatientProfileServlet extends HttpServlet {

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
            String emergencyContact = request.getParameter("emergencyContact");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            Part profilePicture = request.getPart("profilePicture");
            String profilePictureName = profilePicture.getSubmittedFileName();

            HttpSession session = request.getSession();
            Patient patient = (Patient) session.getAttribute("currentPatient");

            if (email != "" & firstName != "" & password != "" & emergencyContact != "" & address != "" & gender != "" & profilePicture != null & profilePictureName != null & profilePictureName != "") {

                

                PatientDao patientDao = new PatientDao(ConnectionProvider.getConnection());

                
//                TODO : Path Till img directory using getServletContext which is alternative to request.getRealPath("/")
                String realPathTillImgDirectory = getServletContext().getRealPath("/") + "img" + File.separator;

//                TODO : Path of Previous file
                String previousProfilePicturePath = realPathTillImgDirectory + patient.getProfilePicture();

                
                if (!previousProfilePicturePath.equals(realPathTillImgDirectory + "default_profile_picture.png")) {
//                    TODO : Deleting the older profile Picture
                    Helper.deleteFile(previousProfilePicturePath);
                }

                
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setPassword(password);
                patient.setAddress(address);
                patient.setGender(gender);
                patient.setEmergencyContact(emergencyContact);
                patient.setEmail(email);
                patient.setProfilePicture(patient.getUsername()+"_"+patient.getPid()+".png");
                
//                TODO : Path of New File                
                String profilePicturePath = getServletContext().getRealPath("/") + "img" + File.separator + patient.getProfilePicture();
                
                
                Boolean profilePictureUpdateStatue = Helper.saveFile(profilePicture.getInputStream(), profilePicturePath);
                
                
                
                
                
                
                Boolean patientDetailsUpdateStatus = patientDao.updatePatientDetials(patient);
                if (patientDetailsUpdateStatus & profilePictureUpdateStatue) {
                    PromptMessage promptMessage = new PromptMessage("Updated Information Successfully", "success", "alert-success");
                    session.setAttribute("promptMessage", promptMessage);

                } else {
                    PromptMessage promptMessage = new PromptMessage("Could not update information", "error", "alert-danger");
                    session.setAttribute("promptMessage", promptMessage);
                }
                
            } else {
//                out.println("Required Fields cannot be empty");
                PromptMessage promptMessage = new PromptMessage("Required Fields cannot be empty", "error", "alert-danger");
                session.setAttribute("promptMessage", promptMessage);
            }

            response.sendRedirect("patient_profile.jsp");
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
