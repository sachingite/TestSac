package com.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestJPA" );
	      
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		/*COURCES cource = new COURCES();
		cource.setCourceId("111");
		cource.setCourceName("Test");*/
		
		COURCES cource = entitymanager.find(COURCES.class, "111");
		cource.setCourceName("Test1");
		
		//entitymanager.persist(cource);
		
		entitymanager.getTransaction().commit();
		
		List<COURCES> list = entitymanager.createQuery("from COURCES c", COURCES.class).getResultList();
		
		System.out.println(list);
		
		list = entitymanager.createNamedQuery("test", COURCES.class).getResultList();
		
		System.out.println(list);
		
		entitymanager.close();
		emfactory.close();

	}

}
