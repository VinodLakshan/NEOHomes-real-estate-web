<%-- 
    Document   : submit-property
    Created on : 26-Sep-2017, 11:45:38
    Author     : vinod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>

    <body>

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

                    <div class="col-md-8">
                        <div class="row">

                            <form id="frm-changePass">
                                <div class="col-md-6  my-profile">
                                    <h4 class="margin-top-0 margin-bottom-30">Change Password</h4>

                                    <label>Current Password</label>
                                    <input type="password" id="txtOldPass" name="txtOldPass">

                                    <label>New Password</label>
                                    <input type="password" id="txtPass1" name="txtPass1">

                                    <label>Confirm New Password</label>
                                    <input type="password" id="txtPassCon" name="txtPassCon">

                                    <div id="errorNotifyChangePass" class="notification error closeable">
                                        <p id="txtErrorMsgChangePass">xxxxxx</p>
                                        <a class="close" id="btCloseChangePass" href="#"></a>
                                    </div>

                                    <a id="btPassChange" class="margin-top-20 button">Save Changes</a>
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
        <script type="text/javascript" src="<c:url value="/assests/scripts/validation.js"/>"></script>
    </body>

</html>
