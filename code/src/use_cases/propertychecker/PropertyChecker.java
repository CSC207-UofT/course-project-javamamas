package use_cases.propertychecker;

import entities.bank.Bank;
import entities.player.Player;
import entities.tiles.buyable.BuyableTile;
import entities.tiles.tile.Tile;

import java.util.Collection;

public class PropertyChecker {
    
    /**
     * Do player and tile state allow for purchase of this tile?
     * 
     * @param player {@link Player}
     * @param tile {@link Tile}
     * @param bank {@link Bank}
     * @param remainingTiles A list of remaining tiles {@link BuyableTile}
     * @return true if conditions met, false otherwise
     */
    public boolean canBuy(Player player, Tile tile, Bank bank, Collection<BuyableTile> remainingTiles) {
        
        if (remainingTiles.contains(tile) && tile instanceof BuyableTile){
            return (player.getBalance() >= ((BuyableTile)tile).getPrice());
        }
        return false;

    }

}
