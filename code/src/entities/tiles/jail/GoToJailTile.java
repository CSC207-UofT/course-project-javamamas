package entities.tiles.jail;

import entities.tiles.tile.ActionStruct;
import entities.player.Player;
import entities.tiles.tile.Tile;

public class GoToJailTile extends Tile {

    public GoToJailTile(String tile_name) {}

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
