package com.lrn.sb.restservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lrn.sb.restservices.exception.UserNotFoundException;
import com.lrn.sb.restservices.model.User;
import com.lrn.sb.restservices.service.UserServiceJpa;

/*exposing class as rest controller*/
@RestController
public class UserJPAResource {

	@Autowired
	private UserServiceJpa userService;
	/*get request mapping*/
	@GetMapping(path="/jpa/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/jpa/users/{id}")
	/*capture path variables*/
	public User getUser(@PathVariable final int id) {
		User user =  userService.getUser(id);
		if(user == null) {
			throw new UserNotFoundException("Id "+ id + " user not found.");
		}
		return user;
	}

	@PostMapping("/jpa/users")
	/*capture request body for post call and enable validation*/
	public ResponseEntity<URI> createUser(@Valid @RequestBody final User user) {
		User savedUser = userService.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		/*response entity to send response back*/
		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping("/jpa/users/{id}")
	public ResponseEntity<String> removeUser(@PathVariable final int id) {
		boolean result = userService.removeUser(id);
		if(!result) {
			throw new UserNotFoundException("User not found id " + id);
		}
		return ResponseEntity.ok("User id "+ id + " has been removed successfuly.");
	}


}
