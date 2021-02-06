/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.restfulwebservice.beans.User;
import com.in28minutes.restfulwebservice.repositories.UserRepository;


/**
 * @author Sameer
 * Created on Feb 2, 2021 10:39:22 AM
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findUser(Integer id) {
		return userRepository.findUser(id);
	}

	@Override
	public User deleteUserById(Integer id) {
		return userRepository.deleteUser(id);
	}
}
