package use_cases.gamestatus;

import java.util.ArrayList;
import java.util.Collection;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;

public class GameStatus {
    
    /**
     * 
     * @param remainingTiles
     * @return true if all buyables have been bought 
     */
    public boolean isAllBought(ArrayList<BuyableTile> remainingTiles) {
    
        return (remainingTiles.size() == 0);

    }

    /**
     * 
     * @param players
     * @return true if all the players are broke
     */
    public boolean isAllBroke(Collection<Player> players) {
        
        for (Player p : players) {
            if (p.getBalance() != 0) {
                return false;
            }
        }
        return true;

    }

    public boolean gameStatus(Collection<Player> players, ArrayList<BuyableTile> remainingTiles){
        if (isAllBroke(players)){
            return true;
        }
        else if (isAllBought(remainingTiles)){
            return true;
        }
        else{
            return false;
        }
    }



}
