package com.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusicstore.Service.CartService;

import com.emusicstore.model.Cart;


@Controller
@RequestMapping("/rest/cart")
public class CartController {
@Autowired
private CartService cartService;	

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value = "/cartId") String cartId) {
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "/cartId") String cartId, @RequestBody Cart cart) {

		

	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)

	public void delete(@PathVariable(value = "/cartId") String cartId) {

		

	}

	@RequestMapping(value = "/add/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
		String session = request.getSession(true).getId();

	

	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
		String session = request.getSession(true).getId();

		

	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Pad reuqest, Please verify your payload")
	public void handleClientErrors(Exception e) {
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server errors")
	public void handleServerErrors(Exception e) {
	}

}
