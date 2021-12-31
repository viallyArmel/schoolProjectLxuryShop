<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 07/12/2021
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<html>
    <head>
        <title>${title}</title>
        <!-- icon -->
        <link rel="shortcut icon" type="image/x-icon" href="<spring:url value='/images/icon.jpeg'/>" />
        <!-- CSS -->
        <link type="text/css" href="<spring:url value='/plugins/animate/animate.css' />" rel="stylesheet" />
        <!-- Main Stylesheet -->
        <link type="text/css" href="<spring:url value='/css/style.css' />" rel="stylesheet" />
        <link type="text/css" href="<spring:url value='/plugins/themefisher-font/style.css' />" rel="stylesheet" />
        <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/css/index.css' />" rel="Stylesheet" />
    </head>
    <body id="body">
        <section class="page-404">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <a href="<spring:url value='/home'/>">
                            <img class="logoSiteError" src="<spring:url value='/images/logo.jpg'/>" alt="site logo" />
                        </a>
                        <h1>404</h1>
                        <h2>Page Not Found</h2>
                        <a href="<spring:url value='/home'/>" class="btn btn-main"><i class="tf-ion-android-arrow-back"></i> Go Home</a>
                        <p class="copyright-text">© 2021 Luxury Shop All Rights Reserved</p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Main jQuery -->
        <script src="<spring:url value='/plugins/jquery/dist/jquery.min.js'/>"></script>
        <!-- Bootstrap 3.1 -->
        <script src="<spring:url value='/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
        <!-- Bootstrap Touchpin -->
        <script src="<spring:url value='/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js'/>"></script>

        <!-- Count Down Js -->
        <script src="<spring:url value='/plugins/syo-timer/build/jquery.syotimer.min.js'/>"></script>

        <!-- slick Carousel -->
        <script src="<spring:url value='/plugins/slick/slick.min.js'/>"></script>
        <script src="<spring:url value='/plugins/slick/slick-animation.min.js'/>"></script>

        <!-- Google Mapl -->
        <script src="<spring:url value='https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw'/>"></script>
        <script type="text/javascript" src="<spring:url value='plugins/google-map/gmap.js'/>"></script>

    </body>
</html>
