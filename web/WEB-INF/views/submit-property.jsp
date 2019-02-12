<%-- 
    Document   : submit-property
    Created on : 26-Sep-2017, 11:45:38
    Author     : vinod
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="com.ijse.neohomesrealestate.model.Advertistment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>
    <% Advertistment loadAdv = (Advertistment) request.getSession().getAttribute("newAdvertistment"); %>
    <body onload="loadFeatures();">
        
        <!-- Wrapper -->
        <div id="wrapper">

            <%@include file="headerBar.jsp" %>

            <!-- Titlebar
            ================================================== -->
            <div id="titlebar" class="submit-page" style="height: 1px;">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12" style="margin-top: -20px;">
                            <h2><i class="fa fa-plus-circle"></i> Add Property</h2>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Content
            ================================================== -->
            <div class="container">
                <div class="row">

                    <!-- Submit Page -->
                    <div class="col-md-12">
                        <form id="frmAddSt1" method="post">
                            <div class="submit-page">

                                <!-- Section -->
                                <h3>Basic Information</h3>
                                <div class="submit-section">

                                    <!-- Title -->
                                    <div class="form">
                                        <h5>Property Title <i class="tip" data-tip-content="Type title that will also contains an unique feature of your property (e.g. renovated, air contidioned)"></i></h5>
                                        <input class="search-field" id="txtPropertyTitle" name="txtPropertyTitle" type="text" <%if(loadAdv != null){ %> value="<%= loadAdv.getTitle() %>" <%}%> />
                                    </div>

                                    <!-- Row -->
                                    <div class="row with-forms">

                                        <!-- Status -->
                                        <div class="col-md-6">
                                            <h5>Status</h5>
                                            <select name="txtSaleType" id="txtSaleType" class="chosen-select-no-single">
                                                <option label="blank"></option>	
                                                <option <%if(loadAdv != null){ if (loadAdv.getSaleType().equalsIgnoreCase("For Sale")){%> selected <% } }%> >For Sale</option>
                                                <option <%if(loadAdv != null){ if (loadAdv.getSaleType().equalsIgnoreCase("For Rent")){%> selected <% } }%> >For Rent</option>
                                            </select>
                                        </div>

                                        <!-- Type -->
                                        <div class="col-md-6">
                                            <h5>Type</h5>
                                            <select name="txtPropertyType" id="txtPropertyType" class="chosen-select-no-single" >
                                                <option label="blank"></option>		
                                                <option <%if(loadAdv != null){ if (loadAdv.getType().equalsIgnoreCase("Apartment")){%> selected <% } }%> >Apartment</option>
                                                <option <%if(loadAdv != null){ if (loadAdv.getType().equalsIgnoreCase("House")){%> selected <% } }%> >House</option>
                                                <option <%if(loadAdv != null){ if (loadAdv.getType().equalsIgnoreCase("Lot")){%> selected <% } }%> >Lot</option>
                                            </select>
                                        </div>

                                    </div>
                                    <!-- Row / End -->


                                    <!-- Row -->
                                    <div class="row with-forms">

                                        <!-- Price -->
                                        <div class="col-md-4">
                                            <h5>Price <i class="tip" data-tip-content="Type overall or monthly price if property is for rent"></i></h5>
                                            <div class="select-input disabled-first-option">
                                                <input name="txtPrice" id="txtPrice" type="number" data-unit="USD" <%if(loadAdv != null){ %> value="<%= loadAdv.getPrice()%>" <%}%> />
                                            </div>
                                        </div>

                                        <!-- Area -->
                                        <div class="col-md-4">
                                            <h5>Area</h5>
                                            <div class="select-input disabled-first-option">
                                                <input name="txtArea" id="txtArea" type="number" data-unit="Sq Ft" <%if(loadAdv != null){ %> value="<%= loadAdv.getArea() %>" <%}%> />
                                            </div>
                                        </div>

                                    </div>
                                    <!-- Row / End -->

                                </div>
                                <!-- Section / End -->

                                <!-- Section -->
                                <h3>Location</h3>
                                <div class="submit-section">

                                    <!-- Row -->
                                    <div class="row with-forms">

                                        <!-- Address -->
                                        <div class="col-md-6">
                                            <h5>Address</h5>
                                            <input name="txtAddress" id="txtAddress" type="text" <%if(loadAdv != null){ %> value="<%= loadAdv.getAddress() %>" <%}%> />
                                        </div>

                                        <!-- City -->
                                        <div class="col-md-6">
                                            <h5>City</h5>
                                            <input name="txtCity" id="txtCity" type="text" <%if(loadAdv != null){ %> value="<%= loadAdv.getCity() %>" <%}%> />
                                        </div>

                                        <!-- City -->
                                        <div class="col-md-6">
                                            <h5>State</h5>
                                            <input name="txtState" id="txtState" type="text" <%if(loadAdv != null){ %> value="<%= loadAdv.getState() %>" <%}%> />
                                        </div>

                                        <!-- Zip-Code -->
                                        <div class="col-md-6">
                                            <h5>Zip-Code</h5>
                                            <input name="txtZip" id="txtZip" type="text" <%if(loadAdv != null){ %> value="<%= loadAdv.getZip() %>" <%}%> />
                                        </div>

                                    </div>
                                    <!-- Row / End -->

                                </div>
                                <!-- Section / End -->
                                <div id="errorNotifySubProp1" style="width: 50%;" class="notification error closeable">
                                    <p id="txtErrorMsgSubProp1">xxxxxx</p>
                                    <a class="close" id="btCloseSubProp1" href="#"></a>
                                </div>

                                <div class="divider"></div>
                                <a href="cancelAdd" class="button preview margin-top-1 margin-bottom-20">Cancel <i class="fa fa-times-circle"></i></a>
                                <a id="addConSt1" class="button preview margin-top-1 margin-bottom-20">Next <i class="fa fa-arrow-circle-right"></i></a>

                            </div>
                        </form>
                    </div>

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
