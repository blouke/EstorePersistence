package com.estore.domain.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
	public void saveUser(IUser user) {
		EntityTransaction tx = em.getTransaction();

        tx.begin();
        IUser userToUpdate;
        if ((user.getID() != null) && (user.getID() > 0)) {
            userToUpdate = em.find(User.class, user.getID());
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPasswordHash(user.getPasswordHash());
            userToUpdate.setDateTime(user.getDateTime());
            userToUpdate.setGroupID(user.getGroupID());
        } else {
            userToUpdate = user;
        }

        em.persist(userToUpdate);
        tx.commit();

	}

	@Override
	public IUser getUserById(Long id) {
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
	public List<IUser> getUsersByPassword(String Password) {
		List<IUser> userPasswordList = em.createQuery("Select a From User a Where a.password_hash=:password", IUser.class).setParameter("password", Password).getResultList();
		return userPasswordList;
	}

}
