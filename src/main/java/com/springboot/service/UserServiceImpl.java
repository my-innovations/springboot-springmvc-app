package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.exceptions.UserNotfoundException;
import com.springboot.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User getUserByUserId(Long userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User updateUser(User user) {
		if (null != user.getId())
			return userDao.updateUser(user);
		else
			throw new UserNotfoundException("Invalid User:");
	}

	@Override
	public void deleteUserById(Long userId) {
		User user = userDao.getUserByUserId(userId);
		if (null != user)
			userDao.deleteUserById(userId);
		else
			throw new UserNotfoundException("User not found:" + userId);
	}

	@Override
	public void deleteAllUsers() {
		userDao.deleteAllUsers();
	}

	@Override
	public boolean validateUserLogin(String username, String password) {
		if (username.equalsIgnoreCase("punya") && password.equalsIgnoreCase("punya"))
			return true;
		else
			return false;
	}
}
