package tests.use_cases.playerstatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.use_cases.playerstatus.PlayerStatus;

public class TestPlayerStatus {
	
	@Test public void testPlayablePlayer() {
		
		Player p = new Player();
		p.setBalance(0);
		
		assertEquals(false, new PlayerStatus().checkPlayer(p));
		
	}
	
}
