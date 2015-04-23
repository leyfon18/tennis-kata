import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.games.Player;
import com.pointstate.states.DeucePointState;
import com.pointstate.states.OddPointState;
import com.pointstate.states.ParPointState;
import com.pointstate.states.PointState;
import com.pointstate.states.WonPointState;

public class OddPointStateTest {
	String player1Name= "Leyfon18";
	String player2Name = "Duaobin";
	Player player1 = new Player(player1Name);
	Player player2 = new Player(player2Name);
	OddPointState currentstate;
	
	@Test
	public void oddState_To_oddStateADVCase(){
		/*
		 * odd            
		 * score 1-0  
		 */
		player1.wonPoint();
		currentstate = new OddPointState(player1, player2);
		
		/*
		 * odd
		 * score 2-0
		 */
		PointState newState = currentstate.handleTransition(player1Name);
		
		assertTrue(newState instanceof OddPointState);	
	}
	
	@Test
	public void oddState_To_oddStateNoADVCase(){
		/*
		 * odd            
		 * score 2-0  
		 */
		player1.wonPoint();
		player1.wonPoint();
		currentstate = new OddPointState(player1, player2);
		
		/*
		 * odd
		 * score 2-1
		 */
		PointState newState = currentstate.handleTransition(player2Name);
		
		assertTrue(newState instanceof OddPointState);	
	}
	
	@Test
	public void oddState_To_deuceState(){
		/*
		 * odd            
		 * score 3-2
		 */
		player1.wonPoint();
		player1.wonPoint();
		player1.wonPoint();
		player2.wonPoint();
		player2.wonPoint();
		currentstate = new OddPointState(player1, player2);
		
		/*
		 * deuce
		 * score 3-3
		 */
		PointState newState = currentstate.handleTransition(player2Name);
		
		assertTrue(newState instanceof DeucePointState);	
	}
	
	@Test
	public void oddState_To_parState(){
		/*
		 * odd            
		 * score 1-0
		 */
		player1.wonPoint();
		currentstate = new OddPointState(player1, player2);
		
		/*
		 * par
		 * score 1-1
		 */
		PointState newState = currentstate.handleTransition(player2Name);
		
		assertTrue(newState instanceof ParPointState);	
	}
	
	@Test
	public void oddState_To_WonState(){
		/*
		 * odd            
		 * score 3-2
		 */
		player1.wonPoint();
		player1.wonPoint();
		player1.wonPoint();
		player2.wonPoint();
		player2.wonPoint();
		currentstate = new OddPointState(player1, player2);
		
		/*
		 * win
		 * score 4-2
		 */
		PointState newState = currentstate.handleTransition(player1Name);
		
		assertTrue(newState instanceof WonPointState);	
	}
	
	@Ignore
	@Test
	public void NoInRequirementState(){
		/*
		 * odd            
		 * score 3-3
		 */
		player1.wonPoint();
		player1.wonPoint();
		player1.wonPoint();
		player2.wonPoint();
		player2.wonPoint();
		player2.wonPoint();
		currentstate = new OddPointState(player1, player2);
		
		/*
		 * Advantage
		 * score 4-3
		 */
		PointState newState = currentstate.handleTransition(player1Name);
		
		assertTrue(newState instanceof WonPointState);	
	}
}
