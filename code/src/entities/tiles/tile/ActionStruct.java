// Author: Dennis Yakovlev

package entities.tiles.tile;

import entities.bank.Bank;

/**
 * OnAction information to be passed
 */
public class ActionStruct {
    
    public Bank bank;

    public ActionStruct(Bank bank) {
        this.bank = bank;
    }

}
