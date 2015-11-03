package com.estore.domain.user;

import java.util.List;


public interface IUserService 
{
	void deleteUser(int userId);

    List<IUser> getAllUsers();
    
    List<IUser>getUsersByEmail(String Email);
    
    List<IUser>getUsersByPassword(String Password);
    
    List<IUser>getUsersByGroup(Long groupId);
    
    void saveUser(IUser user);
    
    IUser getUserById(Long id);
}
