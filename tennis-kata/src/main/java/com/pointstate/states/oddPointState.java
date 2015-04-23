package com.pointstate.states;

import com.games.Player;

public class oddPointState extends PointState {

	public oddPointState(Player player1, Player player2) {
		super(player1, player2);

	}

	@Override
	protected String calculateScoreName() {
		return this.getPlayer1().getScore().asWord() + "-"
				+ this.getPlayer2().getScore().asWord();
	}

	@Override
	public PointState handleTransition(String wonPointPlayerName) {
		if (player1.hasName(wonPointPlayerName)) {
			return transition(player1.wonPoint());
		} else
			return transition(player2.wonPoint());
	}

	private PointState transition(Player wonPointPlayer) {
		if (wonPointPlayer.equals(advanPlayer)) {
			advanPlayer = wonPointPlayer;
			return oddTransition(wonPointPlayer);
		} else

			return parTransition(wonPointPlayer);
	}

	private PointState oddTransition(Player wonPointPlayer) {
		if (wonPointPlayer.hasMorethan3Points())

			return new WonPointState(player1, player2);
		else

			return new oddPointState(player1, player2);
	}

	// TODO test for that class.
	private PointState parTransition(Player wonPointPlayer) {
		if (wonPointPlayer.isParWith(advanPlayer))
			// TODO new deuce state
			return new ParPointState(player1, player2);
		else
			return new DeucePointState(player1, player2);
		// else if(wonPointPlayer.isDeuceWith(advanPlayer))
		// //TODO new par state
		// return new DeucePointState(player1,player2);
		// else
		// //TODO new odd state
		// return new oddPointState(player1,player2);
		// }

	}
}
