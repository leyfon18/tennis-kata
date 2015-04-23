package com.pointstate.states;

import com.games.Player;

public class OddPointState extends PointState {

	public OddPointState(Player player1, Player player2) {
		super(player1, player2);

	}

	@Override
	protected String calculateScoreName() {
		return this.getPlayer1().getScore().asWord() + "-"
				+ this.getPlayer2().getScore().asWord();
	}

	@Override
	public PointState handleTransition(String wonPointPlayerName) {
		Player player = playerWithName(wonPointPlayerName);
		player.wonPoint();
		return transition(player);
//		if (player1.hasName(wonPointPlayerName)) {
//			player1.wonPoint();
//			return transition(player1);
//		} else{
//			player2.wonPoint();
//			return transition(player2);
//			}
	}

	private PointState transition(Player wonPointPlayer) {
		if (wonPointPlayer.equals(advanPlayer)) {
			advanPlayer = wonPointPlayer;
			return oddTransition(wonPointPlayer);
		} else {
			return chooseOddOrParTransition(wonPointPlayer);
		}
	}

	private PointState oddTransition(Player wonPointPlayer) {
		if (wonPointPlayer.hasMorethan3Points())

			return new WonPointState(player1, player2);
		else

			return new OddPointState(player1, player2);
	}

	// TODO test for that class.
	private PointState chooseOddOrParTransition(Player wonPointPlayer) {
		if (wonPointPlayer.isParWith(advanPlayer))

			return new ParPointState(player1, player2);
		else if (wonPointPlayer.isDeuceWith(advanPlayer))

			return new DeucePointState(player1, player2);
		else
			return new OddPointState(player1, player2);
	}

}
