<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 29/11/2021
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/importTags.jsp"%>
<html>
    <head>
        <title>login</title>

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

        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Construction Html5 Template">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
        <meta name="author" content="Themefisher">
        <meta name="generator" content="Themefisher Constra HTML Template v1.0">
    </head>
    <body>
        <section class="signin-page account">
            <div class="container">
                <div class="row">
                    <div class="block-border col-md-6 col-md-offset-3">
                        <div class="block text-center">
                            <a class="logo" href="<spring:url value="/home"/> ">
                                LUXURY
                            </a>
                            <h2 class="text-center"><spring:message code="welcomeBackLabel"/></h2>
                            <%--@elvariable id="customer" type="java"--%>
                            <form:form class="text-left clearfix" modelAttribute="customer" method="post" >
                                <div class="form-group ${alertClass}" role="alert">
                                    <spring:message code="${noCredential}"/>
                                </div>
                                <div class="form-group">
                                    <c:set var="username"><spring:message code="usernameLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${username}" path="username"/>
                                </div>
                                <div class="form-group">
                                    <c:set var="password"><spring:message code="passwordLabel"/></c:set>
                                    <form:input type="password" class="form-control" placeholder="${password}" path="password"/>
                                </div>
                                <div class="text-center">
                                    <form:button type="submit" class="btn btn-main text-center" ><spring:message code="loginButton"/></form:button>
                                </div>
                            </form:form>
                            <p class="mt-20"><spring:message code="newIntheSiteLabel"/><a href="<spring:url value="/sign" />"> <spring:message code="newAccountLabel"/></a></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
