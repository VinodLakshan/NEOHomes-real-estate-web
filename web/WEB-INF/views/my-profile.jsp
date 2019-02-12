<%-- 
    Document   : submit-property
    Created on : 26-Sep-2017, 11:45:38
    Author     : vinod
--%>

<%@page import="com.ijse.neohomesrealestate.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>

    <body onload="previewProImg()">

        <!-- Wrapper -->
        <div id="wrapper">

            <%@include file="headerBar.jsp" %>

            <!-- Titlebar
            ================================================== -->
            <div id="titlebar" style="height: 1px;">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12" style="margin-top: -20px;">

                            <h2>My Profile</h2>

                            <!-- Breadcrumbs -->
                            <nav id="breadcrumbs">
                                <ul>
                                    <li>My Details</li>
                                </ul>
                            </nav>

                        </div>
                    </div>
                </div>
            </div><br><br>

            <!-- Content
            ================================================== -->
            <div class="container">
                <div class="row">

                    <%@include file="my-profile-nav.jsp" %>

                    <% User user = (User) request.getSession().getAttribute("loggedUser");%>

                    <div class="col-md-8">
                        <div class="row">
                            <form id="frmSaveChanges" enctype="multipart/form-data" method="POST">
                                <div class="col-md-8 my-profile">
                                    <h4 class="margin-top-0 margin-bottom-30">My Account</h4>

                                    <label>Your Name</label>
                                    <input name="txtUpdateName" value="<%= user.getName()%>" type="text">

                                    <label>NIC</label>
                                    <input name="txtUpdateNic" value="<%= user.getNic()%>" type="text">

                                    <label>Phone</label>
                                    <input name="txtUpdateTp" value="<%= user.getTelephone()%>" type="text">

                                    <label>Address</label>
                                    <input name="txtUpdateAddress" value="<%= user.getAddress()%>" type="text">

                                    <label>Email</label>
                                    <input name="txtUpdateEmail" value="<%= user.getEmail()%>" type="text">


                                    <h4 class="margin-top-50 margin-bottom-25">About Me</h4>
                                    <textarea placeholder="Write something about you" name="txtUpdateDesc" cols="30" rows="10"><%= user.getMyDesc()%></textarea>


                                    <h4 class="margin-top-50 margin-bottom-0">Social</h4>

                                    <label><i class="fa fa-twitter"></i> Twitter</label>
                                    <input name="txtUpdateTw" value="<%= user.getTwitter()%>" type="text">

                                    <label><i class="fa fa-facebook-square"></i> Facebook</label>
                                    <input name="txtUpdateFb" value="<%= user.getFacebook()%>" type="text">

                                    <label><i class="fa fa-google-plus"></i> Google+</label>
                                    <input name="txtUpdateGp" value="<%= user.getGoogleP()%>" type="text">

                                    <label><i class="fa fa-linkedin"></i> Linkedin</label>
                                    <input name="txtUpdateLi" value="<%= user.getLinkedIn()%>" type="text">

                                    <div id="errorNotifyUpdateUser" class="notification error closeable">
                                        <p id="txtErrorMsgUpdateUser">xxxxxx</p>
                                        <a  class="close" id="btCloseUpdateUser" href="#"></a>
                                    </div><br>

                                    <button id="btnSaveChanges" class="button margin-top-20 margin-bottom-20">Save Changes</button>
                                </div>

                                <div class="col-md-4">
                                    <!-- Avatar -->
                                    <div class="edit-profile-photo">
                                        <img id="imgProPicUpdate" style="width: 180px; height: 180px;" src="<c:url value="/assests/images/student-512.jpg"/>" alt="">
                                        <div class="change-photo-btn">
                                            <div class="photoUpload">
                                                <span><i class="fa fa-upload"></i> Upload Photo</span>
                                                <input id="txtUpdateProImg" name="txtUpdateProImg" type="file" class="upload" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>


            <%@include file="footerBar.jsp"%>
            <!-- Back To Top Button -->
            <div id="backtotop"><a href="#"></a></div>

        </div>
        <!-- Wrapper / End -->
        <script type="text/javascript" src="<c:url value="/assests/scripts/userManage.js"/>"></script>
    </body>

</html>
