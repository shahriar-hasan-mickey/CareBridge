/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.shm.careBridge.servlets;

import com.shm.careBridge.dao.AppointmentDao;
import com.shm.careBridge.entities.Patient;
import com.shm.careBridge.entities.PromptMessage;
import com.shm.careBridge.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.Instant;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author akhlaq-aqidah
 */
public class AppointmentServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            Patient patient = (Patient) session.getAttribute("currentPatient");
            try{
                
                
//                TODO [for date and time conversion]: https://stackoverflow.com/questions/55449800/how-to-get-date-from-html-form-to-servlet
                
                Date appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("appointmentDate"));
                Date appointmentTime = new SimpleDateFormat("hh:mm").parse(request.getParameter("appointmentTime"));
                java.sql.Date selectedDate = new java.sql.Date(appointmentDate.getTime());
                java.sql.Time selectedTime = new java.sql.Time(appointmentTime.getTime());
                String previouselyVisited = request.getParameter("previouselyVisited");
                String previousAppointmentNo = request.getParameter("previousAppointmentNo");
                String reportPresent = request.getParameter("reportPresent");
                out.println(selectedDate + " " + selectedTime + " " + previouselyVisited + " " + previousAppointmentNo + " " + reportPresent);
//                AppointmentDao appointmentDao = new AppointmentDao(ConnectionProvider.getConnection());
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            PromptMessage promptMessage = new PromptMessage("Appointment Booked Successfully", "success", "alert-success");
            session.setAttribute("promptMessage", promptMessage);
            
//            response.sendRedirect("patient_profile.jsp");
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
