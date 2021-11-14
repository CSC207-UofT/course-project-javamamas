package entities.tiles.start;

import entities.player.Player;
import entities.tiles.tile.ActionStruct;
import entities.tiles.tile.Tile;

// Author: Shivanshi

public class StartTile extends Tile {

    public StartTile(String tile_name) {}

    @Override
    public void onAction(ActionStruct p) {
        p.currPlayer.setBalance(p.currPlayer.getBalance() + 200);
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
