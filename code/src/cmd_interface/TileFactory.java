package cmd_interface;

import java.util.ArrayList;

import entities.tiles.buyable.BuyableTile;
import entities.tiles.communitychest.CommunityChestTile;
import entities.tiles.pass.FreePassTile;
import entities.tiles.prison.PrisionTile;
import entities.tiles.start.StartTile;
import entities.tiles.tile.Tile;

public class TileFactory {
    
    public static ArrayList<Tile> setUp() {

        ArrayList<Tile> tiles = new ArrayList<>();

        tiles.add(new StartTile());

        tiles.add(new BuyableTile(1));
        tiles.add(new CommunityChestTile());
        tiles.add(new BuyableTile(2));
        tiles.add(new FreePassTile());
        tiles.add(new FreePassTile());
        tiles.add(new BuyableTile(3));
        tiles.add(new CommunityChestTile());
        tiles.add(new BuyableTile(4));
        tiles.add(new BuyableTile(5));

        tiles.add(new PrisionTile());

        tiles.add(new BuyableTile(6));
        tiles.add(new FreePassTile());
        tiles.add(new BuyableTile(7));
        tiles.add(new BuyableTile(8));
        tiles.add(new CommunityChestTile());
        tiles.add(new BuyableTile(9));
        tiles.add(new FreePassTile());
        tiles.add(new BuyableTile(10));
        tiles.add(new BuyableTile(11));


        return tiles;

    }

}
