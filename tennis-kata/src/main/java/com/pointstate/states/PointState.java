package com.pointstate.states;

import com.games.Player;

public abstract class PointState {

	private final String scoreStateName;
	protected Player player1;
	protected Player player2;
	protected Player advanPlayer;

	abstract public PointState handleTransition(String wonPointPlayerName);

	public String getStateName() {
		return scoreStateName;
	}

	abstract protected String calculateScoreName();

	/**
	 * @return the player1
	 */
	protected Player getPlayer1() {
		return player1;
	}

	/**
	 * @return the player2
	 */
	protected Player getPlayer2() {
		return player2;
	}

	protected PointState(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
		advanPlayer = getAdvantagePlayer();
		scoreStateName = calculateScoreName();
	}

	protected Player playerWithName(String wonPointPlayerName) {
		if (player1.hasName(wonPointPlayerName))
			return player1;
		else
			return player2;
	}

	private Player getAdvantagePlayer() {
		if (player1.hasMorePoints(player2))
			return player1;
		else
			return player2;
	}
}
