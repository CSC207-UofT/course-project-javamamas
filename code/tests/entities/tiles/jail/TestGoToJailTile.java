package tests.entities.tiles.jail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.jail.GoToJailTile;

public class TestGoToJailTile {
	
	@Test public void testCanRemove() {
		
		assertEquals(true, new GoToJailTile("Name").canRemovePlayer(new Player()));
		
	}
	
}
