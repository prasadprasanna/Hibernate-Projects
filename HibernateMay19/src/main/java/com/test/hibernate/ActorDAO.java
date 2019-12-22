package com.test.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.h2k.hibernate.Actor;

public class ActorDAO {
	
	
	public ActorDAO() throws Exception {
		setUp();
	}
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
		Actor actor = new Actor();
		actor.setId(599);
		actor.setFirstName("David");
		actor.setLastName("Nix");
		actor.setLastUpdate(new Date());
		
		ActorDAO dao = new ActorDAO();
		dao.selectActorWithCriteria();
	}

	
	public void selectActor() {
		// 2 - Create session
		Session session = sessionFactory.openSession();
		// 3 - start transaction
		Transaction tx = session.beginTransaction();
		// 4 - Query
		List<Actor> actors = session.createQuery(" From Actor ", Actor.class).list();
		for(Actor eachActor : actors) {
			System.out.println(eachActor);
		}
		tx.commit();
		session.close();
	}
	
	public void selectActorWithCriteria() {
		// 2 - Create session
		Session session = sessionFactory.openSession();
		// 3 - start transaction
		Transaction tx = session.beginTransaction();
		// 4 - Query
		Criteria cr = session.createCriteria(Actor.class);
		Criterion cron1 = Restrictions.gt("id", 100);
		Criterion cron2 = Restrictions.ilike("firstName", "A%");
		
		LogicalExpression logical = Restrictions.and(cron1, cron2);
		
		cr.add(logical);
		cr.addOrder(Order.desc("id"));
		List<Actor> actors = cr.list(); 
				//session.createQuery(" From Actor ", Actor.class).list();
		for(Actor eachActor : actors) {
			System.out.println(eachActor);
		}
		tx.commit();
		session.close();
	}
}
