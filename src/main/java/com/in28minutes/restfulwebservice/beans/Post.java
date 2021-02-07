/**
 * 
 */
package com.in28minutes.restfulwebservice.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Sameer
 *
 */
@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	
	@JsonIgnore	// To avoid the loop. User -> Post -> User -> Post again and again.
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
