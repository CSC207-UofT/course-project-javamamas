package tests.use_cases.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.start.StartTile;
import application.backend.use_cases.board.Board;

public class TestBoard {
	
	public Board board;
	
	@BeforeEach public void before() {
		
		board = new Board();
		board.create_board();
		
	}
	
	@Test public void testGetTile() {
		
		assertEquals(true, board.getTileAtPosition(1) instanceof StartTile);
		
	}
	
	@Test public void testPlayerPos() {
		
		Player p = new Player();
		board.setPlayerPosition(p, 1);
		assertEquals(true, board.getPlayerPosition(p) == 1);
		
	}
	
}
