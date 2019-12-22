package com.test.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.h2k.hibernate.EmployeeTO;

public class HibernateTester {
	
	private String empQuery = "FROM EmployeeTO E WHERE E.id = :employee_id";
	private SessionFactory sessionFactory = null;
	
	public HibernateTester() throws Exception {
		setUp();
	}
	
	
	
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
		HibernateTester tester = new HibernateTester();
		// 1 - Session Factory - use hibernate documentation (always)
		EmployeeTO emp = new EmployeeTO();
		emp.setId(3);
		emp.setFirstName("Daniel");
		emp.setLastName("Armstrong");
		emp.setSalary(50000);
		
		//tester.updateEmployee(emp);
		//tester.deleteEmployee(emp);
		//tester.selectEmployees();
		tester.getEmployee(1);
	}
	
	
	public void saveEmployee(EmployeeTO emp) {
		// 2 - Create session
		Session session = sessionFactory.openSession();
		// 3 - start transaction
		Transaction tx = session.beginTransaction();
		// 4 - Query
		session.save(emp);
		tx.commit();
		session.close();
	}
	
	public void updateEmployee(EmployeeTO emp) {
		// 2 - Create session
		Session session = sessionFactory.openSession();
		// 3 - start transaction
		Transaction tx = session.beginTransaction();
		// 4 - Query
		session.saveOrUpdate(emp);
		tx.commit();
		session.close();
	}
	
	public void deleteEmployee(EmployeeTO emp) {
		// 2 - Create session
		Session session = sessionFactory.openSession();
		// 3 - start transaction
		Transaction tx = session.beginTransaction();
		// 4 - Query
		session.delete(emp);
		tx.commit();
		session.close();
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
	
	public EmployeeTO getEmployee(int empId){
		EmployeeTO empObj = null;
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			TypedQuery<EmployeeTO> query = session.createQuery(empQuery, EmployeeTO.class);
			query.setParameter("employee_id", empId);
			EmployeeTO eachEmp = query.getSingleResult();
			System.out.println(eachEmp.getId() +  "    " + eachEmp.getFirstName() + "   " + eachEmp.getSalary());
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empObj;
	}

}
