package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccountPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserAccount account=new UserAccount();
		account.setEmail("surazz@gmail.com");
		account.setName("Suraj");
		account.setPassword("suraz@!2");
		account.setMobile(9877412l);
		
		Page page1=new Page();
		page1.setName("Sports");
		page1.setTitle("Football");
		page1.setDescription("Football is always entairtaining");
		
		Page page2=new Page();
		page2.setName("Agriculture");
		page2.setTitle("Farming");
		page2.setDescription("Farmer feeds people");
		
		
		List<Page> page=new ArrayList<Page>() ;
		page.add(page1);
		page.add(page2);
		
		account.setPage(page);
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityTransaction.commit();
		
	}

}
