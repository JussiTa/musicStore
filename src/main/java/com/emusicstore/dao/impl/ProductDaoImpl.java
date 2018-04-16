package com.emusicstore.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
//For Spring to scan this class to Spring container.

@Repository
@Transactional

public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(Product.class.getName());

	public void addProduct(Product product) {
		System.out.println("täällä ollaan");
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		List<Product> products = null;
		try {

			session.beginTransaction();
			products = session.createQuery("from Product").list();

			// Commit data.
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.

		}

		session.getTransaction().commit();
		session.close();

		return products;
	}

	public Product getProductById(String Id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, Id);
		session.flush();

		return product;
	}

	public void deleteProduct(String Id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(Id));
		session.flush();

	}

	public void update(Product product) {

		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		log.info("Logging save");

	}
}
