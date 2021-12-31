<%--
  Created by IntelliJ IDEA.
  User: armel
  Date: 09/12/2021
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <title>Cart</title>
    </head>
    <body>
        <section class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="content">
                            <h1 class="page-name">Cart</h1>
                            <ol class="breadcrumb">
                                <li><a href="/luxuryShop/home">Home  </a></li>
                                <li class="active"> | cart</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div class="page-wrapper">
            <div class="cart shopping test">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="block">
                                <div class="product-list">
                                    <form method="post">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th class="">Name</th>
                                                <th class="">Price</th>
                                                <th class="">Quantity</th>
                                                <th class="">Actions</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr class="">
                                                <td class="">
                                                    <div class="product-info">
                                                        <img width="80" src="<spring:url value="/images/menShoes/menShoes3.jpeg"/>" alt="" />
                                                        <a href="#!">Sunglass</a>
                                                    </div>
                                                </td>
                                                <td class="">$200.00</td>
                                                <td>
                                                    <input class="itemPrice" name="quantity" width="5" type="number" value="1" min="1">
                                                </td>
                                                <td class="">
                                                    <a class="product-remove" href="#!">Remove</a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="product-info">
                                                        <img width="80" src="<spring:url value="/images/menShoes/menShoes3.jpeg"/>" alt="" />
                                                        <a href="#!">Airspace</a>
                                                    </div>
                                                </td>
                                                <td class="">$200.00</td>
                                                <td>
                                                    <input class="itemPrice" name="quantity" width="5" type="number" value="1" min="1">
                                                </td>
                                                <td class="">
                                                    <a class="product-remove" href="#!">Remove</a>
                                                </td>
                                            </tr>
                                            <tr class="">
                                                <td class="">
                                                    <div class="product-info">
                                                        <img width="80" src="<spring:url value="/images/menShoes/menShoes3.jpeg"/>" alt="" />
                                                        <a href="#!">Bingo</a>
                                                    </div>
                                                </td>
                                                <td class="">$200.00</td>
                                                <td>
                                                    <input class="itemPrice" name="quantity" width="5" type="number" value="1" min="1">
                                                </td>
                                                <td class="">
                                                    <a class="product-remove" href="#!">Remove</a>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <div class="row row-cols-2">
                                            <div class="col">
                                                <a href="checkout.html" class="btn btn-main pull-right">Checkout</a>
                                            </div>
                                            <div class="col">
                                                <label>Total :</label>
                                                <input type="text" disabled value="300£">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <sec:authorize access="!isAuthenticated()">
                                <div class="alert alert-danger" role="alert">
                                    Connect to checkout !
                                </div>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
