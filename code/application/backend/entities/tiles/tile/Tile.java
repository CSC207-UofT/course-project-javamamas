package application.backend.entities.tiles.tile;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import application.backend.entities.player.Player;

public abstract class Tile {

    String tile_name;

    public Tile(String tile_name) {
        this.tile_name = tile_name;
    }

    private Set<Player> players; // all players currently on the tile

    public Tile() {

        players = new HashSet<>();

    }

    /**
     * 
     * @param args Neccessary arguments to complete method.
     */
    public abstract void onAction(ActionStruct info);

    /**
     *
     * @param player {@link Player}
     * @return true if player can be removed
     */
    public abstract boolean canRemovePlayer(Player player);

    /**
     * Add player.
     *
     * @param player {@link Player}
     */
    public abstract void addPlayer(Player player);

    /**
     * remove player.
     *
     * TODO: catch exception if player cannot be removed
     *
     * @param player {@link Player}
     */

    public abstract void removePlayer(Player player);

    /**
     *
     * @return all players.
     */
    public Collection<Player> getPlayers() {
        return this.players;
    }

}
