// Author: Dennis Yakovlev

package entities.player;

import java.util.Map;

import entities.tiles.buyable.BuyableTile;

public class Player {
 
    private String name;
    private int titleDeeds;
    private Map<BuyableTile, Integer> houses;
    private int balance;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTitleDeeds() {
        return this.titleDeeds;
    }

    public void setTitleDeeds(int titleDeeds) {
        this.titleDeeds = titleDeeds;
    }

    public Map<BuyableTile,Integer> getHouses() {
        return this.houses;
    }

    public void setHouses(Map<BuyableTile,Integer> houses) {
        this.houses = houses;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
