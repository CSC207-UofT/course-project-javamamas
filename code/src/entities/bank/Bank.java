// Author: Yusra Fayyaz
package entities.bank;

import java.util.ArrayList;
import java.util.HashMap;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;
import use_cases.board.Board;

/**
 * Bank class. Stores money, houses, hotels and tiles available for purchase. Also allows for purchase
 * of tiles.
 *
 */
public class Bank {
    
    HashMap<Player, Integer> balances; // balance of players
    int balance; // total balance in bank
    int numHouses; // number of houses in bank
    int numHotels; // number of hotels in bank
    ArrayList<BuyableTile> remainingTiles; // a list of the remaining tiles that are still in bank possession

    /**
     *  Construct the bank.
     *
     * @param board board created at start of the game.
     */
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
     * Checks if player has enough money in their balance to buy the given BuyableTile and whether the BuyableTile is
     * available for purchase.
     *
     * @param player {@link Player}
     * @param prospect {@link BuyableTile}
     * @return true if conditions met, false otherwise
     */
    public boolean checkAcceptance(Player player, BuyableTile prospect){
        return (player.getBalance() >= prospect.getPrice()) & (this.remainingTiles.contains(prospect));
    }

    /**
     * Purchases a property (BuyableTile) for a player if they are eligble to purchase it.
     *
     * @param player {@link Player}
     * @param prospect {@link BuyableTile}
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
