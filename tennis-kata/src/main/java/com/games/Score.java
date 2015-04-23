package com.games;

public class Score {
	private static String[] scoreNames = new String[] { "Love", "Fifteen",
			"Thirty", "Forty" };

	int points;

	public Score(int points) {
		this.points = points;
	}

	public int asPoints() {
		return points;
	}

	public String asWord() {
		return scoreNames[points];
	}

	public void addPoint() {
		points++;
	}

	public boolean equals(Score score) {
		return score.asPoints() == this.points;
	}
}
