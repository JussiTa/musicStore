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

import com.emusicstore.dao.CartDao;
import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;
import com.emusicstore.model.Product;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CartDao cartdao;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable(value = "/cartId") String cartId) {
		return cartdao.read(cartId);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "/cartId") String cartId, @RequestBody Cart cart) {

		cartdao.update(cartId, cart);

	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)

	public void delete(@PathVariable(value = "/cartId") String cartId) {

		cartdao.delete(cartId);

	}

	@RequestMapping(value = "/add/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
		String session = request.getSession(true).getId();

		Cart cart = cartdao.read(session);

		if (cart == null)
			cartdao.create(new Cart(session));

		Product product = productDao.getProductById(productId);

		if (product == null) {
			throw new IllegalArgumentException(new Exception());
		}

		cart.addItem(new CartItem(product));

		cartdao.update(session, cart);

	}

	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
		String session = request.getSession(true).getId();

		Cart cart = cartdao.read(session);

		if (cart == null)
			throw new IllegalArgumentException(new Exception());

		Product product = productDao.getProductById(productId);

		if (product == null) {
			throw new IllegalArgumentException(new Exception());
		}

		cart.removeItem(new CartItem(product));

		cartdao.update(session, cart);

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
