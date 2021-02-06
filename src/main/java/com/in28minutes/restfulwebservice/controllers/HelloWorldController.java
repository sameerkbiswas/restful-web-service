/**
 * 
 */
package com.in28minutes.restfulwebservice.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restfulwebservice.beans.HelloWorldBean;

/**
 * @author Sameer
 * Created on Jan 30, 2021 9:29:24 PM
 */

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean!");
	}
	
	/*
	 * To avoid getting "Accept-Language" from RequestHeader
	 * you can use LocaleContextHolder.getLocale() for locale and
	 * configuring AcceptHeaderLocaleResolver in place of SessionLocaleResolver 
	 */
	/*@GetMapping("/hello-world-i18n")
	public String helloWorldI18n(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning", null, locale);
	}*/
	
	@GetMapping("/hello-world-i18n")
	public String helloWorldI18n(Locale locale) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
