package com.games;

import com.pointstate.states.ParPointState;
import com.pointstate.states.PointState;

public class TennisGameInState implements TennisGame {
	private PointState currentState;


	public TennisGameInState(String p1, String p2) {
		
		currentState = new ParPointState(new Player(p1),new Player (p2));
	}

	public void wonPoint(String playerName) {
		currentState = currentState.handleTransition(playerName);
	}

	public String getScore() {
		return currentState.getStateName();
	}
		
}
