package com.estore.jpa;

import java.util.List;

import com.estore.domain.user.IUser;
import com.estore.domain.user.IUserService;
import com.estore.domain.user.UserService;

public class UserTest {
	private IUserService userService;

    public UserTest() {
    	userService = new UserService();
    }
 
    public static void main(String[] args) {
        UserTest test = new UserTest();
        System.out.println("GET ALL USERS");
        test.listUsers();
        System.out.println("GET USERS BY GROUP");
        test.getUserByGroup();
        test.updateUser(1L);
        System.out.println(".. done");
    }
    
    private void listUsers() {	
    	List<IUser> resultList = userService.getAllUsers();
    	System.out.println("num of users:" + resultList.size());
    	
    	for(IUser next :resultList) {
    		System.out.println(next);
    	}     
    }
    
    private void getUserByGroup() {
    	List<IUser> resultList = userService.getUsersByGroup(2L);
    	System.out.println("num of groups:" + resultList.size());
    	
    	for(IUser next :resultList) {
    		System.out.println(next);
    	}   
    }
    
    private void updateUser(Long id) {
    	IUser user = userService.getUserById(id);
//    	product.setImage("/images/1.jpg");
    	userService.saveUser(user);
    }

	}
