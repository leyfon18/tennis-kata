package com.pointstate.states;

import com.games.Player;

public class ParPointState extends PointState {

	public ParPointState(Player player1, Player player2) {
		super(player1, player2);

	}

	// public PointState handleTransition(Player player1, Player otherPlayer) {
	// wonPointPlayer.wonPoint();
	// return new oddPointState(wonPointPlayer, otherPlayer);
	// }

	@Override
	protected String calculateScoreName() {
		return this.getPlayer1().getScore().asWord() + "-All";
	}

	@Override
	public PointState handleTransition(String wonPointPlayerName) {
		if (player1.hasName(wonPointPlayerName)) {
			player1.wonPoint();
		} else
			player2.wonPoint();
		return new OddPointState(player1, player2);
	}

}
