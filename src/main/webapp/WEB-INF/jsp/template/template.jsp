<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 06/11/2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

                    <a class="navbar-brand">LUXURY</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <span class="nav-link ">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <button class="btn btn-dark">Connexion</button>
                                </li>
                                <li class="nav-item">
                                    <div>
                                        <a class="nav-link active" aria-current="page" href="#">
                                            <span class="iconify" data-icon="ion:search-outline" ></span>
                                            Search
                                        </a>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="">
                                        <a class="nav-link active"  href="#">
                                            <span class="iconify" data-icon="ion:cart-outline"></span>
                                            Card
                                        </a>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <%--@elvariable id="language" type="java"--%>
                                    <form:form action="" method="post" modelAttribute="language" id="lang">
                                        <form:select class="form-select form-select-sm" aria-label=".form-select-sm example" path="label">
                                            <form:options items="${languages}" itemValue="code" itemLabel="code" />
                                        </form:select>
                                    </form:form>
                                </li>
                            </ul>
                        </span>
                </div>
            </nav>
            <script src="<spring:url value='https://code.iconify.design/2/2.0.3/iconify.min.js' />" ></script>
            <script type="text/javascript" src="https://code.iconify.design/2/2.0.3/iconify.min.js" ></script>
        </section>

        <div>
            <tiles:insertAttribute name="main-content"/>
        </div>


    </body>
</html>
