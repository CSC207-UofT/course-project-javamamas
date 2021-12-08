package application.backend.entities.tiles.communitychest;

import java.util.ArrayList;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.tile.ActionStruct;

/**
 * Card to make player miss turn.
 */
public class MissTurn extends Card {

    private ArrayList<Player> heldBack;

    public MissTurn() {
        heldBack = new ArrayList<>();
    }

    @Override
    public void onAction(ActionStruct action) {
        if (heldBack.contains(action.currPlayer)) { // if already in heldBack, remove
            heldBack.remove(action.currPlayer);
            return;
        }

        heldBack.add(action.currPlayer); // add player otherwise
    }
    
    /**
     * Whether the player is held back (true) or not.
     */
    public boolean isHeldBack(Player player) {
        return heldBack.contains(player);
    }

}
