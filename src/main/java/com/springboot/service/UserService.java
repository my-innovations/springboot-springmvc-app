package com.springboot.service;

import java.util.List;

import com.springboot.model.User;

public interface UserService {
	
	public User saveUser(User user) ;
	
	public User getUserByUserId(Long userId) ;
	public List<User> getAllUsers();
	
	public User updateUser(User user);
	
	public void deleteUserById(Long userId);
	
	public void deleteAllUsers();
	
	public boolean validateUserLogin(String username,String password);

}
