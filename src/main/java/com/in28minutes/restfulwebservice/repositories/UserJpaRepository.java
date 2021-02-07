package com.in28minutes.restfulwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restfulwebservice.beans.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {}
