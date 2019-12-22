package com.h2k.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class Tester {
	
	private static SessionFactory sessionFactory = null;
	
	public Tester(){
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
		test.testInsert();
		sessionFactory.close();
	}

	public void testInsert(){
		Session session = sessionFactory.openSession();
		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("American Airlines");
		stockDetail.setCompDesc("Airline Company");
		stockDetail.setRemark("Popular in ALL USA");
		stockDetail.setListedDate(new Date());
		
		Stock stock = new Stock();
		stock.setStockCode("2626");
		stock.setStockName("AMRA");
		stock.setStockDetail(stockDetail);
		
		stockDetail.setStock(stock);
		
		session.beginTransaction();
		session.save(stock);
		session.getTransaction().commit();
		System.out.println("Done");
		session.close();
		
	}
	
	private void selectAll(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Stock> result = session.createQuery( "from Stock" ).list();
		for ( Stock eachStock : result) {
			System.out.println(eachStock);
		}
		session.getTransaction().commit();
		session.close();
	}
}
