package com.ty.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteBankAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person=entityManager.find(Person.class, 1);
		List<BankAccount> bankAccount=person.getBankAccount();
		
		entityTransaction.begin();
		for(BankAccount e:bankAccount) {
		entityManager.remove(e);
		}
		entityManager.remove(person);
		entityTransaction.commit();
		
		
	}
}
