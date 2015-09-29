package com.estore.domain.user;

import java.util.List;


public interface IUserService 
{
	void deleteUser(int userId);

    List<IUser> getAllUsers();
    
    List<IUser>getUsersByFirstName(String FirstName);
    
    List<IUser>getUsersByLastName(String LastName);
    
    List<IUser>getUsersByGroup(Long groupId);
    
    void saveUser(IUser user);
    
    IUser getUserById(Long id);
}
