// Author: Yusra Fayyaz

package application.backend.use_cases.playerstatus;

import application.backend.entities.bank.Bank;
import application.backend.entities.player.Player;
import application.backend.entities.tiles.buyable.BuyableTile;

public class PlayerStatus {
    
    /**
     * Is player in playable state?
     * 
     * @param player {@link Player}
     * @param bank {@link Bank}
     * @return true if conditions met, false otherwise
     */
    public boolean checkPlayer(Player player) {
        return player.getBalance() != 0;
    }

    /**
     * 
     *
     */
    public int playerValue(Player player) {
        int networth = 0;
        for (BuyableTile property : player.getHouses().keySet()) {
            networth += property.getPrice();
        }
        return networth + player.getBalance();
    }

}
