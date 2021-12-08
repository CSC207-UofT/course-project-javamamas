// Author: Dennis Yakovlev

package application.backend.entities.tiles.pass;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.tile.ActionStruct;
import application.backend.entities.tiles.tile.Tile;

public class FreePassTile extends Tile {

    public FreePassTile(String tile_name) {}

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
