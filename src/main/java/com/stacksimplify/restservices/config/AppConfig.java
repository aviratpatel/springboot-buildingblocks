/**
 * 
 */
package com.stacksimplify.restservices.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Avi
 * Created and Registered Bean for ModelMapper object
 */
@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
