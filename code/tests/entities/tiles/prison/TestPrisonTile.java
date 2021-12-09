package tests.entities.tiles.prison;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.prison.PrisonTile;

public class TestPrisonTile {
	
	@Test public void testCanRemove() {
		
		assertEquals(false, new PrisonTile("Name").canRemovePlayer(new Player()));
		
	}
	
}
