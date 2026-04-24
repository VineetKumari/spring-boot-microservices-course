package com.learning.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContra implements GamingConsole{
	
	public void up() {
		System.out.println("SuperContra up");
	}
	
	public void down() {
		System.out.println("SuperContra down");
	}

	public void left() {
		System.out.println("SuperContra stop");
	}
	 
	public void right() {
		System.out.println("SuperContra accelerate");
	}
}
