package tests.entities.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;

public class TestPlayer {
	
	public Player p;
	
	@BeforeEach public void before() {
		
		p = new Player();
		p.setName("Name");
		
	}
	
	@Test public void testInitialized() {
		
		assertEquals(false, p.initialized());
		
	}

	@Test public void testGetName() {
		
		assertEquals("Name", p.getName());
		
	}
	
	
}
