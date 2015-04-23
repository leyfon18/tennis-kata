import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.games.Player;
import com.pointstate.states.OddPointState;
import com.pointstate.states.ParPointState;
import com.pointstate.states.PointState;


public class ParPointStateTest {
	String player1Name= "Leyfon18";
	String player2Name = "Duaobin";
	Player player1 = new Player(player1Name);
	Player player2 = new Player(player2Name);
	ParPointState currentstate;
	

	@Test
	public void ParState_To_oddState(){
		/*
		 * par            
		 * score 1-1 
		 */
		player1.wonPoint();
		player2.wonPoint();
		currentstate = new ParPointState(player1, player2);
		
		/*
		 * odd
		 * score 2-1
		 */
		PointState newState = currentstate.handleTransition(player2Name);

		assertTrue(newState instanceof OddPointState);	
	}
	
	

}
