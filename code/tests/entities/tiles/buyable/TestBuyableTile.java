package tests.entities.tiles.buyable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.buyable.BuyableTile;

public class TestBuyableTile {
	
	public BuyableTile buyable;
	public Player p;
	
	@BeforeEach public void before() {
		
		buyable = new BuyableTile(500, "Name");
		p = new Player();
		
	}
	
	@Test public void testSetOwner() {
		
		assertEquals(true, buyable.canSetOwner(p));
		
	}
	
	@Test public void testRemovesOwner() {
		
		buyable.setOwner(p);
		assertEquals(true, buyable.canRemoveOwner());
		
	}
	
}
