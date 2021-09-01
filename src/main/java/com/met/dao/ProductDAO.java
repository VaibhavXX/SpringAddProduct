package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.met.model.Product;

//@Component
@Repository
public class ProductDAO {
	
	private Map<Integer, Product> mapProducts = new HashMap<>();
	
	@Autowired
	@Qualifier("myOracledataSource")
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveUsingJDBC() {
		
		
		
	}
	
	
	public void saveUsingHibernate(Product product) {
		
		System.out.println("save product using hibernate");
		
		Session session = null;
		Transaction tx = null;
		
		try {
			
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(product);
			
			tx.commit();
		
		}catch(HibernateException ex){
			ex.printStackTrace();
			if(tx != null) tx.rollback();
		}finally {
			if(session != null) session.close();
		}
		
		
	}
	
	
	public void saveUsingJDBCTemplate(Product product) {
		
		jdbcTemplate.update("insert into producttbl values(?,?,?)",
				new Object[] {product.getPno(),product.getPrice(),
						product.getStock()});
		
	}
	
	public void saveUsingDataSource(Product product) {
		
		try(Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into producttbl values(?,?,?)")
				){
			
			pstmt.setInt(1, product.getPno());
			pstmt.setFloat(2, product.getPrice());
			pstmt.setInt(3, product.getStock());
			
			
			pstmt.executeUpdate();
			con.commit();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveProduct(Product product) {
		
		System.out.println("ProductDAO :: saveProduct: " + product);
	
		
		saveUsingHibernate(product);
	}
	
	public Collection<Product> getAllProduct(){
		
		
		return jdbcTemplate.query("select * from producttbl",
				new BeanPropertyRowMapper<Product>(Product.class));
		
		
		
		//return mapEmployees.values();
	}
	
	
	
	
}
