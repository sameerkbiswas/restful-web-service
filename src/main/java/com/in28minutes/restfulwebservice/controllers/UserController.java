/**
 * 
 */
package com.in28minutes.restfulwebservice.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.restfulwebservice.beans.User;
import com.in28minutes.restfulwebservice.exceptions.UserNotFoundException;
import com.in28minutes.restfulwebservice.service.UserService;

/**
 * @author Sameer
 * Created on Feb 2, 2021 11:07:08 AM
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}*/
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<EntityModel<User>> retrieveUser(@PathVariable Integer id) {
		User user = userService.findUser(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}

		// Using HATEOAS to add link of /users to the response
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(this.getClass()).findAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return ResponseEntity.ok(resource);
	}
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		User deletedUser = userService.deleteUserById(id);
		if(deletedUser == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}
}
