/**
 * 
 */
package com.in28minutes.restfulwebservice.service;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Sameer
 * Created on Feb 3, 2021 10:48:55 PM
 */
public interface I18nMessageService {
	
	LocaleResolver localeResolver();
	//ResourceBundleMessageSource bundleMessageSource();

}
