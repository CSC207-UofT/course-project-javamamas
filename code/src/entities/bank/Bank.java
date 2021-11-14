// Author: Yusra Fayyaz
package entities.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;
import interfaces.Initializable;
import interfaces.LockAction;
import controllers.move.MoveController;
import use_cases.board.Board;

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

    /**
     *  Construct the bank.
     *
     * 
     *
     */
    public Bank() {
        this.numHouses = 32;
        this.numHotels = 12;
        this.balance = 20580;
//        BuyableTile MediterraneanAvenue = new BuyableTile(60);
//        BuyableTile BalticAvenue = new BuyableTile(60);
//        BuyableTile OrientalAvenue = new BuyableTile(100);
//        BuyableTile VermontAvenue = new BuyableTile(100);
//        BuyableTile ConnecticutAvenue = new BuyableTile(120);
//        BuyableTile StCharlesPlace = new BuyableTile(140);
//        BuyableTile StatesAvenue = new BuyableTile(140);
//        BuyableTile VirginiaAvenue = new BuyableTile(160);
//        BuyableTile StJamesPlace = new BuyableTile(180);
//        BuyableTile TennesseeAvenue = new BuyableTile(180);
//        BuyableTile NewYorKAvenue = new BuyableTile(200);
//        BuyableTile KentuckyAvenue = new BuyableTile(220);
//        BuyableTile IndianaAvenue = new BuyableTile(220);
//        BuyableTile IllinoisAvenue = new BuyableTile(240);
//        BuyableTile AtlanticAvenue = new BuyableTile(260);
//        BuyableTile VentorAvenue = new BuyableTile(260);
//        BuyableTile MarvinGardens = new BuyableTile(280);
//        BuyableTile PacificAvenue = new BuyableTile(300);
//        BuyableTile NorthCarolinaAvenue = new BuyableTile(300);
//        BuyableTile PennsylvaniaAvenue = new BuyableTile(320);
//        BuyableTile ParkPlace = new BuyableTile(350);
//        BuyableTile Boardwalk = new BuyableTile(400);
//        BuyableTile ReadingRailroad = new BuyableTile(200);
//        BuyableTile PennsylvaniaRailroad = new BuyableTile(200);
//        BuyableTile BnORailroad = new BuyableTile(200);
//        BuyableTile ShortLine = new BuyableTile(200);
//        List<BuyableTile> tiles = Arrays.asList(MediterraneanAvenue, BalticAvenue, OrientalAvenue, VermontAvenue,
//                ConnecticutAvenue, StCharlesPlace, StatesAvenue, VirginiaAvenue, StJamesPlace, TennesseeAvenue,
//                NewYorKAvenue, KentuckyAvenue, IndianaAvenue, IllinoisAvenue, AtlanticAvenue, VentorAvenue,
//                MarvinGardens, PacificAvenue, NorthCarolinaAvenue, PennsylvaniaAvenue, ParkPlace, Boardwalk,
//                ReadingRailroad, PennsylvaniaRailroad, BnORailroad, ShortLine);
        for ()
        this.remainingTiles = new ArrayList<>(tiles);
    }

    public void sellProperty(Player player, BuyableTile prospect){

        try {
            if (player.getBalance() >= prospect.getPrice()) {
                this.remainingTiles.remove(prospect);
                player.getBalance() -= prospect.getPrice();
                this.balance += prospect.getPrice();
                // ask Dennis to add player balance and properties
                player.getHouses().put(prospect, 0);
            }
        } catch (BankPropertyException e) {
            e.printStackTrace();
        }

    }

}
