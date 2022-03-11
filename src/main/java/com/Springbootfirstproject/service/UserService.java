package com.Springbootfirstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springbootfirstproject.dao.UserRepo;
import com.Springbootfirstproject.entity.User;



@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public List<User> createUsers(List<User> users) {
		return userRepo.saveAll(users);
	}

	public User getUserById(int id) {
		return userRepo.findById(id).orElse(null);
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public User updateUser(User user) {
		User oldUser = null;
		Optional<User> opUser = userRepo.findById(user.getId());

		if (opUser.isPresent()) {
			oldUser = opUser.get();
			oldUser.setName(user.getName());
			userRepo.save(oldUser);
		} else {
			return new User();
		}
		return oldUser;

	}
	
	public String deleteUser(int id) {
		userRepo.deleteById(id);
		return "User deleted";
	}
}


