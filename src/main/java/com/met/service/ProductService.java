package com.met.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.met.dao.ProductDAO;
import com.met.model.Product;

//@Component
@Service
public class ProductService {
	
	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private ProductDAO productDAO;
	
	public void saveProduct(Product product) {
		
		int pno  = product.getPno();
	
		
		System.out.println("ProductService :: saveProduct");
		productDAO.saveProduct(product);
	}
	
	public Collection<Product> getAllProducts(){
		
		return productDAO.getAllProduct();
	}
	
}
