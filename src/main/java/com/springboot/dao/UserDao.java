package com.springboot.dao;

import java.util.List;

import com.springboot.model.User;

public interface UserDao {
	
	public User saveUser(User user) ;
	
	public User getUserByUserId(Long userId) ;
	public List<User> getAllUsers();
	
	public User updateUser(User user);
	
	public void deleteUserById(Long userId);
	public void deleteAllUsers();

}
