package org.sbelei.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sbelei.hibernate.dto.Address;
import org.sbelei.hibernate.dto.UserDetails;
import org.sbelei.hibernate.dto.UserWithMultipleAddresses;

/**
 * One to one sample
 * @author Sergiy Beley
 *
 */
public class MainSaveCllections {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Address firstUserAddress =  new Address();
		firstUserAddress.setCity("Ivano-Frankivsk");
		firstUserAddress.setState("Ukraine");
		firstUserAddress.setStreet("Voloshyna");
		
		Address secondUserAddress = new Address();
		secondUserAddress.setCity("Kalush");
		secondUserAddress.setState("Ukraine");
		secondUserAddress.setStreet("S.Strilciv");
		
		UserWithMultipleAddresses firstUser = new UserWithMultipleAddresses();
		//user.setUserId(1);
		firstUser.setUserName("First User");
		firstUser.getAddresses().add(firstUserAddress);
		firstUser.getAddresses().add(secondUserAddress);
		firstUser.setJoindeDate(new Date());
		firstUser.setDescription("FU description");

		UserWithMultipleAddresses secondUser = new UserWithMultipleAddresses();
		//user.setUserId(1);
		secondUser.setUserName("Second User");
		secondUser.getAddresses().add(secondUserAddress);
		secondUser.getAddresses().add(firstUserAddress);
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
		UserWithMultipleAddresses readUser = (UserWithMultipleAddresses) session.get(UserWithMultipleAddresses.class, firstUser.getUserId());//1 is a primary key
		System.out.println(readUser.toString());
		session.close(); //Uncoment this to check lazy initialization (we set EAGER initialization now)
		System.out.println(readUser.getAddresses().size());
//		UserDetails anotherUser = new UserDetails();
//		anotherUser.setUserId(1);
//		System.out.println(anotherUser.getUserId());
//		System.out.println(anotherUser.getUserName());

	}

}
