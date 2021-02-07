/**
 * 
 */
package com.in28minutes.restfulwebservice.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Sameer
 * Created on Feb 2, 2021 10:34:29 AM
 * @ApiModel and @ApiModelProperty annotations are used to show User information
 * in Swagger document 
 */
@ApiModel(description="All details about user.")
@Entity	// To treat User as a JPA Entity
public class User {
	
	@Id
	@GeneratedValue	// To generate id by the Database
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 charecters.")
	@ApiModelProperty(notes="Name should have at least 2 charecters.")
	private String name;
	
	@Past(message="Date of birth should be a past date.")
	@ApiModelProperty("Date of birth should be a past date.")
	private Date dateOfBirth;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;

	public User() {
		super();
	}
	public User(Integer id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
