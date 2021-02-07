/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;

import com.in28minutes.restfulwebservice.beans.Post;

/**
 * @author Sameer
 *
 */
public interface PostService {
	List<Post> retrieveAllPosts();
	Post retrievePostById(Integer postId);
	Post savePost(Post post);
	void deletePostById(Integer postId);
}
