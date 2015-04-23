package com.pointstate.states;

import com.games.Player;

public class WonPointState extends PointState {
	public WonPointState(Player p1, Player p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String calculateScoreName() {
		// TODO Auto-generated method stub
		return "Win for " + this.advanPlayer.getName();
	}

	@Override
	public PointState handleTransition(String wonPointPlayerName) {
		// TODO Auto-generated method stub
		return this;
	}

}
