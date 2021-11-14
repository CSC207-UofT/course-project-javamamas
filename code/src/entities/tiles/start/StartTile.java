package entities.tiles.start;

import entities.player.Player;
import entities.tiles.tile.ActionStruct;
import entities.tiles.tile.Tile;

public class StartTile extends Tile {

    public StartTile(String tile_name) {}

    @Override
    public void onAction(ActionStruct info) {
    }

    @Override
    public void addPlayer(Player player) {
    }

    @Override
    public boolean canRemovePlayer(Player player) {
        return false;
    }

    @Override
    public void removePlayer(Player player) {
    }
    
}
