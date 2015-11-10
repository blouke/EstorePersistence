package com.estore.domain.user;

import java.util.List;


public interface IUserService 
{
	void deleteUser(int userId);

    List<IUser> getAllUsers();
    
    List<IUser>getUsersByEmail(String Email);
    
    IUser getUserByEmail(String Email);
    
    List<IUser>getUsersByPassword(String Password);
    
    List<IUser>getUsersByGroup(Long groupId);
    
    int saveUser(IUser user);
    
    IUser getUserById(int id);
    
    public UserGroup getUserGroupById(int id);
}
