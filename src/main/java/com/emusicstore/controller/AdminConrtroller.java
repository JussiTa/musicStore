package com.emusicstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;

@Controller
public class AdminConrtroller {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/admin/")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/admin/productInventory/")
	public String productInventory(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);

		return "productInventory";

	}

	@RequestMapping("/admin/productInventory/addProduct")
	public String showForm(Model model) {
		Product product = new Product();
		product.setProductName("Piano");
		product.setProductCondition("new");
		product.setProductCategory("instrument");
		product.setProductDescription("");
		product.setProductPrice(0.0);

		model.addAttribute(product);

		return "/addProduct";
	}

	@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {
		productDao.addProduct(product);

		return "/productInventory";

	}

	@RequestMapping("/admin/productInventory/editProduct/{productId}")
	public String showeditForm(@ModelAttribute("product") Product product, Model model) {

		model.addAttribute(product);

		return "/editProduct";
	}

	@RequestMapping(value = "/admin/productInventory/editProduct/{productId}", method = RequestMethod.POST)
	public String edit(@ModelAttribute("product") Product product) {
		productDao.update(product);

		MultipartFile image = product.getImage();

		try {
			image.transferTo(new File("/recources/images/" + product.getProductId() + ".png"));

		} catch (IOException e) {
			e.printStackTrace();

		}

		return "redirect:/productInventory";

	}
	
	@RequestMapping(value="admin/producInventory/delete/{productID}")
	public String delete(@PathVariable("productId")String id) {
		productDao.deleteProduct(id);
		return "redirect:/productInventory";
		
		
	}
	

}