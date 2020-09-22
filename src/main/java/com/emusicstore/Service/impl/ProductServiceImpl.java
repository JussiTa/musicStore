package com.emusicstore.Service.impl;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.emusicstore.Service.ProductService;
import com.emusicstore.dao.impl.ProductDaoImpl;
import com.emusicstore.model.Product;
@Service
public class ProductServiceImpl implements ProductService {
  private ProductDaoImpl repository;
  public ProductServiceImpl(@Qualifier("product") ProductDaoImpl repository) {
	    this.repository = repository;
	}

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(@Valid Product product) {
	repository.addProduct(product);	
	Session session = sessionFactory.getCurrentSession();	
	
	 session.saveOrUpdate(product);
	 session.flush();	

	}

	@Override
	public void editProduct(@Valid Product product) {
		
		repository.edit(product);
	}

	@Override
	public void deleteProduct(Product product) {
		repository.deleteProduct(product);

	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();	
		Product product;
		product = session.get(Product.class, productId);
		session.flush();	
		return product;
	}

	@Override
	public List<Product> getProducts() {
		return repository.getAllProducts();
		
	}



	


}
