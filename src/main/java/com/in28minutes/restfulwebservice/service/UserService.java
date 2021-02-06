/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;

import com.in28minutes.restfulwebservice.beans.User;

/**
 * @author Sameer
 * Created on Feb 2, 2021 10:56:05 AM
 */
public interface UserService {

	public List<User> findAll();
	public User save(User user);
	public User findUser(Integer id);
	public User deleteUserById(Integer id);
}
