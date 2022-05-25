package com.onetomanybi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Mobile mobile=new Mobile();
	mobile.setName("samsung");
	mobile.setCost(50000);
	Sim sim1=new Sim();
	sim1.setProvider("Airtel");
	sim1.setType("3G");
	sim1.setImei("SKAKK5649656D");
	Sim sim2=new Sim();
	sim2.setProvider("Jio");
	sim2.setType("4G");
	sim2.setImei("SAQIEON49656D");
	List<Sim> list=new ArrayList<Sim>();
	list.add(sim2);
	list.add(sim1);
	mobile.setSims(list);
	sim1.setMobile(mobile);
	sim2.setMobile(mobile);
	
	entityTransaction.begin();
	entityManager.persist(sim1);
	entityManager.persist(sim2);
	entityManager.persist(mobile);
	entityTransaction.commit();
}
}
