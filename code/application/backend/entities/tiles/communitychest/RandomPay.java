package application.backend.entities.tiles.communitychest;

import application.backend.entities.tiles.tile.ActionStruct;

/**
 * Card to pay player randomly.
 */
public class RandomPay extends Card {

    @Override
    public void onAction(ActionStruct action) {
        
        action.currPlayer.setBalance(action.currPlayer.getBalance() + (int)(Math.random() * 250 * (Math.random() > 0.5 ? -1 : 1)));

    }
    
}
