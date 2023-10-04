
<%@page import="com.shm.careBridge.entities.Patient" %>
<%@page import="com.shm.careBridge.entities.PromptMessage" %>
<%@page errorPage="error_page.jsp" %>
<%@page import="org.apache.commons.lang3.StringUtils" %>
<%
    Patient patient = (Patient)session.getAttribute("currentPatient");
    if(patient == null){
        response.sendRedirect("patient_login_page.jsp");
    }
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
<!--                    <div class="input-group-prepend">
                        <div class="input-group-text">-->
                            <a class="nav-link" id="viewSearchBar" href="#!"><span class="fa fa-search"></span>&nbsp;&nbsp;</a>
<!--                        </div>
                    </div>-->
                    </li>
                    
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
                            <a class="nav-link active" href="PatientLogoutServlet">Logout</a>
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


        
        
        <!--SEARCH BOX-->
        <div class="container mt-2" id="searchBar" style="display:none;">
            <form  class="form-inline my-2 my-lg-0" method="post" action="#" id="searchBox">
                <input name="search" id="search" class="form-control mr-sm-2 " type="search" placeholder="Search" aria-label="Search" width="20px" autocomplete="off">
                
                <div class="input-group-append">
                    <button id="cancel_search" class="btn btn-primary primary-background" style="display:none;"><i class="fa fa-times"></i></button>
                </div>
            </form>
            <div class="col-md-6" >
                <div class="container text-center border " id="loader" style="display:none;">
                    <i class="fa fa-refresh fa-2x fa-spin mt-4"></i>
                    <h5 class="mt-2">Searching...</h5>
                </div>
                <div class="container-fluid border mt-1" id="searchBoxResult" style="display:none;"></div>
            </div>
        </div>
        
        

        <!--Start of Profile (in modal)-->

        <!-- Modal -->
        <div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header primary-background text-white text-centre">
                        <h5 class="modal-title" id="exampleModalLabel">Profile Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container text-center">
                            <img src="img/<%= patient.getProfilePicture()%>" class="img-fluid" style="border-radius: 50%; max-width: 150px;">
                            <br>
                            <h5 class="modal-title mt-3" id="exampleModalLabel"><%= patient.getFirstName() + " " + patient.getLastName()%></h5>
                        </div>

                        <div id="profile-details" class="container mt-3">
                            <table class="table table-hover">
                                <tbody class="primary-background text-white">
                                    <tr>
                                        <th scope="row">Patient ID</th>
                                        <td><%=patient.getPid()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Username</th>
                                        <td><%=patient.getUsername()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">First Name</th>
                                        <td><%= patient.getFirstName()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Last Name</th>
                                        <td><%= patient.getLastName()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Password</th>
                                        <td type="password"><%= StringUtils.repeat("*", patient.getPassword().length())%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Email</th>
                                        <td><%=patient.getEmail()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Emergency Contact</th>
                                        <td><%= patient.getEmergencyContact()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Description</th>
                                        <td><%=patient.getDescription()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Gender</th>
                                        <td><%=patient.getGender()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Address</th>
                                        <td><%=patient.getAddress()%></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Account Created On</th>
                                        <td><%=patient.getCreate_time()%></td>
                                    </tr>
                                </tbody>
                            </table>


                        </div>



                        <!--Profile Edit-->

                        <div id="profile-edit" class="container mt-3" style="display: none;">
                            <form action="EditPatientProfileServlet" method="post" enctype="multipart/form-data">
                                <table class="table table-hover">
                                    <tbody class="primary-background text-white">
                                        <tr>
                                            <th scope="row">Patient ID</th>
                                            <td><%=patient.getPid()%></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Username</th>
                                            <td><%=patient.getUsername()%></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">First Name</th>
                                            <td><input name="firstName" type="text" value="<%= patient.getFirstName()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Last Name</th>
                                            <td><input name="lastName" type="text" value="<%= patient.getLastName()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Email</th>
                                            <td><input name="email" type="text" value="<%=patient.getEmail()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Password</th>
                                            <td><input name="password" type="text" value="<%= patient.getPassword()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Emergency Contact</th>
                                            <td><input name="emergencyContact" type="text" value="<%= patient.getEmergencyContact()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Description</th>
                                            <td><textarea name="description" rows="3" class="form-control"><%=patient.getDescription()%></textarea></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Gender</th>
                                                <% if(patient.getGender().equals("Male")){
                                                %>
                                            <td>
                                                <input type="radio" name="gender" value="<%=patient.getGender()%>" checked><%=patient.getGender()%>
                                                <input type="radio" name="gender" value="Female" >Female
                                            </td>
                                            <% }else{
                                            %>
                                            <td>
                                                <input type="radio" name="gender" value="Male" ><%=patient.getGender()%>
                                                <input type="radio" name="gender" value="<%=patient.getGender()%>" checked><%=patient.getGender()%>
                                            </td>
                                            <% }
                                            %>
                                        </tr>
                                        <tr>
                                            <th scope="row">Address</th>
                                            <td><input name="address" type="text" value="<%=patient.getAddress()%>" class="form-control"></td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Account Created On</th>
                                            <td><%=patient.getCreate_time()%></td>
                                        </tr>

                                        <tr>
                                            <th scope="row">Choose a Profile Picture</th>
                                            <td><input type="file" name="profilePicture" value="<%=patient.getProfilePicture()%>" class="form-control"></td>
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
                        <button type="button" class="btn primary-background text-white" data-dismiss="modal">Close</button>
                        <button id="editBtn" class="btn ">Edit</button>
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



            const search = document.getElementById("search");
            const loader = document.getElementById("loader");
            const searchBoxResult = document.getElementById("searchBoxResult");
            const searchBox = document.getElementById("searchBox");
            var clicker = null;
            const cancel_search = document.getElementById("cancel_search");
            
            if(search.value!=""){
                    cancel_search.style.display = "";
            }
            
            
            search.addEventListener("focus", function () {

                if(search.value!=""){
                    cancel_search.style.display = "";
                }

                searchBox.addEventListener("keyup",async function () {
                    event.preventDefault();
                    
                    if(search.value!=""){
                        cancel_search.style.display = "";
                    }
                    
                    loader.style.display = "none";
                    searchBoxResult.style.display = "none";
                    
                    const formData = new FormData(this);

                    const fromDataObject = await Object.fromEntries(formData.entries());
                    const formDataJsonString = JSON.stringify(fromDataObject);

                    const fetchOptions = {
                        method: 'POST',
                        headers: {
                            'Content-Type': '*/*',
                            'Accept': '*/*',
                        },
                        body: formDataJsonString,
                    };
                    if(search.value!==""){
                        cancel_search.style.display = "";
                        searchDoctor(fetchOptions);
                        
                    }else{
                        cancel_search.style.display = "none";
                    }

                });

            });

//            search.addEventListener("focusout", function () {
//                loader.style.display = "none";
//                searchBoxResult.style.display = "none";
//            });


            cancel_search.addEventListener("click", () => {
               event.preventDefault();
               search.value = "";
               cancel_search.style.display = "none";
               loader.style.display = "none";
               searchBoxResult.style.display = "none";
            });


            function searchDoctor(fetchOptions) {
                loader.style.display = "";
                searchBoxResult.style.display = "none";
                fetch("helper_search/loadSearchResult.jsp", fetchOptions).
                        then(function (response) {
                            return response.text();
                        }).then(function (data) {
//                    console.log(data);
                    loader.style.display = "none";
                    searchBoxResult.style.display = "";
                    searchBoxResult.innerHTML = data;
                    
                    doctorClicked();
                });
            }
            
            function doctorClicked(){
                clicker = document.getElementById("2");
                    clicker.addEventListener("click", ()=>{
                       console.log("clicked");
                    });
                    
                    
            }
            
            
            
            
            
            
            
            const viewSearchBar = document.getElementById("viewSearchBar");
            const searchBar = document.getElementById("searchBar");
            var searchClickCount = 0;
            viewSearchBar.addEventListener("click", () => {
                event.preventDefault();
                
                if(searchClickCount === 0){
                    searchClickCount = 1;
                    searchBar.style.display = "";
                }else{
                    searchClickCount = 0;
                    searchBar.style.display = "none";
                }
                
                
            });
        </script>
    </body>
</html>
