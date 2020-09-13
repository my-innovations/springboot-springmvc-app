package com.springboot.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springboot.dao.UserDao;
import com.springboot.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTestUsingMockito1 {

	@InjectMocks
	UserServiceImpl userService;
	// UserService userService; // will not work

	@Mock
	// @MockBean //OK
	UserDao userDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * ##############################################################################################################################
	 * Insert Operation
	 * ##############################################################################################################################
	 */

	// @Test(expected=NullPointerException.class)
	@Test
	public void testCreateUser() throws Exception {
		User user = new User(1L, "punya", 40, "punya@gmail.com");
		Mockito.when(userDao.saveUser(user)).thenReturn(user);
		User created = userService.saveUser(user);
		Assertions.assertThat(created.getEmail()).isSameAs(user.getEmail());
		verify(userDao, times(1)).saveUser(user);
	}

	/**
	 * ##############################################################################################################################
	 * Select Operation
	 * ##############################################################################################################################
	 */

	@Test
	public void testGetUserByUserId() throws Exception {
		User user = new User(1L, "punya", 40, "punya@gmail.com");
		Mockito.when(userDao.getUserByUserId(1L)).thenReturn(user);
		User u = userService.getUserByUserId(1L);
		Assertions.assertThat(u.getEmail()).isNotEmpty();
		assertEquals("punya", u.getName());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		User user = new User(1L, "punya", 40, "punya@gmail.com");
		List<User> list = new ArrayList<>();
		list.add(user);
		Mockito.when(userDao.getAllUsers()).thenReturn(list);
		List<User> usersList = userService.getAllUsers();
		assertEquals(1, usersList.size());
		verify(userDao, times(1)).getAllUsers();
	}

	/**
	 * ##############################################################################################################################
	 * Update Operation
	 * ##############################################################################################################################
	 */

	@Test
	public void testupdateUser() throws Exception {
		User user = new User(1L, "punya", 40, "punya@gmail.com");
		Mockito.when(userDao.updateUser(user)).thenReturn(user);
		User u = userService.updateUser(user);
		Assertions.assertThat(user.getEmail()).isSameAs(u.getEmail());
	}

	/**
	 * ##############################################################################################################################
	 * Delete Operation
	 * ##############################################################################################################################
	 * 
	 * 
	 */

	@Test
	public void deleteUserById() throws Exception {
		
		User user = new User(1L, "punya", 40, "punya@gmail.com");
		Mockito.when(userDao.getUserByUserId(1L)).thenReturn(user);
		
		Mockito.doNothing().when(userDao).deleteUserById(Mockito.anyLong());
		userService.deleteUserById(1L);
		verify(userDao, times(1)).deleteUserById(1L);
	}

	@Test
	public void deleteAllUsers() throws Exception {
		Mockito.doNothing().when(userDao).deleteAllUsers();
		userService.deleteAllUsers();
		verify(userDao, times(1)).deleteAllUsers();
	}

}
