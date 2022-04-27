package com.csi.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	

	public static void main(String[] args) {

		saveData();
		getData();
	}

	static void saveData() {

		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date productLaunchDate=null;
		try {
			productLaunchDate = simpleDateFormat.parse("09-02-2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product product = new Product("OnePlus TV", 345455.99, productLaunchDate);
		
		session.save(product);
		
		transaction.commit();
	}

	static void getData() {
		
		Session session = factory.openSession();
		
		List<Product> productList = session.createQuery("from Product").list();
		
		productList.forEach(System.out::println);
		

	}

}
