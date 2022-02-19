package com.lrn.sb.restservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lrn.sb.restservices.dao.UserRepository;
import com.lrn.sb.restservices.model.User;

@Component
public class UserServiceJpa {

	List<User> userList = new ArrayList<>();
	@Autowired
	private UserRepository userRepository;
	public int userIdCount = 0;

	public UserServiceJpa() {
	}

	public User getUser(final int id) {
		Optional<User> opUser = userRepository.findById(id);
		return opUser.orElse(null);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public boolean removeUser(final int id) {
		userRepository.deleteById(id);
		return true;
	}

	public User save(final User user) {

		return userRepository.save(user);
	}

}
