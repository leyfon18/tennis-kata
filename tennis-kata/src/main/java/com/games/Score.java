package com.games;

public class Score {
	private static String[] scoreNames = new String []{ "Love", "Fifteen", "Thirty","Forty", "Deuce"};
	
	int points;
	
	public Score(int points){
		this.points = points;
	}
	
	public int asPoints(){
		return points;
	}
	
	public String asWord(){
		return scoreNames[points];
	}

	public void addPoint() {
		points++;
	}

	public boolean isInLateGame() {
		return points >= 3;
	}
	
	public boolean equals(Score score){
		return score.asPoints() == this.points;
	}

	public boolean beats(Score score) {
		if (points > 3 && (points - score.asPoints()) >= 2)
			return true;
		
		return false;
	}
}
