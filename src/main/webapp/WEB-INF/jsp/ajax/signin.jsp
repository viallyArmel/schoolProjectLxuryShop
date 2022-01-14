<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 04/12/2021
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../include/importTags.jsp"%>
<html>
    <head>
        <title>Insciption</title>

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

    </head>
    <body>
        <section class="signin-page account">
            <div class="container">
                <div class="row">
                    <div class="block-border col-md-6 col-md-offset-3">
                        <div class="block text-center">
                            <a class="logo" href="<spring:url value="/home" />">
                                LUXURY
                            </a>
                            <h2 class="text-center"><spring:message code="createAccountLabel"/></h2>
                            <%--@elvariable id="user" type="java"--%>
                            <form:form id="sign" class="text-left clearfix" modelAttribute="user" method="POST" action="/luxuryShop/sign">
                                <div class="form-group">
                                    <c:set var="firstnameLabel"><spring:message code="firstnameLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${firstnameLabel} *" path="firstname"/>
                                    <p class="err"><form:errors path="firstname"><spring:message code="nameError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <c:set var="lastnameLabel"><spring:message code="lastnameLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${lastnameLabel} *" path="lastname" />
                                    <p class="err"><form:errors path="lastname"><spring:message code="nameError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <c:set var="usernameLabel"><spring:message code="usernameLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${usernameLabel} *" path="username" />
                                    <p class="err"><form:errors path="username"><spring:message code="usernameError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <form:input type="email" class="form-control"  placeholder="Email *" path="email" />
                                    <p class="err"><form:errors path="email"><spring:message code="emailError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <c:set var="passwordLabel"><spring:message code="passwordLabel"/></c:set>
                                    <form:input type="password" class="form-control"  placeholder="${passwordLabel} *" path="password" />
                                    <p class="err"><form:errors path="password"><spring:message code="passwordError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <c:set var="passwordAgain"><spring:message code="passwordLabelAgainLabel"/></c:set>
                                    <form:input type="password" class="form-control"  placeholder="${passwordAgain} *" path="passwordAgain" />
                                    <p class="err">
                                        <c:if test="${samePassword == false}" >
                                            <spring:message code="passwordAgainError"/>
                                        </c:if>
                                    </p>
                                </div>
                                <div class="form-group">
                                    <c:set var="phoneLabel"><spring:message code="phoneNumberLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${phoneLabel}" path="phoneNumber" />
                                    <p class="err"><form:errors path="phoneNumber"><spring:message code="phoneNumberError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <form:input type="date" class="form-control" value="23-10-1998" min="01-01-1400" max="01-01-2014"  path="date" pattern="\d{2}-\d{2}-\d{4}" />
                                </div>
                                <div class="form-group">
                                    <form:select class="form-control"  path="gender" >
                                        <form:option value="Homme"><spring:message code="manLabel"/></form:option>
                                        <form:option value="Femme"><spring:message code="womanLabel"/></form:option>
                                    </form:select>
                                </div>
                                <div class="form-group">
                                    <c:set var="streetLabel"><spring:message code="streetLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${streetLabel}" path="street" />
                                </div>
                                <div class="form-group">
                                    <c:set var="pcLabel"><spring:message code="postalCodeLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${pcLabel}" path="postalCode" />
                                    <p class="err"><form:errors path="postalCode"><spring:message code="postalCodeError"/></form:errors></p>
                                </div>
                                <div class="form-group">
                                    <c:set var="localityLabel"><spring:message code="localityLabel"/></c:set>
                                    <form:input type="text" class="form-control"  placeholder="${localityLabel}" path="locality" />
                                </div>
                                <div class="form-group">
                                    <form:select class="form-control"  path="country" >
                                        <c:forEach items="${countries}" var="country" varStatus="status">
                                            <c:choose>
                                                <c:when test="${country == countries[18]}">
                                                    <form:option value="${country}" label="${country}" selected="true" />
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${country}" label="${country}" />
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="text-center">
                                    <form:button class="btn btn-main text-center"><spring:message code="inscriptionLabel"/></form:button>
                                </div>
                            </form:form>
                            <p class="mt-20"><spring:message code="AllreadyAccountLabel"/><a href="<spring:url value= "/login" />"> <spring:message code="loginButton" /></a></p>
                            <c:if test="${customerExists}">
                                <div class="alert alert-danger" role="alert">
                                    <spring:message code="alreadyExists"/>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
