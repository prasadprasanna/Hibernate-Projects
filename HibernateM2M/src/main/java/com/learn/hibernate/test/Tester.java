package com.learn.hibernate.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.learn.hibernate.Category;
import com.learn.hibernate.Stock;


public class Tester {

	private static SessionFactory sessionFactory = null;
	
	public Tester() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, 
			// but we had trouble building the SessionFactory so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	
	}
	
	public static void main(String[] args) {
		Tester test = new Tester();
		test.selectAllCategory();
		sessionFactory.close();
	}

	public void testInsert(){
		
		Session session = sessionFactory.openSession();
		
		Stock stock = new Stock();
		stock.setStockCode("5566");
	    stock.setStockName("ASOS");
    
	    Category category1 = new Category("ASSET", "ASSET MGMT");
        Category category2 = new Category("ONLINE", "ONLINE RETAIL");
        
        Set<Category> categories = new HashSet();
        categories.add(category1);
        categories.add(category2);
        stock.setCategories(categories);
		
		session.beginTransaction();
		session.saveOrUpdate(stock);
		session.getTransaction().commit();

		System.out.println("Done");
		
	}
	
	private void selectAll(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Stock> result = session.createQuery( "from Stock", Stock.class ).list();
		for ( Stock eachStock : result) {
			System.out.println(eachStock);
		}
		session.getTransaction().commit();
		session.close();
	}

	private void selectAllCategory(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> result = session.createQuery( "from Category", Category.class ).list();
		for ( Category eachStock : result) {
			System.out.println(eachStock);
		}
		session.getTransaction().commit();
		session.close();
	}

}
