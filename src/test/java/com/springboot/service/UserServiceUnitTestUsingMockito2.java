package com.springboot.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.SpringBootSpringMvcWarApp;
import com.springboot.dao.UserDao;
import com.springboot.model.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
//@RunWith(MockitoJUnitRunner.class) //OK
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class) //OK
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootSpringMvcWarApp.class)
public class UserServiceUnitTestUsingMockito2 {

	@Autowired
	// @InjectMocks // will not work, will work when we will use run with MockitoJUnitRunner
	private UserServiceImpl userService;
	
	//@Mock //OK
	@MockBean
	private UserDao userDao;

	// Below are Unit Test cases but not integretion test cases.

	/**
	 * ########################################################################################################################
	 * Select Operation
	 * ########################################################################################################################
	 */
	
	@Test
	public void testGetUserById() {
		User user = new User(1L, "punya", 40, "Punya@gmail.com");
		Mockito.when(userDao.getUserByUserId(1L)).thenReturn(user);
		Assert.assertSame(user.getEmail(), userService.getUserByUserId(1L).getEmail());
	}

	@Test
	public void testGetAllUsers() {

		User user1 = new User(1L, "punya", 40, "punya@gmail.com");
		User user2 = new User(2L, "pankaj", 30, "pankaj@gmail.com");

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);

		Mockito.when(userDao.getAllUsers()).thenReturn(userList);
		Assert.assertEquals(2, userService.getAllUsers().size());

	}
	/**
	 * ########################################################################################################################
	 * Insert Operation
	 * ########################################################################################################################
	 */

	@Test
	public void saveUserTest() {
		User user = new User(1L,"punya", 40, "punya@gmail.com");
		Mockito.when(userDao.saveUser(user)).thenReturn(user);
		Assert.assertEquals(user, userService.saveUser(user));
	}

	/**
	 * ########################################################################################################################
	 * Update Operation
	 * ########################################################################################################################
	 */
	
	@Test
	public void updateUserTest() {
		User user = new User(1L,"punya", 40, "punya@gmail.com");
		Mockito.when(userDao.updateUser(user)).thenReturn(user);
		Assert.assertEquals(user, userService.updateUser(user));
	}

	/**
	 * ########################################################################################################################
	 * Delete Operation
	 * ########################################################################################################################
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
