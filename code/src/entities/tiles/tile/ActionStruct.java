// Author: Dennis Yakovlev

package entities.tiles.tile;

import entities.bank.Bank;
import entities.player.Player;

/**
 * OnAction information to be passed
 */
public class ActionStruct {
    
    public Bank bank;
    public Player currPlayer;

    public ActionStruct(Bank bank, Player currPlayer) {
        this.bank = bank;
        this.currPlayer = currPlayer;
    }

}
