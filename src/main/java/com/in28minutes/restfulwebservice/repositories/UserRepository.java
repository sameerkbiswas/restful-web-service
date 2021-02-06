/**
 * 
 */
package com.in28minutes.restfulwebservice.repositories;

import java.util.List;

import com.in28minutes.restfulwebservice.beans.User;

/**
 * @author Sameer
 * Created on Feb 2, 2021 10:58:28 AM
 */
public interface UserRepository {
	
	public List<User> findAll();
	public User save(User user);
	public User findUser(Integer id);
	public User deleteUser(Integer id);
}
