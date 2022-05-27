package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=new Person();
		person.setName("Surazz");
		person.setAge(25);
		person.setPhone(987441361l);
		
		BankAccount account1 =new BankAccount();
		account1.setName("Surazz");
		account1.setPincode(585442);
		account1.setAddress("Majestic");
		account1.setAccno(987412563l);
		
		BankAccount account2=new BankAccount();
		account2.setName("Surazz");
		account2.setPincode(987416);
		account2.setAddress("marathalli");
		account2.setAccno(987412369854l);
		
		List<BankAccount> bankAccounts=new ArrayList<BankAccount>();
		bankAccounts.add(account1);
		bankAccounts.add(account2);
		
		person.setBankAccount(bankAccounts);
		 
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityTransaction.commit();

	}

}
