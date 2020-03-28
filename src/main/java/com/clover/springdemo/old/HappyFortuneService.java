package com.clover.springdemo.old;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	
	public String getFortune() {
		return "Happy!";
	}
}
