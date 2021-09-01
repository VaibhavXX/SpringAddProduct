package com.met.controller;

import com.met.model.Product;
import com.met.service.ProductService;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Component
@Controller
@RequestMapping("/product")
public class ProductController {
	
	//private EmployeeService employeeService = new EmployeeService();
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ModelAndView initializeProduct() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Product pro1 = new Product();
		
		
		modelAndView.addObject("product", pro1);
		
		Collection<Product> allProducts= productService.getAllProducts();
		
		modelAndView.addObject("allProducts",allProducts);
		
		
		modelAndView.setViewName("product");
		
		
		return modelAndView;
	}
	
	@PostMapping()
	public ModelAndView submitProduct(@ModelAttribute Product product) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("jsp to product container product object deatils : "+ product);
		
		
		productService.saveProduct(product);
		
		
		Product pro1 = new Product();
		
		
		modelAndView.addObject("product", pro1);
		
		Collection<Product> allProducts= productService.getAllProducts();
		
		modelAndView.addObject("allProducts",allProducts);
		
		
		
		modelAndView.setViewName("product");
		
		
		return modelAndView;
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("errMsg", ex.getMessage());
		modelAndView.addObject("url", request.getRequestURI());
		
		modelAndView.setViewName("error");
		
		return modelAndView;
		
	}
	
	
	
}
