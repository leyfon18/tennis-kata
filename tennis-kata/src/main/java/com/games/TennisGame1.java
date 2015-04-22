package com.games;
public class TennisGame1 implements TennisGame {

	private int player1Score = 0;
	private int player2Score = 0;
	private String player1Name;
	private String player2Name;
	private String[] scoreName = { "Love", "Fifteen", "Thirty", "Forty",
			"Deuce" };

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == player1Name)
			player1Score++;
		else
			player2Score++;
	}

	public String getScore() {
		String score = "";
		int tempScore = 0;
		if (!isScoreMore4()) {
			score += getScoreName(player1Score);
			score += "-";
			if (isPair())
				if (isDeuceWhenPair())
					score = "Deuce";
				else
					score += "All";
			else
				score += getScoreName(player2Score);
		} else {
			if (isScoreMore4()) {
				if (isPair())
					score = "Deuce";
				else {
					int minusResult = player1Score - player2Score;
					if (minusResult == 1)
						score = "Advantage player1";
					else if (minusResult == -1)
						score = "Advantage player2";
					else if (minusResult >= 2)
						score = "Win for player1";
					else
						score = "Win for player2";

				}
			}
		}
		return score;
	}

	private boolean isDeuceWhenPair() {
		return player2Score == 3;
	}

	private String getScoreName(int tempScore) {
		// switch(tempScore)
		// {
		// case 0:
		// score+="Love";
		// break;
		// case 1:
		// score+="Fifteen";
		// break;
		// case 2:
		// score+="Thirty";
		// break;
		// case 3:
		// score+="Forty";
		// break;
		// }
		// return score;

		return scoreName[tempScore];

	}

	private boolean isScoreMore4() {
		return player1Score >= 4 || player2Score >= 4;
	}

	private boolean isPair() {
		return player1Score - player2Score == 0;
	}
}
