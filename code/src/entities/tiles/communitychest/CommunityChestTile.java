package entities.tiles.communitychest;

import entities.tiles.tile.ActionStruct;
import entities.player.Player;
import entities.tiles.tile.Tile;

// Author: Shivanshi

public class CommunityChestTile extends Tile {

    @Override
    public void onAction(ActionStruct info) {        
    }

    @Override
    public boolean canAddPlayer(Player player) {
        return false;
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
