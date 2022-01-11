<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 05/12/2021
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <section class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="content">
                            <h1 class="page-name">${pageName}</h1>
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="<spring:url value="/home"/>">Home  </a></li>
                                <li class="breadcrumb-item active">${pageName}</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="products section">
            <div class="container">
                <c:set var="extension" value=".jpeg"/>
                <c:set var="devise" value="€"/>

                <div class="row row-cols-3">
                    <c:forEach items="${products}" var="prod" varStatus="status">
                        <div class="product-item">
                            <div class="product-thumb">
                                <c:if test="${prod.outOfStock}">
                                    <span class="bage">
                                        <c:out value="Out of stock" escapeXml="false" />
                                    </span>
                                </c:if>
                                <a href="<spring:url value="/products/single/${prod.name}/${prod.category.id}"/> ">
                                    <img class="img-responsive" src="<spring:url value="${prod.picture}${extension}"/>" alt="${prod.name}" />
                                </a>
                                <div class="preview-meta">
                                    <ul>
                                        <li>
                                            <%--@elvariable id="cartItem" type="java"--%>
                                            <form:form method="post" id="addToCart"
                                                action="/luxuryShop/products/addToCart"
                                                modelAttribute="cartItem">
                                                <form:input path="categId" type="hidden" value="${categId}"/>
                                                <form:input path="productId" type="hidden" value="${prod.id}"/>
                                                <form:input path="label" type="hidden" value="${prod.name}"/>
                                                <form:input path="image" type="hidden" value="${prod.picture}${extension}"/>
                                                <form:input path="price" type="hidden" value="${prod.price}"/>
                                                <form:input path="quantity" value="${cart.value.quantity + 1}" type="hidden"/>
                                                <form:button class="btnPanier"><i class="tf-ion-android-cart toi"></i></form:button>
                                                <%--<a href="<spring:url value="#!"/>"><i class="tf-ion-android-cart"></i></a>--%>
                                            </form:form>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="product-content">
                                <h4><a href="<spring:url value="/products/single/${prod.name}/${prod.category.id}"/>">${prod.name}</a></h4>
                                <p class="price">${prod.price} ${devise}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
    </body>
</html>
