/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.restfulwebservice.beans.Post;
import com.in28minutes.restfulwebservice.beans.User;
import com.in28minutes.restfulwebservice.exceptions.UserNotFoundException;
import com.in28minutes.restfulwebservice.repositories.PostRepository;
import com.in28minutes.restfulwebservice.repositories.UserJpaRepository;


/**
 * @author Sameer
 * Created on Feb 2, 2021 10:39:22 AM
 */
@Service
public class UserJpaServiceImpl implements UserJpaService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired private PostRepository postRepository;
	
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

	@Override
	public List<Post> retrieveAllPostsOfUser(Integer id) {
		Optional<User> optionalUser = findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get().getPosts();
		} else {
			throw new UserNotFoundException("id-" + id);
		}
	}
	
	@Override
	public Post retrieveUserPostById(Integer id, Integer postId) {
		List<User> userList = findAll();
		User expectedUser = null;
		for (User user : userList) {
			if(user.getId() != null && user.getId().equals(id)) {
				expectedUser = user;
				break;
			}
		}
		
		if(null == expectedUser) {
			throw new UserNotFoundException("id-" + id);
		} else {
			List<Post> posts = expectedUser.getPosts();
			for (Post post : posts) {
				if(post.getId() != null && post.getId().equals(postId)) {
					return post;
				}
			}
		}
		return null;
	}

	@Override
	public Post savePost(Integer userId, Post post) {
		Optional<User> optionalUser = findById(userId);
		if(optionalUser.isPresent()) {
			post.setUser(optionalUser.get());
			return postRepository.save(post);
		} else {
			throw new UserNotFoundException("userId-" + userId);
		}
	}

	@Override
	public void deletePostById(Integer userId, Integer postId) {
		Optional<User> optionalUser = findById(userId);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<Post> posts = user.getPosts();
			for (Post post : posts) {
				if(post.getId().equals(postId)) {
					postRepository.deleteById(postId);
					break;
				}
			}
		} else {
			throw new UserNotFoundException("userId-" + userId);
		}
	}

}
