package com.pointstate.states;

import com.games.Player;

public class oddPointState extends PointState {

	public oddPointState(Player player1,Player player2) {
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
		}else
			return transition(player2.wonPoint());
	}

	private PointState transition(Player wonPointPlayer) {
		if(wonPointPlayer.equals(advanPlayer)){
			advanPlayer = wonPointPlayer;
			return oddTransition(wonPointPlayer);
		}
		else
			//TODO partrantition
			return parTransition(wonPointPlayer);		
	}
	private PointState oddTransition(Player wonPointPlayer){
		if(wonPointPlayer.hasMorethan3Points())
			//TODO new won state
			return new WonPointState(player1,player2);
		else
			//TODO new odd state
			return new oddPointState(player1,player2);
	}
	private PointState parTransition(Player wonPointPlayer){
		if(wonPointPlayer.isParWith(advanPlayer))
			//TODO new deuce state
			return new ParPointState(player1,player2);
		else
			//TODO new par state
			return new DeucePointState(player1,player2);
	}
	

//			
//		return null;
//	}
	
//
//	@Override
//	public PointState handleTransition(String wonPlayerName) {
//		if (this.getPlayer1().hasName(wonPlayerName)) 
//			return nextTransition(this.getPlayer1().wonPoint(),this.getPlayer2());
//		else
//			return nextTransition(this.getPlayer1(),this.getPlayer2().wonPoint());
//	}
//	
//	private PointState nextTransition(Player player1temp,
//			Player player2temp){
//		
//		if (player1temp.getScore().equals(player2temp.getScore()))
//				return new ParPointState(player1temp, player2temp);
//		else if(player1temp.getScore().beats(player2temp.getScore()))
//			return new ParPointState(player1temp, player2temp);
//		else 
//		return new oddPointState(player1temp,player2temp);
//	
//	}
		
	}

