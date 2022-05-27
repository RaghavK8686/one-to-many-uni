package com.ty.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteAccountPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserAccount account = entityManager.find(UserAccount.class, 1);
		List<Page> page = account.getPage();

		entityTransaction.begin();
		for (Page pages : page) {
			entityManager.remove(pages);
		}
		entityManager.remove(account);
		entityTransaction.commit();
	}

}
