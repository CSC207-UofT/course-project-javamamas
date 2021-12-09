package tests.controllers.move;

import org.junit.jupiter.api.Test;

import application.backend.controllers.move.MoveController;
import application.backend.entities.player.Player;

public class TestMoveAddException {
	
	@Test public void testAddException() {
		
		MoveController controller = new MoveController();
		
		controller.addPlayer(1, new Player());
		
	}
	
}
