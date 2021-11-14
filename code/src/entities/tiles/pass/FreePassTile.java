// Author: Dennis Yakovlev

package entities.tiles.pass;

import entities.player.Player;
import entities.tiles.tile.ActionStruct;
import entities.tiles.tile.Tile;

public class FreePassTile extends Tile {

    @Override
    public void onAction(ActionStruct info) {        
    }

    @Override
    public boolean canAddPlayer(Player player) {
        return false;
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
