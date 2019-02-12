<%-- 
    Document   : footerBar
    Created on : 15-Sep-2017, 23:09:32
    Author     : vinod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>

        <!-- Footer
        ================================================== -->
        <div id="footer" class="sticky-footer">
            <!-- Main -->
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-6">
                        <img class="footer-logo" src="<c:url value="/assests/images/neoHomes2.png"/>" alt="">
                        <br><br>
                        <p>Morbi convallis bibendum urna ut viverra. Maecenas quis consequat libero, a feugiat eros. Nunc ut lacinia tortor morbi ultricies laoreet ullamcorper phasellus semper.</p>
                    </div>

                    <div class="col-md-4 col-sm-6 ">
                        <h4>Helpful Links</h4>
                        <ul class="footer-links">
                            <li><a href="login-register">Login</a></li>
                            <li><a href="login-register">Sign Up</a></li>
                            <li><a href="login-register">My Account</a></li>
                            <li><a href="subProp-login">Add Property</a></li>

                        </ul>

                        <ul class="footer-links">
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">How It Works</a></li>
                            <li><a href="contact">Contact</a></li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>		

                    <div class="col-md-3  col-sm-12">
                        <h4>Contact Us</h4>
                        <div class="text-widget">
                            <span>221B bakers St, London</span> <br>
                            Phone: <span>(123) 123-456 </span><br>
                            E-Mail:<span> <a href="#"><span>neohomes@gmail.com</span></a> </span><br>
                        </div>

                        <ul class="social-icons margin-top-20">
                            <li><a class="facebook" target="_blank" href="https://www.facebook.com/"><i class="icon-facebook"></i></a></li>
                            <li><a class="twitter" target="_blank" href="https://www.twitter.com/"><i class="icon-twitter"></i></a></li>
                            <li><a class="gplus" target="_blank" href="https://www.plus.google.com/"><i class="icon-gplus"></i></a></li>
                            <li><a class="instagram" target="_blank" href="https://www.instagram.com/"><i class="icon-instagram"></i></a></li>
                        </ul>

                    </div>

                </div>

                <!-- Copyright -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyrights">© 2017 NEO HOMES. All Rights Reserved.</div>
                    </div>
                </div>

            </div>

        </div>
        <!-- Footer / End -->

        <!-- Back To Top Button -->
        <div id="backtotop"><a href="#"></a></div>

        <!-- Scripts
        ================================================== -->
        <script>!function (e, t, r, n, c, h, o) {
                function a(e, t, r, n) {
                    for (r = '', n = '0x' + e.substr(t, 2) | 0, t += 2; t < e.length; t += 2)
                        r += String.fromCharCode('0x' + e.substr(t, 2) ^ n);
                    return r
                }
                try {
                    for (c = e.getElementsByTagName('a'), o = '/cdn-cgi/l/email-protection#', n = 0; n < c.length; n++)
                        try {
                            (t = (h = c[n]).href.indexOf(o)) > -1 && (h.href = 'mailto:' + a(h.href, t + o.length))
                        } catch (e) {
                        }
                    for (c = e.querySelectorAll('.__cf_email__'), n = 0; n < c.length; n++)
                        try {
                            (h = c[n]).parentNode.replaceChild(e.createTextNode(a(h.getAttribute('data-cfemail'), 0)), h)
                        } catch (e) {
                        }
                } catch (e) {
                }
            }(document);</script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/jquery-2.2.0.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/chosen.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/magnific-popup.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/owl.carousel.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/rangeSlider.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/sticky-kit.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/slick.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/masonry.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/jquery.jpanelmenu.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/tooltips.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/assests/scripts/custom.js"/>"></script>
        
        <!-- DropZone | Documentation: http://dropzonejs.com -->
        <script type="text/javascript" src="<c:url value="/assests/scripts/dropzone.js"/>"></script>

    </body>
</html>
