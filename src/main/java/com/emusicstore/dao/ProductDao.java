package com.emusicstore.dao;

import com.emusicstore.model.Product;


import java.util.List;

public interface ProductDao {

    public void addProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(String Id);

    public void deleteProduct(Product product);
    
    public void edit(Product product);



}
