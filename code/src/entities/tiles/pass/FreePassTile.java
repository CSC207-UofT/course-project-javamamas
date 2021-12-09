// Author: Dennis Yakovlev

package entities.tiles.pass;

import entities.player.Player;
import entities.tiles.tile.ActionStruct;
import entities.tiles.tile.Tile;

public class FreePassTile extends Tile {

    public FreePassTile(String tile_name) {}

    /**
     * This is a resting tile. Nothing will happen to players on this tile.
     *
     * @param info variables obtained from ActionStruct needed for the action.
     */
    @Override
    public void onAction(ActionStruct info) {        
    }

    @Override
    public boolean canRemovePlayer(Player player) {
        return false;
    }

    @Override
    public void addPlayer(Player player) {        
    }

    @Override
    public void removePlayer(Player player) {        
    }
    
}
