package com.in28minutes.restfulwebservice.service;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class DynamicFilteringServiceImpl<T> implements DynamicFilteringService<T> {

	@Override
	public MappingJacksonValue mapJacksonValue(T t, String id, String[] fieldsToDisplay) {
		return applyMappingOnFilter(getMappingJacksonValue(t), id, fieldsToDisplay);
	}

	@Override
	public MappingJacksonValue mapJacksonValue(List<T> tList, String id, String[] fieldsToDisplay) {
		return applyMappingOnFilter(getMappingJacksonValue(tList), id, fieldsToDisplay);
	}
	
	private MappingJacksonValue getMappingJacksonValue(Object object) {
		return new MappingJacksonValue(object);
	}
	
	private MappingJacksonValue applyMappingOnFilter(MappingJacksonValue mappingJacksonValue, String id, String[] fieldsToDisplay) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToDisplay);
		FilterProvider filters = new SimpleFilterProvider().addFilter(id, filter);
		mappingJacksonValue.setFilters(filters );
		return mappingJacksonValue;
	}
}
