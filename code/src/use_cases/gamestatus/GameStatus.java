package use_cases.gamestatus;

import java.util.Collection;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;

public class GameStatus {
    
    /**
     * Are all BuyableTile's owned by a player?
     *
     * @param remainingTiles Unique list of {@link BuyableTile}
     * @return true if condition is met.
     */
    public boolean isAllBought(Collection<BuyableTile> remainingTiles) {
    
        return (remainingTiles.size() == 0);

    }

    /**
     * 
     * @param players Unique list of {@link Player}
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

    /**
     * Checks possible game ending scenarios - All BuyableTiles are owned or all players are bankrupt.
     * 
     * @param players Unique list of {@link Player}
     * @param remainingTiles Unique list of {@link BuyableTile}
     * @return true iff all the tiles are bought and none of the players too poor to play.
     */
    public boolean gameStatus(Collection<Player> players, Collection<BuyableTile> remainingTiles){
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
