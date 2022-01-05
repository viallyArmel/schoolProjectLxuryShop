<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 06/11/2021
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<%@ page isELIgnored="false"%>
<html>
    <head>
        <title>${title}</title>
    </head>
    <body>

        <section class="container-fluid">
            <!-- debut carousel -->
            <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                        <img src="<spring:url value='/images/caroussel/womanBag1.jpeg' />" class="d-block w-100" alt="womanBag1">
                        <div class="carousel-caption d-none d-md-block">
                            <a href="<spring:url value='/products/all'/>" class="btn btn-main"><spring:message code="shopNowLabel"/></a>
                            <p><h4>Some representative placeholder content for the first slide.</h4></p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <img src="<spring:url value='/images/caroussel/menShoes3.jpeg' />" class="d-block w-100" alt="menShoes3">
                        <div class="carousel-caption d-none d-md-block">
                                <a href="<spring:url value='/products/all'/>" class="btn btn-main"><spring:message code="shopNowLabel"/></a>
                            <p><h4>Some representative placeholder content for the second slide.</h4></p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="<spring:url value='/images/womanBag/womanBag6.jpeg' />" class="d-block w-100" alt="womanSetBagShoes3">
                        <div class="carousel-caption d-none d-md-block">
                            <a href="<spring:url value='/products/all'/>" class="btn btn-main"><spring:message code="shopNowLabel"/></a>
                            <p><h4>Some representative placeholder content for the third slide.</h4></p>
                        </div>
                    </div>
                    <div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                            <span class="icon carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                            <span class="icon carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>
        </section>
        <!-- Fin caroussel -->

        <!-- category -->
        <section class="container-fluid">
            <h2 class="titleMenu"> Categories </h2>
            <div class="container">
                <c:set var="path" value="/images/category/"/>
                <c:set var="extension" value=".jpeg"/>

                <div class="row row-cols-3">
                    <c:forEach items="${categories}" var="categ" varStatus="status">
                        <div class="col product-thumb sepia">
                            <div>
                                <a href="<spring:url value="/products/category/${status.count}"/>"><img class="img-responsive" title="${categoriesLabels.get(status.index)}" src="<spring:url value='${path}${categ}${extension}' />" alt="category image" /></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- fin category -->

    <!-- les plus commandé -->
    <div class="container-fluid">
        <h2 class="titleMenu"><spring:message code="bestSellersLabel"/></h2>
        <div class="row row-cols-3 sepia">
            <div class="col">
                <div class="product-item">
                    <div class="product-thumb">
                        <img class="img-responsive" src="<spring:url value='/images/menShoes/menShoes3.jpeg' />" class="d-block w-100" alt="menShoes3">
                        <div class="preview-meta">
                            <ul>
                                <li>
                                    <a href="#!"><i class="tf-ion-android-cart"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-content">
                        <h4><a href="product-single.html">Rainbow Shoes</a></h4>
                        <p class="price">$200</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="product-item">
                    <div class="product-thumb">
                        <img class="img-responsive" src="<spring:url value='/images/womanSetBagShoes/womanSetBagShoes26.jpeg' />" class="d-block w-100" alt="menShoes3">
                        <div class="preview-meta">
                            <ul>
                                <li>
                                    <a href="#!"><i class="tf-ion-android-cart"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-content">
                        <h4><a href="<spring:url value='product-single.html'/>">Rainbow Shoes</a></h4>
                        <p class="price">$200</p>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="product-item">
                    <div class="product-thumb">
                        <img class="img-responsive" src="<spring:url value='/images/womanBag/womanBag5.jpeg' />" class="d-block w-100" alt="menShoes3">
                        <div class="preview-meta">
                            <ul>
                                <li>
                                    <a href="#!"><i class="tf-ion-android-cart"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="product-content">
                        <h4><a href="<spring:url value='product-single.html'/>">Rainbow Shoes</a></h4>
                        <p class="price">$500</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- fin les plus commandé -->
        <!-- newsteller -->
        <section class="call-to-action bg-gray section">
            <div class="container">
                <div class="row">
                    <div class="col text-center">
                        <div class="title">
                            <h2><spring:message code="newstellerLabel"/></h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Fugiat, <br> facilis numquam impedit ut sequi. Minus facilis vitae excepturi sit laboriosam.</p>
                        </div>
                        <div class="col-lg-6 text-center">
                            <div class="input-group subscription-form">
                                <input type="text" class="form-control" placeholder="Enter Your Email Address">
                                <span class="input-group-btn">
                                    <button class="btn btn-main" type="button"><spring:message code="suscribeLabel"/></button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- fin newsteller -->
    </body>
</html>
