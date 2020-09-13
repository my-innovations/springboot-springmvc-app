package com.springboot.service;

import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegretionTest {

	// Here we are not mocking Dao layer.

	@Autowired
	UserService userService;

	@Test
	public void testGetUserByUserId() throws Exception {
		User u = userService.getUserByUserId(1L);
		Assertions.assertThat(u.getEmail()).isNotEmpty();
		assertEquals("punya", u.getName());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		List<User> usersList = userService.getAllUsers();
		assertEquals(2, usersList.size());
	}
	
	/*@Test
	public void deleteUserById() throws Exception {
		userService.deleteUserById(1L);
	}*/
	/*
	@Test
	public void deleteAllUsers() throws Exception {
		userService.deleteAllUsers();
	}*/

}
