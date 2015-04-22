package com.pointstate.states;

import com.games.Player;

public class ParPointState extends PointState {
	
	
public ParPointState(Player wonPointPlayer, Player otherPlayer) {
		super(wonPointPlayer, otherPlayer);
	}
	public PointState handleTransition(Player wonPointPlayer, Player otherPlayer) {
		return new oddPointState( wonPointPlayer, otherPlayer);
	}

	@Override
	protected String calculateScoreName(Player wonPointPlayer,Player otherPlayer) {
		return wonPointPlayer.getName() + "-All";
	}

}
