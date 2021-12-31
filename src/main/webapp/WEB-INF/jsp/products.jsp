<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 05/12/2021
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
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
                                <li><a href="<spring:url value="/home"/>">Home | </a></li>
                                <li class="active">${pageName}</li>
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
                <div class="toast align-items-center"  role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="d-flex">
                        <div class="toast-body">
                            Hello, world! This is a toast message.
                        </div>
                        <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                </div>

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
                                            <a href="<spring:url value="#!"/>" ><i class="tf-ion-ios-heart"></i></a>
                                        </li>
                                        <li>
                                            <a onclick="${toat.show()}" href="<spring:url value="#!"/>"><i class="tf-ion-android-cart"></i></a>
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
