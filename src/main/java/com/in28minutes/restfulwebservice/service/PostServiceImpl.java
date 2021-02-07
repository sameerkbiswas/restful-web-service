/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.restfulwebservice.beans.Post;
import com.in28minutes.restfulwebservice.repositories.PostRepository;

/**
 * @author Sameer
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> retrieveAllPosts() {
		return postRepository.findAll();
	}
	
	@Override
	public Post retrievePostById(Integer postId) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		return optionalPost.get();
	}

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deletePostById(Integer postId) {
		postRepository.deleteById(postId);
	}

}
