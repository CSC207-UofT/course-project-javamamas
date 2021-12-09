package tests.entities.tiles.pass;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.pass.FreePassTile;

public class TestFreePassTile {
	
	@Test public void testCanRemove() {
		
		assertEquals(false, new FreePassTile("Name").canRemovePlayer(new Player()));
		
	}
	
}
