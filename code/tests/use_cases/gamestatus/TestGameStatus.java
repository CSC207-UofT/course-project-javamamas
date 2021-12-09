package tests.use_cases.gamestatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.backend.entities.tiles.buyable.BuyableTile;
import application.backend.use_cases.gamestatus.GameStatus;

public class TestGameStatus {
	
	@Test public void testIsAllBought() {
		
		ArrayList<BuyableTile> tiles = new ArrayList<>();
		tiles.add(new BuyableTile(250, "Name"));
		
		assertEquals(false, new GameStatus().isAllBought(tiles));
		
	}
	
}
