package application.backend.entities.tiles.prison;

import application.backend.entities.tiles.tile.ActionStruct;

import java.util.HashMap;
import java.util.Map;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.tile.Tile;

public class PrisonTile extends Tile {

    private Map<Player, Integer> numJailed;

    public PrisonTile(String tile_name) {

        numJailed = new HashMap<>();

    }

    @Override
    public void onAction(ActionStruct info) {
        numJailed.put(info.currPlayer, numJailed.get(info.currPlayer) + 1); // add that player has sat a turn
    }

    @Override
    public void addPlayer(Player player) {
        numJailed.put(player, 0);
    }

    @Override
    public boolean canRemovePlayer(Player player) {        
        return numJailed.get(player) >= 3;
    }

    @Override
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);
    }

}
