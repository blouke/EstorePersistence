package com.estore.domain.user;

import java.util.List;

public interface IUserGroupService 
{
	void deleteGroup(Long groupId);

    List<IUserGroup> getAllGroups();
    
    void saveGroup(IUserGroup group);
    
    IUserGroup getGroupById(Long id);
}
