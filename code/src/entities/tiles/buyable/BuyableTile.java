package entities.tiles.buyable;

import entities.tiles.tile.ActionStruct;
import entities.player.Player;
import entities.tiles.tile.Tile;
import interfaces.Initializable;
import java.util.Scanner;
import entities.bank.Bank;

public class BuyableTile extends Tile implements Initializable {

    int price;

    /**
     * TODO: catch exception if invalid price
     * 
     * @param price price of tile
     */
    public BuyableTile(int price) {
        this.price = price;
    }


    @Override
    public void onAction(Bank bank, Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you wish to buy this property?");
        boolean accept = sc.nextBoolean();
        if (accept) {
            bank.sellProperty(player, ) // confused about how to get the tile and player
        }
    }

//    /**
//     *
//     * @return true if tile owner can be set to player, false otherwise
//     */
//    public boolean canSetOwner(Player player) {
//
//        return true;
//
//    }
//
//    /**
//     *
//     * @return true if owner of tile can be removed, false otherwise
//     */
//    public boolean canRemoveOwner() {
//
//        return true;
//
//    }
//
//    /**
//     *
//     * @return true if has owner, false otherwise
//     */
//    public boolean hasOwner() {
//
//        return true;
//
//    }
//
//    /**
//     * Set owner of tile.
//     *
//     * TODO: Catch exception if cannot set owner.
//     *
//     * @param player {@link Player}
//     */
//    public void setOwner(Player player) {
//    }
//
//    /**
//     * Remove owner of file.
//     *
//     * TODO: Catch exception if cannot remove owner.
//     */
//    public void removeOwner() {
//    }
//
//    /**
//     *
//     * TODO: catch exception if cannot get owner of this tile
//     *
//     * @return owner of this tile
//     */
//    public Player getOwner() {
//        return null;
//    }
//
//    /**
//     *
//     * @return price of tile
//     */
//    public int getPrice(){
//
//        return -1;
//
//    }
//
//    @Override
//    public void onAction(ActionStruct info) {
//    }
//
//    @Override
//    public boolean canAddPlayer(Player player) {
//        return false;
//    }
//
//    @Override
//    public void addPlayer(Player player) {
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
//
//    @Override
//    public boolean initialized() {
//        return false;
//    }
//
    //    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Tryna be a material gworl??? $$$$");
//        boolean accept = sc.nextBoolean();
//        if (accept) {
//
//        }
//    }
}
