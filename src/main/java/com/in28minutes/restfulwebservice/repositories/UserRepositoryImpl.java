/**
 * 
 */
package com.in28minutes.restfulwebservice.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.in28minutes.restfulwebservice.beans.User;

/**
 * @author Sameer
 * Created on Feb 2, 2021 10:59:47 AM
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	private static Integer id = 3;
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Sameer", new Date()));
		users.add(new User(2, "Kumar", new Date()));
		users.add(new User(3, "Biswas", new Date()));
	}
	
	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++id);
		}
		users.add(user);
		return user;
	}

	@Override
	public User findUser(Integer id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User deleteUser(Integer id) {
		Iterator<User> iterator = users.iterator();
		User user;
		while(iterator.hasNext()) {
			user = iterator.next();
			if(user.getId().equals(id)) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
