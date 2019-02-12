<%-- 
    Document   : submit-property
    Created on : 26-Sep-2017, 11:45:38
    Author     : vinod
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ijse.neohomesrealestate.model.Feature"%>
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

                        <form id="frmAddSt2" enctype="multipart/form-data" method="POST">
                            <div class="submit-page">

                                <!-- Section -->
                                <h3>Detailed Information</h3>
                                <div class="submit-section">

                                    <!-- Description -->
                                    <div class="form">
                                        <h5>Description</h5>
                                        <textarea class="WYSIWYG" name="txtDesc" cols="40" rows="3" id="txtDesc" spellcheck="true"></textarea>
                                    </div>

                                    <!-- Row -->
                                    <div class="row with-forms">

                                        <!-- Age of Home -->
                                        <div class="col-md-4">
                                            <h5>Building Age <span>(optional)</span></h5>
                                            <select name="txtBAge" id="txtBAge" class="chosen-select-no-single" >
                                                <option label="blank"></option>	
                                                <option>0 - 1 Years</option>
                                                <option>0 - 5 Years</option>
                                                <option>0 - 10 Years</option>
                                                <option>0 - 20 Years</option>
                                                <option>0 - 50 Years</option>
                                                <option>50 + Years</option>
                                            </select>
                                        </div>

                                    </div><br>
                                    <!-- Row / End -->

                                    <!-- Section -->
                                    <h3>Partitions</h3>
                                    <div class="submit-section">

                                        <!-- Beds & Bath-->
                                        <div class="row">
                                            <div class="col-md-4">
                                                <h5>Bedrooms</h5>
                                                <select name="txtPartitionCount" class="chosen-select-no-single">
                                                    <option label="blank"></option>	
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>

                                            <div class="col-md-4">
                                                <h5>Bathrooms</h5>
                                                <select name="txtPartitionCount" class="chosen-select-no-single">
                                                    <option label="blank"></option>	
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>
                                        </div><br>

                                        <!-- Other -->
                                        <h5>Others ( Click  +  to add more partitions )</h5>

                                        <div class="row">
                                            <div class="col-md-3">
                                                <select name="txtPartitionType" class="chosen-select-no-single">
                                                    <option label="blank"></option>	
                                                    <option>Garages</option>
                                                    <option>Living Rooms</option>
                                                    <option>Kitchens</option>
                                                    <option>Dinning Rooms</option>
                                                    <option>Office Rooms</option>
                                                </select>
                                            </div>
                                            <div class="col-md-3">
                                                <select name="txtPartitionCount" class="chosen-select-no-single">
                                                    <option label="blank"></option>	
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                </select>
                                            </div>
                                            <div class="col-md-5">
                                                <input name="txtPartitionDesc" type="text" placeholder="description  ( Max 20 Letters - Optional )" />
                                            </div>
                                        </div>

                                        <div id="containDiv">

                                        </div>
                                        <a id="addPartition" style="font-size: xx-large; font-weight: bolder;" class="button border">+</a>
                                        <a id="removePartition" style="font-size: xx-large; font-weight: bolder; display: none;" class="button border">-</a>
                                    </div>
                                    <!-- Section / End -->


                                    <!-- Checkboxes -->
                                    <h3>Other Features </h3>
                                    <div class="submit-section">
                                        <div class="checkboxes in-row margin-bottom-20">
                                            <table>
                                                <tr>
                                                <input type="checkbox" name="cbFeatures" checked value="X">
                                                <% ArrayList<Feature> fList = (ArrayList<Feature>) request.getSession().getAttribute("featureList");
                                                    if (fList != null) {
                                                        int count = 0;

                                                        for (Feature f : fList) {
                                                            if (count >= 6) {
                                                                count = 0;

                                                %>
                                                </tr>
                                                <tr>
                                                    <%}
                                                        count++;
                                                    %>
                                                    <td>
                                                        <input id="check-<%=f.getFeatureId()%>" type="checkbox" name="cbFeatures" value="<%=f.getFeatureName()%>">
                                                        <label for="check-<%=f.getFeatureId()%>"><%=f.getFeatureName()%></label>
                                                    </td>
                                                    <%}
                                                        }%>
                                                </tr>
                                            </table>
                                        </div>
                                        <!-- Checkboxes / End -->
                                    </div>
                                </div>
                                <!-- Section / End -->

                                <!-- Section -->
                                <h3>Gallery</h3>
                                <div class="submit-section">
                                    <div class="row">
                                        <% for (int i = 0; i < 4; i++) {%>
                                        <div class="col-md-3">
                                            <!-- Avatar -->
                                            <div class="edit-profile-photo">
                                                <img id="imgProPic<%=(i+1)%>" style="width: 180px; height: 180px; resize: both;" src="<c:url value="/assests/images/def-home.jpg"/>" alt="">
                                                <div class="change-photo-btn">
                                                    <div class="photoUpload">
                                                        <span><i class="fa fa-upload"></i> Upload Photo</span>
                                                        <input name="imgInput" class="upload"  id="imgInput<%=(i+1)%>" type="file" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>
                                    </div>
                                </div>
                                <!-- Section / End -->
                                <div class="divider"></div>

                                <div id="errorNotifySubProp2" style="width: 50%;" class="notification error closeable">
                                    <p id="txtErrorMsgSubProp2">xxxxxx</p>
                                    <a class="close" id="btCloseSubProp2" href="#"></a>
                                <br>
                                </div>

                                <a href="submit-property" class="button preview margin-top-1 margin-bottom-20">Back <i class="fa fa-arrow-circle-left"></i></a>
                                <a id="addConSt2" class="button preview margin-top-1 margin-bottom-20">Confirm <i class="fa fa-arrow-circle-right"></i></a>

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
