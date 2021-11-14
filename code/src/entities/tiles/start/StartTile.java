package entities.tiles.start;

import entities.player.Player;
import entities.tiles.tile.ActionStruct;
import entities.tiles.tile.Tile;
import entities.bank.Bank;

// Author: Shivanshi

public class StartTile extends Tile {

    @Override
    public void onAction(Bank bank, Player player) {
        bank.balance -= 200;
        player.balance += 200;
    }

//    @Override
//    public boolean canAddPlayer(Player player) { return true; }
//
//    @Override
//    public void addPlayer(Player player) {
//
//    }
//
//    @Override
//    public boolean canRemovePlayer(Player player) {
//        return false;
//    }
//
//    @Override
//    public void removePlayer(Player player) {
//    }
    
}
