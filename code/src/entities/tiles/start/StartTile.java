package entities.tiles.start;

import entities.player.Player;
import entities.tiles.tile.ActionStruct;
import entities.tiles.tile.Tile;

// Author: Shivanshi

public class StartTile extends Tile {

    public StartTile(String tile_name) {}

    /**
     * When a player passes this Tile, 200 is added to their balance.
     *
     * @param info variables obtained from ActionStruct needed for the action.
     */
    @Override
    public void onAction(ActionStruct info) {
        info.currPlayer.setBalance(info.currPlayer.getBalance() + 200);
    }

    public void addPlayer(Player player) {
        this.getPlayers().add(player);
    }

    @Override
    public boolean canRemovePlayer(Player player) {
        return true;
    }

    @Override
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);
    }
    
}
