package application.backend.use_cases.propertychecker;

import application.backend.entities.bank.Bank;
import application.backend.entities.player.Player;
import application.backend.entities.tiles.buyable.BuyableTile;
import application.backend.entities.tiles.tile.Tile;
import application.backend.use_cases.board.Board;

import java.util.Collection;

public class PropertyChecker {
    
    /**
     * Do player and tile state allow for purchase of this tile?
     * 
     * @param player {@link Player}
     * @param tile {@link Tile}
     * @param bank {@link Bank}
     * @param remainingTiles A list of remaining tiles {@link BuyableTile}
     * @return true if conditions met, false otherwise
     */
    public boolean canBuy(Player player, Tile tile, Bank bank, Collection<BuyableTile> remainingTiles) {
        
        if (remainingTiles.contains(tile) && tile instanceof BuyableTile){
            return (player.getBalance() >= ((BuyableTile)tile).getPrice());
        }
        return false;

    }
    
    public boolean isBuyable(int pos, Player player, Board board) {
    	
    	Tile tile = board.getTileAtPosition(pos);
    	return tile instanceof BuyableTile && ((BuyableTile) tile).getPrice() <= player.getBalance();
    	
    }
    
    public boolean isBuyable(int pos, Board board) {
    	
    	return board.getTileAtPosition(pos) instanceof BuyableTile;
    	
    }
    
    public int tilePrice(int pos, Board board) {
    	
    	return ((BuyableTile) board.getTileAtPosition(pos)).getPrice();
    	
    }

}
