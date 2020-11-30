package com.hari.dsal.implementations.Chessgame;

public abstract class Player {
	public boolean whiteSide;
	public boolean humanPlayer;

	public boolean isWhiteSide() {
		return this.whiteSide;
	}

	public boolean isHumanPlayer() {
		return this.humanPlayer;
	}
}

class HumanPlayer extends Player {

	public HumanPlayer(boolean whiteSide) {
		this.whiteSide = whiteSide;
		this.humanPlayer = true;
	}
}

class ComputerPlayer extends Player {

	public ComputerPlayer(boolean whiteSide) {
		this.whiteSide = whiteSide;
		this.humanPlayer = false;
	}
}
