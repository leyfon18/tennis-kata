public class TennisGame3 implements TennisGame {

	private int player2Score;
	private int player1Score;
	private String player1Name;
	private String player2Name;

	public TennisGame3(String p1N, String p2N) {
		this.player1Name = p1N;
		this.player2Name = p2N;
	}

	public String getScore() {


		if (isScoresMore4()) {
			return inLateGane();
		}
		else{
		return inEalryGame();
		}
	}

	private String inEalryGame() {
		return getFirstPlayerScore(player1Score) + getSecondPlayerScore();
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

	private String getSecondPlayerScore() {
		if (isDeuceSituation(getFirstPlayerScore(player2Score)))
			return "";
		return isPair() ? "-All" : "-" + getFirstPlayerScore(player2Score);
	}

	private boolean isDeuceSituation(String firstPlayerScore) {
		return firstPlayerScore == "Deuce";
	}

	private boolean isScoreDifferenceBelow2() {
		return (player1Score - player2Score) * (player1Score - player2Score) == 1;
	}

	private boolean isPair() {
		return player1Score == player2Score;
	}

	private String getFirstPlayerScore(int points) {
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
		if (playerName == this.player1Name)
			this.player1Score += 1;
		else
			this.player2Score += 1;

	}

}
