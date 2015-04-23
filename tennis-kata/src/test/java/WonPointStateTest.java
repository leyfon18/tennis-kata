import static org.junit.Assert.*;

import org.junit.Test;

import com.games.Player;
import com.pointstate.states.PointState;
import com.pointstate.states.WonPointState;


public class WonPointStateTest {

	String player1Name= "Leyfon18";
	String player2Name = "Duaobin";
	Player player1 = new Player(player1Name);
	Player player2 = new Player(player2Name);
	WonPointState currentstate;
	

	@Test
	public void WonPointStateMaintain(){
		/*
		 * Win            
		 * score 5-3
		 */
		for (int i = 0; i < 3; i++) {
			player1.wonPoint();
			player2.wonPoint();
		}
		player1.wonPoint();
		player1.wonPoint();
		currentstate = new WonPointState(player1, player2);
		
		/*
		 * Won state must be maintained
		 */
		PointState newState = currentstate.handleTransition(player2Name);

		assertTrue(newState instanceof WonPointState);	
		assertEquals(currentstate,newState);
	}
}
