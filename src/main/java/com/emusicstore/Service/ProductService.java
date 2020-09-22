package com.emusicstore.Service;

import java.util.List;

import javax.validation.Valid;

import com.emusicstore.model.Product;

public interface ProductService {

	public void addProduct(Product product);

	public Product getProductById(int productId);

	public void editProduct(Product product);

	public void deleteProduct(Product product);
	
	public List<Product> getProducts();



}
