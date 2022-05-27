package com.ty.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetPersonBankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = entityManager.find(Person.class, 2);
		if (person != null) {
			System.out.println("id is : " + person.getId());
			System.out.println("name is :" + person.getName());
			System.out.println("person age is:" + person.getAge());
			System.out.println("phone is:" + person.getPhone());

			List<BankAccount> list = person.getBankAccount();
			for (BankAccount bankAccount : list) {
				System.out.println("bank id is: " + bankAccount.getId());
				System.out.println("bank name is :" + bankAccount.getName());
				System.out.println("bank Pin code is :" + bankAccount.getPincode());
				System.out.println("bank Account is:" + bankAccount.getAccno());
				System.out.println("bank address is :" + bankAccount.getAddress());

			}

		} else {
			System.out.println("Bank Account not found");
		}

	}

}
