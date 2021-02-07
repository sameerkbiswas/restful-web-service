/**
 * 
 */
package com.in28minutes.restfulwebservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restfulwebservice.beans.FilteringBean2;
import com.in28minutes.restfulwebservice.service.DynamicFilteringService;

/**
 * @author Sameer
 *
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicFilteringController {

	@Autowired
	private DynamicFilteringService<FilteringBean2> dynamicFilteringService;

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveFilderingBean() {
		FilteringBean2 filteringBean = new FilteringBean2("Value1", "Value2", "Value3", "Value4");
		String[] exceptFilters = new String[] { "field2", "field4" };
		return dynamicFilteringService.mapJacksonValue(filteringBean, "FilteringBean2", exceptFilters);
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfFilderingBeans() {
		List<FilteringBean2> list = Arrays.asList(new FilteringBean2("Value1", "Value2", "Value3", "Value4"),
				new FilteringBean2("Value111", "Value222", "Value333", "Value444"));

		String[] exceptFilters = new String[] { "field1", "field3" };
		return dynamicFilteringService.mapJacksonValue(list, "FilteringBean2", exceptFilters);
	}
}
