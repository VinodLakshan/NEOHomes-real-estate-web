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
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>
        <link rel="stylesheet" href="<c:url value="/assests/css/payment.css"/>">
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

                            <h2>Advertistment</h2>

                            <!-- Breadcrumbs -->
                            <nav id="breadcrumbs">
                                <ul>
                                    <li><a href="#">Advertistment</a></li>
                                    <li>Payment</li>
                                </ul>
                            </nav>

                        </div>
                    </div>
                </div>
            </div><br><br>


            <div class="container">
                <div id="Checkout" class="inline">
                    <h1>Pay Invoice</h1>
                    <div class="card-row">
                        <span class="visa"></span>
                        <span class="mastercard"></span>
                        <span class="amex"></span>
                        <span class="discover"></span>
                    </div>
                    <form>
                        <div class="form-group">
                            <label for="PaymentAmount">Payment amount</label>
                            <div class="amount-placeholder">
                                <span>Rs.</span>
                                <span>2000.00</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label or="NameOnCard">Name on card</label>
                            <input id="NameOnCard" class="form-control" type="text" maxlength="255"></input>
                        </div>
                        <div class="form-group">
                            <label for="CreditCardNumber">Card number</label>
                            <input id="CreditCardNumber" class="null card-image form-control" type="text"></input>
                        </div>
                        <div class="expiry-date-group form-group">
                            <label for="ExpiryDate">Expiry date</label>
                            <input id="ExpiryDate" class="form-control" type="text" placeholder="MM / YY" maxlength="7"></input>
                        </div>
                        <div class="security-code-group form-group">
                            <label for="SecurityCode">Security code</label>
                            <div class="input-container" >
                                <input id="SecurityCode" class="form-control" type="text" ></input>
                                <i id="cvc" class="fa fa-question-circle"></i>
                            </div>
                            <div class="cvc-preview-container two-card hide">
                                <div class="amex-cvc-preview"></div>
                                <div class="visa-mc-dis-cvc-preview"></div>
                            </div>
                        </div>
                        <div class="zip-code-group form-group">
                            <label for="ZIPCode">ZIP/Postal code</label>
                            <div class="input-container">
                                <input id="ZIPCode" class="form-control" type="text" maxlength="10"></input>
                                <a tabindex="0" role="button" data-toggle="popover" data-trigger="focus" data-placement="left" data-content="Enter the ZIP/Postal code for your credit card billing address."><i class="fa fa-question-circle"></i></a>
                            </div>
                        </div>
                        <button id="PayButton" style="background-color: #274abb !important; left: 30%;" class="button margin-top-20 margin-bottom-20">
                            <span><i class="fa fa-bank"></i></span>
                            <span>Pay Rs 2000.00</span>
                        </button>
                    </form>
                </div>
            </div><br>
            <div style="visibility: hidden;">&nbsp;</div>

            <%@include file="footerBar.jsp"%>
        </div>
        <script type="text/javascript" src="<c:url value="/assests/scripts/paymentControl.js"/>"></script>
    </body>
</html>
