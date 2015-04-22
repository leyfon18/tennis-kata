package com.pointstate.states;

import com.games.Player;

public  abstract class PointState {
	private final String scoreStateName;
	public PointState(Player wonPointPlayer, Player otherPlayer){
		wonPointPlayer.getScore();
		scoreStateName = calculateScoreName(wonPointPlayer,otherPlayer);
	}
	abstract protected String calculateScoreName(Player wonPointPlayer, Player otherPlayer) ;
	abstract public PointState handleTransition(Player wonPointPlayer, Player otherPlayer);
	 public String getStateName(){
		return scoreStateName;
	}
	 
	
	
}
