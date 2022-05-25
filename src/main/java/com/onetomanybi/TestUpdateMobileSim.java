package com.onetomanybi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdateMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = entityManager.find(Mobile.class, 2);
		if (mobile != null) {
			List<Sim> sims = mobile.getSims();
			mobile.setName("Vivo");
			sims.get(0).setProvider("Vodafone");
			entityTransaction.begin();
			entityManager.merge(mobile);
			entityTransaction.commit();
		}
		else {
			System.out.println("No mobile available");
		}
	}
}
