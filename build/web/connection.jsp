
<%@page import="com.shm.careBridge.entities.Patient" %>
<%
    Patient patient = (Patient)session.getAttribute("currentPatient");
    if(patient == null){
        response.sendRedirect("patient_login_page.jsp");
    }
%>

<%
    int id = Integer.parseInt(request.getParameter("doctor_id"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= id %></h1>
    </body>
</html>
