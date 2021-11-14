package entities.tiles.prison;

import entities.tiles.tile.ActionStruct;
import entities.player.Player;
import entities.tiles.tile.Tile;

public class PrisonTile extends Tile {

    public PrisonTile(String tile_name) {}

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
