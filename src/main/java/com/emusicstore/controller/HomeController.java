package com.emusicstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Controller
public class HomeController {

	@Autowired
	ProductDao productDao;
    
	@RequestMapping("/")
	public String home() {
		return "home";

	}

	@RequestMapping("/productList")
	public String getProducts(Model model) {

		List<Product> productList = productDao.getAllProducts();

		model.addAttribute("products", productList);

		return "productList";

	}

	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId, Model model) throws IOException {

		Product product = productDao.getProductById(productId);

		model.addAttribute(product);

		return "viewProduct";

	}

}
