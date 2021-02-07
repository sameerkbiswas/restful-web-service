/**
 * 
 */
package com.in28minutes.restfulwebservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restfulwebservice.beans.Name;
import com.in28minutes.restfulwebservice.beans.Person_V1;
import com.in28minutes.restfulwebservice.beans.Person_V2;

/**
 * @author Sameer
 *
 */
@RestController
public class PersonController {

	// URI versionning
	@GetMapping("/v1/person")
	public Person_V1 personV1() {
		return new Person_V1("Sameer Biswas");
	}

	// URI versionning
	@GetMapping("/v2/person")
	public Person_V2 personV2() {
		return new Person_V2(new Name("Sameer", "Biswas"));
	}

	// HEADER versionning
	@GetMapping(value="/person", headers="X-API-VERSION=1.0")
	public Person_V1 personHeaderV1() {
		return new Person_V1("Sameer Biswas");
	}
	/* Header- X-API-VERSION=2.0*/
	// HEADER versionning
	@GetMapping(value="/person", headers="X-API-VERSION=2.0")
	public Person_V2 personHeaderV2() {
		return new Person_V2(new Name("Sameer", "Biswas"));
	}

	// REQUEST PARAM versionning
	@GetMapping(value="/person", params="version=1.0")
	public Person_V1 personParamV1() {
		return new Person_V1("Sameer Biswas");
	}
	/* ?version=1.0*/
	// REQUEST PARAM versionning
	@GetMapping(value="/person", params="version=2.0")
	public Person_V2 personParamV2() {
		return new Person_V2(new Name("Sameer", "Biswas"));
	}

	// MIME versionning
	@GetMapping(value="/person", produces={"application/vnd.company.aip-v1+json"})
	public Person_V1 personMimeV1() {
		return new Person_V1("Sameer Biswas");
	}
	/* Header- Accept=application/vnd.company.aip-v1+json8*/
	// MIME versionning
	@GetMapping(value="/person", produces={"application/vnd.company.aip-v2+json"})
	public Person_V2 personMimeV2() {
		return new Person_V2(new Name("Sameer", "Biswas"));
	}
}
