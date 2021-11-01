// Author: Yusra

package use_cases.playerstatus;

import java.util.Collection;

import entities.bank.Bank;
import entities.player.Player;
import entities.tiles.tile.Tile;

public class PlayerStatus {
    
    /**
     * Is player in playable state?
     * 
     * @param player {@link Player}
     * @param bank {@link Bank}
     * @return true if conditions met, false otherwise
     */
    public boolean isPlayerPlayable(Player player, Bank bank) {

        return true;

    }

    /**
     * 
     * @param player {@link Player}
     * @param bank {@link Bank}
     * @param tiles {@link Tile}
     * @return a players networth, -1 is cannot check players networth
     */
    public int playerValue(Player player, Bank bank, Collection<Tile> tiles) {

        return 0;

    }

}
