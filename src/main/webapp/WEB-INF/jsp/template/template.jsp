<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 06/11/2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <title>${title}</title>
        <!-- icon -->
        <link rel="shortcut icon" type="image/x-icon" href="<spring:url value='/images/icon.jpeg'/>" />
        <!-- CSS -->
        <link type="text/css" href="<spring:url value='/plugins/animate/animate.css' />" rel="stylesheet" />
        <!-- Slick Carousel -->
        <link type="text/css" href="<spring:url value='/plugins/slick/slick.css' />" rel="stylesheet" />
        <link type="text/css" href="<spring:url value='/plugins/slick/slick-theme.css' />" rel="stylesheet" />
        <!-- Main Stylesheet -->
        <link type="text/css" href="<spring:url value='/css/style.css' />" rel="stylesheet" />
        <link type="text/css" href="<spring:url value='/plugins/themefisher-font/style.css' />" rel="stylesheet" />
        <link type="text/css" href="<spring:url value='/css/bootstrap.min.css' />" rel="Stylesheet" />
        <link type="text/css" href="<spring:url value='/css/index.css' />" rel="Stylesheet" />

        <!-- LANGUAGES -->
        <spring:url value="" var="LocaleFr">
            <spring:param name="locale" value="fr" />
        </spring:url>
        <spring:url value="" var="LocaleEn">
            <spring:param name="locale" value="en" />
        </spring:url>


    </head>
    <body id="body">
        <section>
            <!-- debut Nav bar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <a class="navbar-brand" href="<spring:url value="/home"/> ">LUXURY</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <span class="nav-link ">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <button class="btn btn-dark">
                                    <sec:authorize  access="isAuthenticated()">
                                        <a href="<spring:url value="/logout"/> "><span class="btn-link"><spring:message code="disconnectButton"/></span></a>
                                    </sec:authorize>
                                    <sec:authorize access="!isAuthenticated()">
                                        <a href="<spring:url value="/redirectHome"/> "><span class="btn-link"><spring:message code="connectButton"/></span></a>
                                    </sec:authorize>
                                </button>
                            </li>
                            <sec:authorize  access="isAuthenticated()">
                                <li class="nav-item">
                                    <div>
                                        <a class="nav-link active" href="<spring:url value="/home"/> ">
                                            <span><i class="fi-xtluxl-user-thin"></i>${pageContext.request.userPrincipal.principal.username}</span>
                                        </a>
                                    </div>
                                </li>
                            </sec:authorize>
                            <li class="nav-item">
                                <ul class="top-menu text-right list-inline">
                                    <li class="dropdown cart-nav dropdown-slide">
                                        <a class="nav-link active"  href="<spring:url value="/cart"/>">
                                            <span class="iconify" data-icon="ion:cart-outline"></span>
                                            <spring:message code="cartLabel"/>
                                            <c:if test="${currentCart.items.size() > 0}">
                                                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                                    ${currentCart.items.size()}
                                                    <span class="visually-hidden">unread messages</span>
                                                </span>

                                            </c:if>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a href="${LocaleFr}"><img src="<spring:url value="/images/france.png"/>" alt="drapeau france"/></a>
                            </li>
                            <li class="nav-item">
                                <a href="${LocaleEn}"><img src="<spring:url value="/images/england.png"/>" alt="drapeau angleterre"/></a>
                            </li>
                        </ul>
                    </span>
                </div>
            </nav>
            <script src="<spring:url value='https://code.iconify.design/2/2.0.3/iconify.min.js' />" ></script>
            <script type="text/javascript" src="<spring:url value="https://code.iconify.design/2/2.0.3/iconify.min.js"/>" ></script>
        </section>


        <div>
            <tiles:insertAttribute name="main-content"/>
        </div>



        <!-- Footer-->
        <footer class="footer section text-center ">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="social-media">
                            <li>
                                <a href="<spring:url value="https://www.facebook.com/armel.vially"/>">
                                    <i class="tf-ion-social-facebook"></i>
                                </a>
                            </li>
                            <li>
                                <a href="<spring:url value="https://www.instagram.com/vially.dag_model"/>">
                                    <i class="tf-ion-social-instagram"></i>
                                </a>
                            </li>
                            <li>
                                <a href="<spring:url value="https://www.twitter.com/DagVially"/>">
                                    <i class="tf-ion-social-twitter"></i>
                                </a>
                            </li>
                            <li>
                                <a href="<spring:url value="https://www.pinterest.com/themefisher/"/>">
                                    <i class="tf-ion-social-pinterest"></i>
                                </a>
                            </li>
                        </ul>
                        <ul class="footer-menu text-uppercase">
                            <li>
                                <a href="<spring:url value="/contact"/>">CONTACT</a>
                            </li>
                            <li>
                                <a href="<spring:url value="/products/all"/>"><spring:message code="shopLabel"/></a>
                            </li>
                            <li>
                                <a href="<spring:url value="/about"/>"><spring:message code="aboutLabel"/></a>
                            </li>
                            <li>
                                <a href="<spring:url value="/privacy"/>"><spring:message code="policyLabel"/></a>
                            </li>
                        </ul>
                        <p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a href="<spring:url value="https://github.com/viallyArmel/schoolProjectLxuryShop"/>">Vially & Pierre-olivier</a></p>
                    </div>
                </div>
            </div>
        </footer>

        <script src="<spring:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js' />" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script defer src="<spring:url value="https://friconix.com/cdn/friconix.js"/>"> </script>
        <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
        <script src="plugins/jquery/dist/jquery.min.js"></script>
        <!-- Video Lightbox Plugin -->
        <script src="plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
        <!-- Count Down Js -->
        <script src="plugins/syo-timer/build/jquery.syotimer.min.js"></script>

        <!-- slick Carousel -->
        <script src="plugins/slick/slick.min.js"></script>
        <script src="plugins/slick/slick-animation.min.js"></script>

        <!-- Google Mapl -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
        <script type="text/javascript" src="plugins/google-map/gmap.js"></script>
    </body>
</html>
