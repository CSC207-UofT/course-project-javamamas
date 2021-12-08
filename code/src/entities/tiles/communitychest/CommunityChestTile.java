package entities.tiles.communitychest;

import entities.tiles.tile.ActionStruct;

import java.util.ArrayList;

import entities.player.Player;
import entities.tiles.tile.Tile;

public class CommunityChestTile extends Tile {

    private ArrayList<Card> cards;
    private Card currCard;

    public CommunityChestTile(String tile_name) {

        cards = new ArrayList<>();
        cards.add(new MoveRandom());
        cards.add(new RandomPay());
        cards.add(new MissTurn());

    }

    /**
     * When a player lands on this tile, they get a random card which determines their action (will either cause them
     * to miss a turn, move them to a random board tile, or give them a random amount of money from possible amounts).
     *
     * @param info variables obtained from ActionStruct needed for the action.
     */
    @Override
    public void onAction(ActionStruct info) {   
        currCard = cards.get((int)(Math.random() * 3) + 1);
        currCard.onAction(info);
    }

    @Override
    public void addPlayer(Player player) {
        this.getPlayers().add(player);
    }

    @Override
    public boolean canRemovePlayer(Player player) {
        if (currCard instanceof MissTurn) {
            return ((MissTurn)currCard).isHeldBack(player);
        }
        return true;
    }

    @Override
    public void removePlayer(Player player) {
        this.getPlayers().remove(player);
    }
    
}
