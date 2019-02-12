<%-- 
    Document   : home
    Created on : 15-Sep-2017, 21:59:57
    Author     : vinod
--%>

<%@page import="org.springframework.http.HttpStatus"%>
<%@page import="org.springframework.http.ResponseEntity"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ijse.neohomesrealestate.dto.AdvertistmentDto"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>

    <!-- Basic Page Needs
    ================================================== -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>

<body>
    <!-- Wrapper -->
    <div id="wrapper">

        <%@include file="headerBar.jsp"%>

        <!-- Banner
        ================================================== -->
        <div class="parallax" data-background="<c:url value="/assests/images/background.jpg"/>" data-color="#36383e" data-color-opacity="0.45" data-img-width="2500" data-img-height="1600">
            <div class="parallax-content">

                <div class="container">
                    <div class="row">
                        <div class="col-md-12">

                            <!-- Main Search Container -->
                            <div class="main-search-container">
                                <h2>Find Your Dream Home</h2>

                                <!-- Main Search -->
                                <form id="searchForm" class="main-search-form">

                                    <!-- Type -->
                                    <div class="search-type">
                                        <label class="active"><input class="first-tab" value="" name="tab" checked="checked" type="radio">Any Status</label>
                                        <label><input value="For Sale" name="tab" type="radio">For Sale</label>
                                        <label><input value="For Rent" name="tab" type="radio">For Rent</label>
                                        <div class="search-type-arrow"></div>
                                    </div>


                                    <!-- Box -->
                                    <div class="main-search-box">

                                        <!-- Main Search Input -->
                                        <div class="main-search-input larger-input">
                                            <input type="text" name="txtSearchCity" class="ico-01" placeholder="Enter the city"/>
                                            <input type="text" name="txtSearchState" value="" style="display: none;" />
                                            <button id="btSearch" class="button">Search</button>
                                        </div>

                                        <!-- Row -->
                                        <div class="row with-forms">

                                            <!-- Property Type -->
                                            <div class="col-md-4"><br>
                                                <select name="txtSearchType" data-placeholder="Any Type" class="chosen-select-no-single" >
                                                    <option value="">Any Type</option>	
                                                    <option value="Apartment">Apartments</option>
                                                    <option value="House">Houses</option>
                                                    <option value="Lot">Lots</option>
                                                </select>
                                            </div>

                                            <div class="col-md-1" ></div>
                                            <!-- Price Range -->
                                            <div class="col-md-7 range-slider">
                                                <label>Price Range</label>
                                                <div id="price-range" data-min="0" data-max="1000000" data-unit="$">
                                                    <input type="text" name="txtPrice" class="first-slider-value"/>
                                                    <input type="text" name="txtPrice" class="second-slider-value"/>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>

                                        </div>
                                        <!-- Row / End -->


                                        <!-- More Search Options -->
                                        <a href="#" class="more-search-options-trigger" data-open-title="More Options" data-close-title="Less Options"></a>

                                        <div class="more-search-options">
                                            <div class="more-search-options-container">

                                                <!-- Row -->
                                                <div class="row with-forms">

                                                    <!-- Area Range -->
                                                    <div class="col-md-12 range-slider">
                                                        <label>Area Range</label>
                                                        <div id="area-range" data-min="0" data-max="5000" data-unit="sq ft">
                                                            <input type='text' name="txtArea" class='first-slider-value'/>
                                                            <input type='text' name="txtArea" class='second-slider-value'/>
                                                        </div>
                                                        <div class="clearfix"></div>
                                                    </div>

                                                </div>
                                                <!-- Row / End -->


                                                <!-- Row -->
                                                <div class="row with-forms">

                                                    <!-- Min Area -->
                                                    <div class="col-md-6">
                                                        <select name="txtSearchBed" data-placeholder="Beds" class="chosen-select-no-single" >
                                                            <option value="0" label="blank"></option>	
                                                            <option value="0">Beds (Any)</option>	
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                        </select>
                                                    </div>

                                                    <!-- Max Area -->
                                                    <div class="col-md-6">
                                                        <select name="txtSearchBath" data-placeholder="Baths" class="chosen-select-no-single" >
                                                            <option value="0" label="blank"></option>	
                                                            <option value="0">Baths (Any)</option>	
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                        </select>
                                                    </div>

                                                </div>
                                                <!-- Row / End -->


                                                <!-- Checkboxes -->
                                                <div class="checkboxes in-row">
                                                    <input id="check-x" checked type="checkbox" name="searchFeature" value="xx" style="display: none;">

                                                    <input id="check-1" type="checkbox" name="searchFeature" value="Air Condition">
                                                    <label for="check-1">Air Condition</label>

                                                    <input id="check-2" type="checkbox" name="searchFeature" value="Swimming Pool">
                                                    <label for="check-2">Swimming Pool</label>

                                                    <input id="check-3" type="checkbox" name="searchFeature" value="Central Heating">
                                                    <label for="check-3">Central Heating</label>

                                                    <input id="check-5" type="checkbox" name="searchFeature" value="GYM">
                                                    <label for="check-5">Gym</label>

                                                    <input id="check-4" type="checkbox" name="searchFeature" value="Laundary Room">
                                                    <label for="check-4">Laundry Room</label>	

                                                    <input id="check-6" type="checkbox" name="searchFeature" value="Alarm">
                                                    <label for="check-6">Alarm</label>

                                                    <input id="check-7" type="checkbox" name="searchFeature" value="Window Covering">
                                                    <label for="check-7">Window Covering</label>

                                                </div>
                                                <!-- Checkboxes / End -->

                                            </div>
                                        </div>
                                        <!-- More Search Options / End -->


                                    </div>
                                    <!-- Box / End -->

                                </form>
                                <!-- Main Search -->

                            </div>
                            <!-- Main Search Container / End -->

                        </div>
                    </div>
                </div>

            </div>
        </div>


        <!-- Content
        ================================================== -->
        <div class="container">
            <div class="row">

                <div class="col-md-12">
                    <h3 class="headline margin-bottom-25 margin-top-65">Newly Added</h3>
                </div>
                <!-- Carousel -->
                <div class="col-md-12">
                    <div class="carousel">
                        <% List<AdvertistmentDto> sixAds = (List<AdvertistmentDto>) application.getAttribute("sixAds");
                            if (sixAds == null) {
                                sixAds = new ArrayList<>();
                            }
                        %>
                        <% for (AdvertistmentDto advertistmentDto : sixAds) {%>

                        <!-- Listing Item -->
                        <div class="carousel-item">
                            <div class="listing-item">

                                <a href="#" onclick="viewAdv(<%= advertistmentDto.getAdvertistment().getAdvId()%>)" class="listing-img-container">

                                    <div class="listing-badges">
                                        <span><%= advertistmentDto.getAdvertistment().getType()%></span>
                                    </div>

                                    <div class="listing-img-content">
                                        <span class="listing-price">&dollar;&nbsp;<%= Math.round(advertistmentDto.getAdvertistment().getPrice())%> 
                                            <i><%= advertistmentDto.getAdvertistment().getSaleType()%></i>
                                        </span>
                                    </div>

                                    <div class="listing-carousel">
                                        <div><img id="imgAdHouse" src="<c:url value="/assests/images/single-property-01.jpg"/>"  alt=""></div>
                                    </div>
                                </a>

                                <div class="listing-content">

                                    <div class="listing-title">
                                        <h4><a href="#" onclick="viewAdv(<%= advertistmentDto.getAdvertistment().getAdvId()%>)"><%= advertistmentDto.getAdvertistment().getTitle()%></a></h4>
                                        <i class="fa fa-map-marker" ></i>&nbsp;
                                        <span style="font-size: 16px; font-weight: 200;"><%= advertistmentDto.getAdvertistment().getCity()%></span>&nbsp;&nbsp; - &nbsp;&nbsp;
                                        <span><%= advertistmentDto.getAdvertistment().getAddress()%></span>
                                    </div>

                                    <ul class="listing-features">
                                        <li><i class="fa fa-arrows-alt"></i>&nbsp;&nbsp;Area<span><%= Math.round(advertistmentDto.getAdvertistment().getArea())%>&nbsp;sq ft</span></li>
                                        <li><i class="fa fa-bed"></i>&nbsp;&nbsp;Bedrooms<span><%= advertistmentDto.getAdvertistment().getHomePartitionList().get(0).getPartCount()%></span></li>
                                        <li><i class="fa fa-child"></i>&nbsp;&nbsp;Bathrooms<span><%= advertistmentDto.getAdvertistment().getHomePartitionList().get(1).getPartCount()%></span></li>
                                    </ul> 

                                    <div class="listing-footer">
                                        <a href="#"><i class="fa fa-user"></i>&nbsp;<%= advertistmentDto.getAdvertistment().getUser().getName()%></a>
                                        <span><i class="fa fa-calendar-o"></i><span>&nbsp; <%= advertistmentDto.getAdvertistment().getDate()%></span></span>
                                    </div>

                                </div>

                            </div>
                        </div>
                        <!-- Listing Item / End -->

                        <%}%>

                    </div>
                </div>
                <!-- Carousel / End -->
            </div>
        </div>



        <!-- Fullwidth Section -->
        <section class="fullwidth margin-top-105" data-background-color="#f7f7f7">

            <!-- Box Headline -->
            <h3 class="headline-box">What are you looking for?</h3>

            <!-- Content -->
            <div class="container">
                <div class="row">

                    <div class="col-md-4 col-sm-6">
                        <!-- Icon Box -->
                        <div class="icon-box-1">

                            <div class="icon-container">
                                <i class="im im-icon-Office"></i>
                                <div class="icon-links">
                                    <a href="#">For Sale</a>
                                    <a href="#">For Rent</a>
                                </div>
                            </div>

                            <h3>Apartments</h3>
                            <p>Aliquam dictum elit vitae mauris facilisis, at dictum urna dignissim donec vel lectus vel felis.</p>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                        <!-- Icon Box -->
                        <div class="icon-box-1">

                            <div class="icon-container">
                                <i class="im im-icon-Home-2"></i>
                                <div class="icon-links">
                                    <a href="#">For Sale</a>
                                    <a href="#">For Rent</a>
                                </div>
                            </div>

                            <h3>Houses</h3>
                            <p>Aliquam dictum elit vitae mauris facilisis, at dictum urna dignissim donec vel lectus vel felis.</p>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-6">
                        <!-- Icon Box -->
                        <div class="icon-box-1">

                            <div class="icon-container">
                                <i class="im im-icon-Door"></i>
                                <div class="icon-links">
                                    <a href="#">For Sale</a>
                                    <a href="#">For Rent</a>
                                </div>
                            </div>

                            <h3>Lots</h3>
                            <p>Aliquam dictum elit vitae mauris facilisis, at dictum urna dignissim donec vel lectus vel felis.</p>
                        </div>
                    </div>

                </div>
            </div>
        </section>
        <!-- Fullwidth Section / End -->

        <!-- Flip banner -->
        <a href="#" onclick="LoadAllAds();"  class="flip-banner parallax" data-background="<c:url value="/assests/images/flip-banner-bg.jpg"/>" data-color="#274abb" data-color-opacity="0.9" data-img-width="2500" data-img-height="1600">
            <div class="flip-banner-content">
                <h2 class="flip-visible">We make your dream come true</h2>
                <h2 class="flip-hidden">Browse Properties <i class="sl sl-icon-arrow-right"></i></h2>
            </div>
        </a>
        <!-- Flip banner / End -->

        <%@include file="footerBar.jsp"%>
    </div>
    <!-- Wrapper / End -->

    <script type="text/javascript" src="<c:url value="/assests/scripts/advertistmentControl.js"/>"></script>
</body>

</html>
