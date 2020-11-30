package com.hari.dsal.implementations.Chessgame;

public class MainGame {
	
	public static void main(String[] args) {
		Game game = new Game();
		Player p1 = new HumanPlayer(true);
		Player p2= new HumanPlayer(false);
		
		game.initialize(p1, p2);
	}

}
