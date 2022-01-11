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
                        <h1 class="page-name"><spring:message code="cartLabel"/></h1>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/luxuryShop/home"><spring:message code="homeLabel"/>  </a></li>
                            <li class="breadcrumb-item active"><spring:message code="cartLabel"/></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <c:if test="${currentCart.items.size() > 0}">
        <div class="page-wrapper">
            <div class="cart shopping test">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="block withoutBorder">
                                <div class="product-list">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th class="tableCol"><spring:message code="nameLabel"/></th>
                                            <th class="tableCol"><spring:message code="priceLabel"/></th>
                                            <th class="tableCol"><spring:message code="quantityLabel"/></th>
                                            <th class="tableCol">Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${currentCart.items}" var="cart" varStatus="status">
                                            <tr class="tableLine">
                                                <td class="tableCol">
                                                    <div class="product-info">
                                                        <img src="<spring:url value="${cart.value.image}"/>" alt="${cart.value.label}" />
                                                        <a href="<spring:url value="/products/single/${cart.value.label}/${cart.value.categId}"/>">${cart.value.label}</a>
                                                    </div>
                                                </td>
                                                <td class="tableCol">
                                                    <c:if test="${cart.value.reduction > 0}">
                                                        <span class="canceled">${cart.value.price}€</span>
                                                    </c:if>
                                                    <span>${cart.value.price - cart.value.price * cart.value.reduction}€</span>
                                                </td>
                                                <td class="tableCol"><%--@elvariable id="cartItem" type="java"--%>
                                                    <div class="row row-cols-3">
                                                        <div class="col">
                                                            <form:form method="post" modelAttribute="cartItem" action="/luxuryShop/cart/removeQuantity">
                                                                <form:input path="productId" value="${cart.key}" type="hidden"/>
                                                                <form:button class="btn btn-outline-secondary"><img src="<spring:url value="/images/remove.png"/> "/></form:button>
                                                                <form:input path="quantity" class="itemPrice" type="hidden" value="${cart.value.quantity}" min="0"/>
                                                            </form:form>
                                                        </div>
                                                        <div class="col">
                                                            <input class="itemPrice" type="number" disabled value="${cart.value.quantity}"/>
                                                        </div>
                                                        <div class="col">
                                                            <form:form method="post" modelAttribute="cartItem" action="/luxuryShop/cart/addQuantity">
                                                                <form:input path="productId" value="${cart.key}" type="hidden"/>
                                                                <form:input path="quantity" class="itemPrice" type="hidden" value="${cart.value.quantity}" min="0"/>
                                                                <form:button class="btn btn-outline-secondary"><img src="<spring:url value="/images/add.png"/> "/></form:button>
                                                            </form:form>
                                                        </div>
                                                    </div>



                                                </td>
                                                <td class="tableCol">
                                                    <form:form method="post" action="/luxuryShop/cart/remove" modelAttribute="cartItem">
                                                        <form:input path="productId" value="${cart.key}" type="hidden"/>
                                                        <form:button class="btn btn-outline-secondary"><img src="<spring:url value="/images/delete.png"/> "/></form:button>
                                                    </form:form>
                                                </td>
                                            </tr>

                                        </c:forEach>

                                        </tbody>
                                    </table>
                                    <div class="row row-cols-2">
                                        <div class="col">
                                                <%--@elvariable id="cartItem" type="java"--%>
                                            <form:form method="post"
                                                       action=" https://www.sandbox.paypal.com/cgi-bin/webscr"
                                                       modelAttribute="cartItem">

                                                <input type="hidden" name="business" value="armelvially418@yahoo.fr" />
                                                <input type="hidden" name="cert_id" value="AWA0RZ0pvDG-w-EYUR4dcBJpMgEnDlolGGYzkMAANmQnHwhNd8X0ruBRJ9Hvat6J-Iz_FsytLuXHW3IQ" />
                                                <input type="hidden" name="cmd" value="_cart" />
                                                <input type="hidden" name="upload" value="1" />

                                                <c:forEach items="${ currentCart.items }" var="cart" varStatus="status">
                                                    <input type="hidden" name="quantity_${status.count}" value="${cart.value.quantity}" />
                                                    <input type="hidden" name="amount_${status.count}" value="${cart.value.price - cart.value.price * cart.value.reduction}" />
                                                    <input type="hidden" name="item_name_${status.count}" value="${cart.value.label}" />
                                                </c:forEach>
                                                <input type="hidden" name="return" value="http://localhost:8082/luxuryShop/home" />
                                                <input type="hidden" name="cancel_return" value="http://localhost:8082/luxuryShop/home" />
                                                <input type="hidden" name="currency_code" value="EUR" />
                                                <input type="hidden" name="lc" value="${locale.getLanguage()}-${locale.getCountry()}" />

                                                <sec:authorize access="isAuthenticated()">
                                                    <form:button class="btn btn-main pull-right"><spring:message code="buyButton"/></form:button>

                                                </sec:authorize>
                                                <sec:authorize access="!isAuthenticated()">
                                                    <a href="<spring:url value="/login"/>"><form:button disabled="true" class="btn btn-main pull-right"><spring:message code="buyButton"/></form:button></a>
                                                </sec:authorize>
                                                <div class="form-check form-switch">
                                                    <form:checkbox path="saveOrder" class="form-check-input" role="switch" id="flexSwitchCheckDefault"/>
                                                    <form:label path="saveOrder" class="form-check-label"><spring:message code="saveOrderLabel"/></form:label>
                                                </div>
                                            </form:form>
                                        </div>
                                        <div class="col">
                                            <label>Total :</label>
                                            <c:if test="${currentCart.hasReduction()}">
                                                <span class="canceled">${currentCart.getTotalPrice(false)}€</span>
                                            </c:if>
                                            <span>${currentCart.getTotalPrice(true)}€</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <sec:authorize access="!isAuthenticated()">
                                <div class="alert alert-danger" role="alert">
                                    <spring:message code="connectToBuyLabel"/>
                                </div>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    </body>
</html>
