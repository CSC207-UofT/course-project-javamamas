// Author: Dennis Yakovlev

package entities.tiles.tile;

import entities.bank.Bank;
import entities.player.Player;
import use_cases.board.Board;

/**
 * OnAction information to be passed
 */
public class ActionStruct {
    
    public Bank bank;
    public Player currPlayer;
    public Board board;

    public ActionStruct(Bank bank, Player currPlayer, Board board) {
        this.bank = bank;
        this.currPlayer = currPlayer;
        this.board = board;
    }

}
