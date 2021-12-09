package tests.entities.tiles.communitychest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.communitychest.MissTurn;
import application.backend.entities.tiles.tile.ActionStruct;

public class TestMissTurn {
	
	@Test public void testMiss() {
		
		MissTurn miss = new MissTurn();
		
		Player p = new Player();
		
		miss.onAction(new ActionStruct(null, p, null));
		
		assertEquals(true, miss.isHeldBack(p));
		
	}
	
}
