package com.h2k.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Tester {
	
	private SessionFactory sessionFactory = null;

	public void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	
	public static void main(String[] args) throws Exception {
		Tester test = new Tester();
		test.setUp();
		
		test.selectEmployees();

	}
	
	public void selectEmployees() {
		String query = " from EmployeeTO ";
		// 2 - Create session
		Session session = sessionFactory.openSession();
		// 3 - start transaction
		Transaction tx = session.beginTransaction();
		// 4 - Query
		List<EmployeeTO> employees =  session.createQuery(query).list();
		for(EmployeeTO eachEmp : employees) {
			System.out.println(eachEmp);
		}
		tx.commit();
		session.close();
	
	}
	

}
