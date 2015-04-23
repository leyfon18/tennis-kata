import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.games.Player;
import com.pointstate.states.AdvantagePointState;
import com.pointstate.states.DeucePointState;
import com.pointstate.states.PointState;
import com.pointstate.states.WonPointState;


public class AdvantagePointStateTest {

	String player1Name= "Leyfon18";
	String player2Name = "Duaobin";
	Player player1 = new Player(player1Name);
	Player player2 = new Player(player2Name);
	AdvantagePointState currentstate;
	

	@Test
	public void AdvantageState_To_DeuceState(){
		/*
		 * Advantage            
		 * score 4-3
		 */
		for (int i = 0; i < 3; i++) {
			player1.wonPoint();
			player2.wonPoint();
		}
		player1.wonPoint();
		currentstate = new AdvantagePointState(player1, player2);
		
		/*
		 * Deuce
		 * score 4-4
		 */
		PointState newState = currentstate.handleTransition(player2Name);

		assertTrue(newState instanceof DeucePointState);	
	}
	
	@Test
	public void AdvantageState_To_WonState(){
		/*
		 * par            
		 * score 4-3
		 */
		for (int i = 0; i < 3; i++) {
			player1.wonPoint();
			player2.wonPoint();
		}
		player1.wonPoint();
		currentstate = new AdvantagePointState(player1, player2);
		
		/*
		 * odd
		 * score 5-3
		 */
		PointState newState = currentstate.handleTransition(player1Name);

		assertTrue(newState instanceof WonPointState);	
	}
	
}
