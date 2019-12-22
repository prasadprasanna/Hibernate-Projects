package com.learn.hibernate.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.learn.hibernate.Stock;
import com.learn.hibernate.StockDailyRecord;


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
		test.selectAll();
		sessionFactory.close();
	}

	public void testInsert(){
		
		Session session = sessionFactory.openSession();
		
		Stock stock = new Stock();
		stock.setStockCode("1018");
		stock.setStockName("HRAC");

        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(11.2f);
        stockDailyRecords.setPriceClose(1.2f);
        stockDailyRecords.setPriceChange(10.0f);
        stockDailyRecords.setVolume(400L);
        stockDailyRecords.setDate(new Date());

        stockDailyRecords.setStock(stock);
       
        stock.getStockDailyRecords().add(stockDailyRecords);
		
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
}
