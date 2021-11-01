package use_cases.gamestatus;

import java.util.Collection;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;

public class GameStatus {
    
    /**
     * 
     * @param tiles
     * @return true if all buyables have been bought 
     */
    public boolean isAllBought(Collection<BuyableTile> tiles) {
    
        return true;

    }

    /**
     * 
     * @param players
     * @return true if all the players are broke
     */
    public boolean isAllBroke(Collection<Player> players) {
        
        return true;

    }




}
