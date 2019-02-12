<%-- 
    Document   : submit-property
    Created on : 26-Sep-2017, 11:45:38
    Author     : vinod
--%>

<%@page import="com.ijse.neohomesrealestate.dto.SearchAdvertistment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ijse.neohomesrealestate.dto.AdvertistmentDto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>

    <body>

        <!-- Wrapper -->
        <div id="wrapper">

            <%@include file="headerBar.jsp" %>


            <!-- Titlebar ================================================== -->
            <div class="parallax titlebar"
                 data-background="<c:url value="/assests/images/listings-parallax.jpg" />"
                 data-color="#333333"
                 data-color-opacity="0.7"
                 data-img-width="800"
                 data-img-height="505">

                <div id="titlebar" style="height: 5px; padding: 50px;">
                    <div class="container" >
                        <div class="row">
                            <div class="col-md-12" style="margin: -15px;">

                                <h2>Listings</h2>

                                <!-- Breadcrumbs -->
                                <nav id="breadcrumbs">
                                    <ul>
                                        <li><a href="#">Home</a></li>
                                        <li>Listings</li>
                                    </ul>
                                </nav>

                            </div>
                        </div>
                    </div>
                </div>
            </div><br><br>


            <!-- Content
            ================================================== -->
            <div class="container">
                <div class="row sticky-wrapper">

                    <div class="col-md-8">

                        <!-- Sorting / Layout Switcher -->
                        <div class="row margin-bottom-15">
                            <div class="col-md-6">
                                <!-- Layout Switcher -->
                                <div style="position: relative;left: 120%" class="layout-switcher">
                                    <a href="#" class="list"><i class="fa fa-th-list"></i></a>
                                    <a href="#" class="grid"><i class="fa fa-th-large"></i></a>
                                </div>
                            </div>
                        </div>

                        <% ArrayList<AdvertistmentDto> searchedAdvs = (ArrayList<AdvertistmentDto>) request.getSession().getAttribute("searchedAdvs");
                            if (searchedAdvs == null) {
                                searchedAdvs = new ArrayList<>();
                            }
                        %>

                        <!-- Listings -->
                        <div class="listings-container list-layout">

                            <% for (AdvertistmentDto dto : searchedAdvs) {%>

                            <!-- Listing Item -->
                            <div class="listing-item">

                                <a href="#" onclick="viewAdv(<%= dto.getAdvertistment().getAdvId()%>)" class="listing-img-container">
                                    
                                    <div class="listing-badges">
                                        <span><%= dto.getAdvertistment().getType()%></span>
                                    </div>

                                    <div class="listing-img-content">
                                        <span class="listing-price"><%= Math.round(dto.getAdvertistment().getPrice())%>
                                            <i><%= dto.getAdvertistment().getSaleType()%></i></span>
                                    </div>
                                    
                                    <div class="listing-carousel">
                                        <div><img src="<c:url value="/assests/images/listing-01.jpg" />" alt=""></div>
                                        <div><img src="<c:url value="/assests/images/listing-01b.jpg" />" alt=""></div>
                                        <div><img src="<c:url value="/assests/images/listing-01c.jpg" />" alt=""></div>
                                    </div>
                                </a>

                                <div class="listing-content">

                                    <div class="listing-title">
                                        <h4><a href="#" onclick="viewAdv(<%= dto.getAdvertistment().getAdvId()%>)"><%= dto.getAdvertistment().getTitle()%></a></h4>
                                        <i class="fa fa-map-marker"></i>&nbsp;
                                        <span style="font-size: 16px; font-weight: 200;"><%= dto.getAdvertistment().getCity()%></span>&nbsp;&nbsp; - &nbsp;&nbsp;
                                        <span><%= dto.getAdvertistment().getAddress()%></span>
                                        <a href="#" onclick="viewAdv(<%= dto.getAdvertistment().getAdvId()%>)" class="details button border">Details</a>
                                    </div>

                                    <ul class="listing-details">
                                        <li><i class="fa fa-arrows-alt"></i>&nbsp;&nbsp;<%= Math.round(dto.getAdvertistment().getArea())%>&nbsp; sq ft</li>
                                        <li><i class="fa fa-bed"></i>&nbsp;&nbsp;<%= dto.getAdvertistment().getHomePartitionList().get(0).getPartCount()%>&nbsp;Bedroom</li>
                                        <li><i class="fa fa-child"></i>&nbsp;&nbsp;<%= dto.getAdvertistment().getHomePartitionList().get(1).getPartCount()%>&nbsp;Bathroom</li>
                                    </ul>

                                    <div class="listing-footer">
                                        <a href="#"><i class="fa fa-user"></i> <%= dto.getAdvertistment().getUser().getName()%> </a>
                                        <span><i class="fa fa-calendar-o"></i> <%= dto.getAdvertistment().getDate()%></span>
                                    </div>

                                </div>

                            </div>
                            <!-- Listing Item / End -->

                            <% }%>

                        </div><br>
                        <!-- Listings Container / End -->


                        <!-- Pagination -->
                        <div class="pagination-container margin-top-20">
                            <nav class="pagination">
                                <ul>
                                    <li><a href="#" class="current-page">1</a></li>
                                    <li><a href="#">2</a></li>
                                </ul>
                            </nav>

                            <nav class="pagination-next-prev">
                                <ul>
                                    <li><a href="#" class="prev">Previous</a></li>
                                    <li><a href="#" class="next">Next</a></li>
                                </ul>
                            </nav>
                        </div><br>
                        <!-- Pagination / End -->

                    </div>

                    <!-- Sidebar
                    ================================================== -->
                    <div class="col-md-4" style="left: 4%">
                        <div class="sidebar sticky right">
                            <form id="searchForm">
                                <!-- Widget -->
                                <div class="widget margin-bottom-40">
                                    <h3 class="margin-top-0 margin-bottom-35">Find New Home</h3>

                                    <!-- Row -->
                                    <div class="row with-forms">
                                        <!-- Status -->
                                        <div class="col-md-12">
                                            <select data-placeholder="Any Status" name="tab" class="chosen-select-no-single" >
                                                <option value="">Any Status</option>	
                                                <option value="For Sale" >For Sale</option>
                                                <option value="For Rent" >For Rent</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Row / End -->


                                    <!-- Row -->
                                    <div class="row with-forms">
                                        <!-- Type -->
                                        <div class="col-md-12">
                                            <select name="txtSearchType" data-placeholder="Any Type" class="chosen-select-no-single" > 
                                                <option value="">Any Type</option>
                                                <option value="Apartment">Apartments</option>
                                                <option value="House" >Houses</option>
                                                <option value="Lot" >Lots</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Row / End -->


                                    <!-- Row -->
                                    <div class="row with-forms">
                                        <!-- States -->
                                        <div class="col-md-12">
                                            <select name="txtSearchState" data-placeholder="All States" class="chosen-select" >
                                                <option value="">All States</option>	
                                                <option>Northern Province</option>
                                                <option>North Western Province</option>
                                                <option>Western Province</option>
                                                <option>North Central Province</option>
                                                <option>Central Province</option>
                                                <option>Sabaragamuwa Province</option>
                                                <option>Eastern Province</option>
                                                <option>Uva Province</option>
                                                <option>Southern Province</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Row / End -->


                                    <!-- Row -->
                                    <div class="row with-forms">
                                        <!-- Cities -->
                                        <div class="col-md-12">
                                            <select name="txtSearchCity" data-placeholder="All Cities" class="chosen-select" >
                                                <option value="" >All Cities</option>
                                                <option>Jaffna</option>
                                                <option>Kilinochchi</option>
                                                <option>Mannar</option>
                                                <option>Mullaitivu</option>
                                                <option>Vavuniya</option>
                                                <option>Puttalam</option>
                                                <option>Kurunegala</option>
                                                <option>Gampaha</option>
                                                <option>Colombo</option>
                                                <option>Kalutara</option>
                                                <option>Anuradhapura</option>
                                                <option>Polonnaruwa</option>
                                                <option>Matale</option>
                                                <option>Kandy</option>
                                                <option>Nuwara Eliya</option>
                                                <option>Kegalle</option>
                                                <option>Ratnapura</option>
                                                <option>Trincomalee</option>
                                                <option>Batticaloa</option>
                                                <option>Ampara</option>
                                                <option>Badulla</option>
                                                <option>Monaragala</option>
                                                <option>Hambantota</option>
                                                <option>Matara</option>
                                                <option>Galle</option>
                                            </select>
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

                                    <br>

                                    <!-- Area Range -->
                                    <div class="range-slider">
                                        <label>Area Range</label>
                                        <div id="area-range" data-min="0" data-max="5000" data-unit="sq ft">
                                            <input type='text' name="txtArea" class='first-slider-value'/>
                                            <input type='text' name="txtArea" class='second-slider-value'/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>

                                    <br>

                                    <!-- Price Range -->
                                    <div class="range-slider">
                                        <label>Price Range</label>
                                        <div id="price-range" data-min="0" data-max="1000000" data-unit="$">
                                            <input type="text" name="txtPrice" class="first-slider-value"/>
                                            <input type="text" name="txtPrice" class="second-slider-value"/>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>



                                    <!-- More Search Options -->
                                    <a href="#" class="more-search-options-trigger margin-bottom-10 margin-top-30" data-open-title="Additional Features" data-close-title="Additional Features"></a>

                                    <div class="more-search-options relative">

                                        <!-- Checkboxes -->
                                        <div class="checkboxes one-in-row margin-bottom-10">
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
                                    <!-- More Search Options / End -->

                                    <button id="btSearch" class="button fullwidth margin-top-30">Search</button>
                            </form>
                        </div>
                        <!-- Widget / End -->

                    </div>
                </div>
                <!-- Sidebar / End -->

            </div>
        </div>


        <%@include file="footerBar.jsp"%>
        <!-- Back To Top Button -->
        <div id="backtotop"><a href="#"></a></div>

    </div>
    <!-- Wrapper / End -->

    <script type="text/javascript" src="<c:url value="/assests/scripts/advertistmentControl.js"/>"></script>
</body>

</html>
