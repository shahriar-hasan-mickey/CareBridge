
<%@page import="com.shm.careBridge.entities.PromptMessage" %>
<%@page errorPage="error_page.jsp" %>
<%@page import="org.apache.commons.lang3.StringUtils" %>
<%@page import="com.shm.careBridge.entities.Patient" %>

<%
    Patient patient = (Patient)session.getAttribute("currentPatient");
    if(patient == null){
        response.sendRedirect("patient_login_page.jsp");
    }
%>
<%
    int id = Integer.parseInt(request.getParameter("doctor_id"));
    
    String doctorFullName = request.getParameter("doctor_name");
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= patient.getUsername()%> Profile</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>

        <style>
            .careTaker-background{
                background: #56d1f7 !important;
            }

            .red-brackground{
                background: red;
            }
            .banner-background{
                clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 69% 78%, 50% 100%, 24% 90%, 0 100%, 0% 35%, 0 0);
            }

            th{
                text-align: right;
            }

            .form-inline .form-control {
                display: inline-block;
                width: 50%;
                vertical-align: middle;
            }


        </style>
    </head>




    <body>


        <!--NavBar-->
        <nav class="navbar navbar-expand-lg navbar-light primary-background">
            <a class="navbar-brand " href="index.jsp" style="font-size: 30px"><span class="fa fa-wheelchair"></span> CareBridge</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">






                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link active" href="#">About Us</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="#">Contact</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="fa fa-user-circle-o" ></span>&nbsp;<%= patient.getUsername()%> 
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="nav-link active" href="#!" data-toggle="modal" data-target="#profileModal">Profile Settings</a>
                            <a class="nav-link active" href="patient_profile.jsp" >Dashboard</a>
                            <a class="nav-link active" href="PatientLogoutServlet">Logout</a>
                        </div>
                    </li>





                </ul>
                <!--</div>-->
            </div>
        </nav>

        <!--End of NavBar-->


        <!-- Example split danger button -->




        <div class="card-body mt-4">
            <main class="d-flex align-items-center primary-background banner" style="height: 80vh">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 offset-md-3">
                            <div class="card">
                                <div class="card-header primary-background text-white text-center">
                                    <span class="fa fa-calendar fa-3x"></span>
                                    <br>
                                    <div class="container text-center mt-4">
                                        <h5>Book an appointment with :</h5> 
                                        <h4>Dr. <%= doctorFullName %></h4>
                                    </div>
                                </div>
                                <form id="doctor_appointment_form" action="AppointmentServlet" method="post">


                                    <div class="col-auto my-1 mt-4">
                                        <label class="mr-sm-2" for="inlineFormCustomSelect">Select a day from the Following *</label>
                                        
                                        <input type="date" name="appointmentDate" class="custom-select mr-sm-2 btn-warning" id="daySlot" required>
                                    </div>
                                    <div class="col-auto my-1 mt-4">
                                        <label class="mr-sm-2" for="inlineFormCustomSelect">Select a time from the Following *</label>
                                        <input type="time" name="appointmentTime" class="custom-select mr-sm-2 btn-warning" id="timeSlot" required>
                                        
                                    </div>

                                    <div class="col-auto my-1 mt-4">
                                        If previously visited then checkbox & insert previous AppointmentNo.:
                                        <div class="input-group-prepend">
                                            
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <input name="previouselyVisited" type="checkbox" id="previouselyVisited" aria-label="Checkbox for following text input" >
                                                    </div>
                                                </div>
                                                <input name="previousAppointmentNo" type="number" id="previousAppointmentNo" class="form-control" aria-label="Text input with checkbox">
                                            </div>
                                        </div>
                                        <div class="input-group-prepend mt-3">
                                            Is any report Present? * :
                                            &nbsp;<input name="reportPresent" type="radio" name="reportPresent" value="1" aria-label="Radio button for following text input" required> &nbsp;YES
                                            &nbsp;&nbsp;<input name="reportPresent" type="radio" name="reportPresent" value="0" aria-label="Radio button for following text input" required> &nbsp;NO

                                        </div>

                                    </div>

                                    <div class="col-auto my-1 text-danger mt-4 text-center" >
                                        <b>PLEASE KEEP 1 HOUR IN HAND DURING APPOINTED TIME</b>
                                    </div>
                                    
                                    <input type="hidden" name="doctorId" value="<%= id %>">
                                    <div class="card-header primary-background text-white">
                                        <div class="col-auto my-1 text-center" >
                                            <button type="submit" class="btn btn-primary btn-danger border">Book</button>
                                        </div>
                                    </div>

                                </form>
                            </div>

                        </div>

                    </div>
                </div>


            </main>
        </div>

        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <!--<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>-->
        <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myJS.js" type="text/javascript"></script>
        <script>

        </script>
    </body>
</html>

