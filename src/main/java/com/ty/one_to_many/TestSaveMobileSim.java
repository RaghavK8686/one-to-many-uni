package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = new Mobile();
		mobile.setName("Nokia");
		mobile.setCost(50000.00);

		Sim sim1 = new Sim();
		sim1.setProvider("Airtel");
		sim1.setType("5g");

		Sim sim2 = new Sim();
		sim2.setProvider("Jio");
		sim2.setType("4g");

		Sim sim3 = new Sim();
		sim3.setProvider("vi");
		sim3.setType("6g");

		Sim sim4 = new Sim();
		sim4.setProvider("Aircel");
		sim4.setType("3g");

		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		sims.add(sim3);
		sims.add(sim4);

		mobile.setSim(sims);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityManager.persist(sim4);
		entityTransaction.commit();
	}

}
