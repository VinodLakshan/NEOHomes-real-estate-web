<%-- 
    Document   : login-register
    Created on : 15-Sep-2017, 23:20:36
    Author     : vinod
--%>

<%@page import="java.util.List"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.ijse.neohomesrealestate.model.Parts"%>
<%@page import="com.ijse.neohomesrealestate.model.HomeFeature"%>
<%@page import="com.ijse.neohomesrealestate.model.HomePartition"%>
<%@page import="com.ijse.neohomesrealestate.model.Advertistment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
            <% Advertistment clickedAdv = (Advertistment) request.getSession().getAttribute("clickedAdv");%>
            <% String[] clickedAdvParts = (String[]) request.getSession().getAttribute("clickedAdvParts");%>
            <div id="titlebar" class="property-titlebar margin-bottom-0">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">

                            <a href="search-results" class="back-to-listings"></a>
                            <div class="property-title">
                                <h2><%= clickedAdv.getTitle()%> <span class="property-badge"><%= clickedAdv.getSaleType()%></span></h2>
                                <span>
                                    <a href="#location" class="listing-address">
                                        <i class="fa fa-map-marker"></i>
                                        <%= clickedAdv.getAddress()%>
                                    </a>
                                </span>
                            </div>

                            <div class="property-pricing">
                                <div>$&nbsp;<%= Math.round(clickedAdv.getPrice())%></div>
                                <div class="sub-price"><%= Math.round(clickedAdv.getArea())%>&nbsp;sq ft</div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>

            <!-- Content
================================================== -->
            <div class="container">
                <div class="row margin-bottom-50">
                    <div class="col-md-12">

                        <!-- Slider -->
                        <div class="property-slider default">
                            <a href="<c:url value="/assests/images/single-property-01.jpg"/>" data-background-image="<c:url value="/assests/images/single-property-01.jpg"/>" class="item mfp-gallery"></a>
                            <a href="<c:url value="/assests/images/single-property-02.jpg"/>" data-background-image="<c:url value="/assests/images/single-property-02.jpg"/>" class="item mfp-gallery"></a>
                            <a href="<c:url value="/assests/images/single-property-03.jpg"/>" data-background-image="<c:url value="/assests/images/single-property-03.jpg"/>" class="item mfp-gallery"></a>
                            <a href="<c:url value="/assests/images/single-property-04.jpg"/>" data-background-image="<c:url value="/assests/images/single-property-04.jpg"/>" class="item mfp-gallery"></a>
                        </div>

                        <!-- Slider Thumbs -->
                        <div class="property-slider-nav">
                            <div class="item"><img src="<c:url value="/assests/images/single-property-01.jpg"/>" alt=""></div>
                            <div class="item"><img src="<c:url value="/assests/images/single-property-02.jpg"/>" alt=""></div>
                            <div class="item"><img src="<c:url value="/assests/images/single-property-03.jpg"/>" alt=""></div>
                            <div class="item"><img src="<c:url value="/assests/images/single-property-04.jpg"/>" alt=""></div>
                        </div>

                    </div>
                </div>
            </div>


            <div class="container">
                <div class="row">

                    <!-- Property Description -->
                    <div class="col-lg-8 col-md-7">
                        <div class="property-description">

                            <!-- Main Features -->
                            <ul class="property-main-features">
                                <li>Area <span><%= Math.round(clickedAdv.getArea())%>&nbsp;sq ft</span></li>
                                <li>Building Age <span><%= clickedAdv.getBuildingAge()%></span></li>
                                <li>Bedrooms <span><%= clickedAdv.getHomePartitionList().get(0).getPartCount()%></span></li>
                                <li>Bathrooms <span><%= clickedAdv.getHomePartitionList().get(1).getPartCount()%></span></li>
                            </ul>


                            <!-- Description -->
                            <h3 class="desc-headline">Description</h3>
                            <div class="show-more">
                                <p>
                                    <%= clickedAdv.getDescription()%>
                                </p>

                                <a href="#" class="show-more-button">Show More <i class="fa fa-angle-down"></i></a>
                            </div>

                            <!-- Details -->
                            <h3 class="desc-headline">Partition Details</h3>
                            
                            <ul class="property-features margin-top-0">
                                <% for (int i = 2; i < clickedAdv.getHomePartitionList().size() ; i++) {%>
                                
                                <li>
                                    <%= clickedAdvParts[i] %> : 
                                    <span><%= clickedAdv.getHomePartitionList().get(i).getPartCount()%></span>
                                </li>

                                <%}%>
                            </ul>


                            <!-- Features -->
                            <h3 class="desc-headline">Features</h3>
                            <ul class="property-features checkboxes margin-top-0">
                                <% for (HomeFeature feature : clickedAdv.getHomeFeatureList()) {%>
                                <li>
                                    <%= feature.getFeature().getFeatureName()%>
                                </li>
                                <%}%>
                            </ul>


                            <!-- Location -->
                            <h3 class="desc-headline no-border" id="location">Location</h3>
                            <div id="propertyMap-container">
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4090.806975081711!2d-0.1622297870358711!3d51.52361535331186!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48761acf33628211%3A0x445d7677a88322e1!2s221B+Baker+St%2C+Marylebone%2C+London+NW1+6XE%2C+UK!5e0!3m2!1sen!2slk!4v1508138424519" frameborder="0" style="border:0; width: 100%;height: 100%" allowfullscreen></iframe>
                            </div>

                        </div>
                    </div>
                    <!-- Property Description / End -->


                    <!-- Sidebar -->
                    <div class="col-lg-4 col-md-5">
                        <div class="sidebar sticky right">

                            <!-- Widget -->
                            <div class="widget">

                                <!-- Agent Widget -->
                                <div class="agent-widget">
                                    <div class="agent-title">
                                        <div class="agent-photo"><img src="<c:url value="/assests/images/agent-01.jpg"/>" alt="" /></div>
                                        <div class="agent-details">
                                            <h4><a href="#"><%= clickedAdv.getUser().getName()%></a></h4>
                                            <span><i class="sl sl-icon-call-in"></i><%= clickedAdv.getUser().getTelephone()%></span>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>

                                    <input type="text" placeholder="Your Email" pattern="^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$">
                                    <input type="text" placeholder="Your Phone">
                                    <textarea>I'm interested in this property [ID 123456] and I'd like to know more details.</textarea>
                                    <button class="button fullwidth margin-top-5">Send Message</button>
                                </div>
                                <!-- Agent Widget / End -->

                            </div>
                            <!-- Widget / End -->

                        </div>
                    </div>
                    <!-- Sidebar / End -->

                </div>
            </div>


            <%@include file="footerBar.jsp"%>
        </div>
    </body>
</html>
