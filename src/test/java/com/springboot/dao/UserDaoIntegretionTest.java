package com.springboot.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.SpringBootSpringMvcWarApp;
import com.springboot.model.User;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBootSpringMvcWarApp.class)
public class UserDaoIntegretionTest {

	@Autowired
	UserDao userDao;

	@Test
	public void testGetUserByUserId() throws Exception {
		User u = userDao.getUserByUserId(1L);
		Assertions.assertThat(u.getEmail()).isNotEmpty();
	}

	@Test
	public void testGetAllUsers() {
		int total = userDao.getAllUsers().size();
		Assert.assertEquals(2, total);
	}

	@Test
	public void saveUserTest() {
		User user = new User("punya", 40, "punya@gmail.com",new Date());
		User u = userDao.saveUser(user);
		Assert.assertEquals(u.getEmail(), user.getEmail());
		Assert.assertNotNull(u.getId());
	}

	@Test
	public void updateUserTest() {
		User user = new User(1L, "punya", 40, "punya@gmail.com");
		User u = userDao.updateUser(user);
		Assert.assertEquals(user.getEmail(), u.getEmail());
	}

	@Test
	public void testDeleteuser() throws Exception {
		assertThat(this.userDao).isNotNull();
		userDao.deleteUserById(2L);
	}

	/*@Test
	public void testDeleteAllUsers() throws Exception {
		assertThat(this.userDao).isNotNull();
		userDao.deleteAllUsers();
	}*/
}
