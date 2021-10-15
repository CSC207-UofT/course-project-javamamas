package controllers;

import java.util.HashMap;
import java.util.Map;

import entities.player.Player;

public class MoveController {
    

    private Map<Integer, Player> turns;
    private int numPlayers; // number of players

    public MoveController(int numPlayers) {

        this.numPlayers = numPlayers; // TODO: check that numPlayers input is valid
        turns = new HashMap<Integer,Player>();

    }

    /**
     * Check whether turn is valid.
     * 
     * @param i turn position to attempt add
     * @return true if possible to add, false if otherwise
     */
    public boolean isValidTurn(int i) {

        return i > 0 || i <= this.numPlayers ? true : false;

    }

    /**
     * Whether turn can be added.
     * @param i
     * @return
     */
    public boolean canAddTurn(int i) {

        return !turns.containsKey(i);

    }

    // TODO: throw exception instead of returning bool
    // See player for example
    /**
     * Add a player with their corresponding turn position.
     * 
     * @param i turn position
     * @param player {@link Player}
     * @return return true if added, false otherwise
     */
    public boolean addPlayer(int i, Player player) {

        if (isValidTurn(i) && canAddTurn(i) && player.initializedPlayer()) {
            turns.put(i, player);
        }

        return false;

    }

}
