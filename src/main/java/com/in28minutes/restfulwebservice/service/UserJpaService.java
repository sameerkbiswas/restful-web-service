/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

import com.in28minutes.restfulwebservice.beans.Post;
import com.in28minutes.restfulwebservice.beans.User;

/**
 * @author Sameer
 * Created on Feb 2, 2021 10:56:05 AM
 */
public interface UserJpaService {

	List<User> findAll();
	User save(User user);
	Optional<User> findById(Integer id);
	void deleteById(Integer id);
	
	List<Post> retrieveAllPostsOfUser(Integer userId);
	Post retrieveUserPostById(Integer userId, Integer postId);
	Post savePost(Integer userId, Post post);
	void deletePostById(Integer userId, Integer postId);
}
