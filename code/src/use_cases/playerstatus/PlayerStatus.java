// Author: Yusra Fayyaz

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
    public boolean checkPlayer(Player player) {
        return player.balance != 0;
    }

    /**
     * 
     * @param player {@link Player}
     * @param bank {@link Bank}
     * @param tiles {@link Tile}
     * @return a players networth, -1 is cannot check players networth
     */
    public int playerValue(Player player) {
        networth = 0;
        for (property in player.properties) {
            networth += property.getPrice();
        }
        return networth + player.balance;
    }

}
