import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.games.Player;
import com.pointstate.states.AdvantagePointState;
import com.pointstate.states.DeucePointState;
import com.pointstate.states.ParPointState;
import com.pointstate.states.PointState;


public class DeucePointStateTest {
	String player1Name= "Leyfon18";
	String player2Name = "Duaobin";
	Player player1 = new Player(player1Name);
	Player player2 = new Player(player2Name);
	DeucePointState currentstate;
	

	@Test
	public void DeuceState_To_AdvantageState(){
		/*
		 * par            
		 * score 3-3
		 */
		for (int i = 0; i < 3; i++) {
			player1.wonPoint();
			player2.wonPoint();
		}
		currentstate = new DeucePointState(player1, player2);
		
		/*
		 * odd
		 * score 4-3
		 */
		PointState newState = currentstate.handleTransition(player1Name);

		assertTrue(newState instanceof AdvantagePointState);	
	}
	
	

}