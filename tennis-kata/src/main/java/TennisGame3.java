
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
        String scoreDisplay;
        if (isSetNotEnd()) {
            scoreDisplay = getScoreName(player1Score);
            return isPair() ? scoreDisplay + "-All" : scoreDisplay + "-" + getScoreName(player2Score);
        } else {
            if (isPair())
                return "Deuce";
            scoreDisplay = player1Score > player2Score ? player1Name : player2Name;
            return ((player1Score-player2Score)*(player1Score-player2Score) == 1) ? "Advantage " + scoreDisplay : "Win for " + scoreDisplay;
        }
    }

	private boolean isPair() {
		return player1Score == player2Score;
	}

	private String getScoreName(int points) {
		String[] scoreNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
		return scoreNames[points];
	}

	private boolean isSetNotEnd() {
		return player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6);
	}
    
    public void wonPoint(String playerName) {
        if (playerName == this.player1Name)
            this.player1Score += 1;
        else
            this.player2Score += 1;
        
    }

}
