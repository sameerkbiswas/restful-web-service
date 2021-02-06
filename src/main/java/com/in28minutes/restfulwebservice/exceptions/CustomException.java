/**
 * 
 */
package com.in28minutes.restfulwebservice.exceptions;

import java.util.Date;

/**
 * @author Sameer
 * Created on Feb 3, 2021 5:30:13 PM
 */
public class CustomException {
	
	private Date timeStamp;
	private String message;
	private String details;
	public CustomException(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	};
	
}
