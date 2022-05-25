package com.onetomanybi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Hospital hospital=new Hospital();
	hospital.setName("Apollo");
	hospital.setGstnumber("IJNSI9997A");
	hospital.setWebsite("apollo.com");
	
	Branch branch1=new Branch();
	branch1.setName("Apollo_Nagarbhavi");
	branch1.setAddress("Nagarbhavi");
	branch1.setPhone("997744110");
	Branch branch2=new Branch();
	branch2.setName("Apollo_Udupi");
	branch2.setAddress("Udupi");
	branch2.setPhone("987744566");
	branch1.setHospital(hospital);
	branch2.setHospital(hospital);
	entityTransaction.begin();
	entityManager.persist(hospital);
	entityManager.persist(branch1);
	entityManager.persist(branch2);
	entityTransaction.commit();
}
}
