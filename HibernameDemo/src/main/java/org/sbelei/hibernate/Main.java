package org.sbelei.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sbelei.hibernate.dto.Address;
import org.sbelei.hibernate.dto.UserDetails;

public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		UserDetails firstUser = new UserDetails();
		//user.setUserId(1);
		firstUser.setUserName("First User");
		Address firstUserAddress =  new Address();
		//DONE SB : Fill adderess for user 1
		firstUserAddress.setCity("Ivano-Frankivsk");
		firstUserAddress.setState("Ukraine");
		firstUserAddress.setStreet("Voloshyna");
		firstUser.setAddress(firstUserAddress);
		firstUser.setJoindeDate(new Date());
		firstUser.setDescription("FU description");

		UserDetails secondUser = new UserDetails();
		//user.setUserId(1);
		secondUser.setUserName("Second User");
		Address secondUserAddress = new Address();
		//DONE SB : Fill adderess for user 2
		secondUserAddress.setCity("Kalush");
		secondUserAddress.setState("Ukraine");
		secondUserAddress.setStreet("S.Strilciv");
		
		secondUser.setAddress(secondUserAddress);
		secondUser.setJoindeDate(new Date());
		secondUser.setDescription("SE description");

		//Initialization
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//writing data by Hibernate
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(firstUser);
		session.save(secondUser);
		session.getTransaction().commit();

		//reading data by Hibernate
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails readUser = (UserDetails) session.get(UserDetails.class, firstUser.getUserId());//1 is a primary key
		System.out.println(readUser.toString());
//		UserDetails anotherUser = new UserDetails();
//		anotherUser.setUserId(1);
//		System.out.println(anotherUser.getUserId());
//		System.out.println(anotherUser.getUserName());

	}

}
