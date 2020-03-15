package com.clover.springdemo;

import org.springframework.beans.factory.DisposableBean;

public class CricketCoach implements Coach, DisposableBean {
	
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;
	
	public CricketCoach() {	
		System.out.println("Inside CricketCoach no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void setTeam(String team) {
		this.team= team;
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
					CricketCoach.class,
					emailAddress,
					team
				);
	}
	
	private void doCustomInit() {
		System.out.println("Inside custom init function");
	}

	private void doCustomDestroy() {
		System.out.println("Inside custom destroy function");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Inside new destory method");
		// TODO Auto-generated method stub
		
	}

}
