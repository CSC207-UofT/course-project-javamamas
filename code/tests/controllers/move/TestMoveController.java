package tests.controllers.move;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.backend.controllers.move.MoveController;
import application.backend.entities.player.Player;

public class TestMoveController {

	public MoveController controller;
	
	@BeforeEach public void before() {
	
		controller = new MoveController();
		
		controller.setNumPlayers(2);

		Player p1 = new Player();
		p1.setBalance(500);
		p1.setName("a");
		
		Player p2 = new Player();
		p2.setBalance(500);
		p2.setName("b");
		
		controller.addPlayer(1, p1);
		controller.addPlayer(2, p2);
		
	}
	
	@Test public void testMoveA() {
		
		controller.goTurn(4);
		assertEquals(1, controller.getCurrPlayerPos());
		
	}
	
	@Test public void testMoveB() {
		
		controller.goTurn(3);
		assertEquals(4, controller.getPrevPlayerPos());
		
	}

}
