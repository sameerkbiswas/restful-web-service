/**
 * 
 */
package com.in28minutes.restfulwebservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restfulwebservice.beans.FilteringBean;

/**
 * @author Sameer
 *
 */
@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public FilteringBean retrieveFilderingBean() {
		return new FilteringBean("Value1", "Value2", "Value3", "Value4");
	}
	
	@GetMapping("/filtering-list")
	public List<FilteringBean> retrieveListOfFilderingBeans() {
		return Arrays.asList(new FilteringBean("Value1", "Value2", "Value3", "Value4"),
				new FilteringBean("Value111", "Value222", "Value333", "Value444"));
	}
}
