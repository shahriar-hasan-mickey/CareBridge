/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.shm.careBridge.servlets;

import com.shm.careBridge.dao.PatientDao;
import com.shm.careBridge.entities.PromptMessage;
import com.shm.careBridge.entities.Patient;
import com.shm.careBridge.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import org.json.JSONObject;

/**
 *
 * @author akhlaq-aqidah
 */
@WebServlet(name = "PatientLoginServlet", urlPatterns = {"/PatientLoginServlet"})
public class PatientLoginServlet extends HttpServlet {

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
//            StringBuilder sb = new StringBuilder();
//            BufferedReader reader = request.getReader();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line);
//            }
//            String requestBody = sb.toString();
//
//            String jsonString = requestBody;
//            JSONObject jsonObj = null;
//
////            Read more
////            : https://javarevisited.blogspot.com/2022/03/3-examples-to-parse-json-in-java-using.html#ixzz8CIloWbog
//
//
//
////            Fetching Data
//            try {
//                jsonObj = new JSONObject(jsonString);
//                
//                String condition = jsonObj.getString("condition");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                if (email!=null & password!=null) {
//                    String email = jsonObj.getString("email");
//                    String password = jsonObj.getString("password");


                    
//                Creating Patient-DAO Object
                    PatientDao patientDao = new PatientDao(ConnectionProvider.getConnection());
                    Patient patient = patientDao.getPaitentByEmailAndPassword(email, password);
                    if (patient!=null) {
                        out.println("SUCCESSFULLY LOGGED IN");
                        HttpSession session = request.getSession();
                        session.setAttribute("currentPatient", patient);
                        response.sendRedirect("patient_profile.jsp");
                    } else {
                        PromptMessage promptMessage = new PromptMessage("Invalid Details! try again with valid details", "error", "alert-danger");
                        HttpSession session = request.getSession();
                        session.setAttribute("promptMessage", promptMessage);
                        
                        response.sendRedirect("patient_login_page.jsp");
                    }
                } else {
                    out.println("Input field cannot be blank!");
                }

            
        }
        catch (Exception e) {
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
