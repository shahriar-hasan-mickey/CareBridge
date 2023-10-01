
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>
        <style>
            .careTaker-background{
                background: #56d1f7 !important;
            }
            .banner-background{


                clip-path: polygon(50% 0%, 97% 10%, 100% 35%, 100% 100%, 89% 91%, 50% 100%, 8% 89%, 0 100%, 0% 35%, 2% 10%);


            }
        </style>
    </head>
    <body>

        <%@include file="careTaker_navbar.jsp" %>
        <main class="d-flex align-items-center careTaker-background banner-background" style=" padding: 5%">
            <div class="container">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header careTaker-background text-center text-white">
                            <span class="fa fa-asl-interpreting fa-3x"></span>
                            <h3>Register Here</h3>
                        </div>
                        <div class="card-body">
                            <form id="careTaker_registration_form" > 
                                <div class="form-group">
                                    <label for="username">User Name</label>
                                    <input name="username" type="text" class="form-control" id="username" placeholder="Enter Username" reguired>

                                </div>



                                <div class="form-group">
                                    <label for="firstname">First Name</label>
                                    <input name="firstName" type="text" class="form-control" id="firstName" placeholder="First Name" reguired>
                                </div>
                                <div class="form-group">
                                    <label for="lastname">Last Name</label>
                                    <input name="lastName" type="text" class="form-control" id="lastName" placeholder="Last Name" >
                                </div>


                                <div class="form-group">
                                    <label for="contact">Contact No.</label>
                                    <input name="contactNo" type="text" class="form-control" id="contactNo" placeholder="01XXXXXXXXX" reguired>
                                </div>
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <input name="address" type="text" class="form-control" id="address" placeholder="Permanent Address">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" reguired>
                                    <!--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
                                </div>


                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Enter Password" reguired>
                                </div>

                                <div class="form-group">
                                    <label for="gender">Select Gender :</label>
                                    <input type="radio" name="gender" id="gender" value="Male" reguired> Male
                                    <input type="radio" name="gender" id="gender" value="Female" required> Female
                                </div>





                                <div class="form-check">
                                    <input name="condition" type="checkbox" class="form-check-input" id="exampleCheck1" required>
                                    <label class="form-check-label" for="exampleCheck1">Agree terms & conditions</label>
                                </div><br>
                                <div class="container text-center" id="loader" style="display: none;" >
                                    <span class="fa fa-refresh fa-spin fa-4x"></span>
                                    <h4>Please Wait...</h4>
                                </div>
                                <button id="submit-btn" type="submit" class="btn btn-primary careTaker-background">Submit</button>
                            </form>
                        </div>
                        <div class="card-footer careTaker-background">

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
        <script>

            var form = document.getElementById("careTaker_registration_form");
            let formDataJsonString = "";
            let fromDataObject = "";
            let responseData = "";
            form.addEventListener("submit", async function (event) {
                // console.log("clicked");
                event.preventDefault();
                const data = new FormData(this);
                
                var btn = document.getElementById("submit-btn");
                var loader = document.getElementById("loader");
                btn.style.display = "none";
                loader.style.display = "";
                
                
                // const data = new URLSearchParams(data1);
                 const url = "http://localhost:8080";
//                const url = "";
                const path = "/CareBridgeJEE/CareTakerRegisterServlet";
                fromDataObject = await Object.fromEntries(data.entries());
                formDataJsonString = JSON.stringify(fromDataObject);
                const fetchOptions = {
                    method: 'POST',
                    headers: {
                        'Content-Type': '*/*',
                        'Accept': '*/*',
                    },
                    body: formDataJsonString,
                };
                
                console.log(data);
                const uri = url + path;
                try {
                    const response = await fetch(uri, fetchOptions);
                    if (!response.ok) {
                        const error = await response.text();
                        throw new Error(error);
                    }
                    
                    btn.style.display = "";
                    loader.style.display = "none";

                    responseData = await response.text();
                    alert(responseData);
                    
                    if(responseData.substring(0, responseData.length-1)==="SUCCESSFULLY REGISTERED"){ //   responseData.length-1 : 1 is subtracted because there is a "\n" new line character  
                        window.location.replace("careTaker_login_page.jsp");
                    }
                    
                } catch (error) {
                    console.log(error);
                    alert(error.message);
                }
            });
        </script>
    </body>
</html>
