package com.pointstate.states;

import com.games.Player;

public class DeucePointState extends PointState{

	protected DeucePointState(Player p1, Player p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String calculateScoreName() {
		// TODO Auto-generated method stub
		return "Deuce";
	}

	@Override
	public PointState handleTransition(String wonPointPlayerName) {
		if (player1.hasName(wonPointPlayerName)) {
			 player1.wonPoint();
		}else
			 player2.wonPoint();		
		return new AdvantagePointState(player1,player2);
	}
	

}
