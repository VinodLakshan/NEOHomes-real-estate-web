<%-- 
    Document   : login-register
    Created on : 15-Sep-2017, 23:20:36
    Author     : vinod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

                            <h2>Log In & Register</h2>

                            <!-- Breadcrumbs -->
                            <nav id="breadcrumbs">
                                <ul>
                                    <li><a href="#">Home</a></li>
                                    <li>Log In & Register</li>
                                </ul>
                            </nav>

                        </div>
                    </div>
                </div>
            </div>

            
            <!-- Contact
            ================================================== -->

            <!-- Container -->
            <div class="container">

                <div class="row">
                    <div class="col-md-4 col-md-offset-4">

                        <!--Tab -->
                        <div class="my-account style-1 margin-top-5 margin-bottom-40">

                            <ul class="tabs-nav">
                                <li class=""><a href="#tab1">Log In</a></li>
                                <li><a href="#tab2">Register</a></li>
                            </ul>

                            <div class="tabs-container alt">

                                <!-- Login -->
                                <div class="tab-content" id="tab1" style="display: none;">
                                    <form method="post" class="login" id="frmLogin">

                                        <p class="form-row form-row-wide">
                                            <label for="username">
                                                <i class="im im-icon-Male"></i>
                                                <input type="text" placeholder="  Username" class="input-text" name="txtUsernameLogin" id="txtUsernameLogin" value="" />
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="password">
                                                <i class="im im-icon-Lock-2"></i>
                                                <input class="input-text" placeholder="  Password" type="password" name="txtPassLogin" id="txtPassLogin"/>
                                            </label>
                                        </p>

                                        <div id="errorNotifyLogin" class="notification error closeable">
                                            <p id="txtErrorMsgLogin">xxxxxx</p>
                                            <a class="close" id="btClose1" href="#"></a>
                                        </div>

                                        <p class="form-row">
                                            <input type="submit" class="button border margin-top-10" id="btLogin" name="btLogin" value="Login" />

                                        </p>

                                    </form>
                                </div>

                                <!-- Register -->
                                <div class="tab-content" id="tab2" style="display: none;">

                                    <form class="register" id="frmRegister" enctype="multipart/form-data" method="POST">

                                        <div id="proPicDiv" style="position: relative; width: 50%; left: 25%">
                                            <!-- Avatar -->
                                            <div class="edit-profile-photo">
                                                <img id="imgProPic" style="resize: both; width: 180px; height: 180px;" src="<c:url value="/assests/images/student-512.jpg"/>" alt="">
                                                <div class="change-photo-btn">
                                                    <div class="photoUpload">
                                                        <span><i class="fa fa-upload"></i> Upload Photo</span>
                                                        <input name="imgInput" class="upload"  id="imgInput" type="file" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div><br>

                                        <p class="form-row form-row-wide">
                                            <label for="txtName">
                                                <i class="im im-icon-Male"></i>
                                                <input type="text" placeholder="Name" class="input-text" name="txtName" id="txtName" required/>
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtNic">
                                                <i class="im im-icon-Credit-Card"></i>
                                                <input type="text" placeholder="NIC" class="input-text" required name="txtNic" id="txtNic"/>
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtUsername">
                                                <i class="im im-icon-Male"></i>
                                                <input type="text" placeholder="Username" class="input-text" required name="txtUsername" id="txtUsername"/>
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtGender">
                                                <i class="im im-icon-Bisexual"></i>
                                                <input type="text" placeholder="Gender" class="input-text"  name="txtGender" id="txtGender" readonly />
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtEmail">
                                                <i class="im im-icon-At-Sign"></i>
                                                <input type="email" placeholder="Email" class="input-text" required name="txtEmail" id="txtEmail" />
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtAddress">
                                                <i class="im im-icon-Mail"></i>
                                                <input type="text" placeholder="Address" class="input-text" required name="txtAddress" id="txtAddress" />
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtTelephone">
                                                <i class="im im-icon-Phone-2"></i>
                                                <input type="tel" placeholder="Telephone" class="input-text" required name="txtTelephone" id="txtTelephone" />
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtPass1">
                                                <i class="im im-icon-Lock-2"></i>
                                                <input class="input-text" placeholder="Password" required type="password" name="txtPass1" id="txtPass1"/>
                                            </label>
                                        </p>

                                        <p class="form-row form-row-wide">
                                            <label for="txtPassCon">
                                                <i class="im im-icon-Lock-2"></i>
                                                <input class="input-text" placeholder="Confirm Password" type="password" required name="txtPassCon" id="txtPassCon"/>
                                            </label>
                                        </p>

                                        <div id="errorNotify" class="notification error closeable">
                                            <p id="txtErrorMsg">xxxxxx</p>
                                            <a  class="close" id="btClose" href="#"></a>
                                        </div>

                                        <p class="form-row">
                                            <input type="submit" class="button border fw margin-top-10" id="btReg" name="btReg" value="Register" />
                                        </p>

                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- Container / End -->

            <%@include file="footerBar.jsp"%>
        </div>
        <script type="text/javascript" src="<c:url value="/assests/scripts/userManage.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/validation.js"/>"></script>
    </body>
</html>
