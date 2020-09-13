package com.springboot.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

import com.springboot.exceptions.UserNotfoundException;
import com.springboot.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static Map<Long, User> userRepo = new HashMap<>();

	private static Long id = 0L;

	static {
		++id;
		User user1 = new User();
		user1.setId(id);
		user1.setName("Punya");
		user1.setAge(31);
		user1.setEmail("Punya@gmail.com");
		user1.setDob(new Date());
		userRepo.put(user1.getId(), user1);

		++id;
		User user2 = new User();
		user2.setId(id);
		user2.setName("Lipun");
		user2.setAge(21);
		user2.setEmail("Lipun@gmail.com");
		user2.setDob(new Date());
		userRepo.put(user2.getId(), user2);
	}

	@Override
	public User saveUser(User user) {
		++id;
		user.setId(id);
		userRepo.put(id, user);
		return userRepo.get(user.getId());
	}

	@Override
	public User getUserByUserId(Long userId) {
		User user = userRepo.get(userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersAll = new ArrayList<User>();
		Set<Long> set = userRepo.keySet();
		for (Long userId : set) {
			User user = userRepo.get(userId);
			usersAll.add(user);
		}
		return usersAll;
	}

	@Override
	public User updateUser(User user) {
		if (!userRepo.containsKey(user.getId()))
			throw new UserNotfoundException("User not found");
		userRepo.put(user.getId(), user);
		return userRepo.get(user.getId());
	}

	@Override
	public void deleteUserById(Long userId) {
		userRepo.remove(userId);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("obj destroyed");
	}

	@Override
	public void deleteAllUsers() {
		userRepo.clear();
	}
}
