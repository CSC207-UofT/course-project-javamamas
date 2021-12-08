package entities.tiles.buyable;

import entities.tiles.tile.ActionStruct;
import entities.player.Player;
import entities.tiles.tile.Tile;

public class BuyableTile extends Tile {

    private int price;
    private Player tileOwner;


    /**
     * 
     * @param price price of tile
     */
    public BuyableTile(int price, String tile_name) {

        this.price = price;

    }

    /**
     * 
     * @return true if tile owner can be set to player, false otherwise
     */
    public boolean canSetOwner(Player player) {
        
        return tileOwner == null;
        
    }

    /**
     * 
     * @return true if owner of tile can be removed, false otherwise
     */
    public boolean canRemoveOwner() {

        return tileOwner != null;

    }

    /**
     * Set owner of tile.
     * 
     * 
     * @param player {@link Player}
     */
    public void setOwner(Player player) {
        this.tileOwner = player;
    }

    /**
     * Remove owner of file.
     * 
     */
    public void removeOwner() {
        tileOwner = null;
    }

    /**
     * 
     * @return owner of this tile
     */
    public Player getOwner() {
        return tileOwner;
    }

    /**
     * 
     * @return price of tile
     */
    public int getPrice(){
        
        return this.price;

    }

    /**
     * When a player lands on this tile, they pay rent (based off the price). The amount of money deducted from the\
     * players balance is then obtained by the BuyableTiles owner.
     *
     * @param info variables obtained from ActionStruct needed for the action.
     */
    @Override
    public void onAction(ActionStruct info) {
        int current_balance = info.currPlayer.getBalance();
        info.currPlayer.setBalance(current_balance - price);
        this.tileOwner.setBalance(current_balance + price);
    }

    @Override
    public void addPlayer(Player player) {
        this.getPlayers().add(player);
    }

    @Override
    public boolean canRemovePlayer(Player player) {
        return true;
    }

    @Override
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);
    }
  
}