package controllers.move;

import entities.player.Player;

public class MoveAddException extends Exception {
    
    /**
     * Invalid combination of player and (or) turn number.
     * 
     * @param i turn number
     * @param player {@link Player}
     */
    public MoveAddException(int i, Player player) {
        super("Invalid combination of " + i + " " + player.toString());
    }

    /**
     * Invalid number of players.
     * 
     * @param i number of players
     */
    public MoveAddException(int i) {
        super("Invalid number of players " + i);
    }

}
