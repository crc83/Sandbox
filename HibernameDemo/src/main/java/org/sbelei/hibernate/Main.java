package org.sbelei.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sbelei.hibernate.dto.UserDetails;

public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("FU address");
		user.setJoindeDate(new Date());
		user.setDescription("FU description");

		//Initialization
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//writing data by Hibernate
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

		//reading data by Hibernate
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails readUser = (UserDetails) session.get(UserDetails.class, user.getUserId());//1 is a primary key
		System.out.println(readUser.toString());
//		UserDetails anotherUser = new UserDetails();
//		anotherUser.setUserId(1);
//		System.out.println(anotherUser.getUserId());
//		System.out.println(anotherUser.getUserName());

	}

}
