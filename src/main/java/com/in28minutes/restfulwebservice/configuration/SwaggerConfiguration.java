/**
 * 
 */
package com.in28minutes.restfulwebservice.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sameer
 * Check the below URLs to see the outcome of Swagger
 * http://localhost:8080/v2/api-docs
 * http://localhost:8080/swagger-ui/index.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	// To customize the Swagger document
	/*private static final Contact DEFAULT_CONTACT = new Contact("Ranga Karanam", "http://www.in28mins.com",
			"in28mins@gmail.com");*/
	private static final String DEFAULT_CONTACT = "Ranga Karanam";

	private static final ApiInfo DEFAULT_APP_INFO = new ApiInfo("Awesome API title", "Awesome API Documentation", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));
	private static final Set<String> DEFAULT_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_APP_INFO).consumes(DEFAULT_CONSUMES)
				.produces(DEFAULT_PRODUCES);
	}
}

