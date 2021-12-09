// Author: Dennis Yakovlev

package application.backend.entities.tiles.tile;

import application.backend.entities.bank.Bank;
import application.backend.entities.player.Player;
import application.backend.use_cases.board.Board;

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
