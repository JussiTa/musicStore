<%--
  Created by IntelliJ IDEA.
  User: jti
  Date: 3/12/18
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductAdded</title>
</head>
<body>


<h1>Product added</h1>
<p th:text="'id: ' + ${product.getProductId}" />
<p th:text="'Name: ' + ${product.getProductName}" />
<a href="/admin/productInventory/addProduct">Add new product</a>



</body>
</html>
