/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.restfulwebservice.beans.User;
import com.in28minutes.restfulwebservice.repositories.UserJpaRepository;


/**
 * @author Sameer
 * Created on Feb 2, 2021 10:39:22 AM
 */
@Service
public class UserJpaServiceImpl implements UserJpaService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Override
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}
	
	@Override
	public User save(User user) {
		return userJpaRepository.save(user);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userJpaRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		userJpaRepository.deleteById(id);
	}
	
}
