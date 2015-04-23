package com.pointstate.states;

import com.games.Player;

public  abstract class PointState {
	protected Player player1;
	protected Player player2;
	protected Player advanPlayer;
	/**
	 * @return the player1
	 */
	public Player getPlayer1() {
		return player1;
	}
	/**
	 * @return the player2
	 */
	public Player getPlayer2() {
		return player2;
	}
	private final String scoreStateName;
	protected PointState(Player p1,Player p2){
		player1 = p1;
		player2 = p2;
		advanPlayer =  morePointsPlayer();
		scoreStateName = calculateScoreName();
	}
	abstract protected String calculateScoreName() ;
	abstract public PointState handleTransition(String wonPointPlayerName);
	 public String getStateName(){
		return scoreStateName;
	}
	
	public Player morePointsPlayer(){
		if(player1.hasMorePoints(player2))
			return player1;
		else
			return player2;
	}
	
	
}
