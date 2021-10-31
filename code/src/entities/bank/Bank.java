// Author: Yusra
package entities.bank;

import java.util.Map;

import entities.player.Player;
import interfaces.Initializable;
import interfaces.LockAction;

/**
 * Bank class.
 * 
 * <p> Invariants </p>
 * <p>
 * - {@link #numPlayers} can only be set once
 * </p>
 */
public class Bank implements Initializable, LockAction {
    
    Map<Player, Integer> balances; // balance of players
    int numPlayers; // number of players

    public Bank() {} // allow default construction

    /**
     * 
     * TODO: catch exception if invalid number of players
     * 
     * @param numPlayers
     */
    public Bank(int numPlayers) {
    }

    /**
     * 
     * @param player {@link Player}
     * @param amount
     * @return true if can pay player amount, false otherwise
     */
    public boolean canPay(Player player, int amount) {

        return true;

    }

    /**
     * 
     * @param player {@link Player}
     * @param amount
     * @return true if can take amount from player, false otherwise
     */
    public boolean canTake(Player player, int amount) {

        return true;

    }

    /**
     * 
     * @param player {@link Player}
     * @return true if can add player, false otherwise
     */
    public boolean canAddPlayer(Player player) {

        return true;

    }

    /**
     * 
     * @param num number of players
     * @return true can add number of players.
     */
    public boolean canAddNumPlayers(int num) {

        return true;

    }

    /**
     * 
     * @param player {@link Player}
     * @return true if player balance balance can be checked
     */
    public boolean canCheckBalance(Player player) {

        return true;

    }

    /**
     * Take amount from player.
     * 
     * TODO: catch exception if cannot take amount from player.
     * 
     * @param player {@link Player}
     * @param amount
     */
    public void TakePlayer(Player player, int amount) {
    }

    /**
     * Pay player amount.
     * 
     * TODO: catch exception if cannot pay player.
     * 
     * @param player {@link Player}
     * @param amount
     */
    public void PayPlayer(Player player, int amount) {
    } 
    
    /**
     * Add player to bank.
     * 
     * TODO: catch exception if player cannot be added to bank.
     * 
     * @param player {@link Player}
     */
    public void addPlayer(Player player) {
    }

    /**
     * Add number of players.
     * 
     * TODO: catch exception if cannot add number of players
     * 
     * @param num number of players
     */
    public void addNumPlayers(int num) {
    }

    /**
     * 
     * TODO: catch exception if cannot return player balance
     * 
     * @param player {@link Player}
     * @return player balance
     */
    public int playerBalance(Player player) {

        return -1;

    }

    /**
     * 
     * @return true if all players have been added.
     */
    @Override
    public boolean initialized() {
        return false;
    }

    @Override
    public void begin() {
    }

    @Override
    public void end() {
    }

}
