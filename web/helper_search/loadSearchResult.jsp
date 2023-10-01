<%@page import="com.shm.careBridge.dao.DoctorDao" %>
<%@page import="com.shm.careBridge.helper.ConnectionProvider" %>
<%@page import="com.shm.careBridge.entities.Doctor" %>
<%@page import="java.util.*" %>
<%@page import="java.io.BufferedReader" %>
<%@page import="org.json.JSONObject" %>


<%
    
    


            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String requestBody = sb.toString();

            String jsonString = requestBody;
            JSONObject jsonObj = null;
            
            jsonObj = new JSONObject(jsonString);
                
            String name = jsonObj.getString("search");
            
            DoctorDao doctorDao = new DoctorDao(ConnectionProvider.getConnection());
            List<Doctor> doctors = doctorDao.getDoctorByNameRegX(name);
            if(doctors.size()>0){
            %>
                <div class="row">
            <%
            
                for(Doctor doctor : doctors){

            %>

                    <div class="container coll-md-6 mt-2 ml-2 mb-2" id="<%=doctor.getId()%>">
                        <a href="#" data-toggle="modal" data-target="#doctorProfileModal" style="padding-right: 30%" class="badge badge-light" id="linker"><img src="img/<%= doctor.getProfilePicture() %>" width="30px" alt="profilePicture"/>&nbsp;&nbsp;<%= doctor.getFullName() %></a>
                    </div>
                    
                    
                    
                                <!--DOCTOR PROFILE MODAL VIEWER-->

                    <div class="modal fade" id="doctorProfileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header primary-background text-white text-centre">
                                    <h5 class="modal-title" id="exampleModalLabel">Doctor Details</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="container text-center">
                                        <img src="img/<%= doctor.getProfilePicture()%>" class="img-fluid" style="border-radius: 50%; max-width: 150px;">
                                        <br>
                                        <h5 class="modal-title mt-3" id="exampleModalLabel"><%= doctor.getFullName()%></h5>
                                    </div>

                                    <div id="profile-details" class="container mt-3">
                                        <table class="table table-hover">
                                            <tbody class="primary-background text-white">
                                                
                                                <tr>
                                                    <th scope="row">First Name</th>
                                                    <td><%= doctor.getFirstName()%></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Last Name</th>
                                                    <td><%= doctor.getLastName()%></td>
                                                </tr>
                                                
                                                <tr>
                                                    <th scope="row">Email</th>
                                                    <td><%=doctor.getEmail()%></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Specialization</th>
                                                    <td><%=doctor.getSpecialization()%></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Description</th>
                                                    <td><%=doctor.getBio()%></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Gender</th>
                                                    <td><%=doctor.getGender()%></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Registration No.</th>
                                                    <td><%=doctor.getRegNoMBBS()%></td>
                                                </tr>
                                                <tr>
                                                    <th scope="row">Account Created On</th>
                                                    <td><%=doctor.getCreate_time()%></td>
                                                </tr>
                                            </tbody>
                                        </table>


                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn primary-background text-white" data-dismiss="modal">Close</button>
                                    <button type="button" id="bookAppointment" class="btn bookAppointmentBtn">Book Appointment</button>
                                    <button type="button" id="connect" class="btn connectBtn" style="background: #56d1f7;">Connect</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    

            <%
                }
            %>
        
                </div>
            
            
        <%
            }else{
                out.println("<div class='coll-md-6 text-center mt-2'>");
                out.println("<p>NO RESULT FOUND..</p>");
                out.println("</div>");
            }
        %>