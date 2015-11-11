package com.estore.domain.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;


public class UserService implements IUserService {

	private EntityManager em;
	
	 public UserService() 
	 {
	        em = Persistence.createEntityManagerFactory("Estore").createEntityManager();
	 }
	 
	 
	@Override
	public void deleteUser(int userId) {
		EntityTransaction tx = em.getTransaction();
        tx.begin();
        User user = em.find(User.class, userId);
        em.remove(user);
        tx.commit();

	}

	@Override
	public List<IUser> getAllUsers() {
		List<IUser> userList = em.createQuery("Select a From User a", IUser.class).getResultList();
		return userList;
	}

	@Override
	public List<IUser> getUsersByGroup(Long groupId) {
		List<IUser> userGroupList = em.createQuery("Select a From User a Where a.groupID=:groupId", IUser.class).setParameter("groupId", groupId).getResultList();
		//List<IUser> userGroupList = null;
		return userGroupList;
	}

	@Override
	public int saveUser(IUser user) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IUser userToUpdate;
        if ((user.getId() > 0)) {
            userToUpdate = (IUser) em.find(User.class, user.getId());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPasswordHash(user.getPasswordHash());
            userToUpdate.setCreateDate(user.getCreateDate());
            userToUpdate.setUserGroup(user.getUserGroup());
        } else {
            userToUpdate = user;
        }
        em.persist(userToUpdate);
        tx.commit();
        return userToUpdate.getId();
	}

	@Override
	public IUser getUserById(int id) {
		@SuppressWarnings("unchecked")
		List<IUser> userByIdList = em.createQuery("Select a From User a Where a.id=:userid").setParameter("userid", id).getResultList();
        if (userByIdList.isEmpty()) return null;
        else if (userByIdList.size() == 1) return userByIdList.get(0);
        throw new NonUniqueResultException();
	}


	@Override
	public List<IUser> getUsersByEmail(String Email) {
		List<IUser> userEmailList = em.createQuery("Select a From User a Where a.email=:email", IUser.class).setParameter("email", Email).getResultList();
		return userEmailList;
	}

	
	@Override
	public IUser getUserByEmail(String Email) {
		try {
		IUser user = em.createQuery("Select a From User a Where a.email=:email", IUser.class).setParameter("email", Email).getSingleResult();
		return user;
		} catch (NoResultException e){
			return null;
		}
	}
	

	@Override
	public List<IUser> getUsersByPassword(String Password) {
		List<IUser> userPasswordList = em.createQuery("Select a From User a Where a.password_hash=:password", IUser.class).setParameter("password", Password).getResultList();
		return userPasswordList;
	}

	@Override
	public UserGroup getUserGroupById(int id){
		UserGroup userGroup = em.createQuery("Select a From UserGroup a Where a.id=:id", UserGroup.class).setParameter("id", id).getSingleResult();
		return userGroup;
	}
}
