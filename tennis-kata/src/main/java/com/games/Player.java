package com.games;

public class Player {
	private String name;
	Score score;
	
	Player(String name){
		this.name = name;
		this.score = new Score(0);
	}

	public boolean hasName(String playerName) {
		return name.equals(playerName);
	}

	public void wonPoint() {
		score.addPoint();
	}

	public boolean isPairWith(Player player2) {
		return player2.getScore().equals(score);
	}

	public Score getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public boolean beats(Player player1) {
		return score.beats(player1.getScore());
	}
}
