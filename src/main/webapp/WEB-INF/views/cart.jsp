<%@include file="/WEB-INF/views/template/header.jsp"%>



<div class="container wrapper">
	<div class="container">
		<section class="jumbotron">

			<div class="container">

				<h1>All the selected product in your cart</h1>

			</div>

		</section>
		
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCArt('${cartId}')">

				<div>
					<a class="btn btn-danger pul-left" ng-click="clearCart"> <span
						class="glyphicon glyphicon-remove-sign"></span>Clear cart
					</a>

				</div>

				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit price</th>
						<th>Quantity</th>
						<th>Unit</th>
						<th>Action</th>
					</tr>

					<tr ng-repeat= "contentincart.cartItems">

						<td>{{item.product.productName}}</td>
						<td>{{item.product.productPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{item.totalPrice}}</td>
						<td><a href="#" class="label label-danger"
							ng-click="removeFromCart(item.product.productId)"> <span
								class="glyphicon glyphicon-remove"></span>
						</a></td>

					</tr>

					<tr>
						<th></th>
						<th></th>
						<th>Grand total</th>
						<th>{{cart.grandTotal}}</th>
					</tr>

				</table>
				<a href="<spring:url value="/productList"/>"
					class="button button-default">Continue shopping</a>

			</div>

		</section>
	</div>

</div>




<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>

