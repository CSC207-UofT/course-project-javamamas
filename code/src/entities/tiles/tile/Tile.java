// Author: Dennis Yakovlev

package entities.tiles.tile;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entities.player.Player;

public abstract class Tile {
    String tile_name;

    public Tile() {}

    public Tile(String tile_name) {
        this.tile_name = tile_name;
    }

    private Set<Player> players; // all players currently on the tile

    public Tile() {

        players = new HashSet<>();

    }

    /**
     * 
     * @param <Args> Some types.
     * @param args Neccessary arguments to complete method.
     */
    public abstract void onAction(ActionStruct info);

    /**
     * 
     * @return all players.
     */
    public Collection<Player> getPlayers() {
        return this.players;
    }

}
