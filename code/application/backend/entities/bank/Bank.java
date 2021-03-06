// Author: Yusra Fayyaz
package application.backend.entities.bank;

import java.util.ArrayList;
import java.util.HashMap;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.buyable.BuyableTile;
import application.backend.use_cases.board.Board;

/**
 * Bank class.
 * 
 * <p> Invariants </p>
 * <p>
 * - {@link #numPlayers} can only be set once
 * </p>
 */
public class Bank {
    
    HashMap<Player, Integer> balances; // balance of players
    int balance; // total balance in bank
    int numHouses; // number of houses in bank
    int numHotels; // number of hotels in bank
    ArrayList<BuyableTile> remainingTiles; // a list of the remaining tiles that are still in bank possession

    public Bank(Board board) {
        this.numHouses = 32;
        this.numHotels = 12;
        this.balance = 20580;
        this.remainingTiles = new ArrayList<>();
        for (int i = 0; i != 40; i++){
            if (board.getTileAtPosition(i) instanceof  BuyableTile) {
                remainingTiles.add((BuyableTile) board.getTileAtPosition(i));
            }
        }
    }

    /**
     * Check whether a player can buy a possible tile.
     * 
     * @param player player object
     * @param prospect buyable tile
     * @return true if can buy
     */
    public boolean checkAcceptance(Player player, BuyableTile prospect){
        return (player.getBalance() >= prospect.getPrice()) & (this.remainingTiles.contains(prospect));
    }

    /**
     * Sell a property to player.
     * 
     * @param player player object
     * @param prospect prospective tile
     */
    public void sellProperty(Player player, BuyableTile prospect){

        if (checkAcceptance(player, prospect)) {
            this.remainingTiles.remove(prospect);
            player.setBalance(player.getBalance() - prospect.getPrice());
            this.balance += prospect.getPrice();
            player.getHouses().put(prospect, 0);
        }

    }

}
