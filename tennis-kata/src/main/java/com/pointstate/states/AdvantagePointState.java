package com.pointstate.states;

import com.games.Player;

public class AdvantagePointState extends PointState {

	protected AdvantagePointState(Player p1, Player p2) {
		super(p1, p2);
	}

	@Override
	protected String calculateScoreName() {
		return "Advantage " + this.advanPlayer.getName();
	}

	@Override
	public PointState handleTransition(String wonPointPlayerName) {
		if (player1.hasName(wonPointPlayerName)) {
			return transition(player1.wonPoint());
		} else
			return transition(player2.wonPoint());
	}

	private PointState transition(Player wonPointPlayer) {
		if (wonPointPlayer.equals(advanPlayer))
			// TODO oddtransition
			return new WonPointState(player1, player2);
		else
			// TODO partrantition
			return new DeucePointState(player1, player2);
	}

}
