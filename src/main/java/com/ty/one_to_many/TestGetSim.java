package com.ty.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetSim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Mobile mobile = entityManager.find(Mobile.class, 1);
		if(mobile!=null) {
		
		List<Sim> list = mobile.getSim();
		System.out.println("mobile name is :" + mobile.getName());
		System.out.println("mobile cost is :" + mobile.getCost());

		for (Sim sims : list) {
			
			System.out.println("Sim id is:" + sims.getId());
			System.out.println("Sim provider :" + sims.getProvider());
			System.out.println("Sims type :" + sims.getType());
		
			}
		}
		else
		{
			System.out.println("mobile not found");
		}
		
	}

}
