package com.games;

public class Player {
	private String name;
	Score score;

	public Player(String name) {
		this.name = name;
		this.score = new Score(0);
	}

	public boolean hasName(String playerName) {
		return name.equals(playerName);
	}

	public Player wonPoint() {
		score.addPoint();
		return this;
	}

	public boolean equals(Player otherPlayer) {
		return this.name.equals(otherPlayer.getName());
	}

	public boolean isParWith(Player otherPlayer) {
		// System.out.println("par  "+(otherPlayer.getScore().equals(score)&&score.asPoints()<3));
		return otherPlayer.getScore().equals(score) && score.asPoints() < 3;
	}

	// public boolean isDeuceWith(Player otherPlayer) {
	// //
	// System.out.println("deu   "+(otherPlayer.getScore().equals(score)&&score.asPoints()>=3));
	// return otherPlayer.getScore().equals(score)&&score.asPoints()>=3;
	// }
	public boolean hasMorethan3Points() {
		return this.score.asPoints() > 3;
	}

	public Score getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public boolean hasMorePoints(Player player) {
		return this.getScore().asPoints() > player.getScore().asPoints();
	}
}
