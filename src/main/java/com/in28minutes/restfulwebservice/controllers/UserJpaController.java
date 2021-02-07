/**
 * 
 */
package com.in28minutes.restfulwebservice.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.restfulwebservice.beans.User;
import com.in28minutes.restfulwebservice.exceptions.UserNotFoundException;
import com.in28minutes.restfulwebservice.service.UserJpaService;

/**
 * @author Sameer
 * Created on Feb 2, 2021 11:07:08 AM
 */
@RestController
@RequestMapping("/jpa")
public class UserJpaController {
	
	@Autowired
	private UserJpaService userJpaService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAllUsers() {
		return ResponseEntity.ok(userJpaService.findAll());
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<EntityModel<User>> retrieveUser(@PathVariable Integer id) {
		Optional<User> optionalUser = userJpaService.findById(id);
		User user = null;
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			// Using HATEOAS to add link of /users to the response
			EntityModel<User> resource = EntityModel.of(user);
			WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
					methodOn(this.getClass()).findAllUsers());
			resource.add(linkTo.withRel("all-users"));
			return ResponseEntity.ok(resource);
		} else {
			throw new UserNotFoundException("id-" + id);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User savedUser = userJpaService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		userJpaService.deleteById(id);
	}
}
