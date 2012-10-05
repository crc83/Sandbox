package org.sbelei.hibernate.dto.rent;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * One to many sample
 * @author Sergiy Beley
 *
 */
public class RentMain {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		RentVehicle vehicleCar =  new RentVehicle();
		vehicleCar.setVehicleName("VAZ-2101");
		
		RentVehicle vehicleJeep =  new RentVehicle();
		vehicleJeep.setVehicleName("Jeep");
		
		
		RentUserDetails firstUser = new RentUserDetails();
		//user.setUserId(1);
		firstUser.setUserName("First User");
		firstUser.getVehicles().add(vehicleCar);
		vehicleCar.setUser(firstUser);
		firstUser.getVehicles().add(vehicleJeep);
		vehicleJeep.setUser(firstUser);

		//Initialization
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//writing data by Hibernate
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(firstUser);
		session.save(vehicleCar);
		session.save(vehicleJeep);
		session.getTransaction().commit();

		//reading data by Hibernate
		session = sessionFactory.openSession();
		session.beginTransaction();
		RentUserDetails readUser = (RentUserDetails) session.get(RentUserDetails.class, firstUser.getUserId());//1 is a primary key
		System.out.println(readUser.toString());
		session.close(); //Uncoment this to check lazy initialization (we set EAGER initialization now)
		System.out.println(readUser.getVehicles().size());
//		UserDetails anotherUser = new UserDetails();
//		anotherUser.setUserId(1);
//		System.out.println(anotherUser.getUserId());
//		System.out.println(anotherUser.getUserName());

	}

}
