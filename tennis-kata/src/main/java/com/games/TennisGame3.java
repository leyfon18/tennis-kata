package com.games;
public class TennisGame3 implements TennisGame {

	private int player2Score;
	private int player1Score;
	private String player1Name;
	private String player2Name;
	private Player player1;
	private Player player2;
	

	public TennisGame3(String p1Name, String p2Name) {
		this.player1 = new Player(p1Name);
		this.player2 = new Player(p2Name);
	}

	public String getScore() {
		
		String result = "unknown";
		
		if (player1.beats(player2)){
			result = "Win for " + player1.getName();
		} else{
			if (player2.beats(player1)){
				result = "Win for " + player2.getName();
			}
			else{
		
				if (weAreInLateGame()){
					if (isPair()){
						result = "Deuce";
					}
					
				} else{
					if (isPair()){
						result = player1.getScore().asWord() + "-All";
					} else{
						result = player1.getScore().asWord() + "-" + player2.getScore().asWord();
					}
				}
			}
		}
		return result;

	}


	private boolean weAreInLateGame() {
		return player1.getScore().isInLateGame() && player2.getScore().isInLateGame();
	}

	private String inLateGane() {
		if (isPair())
			return "Deuce";
		String scoreDisplay;
		scoreDisplay = player1Score > player2Score ? player1Name
				: player2Name;
		return isScoreDifferenceBelow2() ? "Advantage " + scoreDisplay
				: "Win for " + scoreDisplay;
	}

	private String inEalryGame() {
		return getPlayerScore(player1Score) + getSecondPlayerScore();
	}
	private String getSecondPlayerScore() {
		if (isDeuceSituation(getPlayerScore(player2Score)))
			return "";
		return isPair() ? "-All" : "-" + getPlayerScore(player2Score);
	}

	private boolean isDeuceSituation(String firstPlayerScore) {
		return firstPlayerScore == "Deuce";
	}

	private boolean isScoreDifferenceBelow2() {
		return (player1Score - player2Score) * (player1Score - player2Score) == 1;
	}

	private boolean isPair() {
		return player1.isPairWith(player2);
	}

	private String getPlayerScore(int points) {
		String[] scoreNames = new String[] { "Love", "Fifteen", "Thirty",
				"Forty", "Deuce", "All" };
		if (this.player1Score >= 3 && isPair())
			return scoreNames[4];
		return scoreNames[points];
	}

	private boolean isScoresMore4() {
		return !(player1Score < 4 && player2Score < 4);
	}

	public void wonPoint(String playerName) {
		
		Player player = getPlayerForName(playerName);
		
		player.wonPoint();
		

	}

	private Player getPlayerForName(String playerName) {
		if (player1.hasName(playerName)){
			return player1;
		}
		return player2;
	}

	

}
