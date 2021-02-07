package com.in28minutes.restfulwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restfulwebservice.beans.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {}
