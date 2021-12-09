package tests.entities.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.bank.Bank;
import application.backend.entities.player.Player;
import application.backend.entities.tiles.buyable.BuyableTile;
import application.backend.use_cases.board.Board;

public class TestBank {
	
	@Test public void testA() {
		
		Board board = new Board();
		board.create_board();
		
		Player p = new Player();
		p.setBalance(500);
		
		assertEquals(true, new Bank(board).checkAcceptance(p, (BuyableTile) board.getTileAtPosition(2)));
		
	}
	
}
