package com.userapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}

	public User getById(long userId) {
		return userDao.findUser(userId);
	}

	@Transactional
	public User createUser(User user) {
		return userDao.createUser(user);
	}

	@Transactional
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(long userId) {
		userDao.deleteUser(userId);
	}
}
