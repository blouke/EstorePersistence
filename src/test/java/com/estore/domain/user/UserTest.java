package com.estore.domain.user;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest 
{
	private static EntityManagerFactory entityManagerFactory;

    private static EntityManager entityManager;
    
    private EntityTransaction tx;
    
    @BeforeClass
    public static void beforeClass() throws SQLException 
    {
    	entityManagerFactory = Persistence.createEntityManagerFactory("Estore");
    }
    
    @Before
    public void beforeEachTest() 
    {
        entityManager = entityManagerFactory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();
    }
        
    /*@Test
    public void testUser()
    {
    	User user = findUser(1);
    	String fname = user.getFirstName();
    	System.out.println(fname);
    	
    	User newUser = findUserName(fname);
    	assertEquals(fname, newUser.getFirstName());
    	
    }
   @Test
    public void testCountUser()
    {
    	Query q = entityManager.createQuery("select c from User c");
        assertEquals(3, q.getResultList().size());
    }
   
   @Test
   public void testUserGroup()
   {
	   User user = findUser(1);
	   UserGroup usergrp = findUserGroup(1);
	   System.out.println(usergrp.getGroupId());
	   
   }*/
   
   @After
   public void afterEachTest() {
       entityManager.close();
   }
   
   
    private User findUser(long userId) {
        Query q = entityManager.createQuery("select c from User c where c.id = :id");
        q.setParameter("id", userId);
        return (User) q.getSingleResult();
    }
    
    private UserGroup findUserGroup(long userId) {
        Query q = entityManager.createQuery("select c from UserGroup c where c.groupId = :id");
        q.setParameter("id", userId);
        return (UserGroup) q.getSingleResult();
    }
    
    private User findUserName(String fname) {
        Query q = entityManager.createQuery("select c from User c where c.first_name = :fname");
        q.setParameter("fname", fname);
        return (User) q.getSingleResult();
    }
}