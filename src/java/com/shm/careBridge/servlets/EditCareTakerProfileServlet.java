/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.shm.careBridge.servlets;

import com.shm.careBridge.dao.CareTakerDao;
import com.shm.careBridge.entities.CareTaker;
import com.shm.careBridge.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 *
 * @author akhlaq-aqidah
 */
public class EditCareTakerProfileServlet extends HttpServlet {

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
            String contactNo = request.getParameter("contactNo");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            Part profilePicture = request.getPart("profilePicture");
            String profilePictureName = profilePicture.getSubmittedFileName();
            
            if(email!="" & firstName!="" & password!="" & contactNo!="" & address!="" & gender!="" & profilePicture!=null & profilePictureName!=null & profilePictureName!=""){
                HttpSession session = request.getSession();
                CareTaker careTaker = (CareTaker) session.getAttribute("currentCareTaker");
                careTaker.setFirstName(firstName);
                careTaker.setLastName(lastName);
                careTaker.setPassword(password);
                careTaker.setAddress(address);
                careTaker.setGender(gender);
                careTaker.setContactNo(contactNo);
                careTaker.setEmail(email);
                careTaker.setProfilePicture(profilePictureName);

                CareTakerDao careTakerDao = new CareTakerDao(ConnectionProvider.getConnection());
                
                Boolean contactNoExists = careTakerDao.getCareTakerCountByContactNo(contactNo);
                if(!contactNoExists){
                    Boolean updateStatus = careTakerDao.updateCareTakerDetials(careTaker);

                    if(updateStatus){
                        out.println("Updated Successfully");
                    }else{
                        out.println("Something Went Wrong");
                    }
                }else{
                    String output = String.format("Contact No. %s aready Exists, Enter a valid Contact No", contactNo);
                    out.println(output);
                }
            }else{
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
