/**
 * 
 */
package com.in28minutes.restfulwebservice.beans;

/**
 * @author Sameer
 * Created on Jan 30, 2021 9:47:38 PM
 */
public class HelloWorldBean {
	private String message;

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
