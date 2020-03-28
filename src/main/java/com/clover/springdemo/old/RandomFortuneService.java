package com.clover.springdemo.old;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	public String getFortune() {
		return "Random..!";
	}
}
