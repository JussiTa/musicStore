<%--
  Created by IntelliJ IDEA.
  User: jti
  Date: 3/12/18
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">

    <div class="container">
        <div class="page-header">

            <h1>Product inventory</h1>

            <p class="lead"> This is product inventory page</p>

        </div>

    </div>
</div>

<table class="table table-striped table-hover">

    <thead>

    <tr class="bg-success">

        <th>Photo thumb</th>
        <th>Name</th>
        <th>Category</th>
        <th>Condition</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>


    <c:forEach items="${products}" var="product">


        <tr>
            <td><img src="#" alt="image"/></td>
            <td>${product.productName}</td>
            <td>${product.productCategory}</td>
            <td>${product.productCondition}</td>
            <td>${product.productPrice}</td>
            <td><a href="<spring:url value="/products/viewProduct/${product.productId}"/>"

            > <span class="glyphicon glyphicon-info-sign"></span> </a></td>


        </tr>

    </c:forEach>

</table>
<a href="<spring:url value="/admin/productInventory/addProduct"/>"class="btn btn-primary">Add product</a>

<%@include file="/WEB-INF/views/template/footer.jsp"%>