package com.clover.springdemo.old;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope
public class SwimCoach implements Coach, DisposableBean {

	@Value("${foo.email}")
	private String emailAddress;

	@Value("${foo.team}")
	private String team;

//	@Autowired
//	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	public SwimCoach() {
		System.out.println("Inside CricketCoach no-arg constructor");
	}

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	public String toString() {
		return String.format("%s ----- Email: %s, Team: %s", 
					SwimCoach.class,
					emailAddress,
					team
				);
	}
	
	@PostConstruct
	private void doCustomInit() {
		System.out.println("Inside custom init function");
	}

	@PreDestroy
	private void doCustomDestroy() {
		System.out.println("Inside custom destroy function");
	}

	@Override
	public void destroy() {
		System.out.println("Inside destory method");
	}
}
