package com.learning.spring.learn_spring_framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learning.spring.learn_spring_framework.game.GameRunner;
import com.learning.spring.learn_spring_framework.game.MarioGame;
import com.learning.spring.learn_spring_framework.game.SuperContra;
import com.learning.spring.learn_spring_framework.game.GamingConsole;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		// MarioGame game=new MarioGame();
		// SuperContra superContraGame=new SuperContra();
		//GamingConsole game=new SuperContra();
		//GameRunner runner=new GameRunner(game); 
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
	}

}
