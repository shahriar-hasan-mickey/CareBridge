

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" 
        import="com.shm.careBridge.helper.ConnectionProvider"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>


        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
        <style>
            .banner-background{
                clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 69% 78%, 50% 100%, 24% 90%, 0 100%, 0% 35%, 0 0);
            }
        </style>
    </head>
    <body>


        <%@include file="navbar.jsp" %>

        <div class="container-fluid p-0 m-0">
            <div class="jumbotron primary-background text-white banner-background">
                <div class="container">
                    <h3>Welcome To </h3>
                    <h3 class="display-3"><b>CareBridge</b></h3>
                    <p>A place where we care for you. A place where you belong to.</p>

                    <a href="patient_register.jsp" class="btn btn-outline-light btn-lg">Register</a>
                    <a href="patient_login_page.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"> </span>&nbsp;Login</a>
                </div>
            </div>
        </div>


        <div class="container"> 
            <h3>Services We Provide</h3>
            <div class="row">
                <div class="col-md-4">
                    <div class="card">

                        <div class="card-body">
                            <h5 class="card-title">Care Taking</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary primary-background"><span class="fa fa-external-link"></span>&nbsp;Learn More</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">

                        <div class="card-body">
                            <h5 class="card-title">Virtual Doctor</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary primary-background"><span class="fa fa-external-link"></span>&nbsp;Learn More</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">

                        <div class="card-body">
                            <h5 class="card-title">AI Suggestion</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary primary-background"><span class="fa fa-external-link"></span>&nbsp;Learn More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!--for learning how to use jquery use the following link serially
        https://hackr.io/blog/how-to-learn-jquery
        from there click the Jquery website link : 
        https://jquery.com/download/
        from there click to download the latest uncompressed (anyone could be used) jquery file. I used 3.7.1:
        https://code.jquery.com/jquery-3.7.1.js     
        -->

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
