package application.backend.entities.tiles.communitychest;

import application.backend.entities.tiles.tile.ActionStruct;

public abstract class Card {
    
    public abstract void onAction(ActionStruct action);

}
