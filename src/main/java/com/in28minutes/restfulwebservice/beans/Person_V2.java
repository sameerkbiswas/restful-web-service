/**
 * 
 */
package com.in28minutes.restfulwebservice.beans;

/**
 * @author Sameer
 *
 */
public class Person_V2 {

	private Name name;

	public Person_V2() {
		super();
	}

	public Person_V2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
