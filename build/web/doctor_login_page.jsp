<%@page import="com.shm.careBridge.entities.PromptMessage" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Login Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
        <style>
            .doctor-background{
                background: #f75656;
                /*clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 69% 78%, 50% 100%, 24% 90%, 0 100%, 0% 35%, 0 0);*/
            }
            
            .banner-background{
                clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 69% 78%, 50% 100%, 24% 90%, 0 100%, 0% 35%, 0 0);
            }
        </style>
    </head>
    <body>
        
        
        <%@include file="doctor_navbar.jsp" %>
        <main class="d-flex align-items-center doctor-background banner-background" style="height: 60vh">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header doctor-background text-center text-white">
                                <span class="fa fa-user-md fa-3x"></span>
                                <br>
                                <h3>Login here</h3>
                            </div>
                            
                            <%
                                        PromptMessage promptMessage = (PromptMessage)session.getAttribute("promptMessage");
                                        if(promptMessage!=null){
                            %>
                                            <div class="alert <%= promptMessage.getCssClass() %>"  role="alert">
                                                <%= promptMessage.getContent() %>
                                            </div>
                            <%
                                            session.removeAttribute("promptMessage");                            
                                        }
                            %> 
                            
                            <div class="card-body">
                                <form action="DoctorLoginServlet">
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                        <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>
                                    <button type="submit" class="btn btn-primary doctor-background">Submit</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <!--<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>-->
        <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myJS.js" type="text/javascript"></script>

    </body>
</html>
