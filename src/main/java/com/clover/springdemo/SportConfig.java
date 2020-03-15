package com.clover.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:coach.properties")
//@ComponentScan("com.clover.springdemo")
public class SportConfig {

	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
		
		return mySwimCoach;
	}
}
