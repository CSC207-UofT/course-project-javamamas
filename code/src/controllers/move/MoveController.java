// Author: Dennis

package controllers.move;

import java.util.HashMap;
import java.util.Map;

import entities.bank.Bank;
import entities.player.Player;
import entities.player.PlayerNameException;
import interfaces.Initializable;
import interfaces.LockAction;
import use_cases.board.Board;
import use_cases.gamestatus.GameStatus;
import use_cases.playerstatus.PlayerStatus;

/**
 * Controls moves of players.
 * <p> Invariants </p>
 * <p>
 * - {@link #numPlayers} can only be set once
 * </p>
 */
public class MoveController {
    
    private Map<Integer, Player> turns;
    private int numPlayers; // number of players
    private int turnNumber = 1;
    private Board board;
    private PlayerStatus status;
    private Bank bank;

    public MoveController() {

        turns = new HashMap<>();
        board.create_board();
        status = new PlayerStatus();
        bank = new Bank();

    }

    public Map<Integer,Player> getTurns() {
        return this.turns;
    }

    private void moveTurnForward() {

        if (turnNumber < numPlayers) {
            turnNumber++;
        } else {
            turnNumber = 1;
        }

    }

    private int rollDie() {

        return (int)(Math.random() * numPlayers) + 1;

    }

    public boolean goTurn() {

        Player currPlayer = turns.get(turnNumber);

        if (!status.isPlayerPlayable(currPlayer, bank)) { // player not playable
            return false;
        }

        board.setPlayerPosition(currPlayer, board.getPlayerPosition(currPlayer) + rollDie());

        moveTurnForward();

        return true;

    }

    public void setTurns(Map<Integer,Player> turns) {
        this.turns = turns;
    }

    public int getNumPlayers() {
        return this.numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }




}
