package tests.entities.tiles.communitychest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.communitychest.RandomPay;
import application.backend.entities.tiles.tile.ActionStruct;

public class TestRandomPay {
	
	public Player p;
	
	@BeforeEach public void before() {
		
		p = new Player();
		p.setBalance(500);
		
	}
	
	@Test public void testRanomPayAmount() {
		
		int oldBalance = p.getBalance();
		new RandomPay().onAction(new ActionStruct(null, p, null));
		assertNotEquals(p.getBalance(), oldBalance);
		
	}
	
	@Test public void testRandomPayNeg() {
		
		new RandomPay().onAction(new ActionStruct(null, p, null));
		assertEquals(true, p.getBalance() >= 0 );
		
	}
	
}
