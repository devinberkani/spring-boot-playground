package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacManGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {

		
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		
		// 1: Object Creation
		var game = new PacManGame();
		
		// 2: Object Creation + Wiring of Dependencies
		// Game is a Dependency of GameRunner Class
		
		var gameRunner = new GameRunner(game);
		
		gameRunner.run();

	}

}
