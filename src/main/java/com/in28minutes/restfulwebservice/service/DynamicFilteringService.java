/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;

/**
 * @author Sameer
 *
 */
public interface DynamicFilteringService<T> {

	MappingJacksonValue mapJacksonValue(T t, String id, String[] fieldsToDisplay);

	MappingJacksonValue mapJacksonValue(List<T> tList, String id, String[] fieldsToDisplay);

}
