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