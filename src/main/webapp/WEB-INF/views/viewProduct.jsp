<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="/WEB-INF/views/template/header.jsp"%>
<!-- JS angular -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>



<div class="container-wrapper">

	<div class="container">
		<div class="page-header">

			<h1>Product detail</h1>

			<p class="lead">Here is product information of the product.</p>

		</div>

		<div class="container" ng-app="cartApp">
			<div class="row">

				<div class="col-md-5">


					<img
						src="<c:url value="/resources/images/${product.productId}.png"/>"
						alt="image" style="width: 100%; height: 300px">



				</div>

				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>${product.productDescription}</p>
					<p>
						<strong>Manufacturer</strong> : ${product.productManufacturer}
					</p>
					<p>
						<strong>Category</strong> : ${product.productCategory}
					</p>
					<p>${product.productCondition}</p>
					<h1>${product.productPrice}</h1>

				</div>
			</div>

		</div>
	</div>

	<br>
	<c:set var="role" scope="page" value="${param.role}" />
	<c:set var="url" scope="page" value="/productList" />
	<c:if test="${role='admin'}">
		<c:set var="url" scope="page" value="/productInentory" />
	</c:if>

	<p ng-controller="cartCtrl">
		<a href="<c:url value='${url}'/>" class="btn btn-default">Back</a> <a
			href="#" class="btn btn-warning btn btn-large"
			ng-click="addToCart(${product.productId})"><span
			class="glyphicon glyphicon-shopping-cart"></span>Order now</a> <a
			href="<spring:url value="/cart"/>" class="btn btn-default"> <span
			class="glyphicon glyphicon-hand-right"></span>View cart
		</a>

	</p>
</div>

<script src="<c:url value="/WEB-INF/resources/js/controller.js"/>"></script>

<%@include file="/WEB-INF/views/template/footer.jsp"%>