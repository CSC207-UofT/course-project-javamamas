package use_cases.board;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;
import entities.tiles.communitychest.CommunityChestTile;
import entities.tiles.jail.GoToJailTile;
import entities.tiles.prison.PrisonTile;
import entities.tiles.start.StartTile;
import entities.tiles.tile.Tile;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Integer, Tile> board_squares;
    private Map<String, Integer> player_positions;

    public void create_board() {
        this.board_squares = new HashMap<Integer, Tile>();
        board_squares.put(1, new StartTile("GO"));
        board_squares.put(2, new BuyableTile(60, "Mediterranean Avenue"));
        board_squares.put(3, new CommunityChestTile("CommunityChest1"));
        board_squares.put(4, new BuyableTile(60, "Baltic Avenue"));
        board_squares.put(5, new CommunityChestTile("CommunityChest2"));
        board_squares.put(6, new BuyableTile(200, "Reading Railroad"));
        board_squares.put(7, new BuyableTile(100, "Oriental Avenue"));
        board_squares.put(8, new CommunityChestTile("CommunityChest3"));
        board_squares.put(9, new BuyableTile(100, "Vermont Avenue"));
        board_squares.put(10, new BuyableTile(120, "Connecticut Avenue"));
        board_squares.put(11, new PrisonTile("Jail"));
        board_squares.put(12, new BuyableTile(140, "St. Charles Place"));
        board_squares.put(13, new BuyableTile(150, "Electric Company"));
        board_squares.put(14, new BuyableTile(140, "States Avenue"));
        board_squares.put(15, new BuyableTile(160, "Virginia Avenue"));
        board_squares.put(16, new BuyableTile(200, "Pennsylvania Railroad"));
        board_squares.put(17, new BuyableTile(180, "St. James Place"));
        board_squares.put(18, new CommunityChestTile("CommunityChest4"));
        board_squares.put(19, new BuyableTile(180, "Tennessee Avenue"));
        board_squares.put(20, new BuyableTile(200, "New York Avenue"));
        board_squares.put(21, new CommunityChestTile("CommunityChest5"));
        board_squares.put(22, new BuyableTile(220, "Kentucky Avenue"));
        board_squares.put(23, new CommunityChestTile("CommunityChest6"));
        board_squares.put(24, new BuyableTile(220, "Indiana Avenue"));
        board_squares.put(25, new BuyableTile(240, "Illinois Avenue"));
        board_squares.put(26, new BuyableTile(200, "B. & O. Railroad"));
        board_squares.put(27, new BuyableTile(260, "Atlantic Avenue"));
        board_squares.put(28, new BuyableTile(260, "Ventnor Avenue"));
        board_squares.put(29, new BuyableTile(150, "Water Works"));
        board_squares.put(30, new BuyableTile(280, "Marvin Gardens"));
        board_squares.put(31, new GoToJailTile("GoToJail"));
        board_squares.put(32, new BuyableTile(300, "Pacific Avenue"));
        board_squares.put(33, new BuyableTile(300, "North Carolina Avenue"));
        board_squares.put(34, new CommunityChestTile("CommunityChest7"));
        board_squares.put(35, new BuyableTile(320, "Pennsylvania Avenue"));
        board_squares.put(36, new BuyableTile(200, "Short Line Railroad"));
        board_squares.put(37, new CommunityChestTile("CommunityChest8"));
        board_squares.put(38, new BuyableTile(350, "Park Place"));
        board_squares.put(39, new CommunityChestTile("CommunityChest9"));
        board_squares.put(40, new BuyableTile(400, "Boardwalk"));

        this.player_positions = new HashMap<String, Integer>();
    }

    /**
     * Set the position of the player on the board. Initial position should be set to 1 for all players.
     *
     * @param player {@link Player}
     * @param position board position
     */
    public void setPlayerPosition(Player player, Integer position){
       player_positions.put(player.getName(), position);
    }

    /**
     *
     * @param player {@link Player}
     * @return integer value representing player position on board.
     */
    public Integer getPlayerPosition(Player player){
        String player_name = player.getName();
        return player_positions.get(player_name);
    }

    /**
     * Returns the type and name of tile at a given position on the board.
     *
     * @param tile_position integer representing position on the board.
     * @return value at corresponding integer key of the board hashmap.
     */
    public Tile getTileAtPosition(Integer tile_position){
        return board_squares.get(tile_position);
    }

}
