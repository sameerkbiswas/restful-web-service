/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

import com.in28minutes.restfulwebservice.beans.User;

/**
 * @author Sameer
 * Created on Feb 2, 2021 10:56:05 AM
 */
public interface UserJpaService {

	public List<User> findAll();
	public User save(User user);
	public Optional<User> findById(Integer id);
	public void deleteById(Integer id);
}
