package com.clover.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.clover.springdemo")
public class SportConfig {
	
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach();
		
		return mySwimCoach;
	}
}
