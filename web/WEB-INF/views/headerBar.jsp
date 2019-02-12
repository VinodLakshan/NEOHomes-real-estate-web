<%-- 
    Document   : header-footer
    Created on : 15-Sep-2017, 22:56:49
    Author     : vinod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NEO Homes</title>
        <link rel="stylesheet" href="<c:url value="/assests/css/style.css" />">
        <link rel="stylesheet" href="<c:url value="/assests/css/colors/main.css"/>">
    </head>
    <body>

        <!-- Header Container
        ================================================== -->
        <header id="header-container">

            <!-- Topbar -->
            <div id="top-bar">
                <div class="container">

                    <!-- Left Side Content -->
                    <div class="left-side">

                        <!-- Top bar -->
                        <ul class="top-bar-menu">
                            <li><i class="fa fa-phone"></i> +12 34 123456789 </li>
                            <li><i class="fa fa-envelope"></i> <a href="#"><span>neohomes@gmail.com</span></a></li>
                        </ul>

                    </div>
                    <!-- Left Side Content / End -->


                    <!-- Left Side Content -->
                    <div class="right-side">

                        <!-- Social Icons -->
                        <ul class="social-icons">
                            <li><a class="facebook" target="_blank" href="https://www.facebook.com/"><i class="icon-facebook"></i></a></li>
                            <li><a class="twitter" target="_blank" href="https://www.twitter.com/"><i class="icon-twitter"></i></a></li>
                            <li><a class="gplus" target="_blank" href="https://www.plus.google.com/"><i class="icon-gplus"></i></a></li>
                            <li><a class="instagram" target="_blank" href="https://www.instagram.com/"><i class="icon-instagram"></i></a></li>
                        </ul>

                    </div>
                    <!-- Left Side Content / End -->

                </div>
            </div>
            <div class="clearfix"></div>
            <!-- Topbar / End -->


            <!-- Header -->
            <div id="header">
                <div class="container">

                    <!-- Left Side Content -->
                    <div class="left-side">

                        <!-- Logo -->
                        <div id="logo">
                            <a href="home"><img src="<c:url value="/assests/images/neoHomes.jpg"/>" alt=""></a>
                        </div>


                        <!-- Mobile Navigation -->
                        <div class="menu-responsive">
                            <i class="fa fa-reorder menu-trigger"></i>
                        </div>


                        <!-- Main Navigation -->
                        <nav id="navigation" class="style-1">
                            <ul id="responsive">

                                <li><a class="current" href="home">Home</a></li>

                                <li><a href="#">Buy</a>
                                    <ul>
                                        <li><a href="#">Apartments</a></li>
                                        <li><a href="#">Houses</a></li>
                                        <li><a href="#">Lots</a></li>
                                    </ul>
                                </li>

                                <li><a href="#">My Account</a>
                                    <ul>
                                        <li><a href="login-register">My Profile</a></li>
                                        <li><a href="my-properties.html">My Properties</a></li>
                                        <li><a href="change-pw">Change Password</a></li>
                                        <li><a href="subProp-login">Submit Property</a></li>
                                    </ul>
                                </li>

                                <li><a href="contact">Contact</a></li>

                            </ul>
                        </nav>
                        <div class="clearfix"></div>
                        <!-- Main Navigation / End -->

                    </div>
                    <!-- Left Side Content / End -->

                    <!-- Right Side Content / End -->
                    <div class="right-side">
                        <!-- Header Widget -->
                        <div class="header-widget">
                            <a href="login-register" class="sign-in"><i class="fa fa-user"></i> Log In / Register</a>
                            <a href="subProp-login" class="button border">Submit Property</a>
                        </div>
                        <!-- Header Widget / End -->
                    </div>
                    <!-- Right Side Content / End -->

                </div>
            </div>
            <!-- Header / End -->

        </header>
        <div class="clearfix"></div>
        <!-- Header Container / End -->


    </body>
</html>
