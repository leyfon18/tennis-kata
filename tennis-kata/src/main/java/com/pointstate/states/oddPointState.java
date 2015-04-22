package com.pointstate.states;

import com.games.Player;

public class oddPointState extends PointState {

	public oddPointState(Player wonPointPlayer, Player otherPlayer) {
		super(wonPointPlayer, otherPlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String calculateScoreName(Player wonPointPlayer,
			Player otherPlayer) {
		return wonPointPlayer.getName()+"-"+otherPlayer.getName();
	}

	@Override
	public PointState handleTransition(Player wonPointPlayer, Player otherPlayer) {
		if(wonPointPlayer.equals(otherPlayer))
			return new ParPointState(wonPointPlayer, otherPlayer);
		return new oddPointState(wonPointPlayer, otherPlayer);
	}
	

}
