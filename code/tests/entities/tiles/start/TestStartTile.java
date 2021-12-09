package tests.entities.tiles.start;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.start.StartTile;

public class TestStartTile {
	
	@Test public void testCanRemove() {
		
		assertEquals(true, new StartTile("Name").canRemovePlayer(new Player()));
		
	}
	
}
