package application.backend.entities.tiles.communitychest;

import application.backend.entities.tiles.tile.ActionStruct;
import application.backend.entities.tiles.tile.Tile;

/**
 * Card to randomly move player somewhere.
 */
public class MoveRandom extends Card {

    @Override
    public void onAction(ActionStruct action) {
        
        action.board.getTileAtPosition(action.board.getPlayerPosition(action.currPlayer)).removePlayer(action.currPlayer); // remove player from current tile
        int newPosNum = (int)(Math.random() * 40) + 1;
        action.board.setPlayerPosition(action.currPlayer, newPosNum);
        Tile newPos = action.board.getTileAtPosition(newPosNum);
        newPos.addPlayer(action.currPlayer);

    }
    
}
