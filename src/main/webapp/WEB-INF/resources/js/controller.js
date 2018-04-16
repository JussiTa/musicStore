var cartApp = ("cartApp",[]);


cartApp.controller("cartCtrl",function($scope, $http){
	
	
	$scope.refreshCart = function(cartId){
		$http.get('/musicstore/rest/cart/'+$scope.cartId).success(function(data){
		$scope.cart=data;
		
	});
	};
	
	
	$scope.clearCart = function(){
		$http.delete('/musicstore/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
						
	};
	
	
	$scope.initCart= function(cartId){
	$scope.cartId=cartId;
	$scope.refreshCart(cartId);
	
	};
	
	
	$scope.addToCart = function(productId){
		
		$http.put('/musicstore/rest/cart/add'+productId).success(function(data){
		$scope.cartId=data;
		$scope.refreshCart($http.get("/musicstore/rest/cart/add/cartId"));		
		alert("product successfully added to cart");
		});	
		
	};
	
	$scope.removeFromCart= function(productId){		
	$http.put("/musicstore/rest/remove"+productId).success(function(data){
	$scope.refreshCart($http.get("/musicstore/rest/cart/cartId"));
	});
		
	};	
	
	
});