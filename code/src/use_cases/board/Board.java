package use_cases.board;

import entities.player.Player;
import entities.tiles.buyable.BuyableTile;
import entities.tiles.communitychest.CommunityChestTile;
import entities.tiles.jail.GoToJailTile;
import entities.tiles.pass.FreePassTile;
import entities.tiles.prison.PrisonTile;
import entities.tiles.start.StartTile;
import entities.tiles.tile.Tile;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Board {
    private Map<Integer, Tile> board_squares;
    private Map<String, Integer> player_positions;

    /**
     * Creates monopoly board by reading in a file containing information for each tile at the given location
     * (spots from 1 - 40). A tile is created based on the tile type specified and added to the board_squares
     * dictionary, where it is mapped from its location.
     */
    public void create_board() {
        this.board_squares = new HashMap<Integer, Tile>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader("monopoly_tiles.csv"));
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer spot = Integer.parseInt(row[0]);
                String name = row[1];
                String tile_type = row[2];
                int price = Integer.parseInt(row[3]);

                switch (tile_type) {
                    case "Buyable":
                        board_squares.put(spot, new BuyableTile(price, name));
                        break;
                    case "CommunityChest":
                        board_squares.put(spot, new CommunityChestTile(name));
                        break;
                    case "GoToJail":
                        board_squares.put(spot, new GoToJailTile(name));
                        break;
                    case "Prison":
                        board_squares.put(spot, new PrisonTile(name));
                        break;
                    case "FreePass":
                        board_squares.put(spot, new FreePassTile(name));
                        break;
                    case "Start":
                        board_squares.put(spot, new StartTile(name));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException ignored) {

            }
        }

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
