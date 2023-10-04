<%@page import="com.shm.careBridge.entities.CareTaker" %>
<%@page errorPage="error_page.jsp" %>
<%@page import="org.apache.commons.lang3.StringUtils" %>
<%@page import="com.shm.careBridge.entities.PromptMessage" %>
<%
    CareTaker careTaker = (CareTaker)session.getAttribute("currentCareTaker");
    if(careTaker == null){
        response.sendRedirect("careTaker_login_page.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= careTaker.getUsername()%> Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/myStyle.css" rel="stylesheet" type="text/css"/>

        <style>
            .careTaker-background{
                background: #56d1f7 !important;
            }
            .banner-background{
                clip-path: polygon(50% 0%, 100% 0, 100% 35%, 100% 100%, 69% 78%, 50% 100%, 24% 90%, 0 100%, 0% 35%, 0 0);
            }
        </style>
    </head>
    <body>
        <!--NavBar-->
        <nav class="navbar navbar-expand-lg navbar-light careTaker-background">
            <a class="navbar-brand " href="index.jsp" style="font-size: 30px"><span class="fa fa-wheelchair"></span> CareBridge</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <!--    <form class="form-inline my-2 my-lg-0">
                      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>-->
                <!--<div class="container">-->
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
                            <span class="fa fa-user-circle-o" ></span>&nbsp;<%= careTaker.getUsername()%> 
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="nav-link active" href="#!" data-toggle="modal" data-target="#profileModal">Profile Settings</a>
                            <a class="nav-link active" href="CareTakerLogoutServlet">Logout</a>
                        </div>
                    </li>





                </ul>
                <!--</div>-->
            </div>
        </nav>

        <!--End of NavBar-->
        
        
        
        
        <%
                    PromptMessage promptMessage = (PromptMessage)session.getAttribute("promptMessage");
                    if(promptMessage!=null){
        %>
        <div class="alert <%= promptMessage.getCssClass() %> text-center"  role="alert">
            <%= promptMessage.getContent() %>
        </div>
        <%
                        session.removeAttribute("promptMessage");                            
                    }
        %>
        
        
        

        <!--Start of Profile (in modal)-->

        <!-- Modal -->
        <div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header careTaker-background text-white text-centre">
                        <h5 class="modal-title" id="exampleModalLabel">Profile Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container text-center">
                            <img src="img/<%= careTaker.getProfilePicture()%>" class="img-fluid" style="border-radius: 50%; max-width: 150px;">
                            <br>
                            <h5 class="modal-title mt-3" id="exampleModalLabel"><%= careTaker.getFirstName() + " " + careTaker.getLastName()%></h5>
                        </div>

                        <div id="profile-details" class="container mt-3">
                            <table class="table table-hover">
                                <tbody class="careTaker-background ">
                                    <tr>
                                        <th scope="row">CareTaker ID</th>
                                        <td><%=careTaker.getCid()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Username</th>
                                        <td><%=careTaker.getUsername()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">First Name</th>
                                        <td><%= careTaker.getFirstName()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Last Name</th>
                                        <td><%= careTaker.getLastName()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Password</th>
                                        <td type="password"><%= StringUtils.repeat("*", careTaker.getPassword().length())%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Email</th>
                                        <td><%=careTaker.getEmail()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Contact No.</th>
                                        <td><%= careTaker.getContactNo()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Gender</th>
                                        <td><%=careTaker.getGender()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Address</th>
                                        <td><%=careTaker.getAddress()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Account Created On</th>
                                        <td><%=careTaker.getCreate_time()%></td>
                                    </tr>
                                </tbody>
                            </table>


                        </div>


                        <!--Profile Edit-->

                        <div id="profile-edit" class="container mt-3" style="display: none;">
                            <form action="EditCareTakerProfileServlet" method="post" enctype="multipart/form-data">
                                <table class="table table-hover">
                                    <tbody class="careTaker-background text-white">
                                        <tr>
                                            <th scope="row">CareTaker ID</th>
                                            <td><%=careTaker.getCid()%></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Username</th>
                                            <td><%=careTaker.getUsername()%></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">First Name</th>
                                            <td><input name="firstName" type="text" value="<%= careTaker.getFirstName()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Last Name</th>
                                            <td><input name="lastName" type="text" value="<%= careTaker.getLastName()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Email</th>
                                            <td><input name="email" type="text" value="<%=careTaker.getEmail()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Password</th>
                                            <td><input name="password" type="text" value="<%= careTaker.getPassword()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Contact No.</th>
                                            <td><input name="contactNo" type="text" value="<%= careTaker.getContactNo()%>" class="form-control"></td>
                                        </tr>
                                        
                                        <tr>
                                            <th scope="row">Gender</th>
                                                <% if(careTaker.getGender().equals("Male")){
                                                %>
                                                        <td>
                                                            <input type="radio" name="gender" value="<%=careTaker.getGender()%>" checked><%=careTaker.getGender()%>
                                                            <input type="radio" name="gender" value="Female" >Female
                                                        </td>
                                                <% }else{
                                                %>
                                                        <td>
                                                            <input type="radio" name="gender" value="Male" ><%=careTaker.getGender()%>
                                                            <input type="radio" name="gender" value="<%=careTaker.getGender()%>" checked><%=careTaker.getGender()%>
                                                        </td>
                                                <% }
                                                %>
                                        </tr>
                                        <tr>
                                            <th scope="row">Address</th>
                                            <td><input name="address" type="text" value="<%=careTaker.getAddress()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Account Created On</th>
                                            <td><%=careTaker.getCreate_time()%></td>
                                        </tr>

                                        <tr>
                                            <th scope="row">Choose a Profile Picture</th>
                                            <td><input type="file" name="profilePicture" value="" class="form-control"></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="container text-center">
                                    <button type="submit", class="btn" style="background: red;">Save</button>
                                </div>
                            </form>

                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn careTaker-background " data-dismiss="modal">Close</button>
                        <button id="editBtn" type="button" class="btn">Edit</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <!--<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>-->
        <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myJS.js" type="text/javascript"></script>
        <script>
            const editBtn = document.getElementById("editBtn");
            let editClicked = true;
            const profileDetails = document.getElementById("profile-details");
            const profileEdit = document.getElementById("profile-edit");
            editBtn.addEventListener("click", function () {
                console.log("clicked");
                if (editClicked) {
                    profileDetails.style.display = "none";
                    profileEdit.style.display = "";
                    editClicked = false;
                    editBtn.innerText = "Cancel";
                } else {
                    profileDetails.style.display = "";
                    profileEdit.style.display = "none";
                    editClicked = true;
                    editBtn.innerText = "Edit";
                }

            });
        </script>
    </body>
</html>
