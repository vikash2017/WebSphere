package com.userapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoJpaImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public User createUser(User user) {
		entityManager.persist(user);
		return user;
	}

	public User updateUser(User user) {
		return entityManager.merge(user);
	}

	public void deleteUser(long userId) {
		User user = findUser(userId);
		entityManager.remove(user);
	}

	public List<User> findAllUsers() {
		TypedQuery<User> query = entityManager.createQuery("from User", User.class);
		return query.getResultList();
	}

	public User findUser(long userId) {
		return entityManager.find(User.class, userId);
	}
}