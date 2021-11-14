package entities.tiles.jail;

import entities.tiles.tile.ActionStruct;
import entities.player.Player;
import entities.tiles.tile.Tile;

public class GoToJailTile extends Tile {

    public GoToJailTile(String tile_name) {}

    @Override
    public void onAction(ActionStruct info) {
        info.board.setPlayerPosition(info.currPlayer, 11);
        Tile prison_tile = info.board.getTileAtPosition(11);
        prison_tile.addPlayer(info.currPlayer);
    }

    @Override
    public void addPlayer(Player player) {
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
