<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 07/12/2021
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <c:set var="extension" value=".jpeg"/>
        <c:set var="devise" value="€"/>
        <section class="single-product">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="<spring:url value="/home"/>"><spring:message code="homeLabel"/></a> </li>
                            <li class="breadcrumb-item"> <a href="<spring:url value="/products/category/${product.category.id}"/>">${categoryName}</a></li>
                            <li class="breadcrumb-item active"> ${product.name}</li>
                        </ol>
                    </div>
                </div>
                <div class="row mt-20">
                    <div class="col-md-5">
                        <div class="single-product-slider">
                            <div id='carousel-custom' class='carousel slide' data-ride='carousel'>
                                <div class='carousel-outer'>
                                    <!-- me art lab slider -->
                                    <div class='carousel-inner '>
                                        <div class='item active'>
                                            <img src='<spring:url value="${product.picture}${extension}"/>' alt='' data-zoom-image=<spring:url value="${product.picture}${extension}"/> />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-7">
                        <div class="single-product-details">
                            <%--@elvariable id="cartItem" type="java"--%>
                            <form:form method="post" id="addToCart"
                                       action="/luxuryShop/products/addToCart"
                                       modelAttribute="cartItem">

                                <h2>${product.name}</h2>
                                <p class="product-price">${product.price} ${devise}</p>
                                <div class="product-quantity">
                                    <span><spring:message code="quantityLabel"/>:</span>
                                    <div class="product-quantity-slider">
                                        <form:input path="quantity" type="number"  min="1" max="100" value="1"/>
                                        <form:errors path="quantity" class="err" />
                                        <form:input path="categId" type="hidden" value="${categId}"/>
                                        <form:input path="productId" type="hidden" value="${product.id}"/>
                                        <form:input path="label" type="hidden" value="${product.name}"/>
                                        <form:input path="image" type="hidden" value="${product.picture}${extension}"/>
                                        <form:input path="price" type="hidden" value="${product.price}"/>
                                    </div>
                                </div>
                                <div class="product-category">
                                    <span><spring:message code="categoryLabel"/>:</span>
                                    <ul>
                                        <li class="nameCateg"><a href="<spring:url value="/products/category/${product.category.id}"/>">${categoryName}</a></li>
                                    </ul>
                                </div>
                                <form:button class="btn btn-main mt-20"><spring:message code="addToCart" /></form:button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
