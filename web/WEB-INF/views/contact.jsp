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

            <!-- Content
            ================================================== -->

            <!-- Map Container -->
            <div class="contact-map margin-bottom-55">

                <!-- Google Maps --> 
                <div class="google-map-container">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4090.806975081711!2d-0.1622297870358711!3d51.52361535331186!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48761acf33628211%3A0x445d7677a88322e1!2s221B+Baker+St%2C+Marylebone%2C+London+NW1+6XE%2C+UK!5e0!3m2!1sen!2slk!4v1508138424519" frameborder="0" style="border:0; width: 100%;height: 100%" allowfullscreen></iframe>
                </div>
                
                <!-- Office -->
                <div class="address-box-container">
                    <div class="address-container" data-background-image="<c:url value="/assests/images/our-office.jpg"/>">
                        <div class="office-address">
                            <h3>Contact</h3>
                            <ul>
                                <li>221B bakers St,</li>
                                <li>London</li>
                                <li>Phone +12 34 123456789 </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- Office / End -->
            </div>
            <div class="clearfix"></div>
            <!-- Map Container / End -->


            <!-- Container / Start -->
            <div class="container">

                <div class="row">

                    <!-- Contact Details -->
                    <div class="col-md-4">

                        <h4 class="headline margin-bottom-30">Find Us There</h4>

                        <!-- Contact Details -->
                        <div class="sidebar-textbox">
                            <p>Collaboratively administrate turnkey channels whereas virtual e-tailers. Objectively seize scalable metrics whereas proactive e-services.</p>

                            <ul class="contact-details">
                                <li><i class="im im-icon-Phone-2"></i> <strong>Phone:</strong> <span> +12 34 123456789 </span></li>
                                <li><i class="im im-icon-Globe"></i> <strong>Web:</strong> <span><a href="#">www.neohomes.com</a></span></li>
                                <li><i class="im im-icon-Envelope"></i> <strong>E-Mail:</strong> <span><a href="#"><span>neohomes@gmail.com</span></a></span></li>
                            </ul>
                        </div>

                    </div>

                    <!-- Contact Form -->
                    <div class="col-md-8">

                        <section id="contact">
                            <h4 class="headline margin-bottom-35">Contact Form</h4>

                            <div id="contact-message"></div> 

                            <form method="post" action="http://www.vasterad.com/themes/findeo/contact.php" name="contactform" id="contactform" autocomplete="on">

                                <div class="row">
                                    <div class="col-md-6">
                                        <div>
                                            <input name="name" type="text" id="name" placeholder="Your Name" required="required" />
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div>
                                            <input name="email" type="email" id="email" placeholder="Email Address" pattern="^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$" required="required" />
                                        </div>
                                    </div>
                                </div>

                                <div>
                                    <input name="subject" type="text" id="subject" placeholder="Subject" required="required" />
                                </div>

                                <div>
                                    <textarea name="comments" cols="40" rows="3" id="comments" placeholder="Message" spellcheck="true" required="required"></textarea>
                                </div>

                                <input type="submit" class="submit button" id="submit" value="Submit Message" />

                            </form>
                        </section>
                    </div>
                    <!-- Contact Form / End -->

                </div>

            </div>
            <!-- Container / End -->


            <%@include file="footerBar.jsp"%>
            <!-- Back To Top Button -->
            <div id="backtotop"><a href="#"></a></div>
            <script type="text/javascript" src="<c:url value="/assests/scripts/myMap.js"/>"></script>
        </div>
        <!-- Wrapper / End -->
        
    </body>

</html>
