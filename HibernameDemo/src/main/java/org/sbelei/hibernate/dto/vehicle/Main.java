package org.sbelei.hibernate.dto.vehicle;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * One to many sample
 * @author Sergiy Beley
 *
 */
public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Vehicle vehicleCar =  new Vehicle();
		vehicleCar.setVehicleName("VAZ-2101");
		
		Vehicle vehicleJeep =  new Vehicle();
		vehicleJeep.setVehicleName("Jeep");
		
		
		VehicleUserDetails firstUser = new VehicleUserDetails();
		//user.setUserId(1);
		firstUser.setUserName("First User");
		firstUser.getVehicle().add(vehicleCar);
		firstUser.getVehicle().add(vehicleJeep);
		firstUser.setJoindeDate(new Date());
		firstUser.setDescription("FU description");

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
		VehicleUserDetails readUser = (VehicleUserDetails) session.get(VehicleUserDetails.class, firstUser.getUserId());//1 is a primary key
		System.out.println(readUser.toString());
		session.close(); //Uncoment this to check lazy initialization (we set EAGER initialization now)
		System.out.println(readUser.getVehicle().size());
//		UserDetails anotherUser = new UserDetails();
//		anotherUser.setUserId(1);
//		System.out.println(anotherUser.getUserId());
//		System.out.println(anotherUser.getUserName());

	}

}
