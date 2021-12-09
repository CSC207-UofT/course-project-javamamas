package tests.use_cases.propertychecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.use_cases.board.Board;
import application.backend.use_cases.propertychecker.PropertyChecker;

public class TestPropertyChecker {
	
	@Test public void testPrice() {
		
		Board b = new Board();
		b.create_board();
		
		assertEquals(280, new PropertyChecker().tilePrice(2, b));
		
	}
	
}
