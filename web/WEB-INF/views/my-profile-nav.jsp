<%-- 
    Document   : my-profile-nav
    Created on : 04-Oct-2017, 21:17:47
    Author     : vinod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Widget -->
        <div class="col-md-4">
            <div class="sidebar left">

                <div class="my-account-nav-container">

                    <ul class="my-account-nav">
                        <li class="sub-nav-title">Manage Account</li>
                        <li><a href="my-profile.html"><i class="sl sl-icon-user"></i> My Profile</a></li>
                    </ul>

                    <ul class="my-account-nav">
                        <li class="sub-nav-title">Manage Listings</li>
                        <li><a href="#"><i class="sl sl-icon-docs"></i> My Properties</a></li>
                        <li><a href="submit-property.html"><i class="sl sl-icon-action-redo"></i> Submit New Property</a></li>
                    </ul>

                    <ul class="my-account-nav">
                        <li><a href="change-pw"  class="current"><i class="sl sl-icon-lock"></i> Change Password</a></li>
                        <li><a href="logOut"><i class="sl sl-icon-power"></i> Log Out</a></li>
                    </ul>

                </div>

            </div>
        </div>

    </body>
</html>
