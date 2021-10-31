package use_cases.propertychecker;

import entities.bank.Bank;
import entities.player.Player;
import entities.tiles.tile.Tile;

public class PropertyChecker {
    
    /**
     * Do player and tile state allow for purchase of this tile?
     * 
     * @param player {@link Player}
     * @param tile {@link Tile}
     * @param bank {@link Bank}
     * @return true if conditions met, false otherwise
     */
    public boolean canBuy(Player player, Tile tile, Bank bank) {
        
        return true;

    }

}
