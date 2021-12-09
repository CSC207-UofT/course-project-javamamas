package application.backend.use_cases.board;

import application.backend.entities.player.Player;
import application.backend.entities.tiles.buyable.BuyableTile;
import application.backend.entities.tiles.communitychest.CommunityChestTile;
import application.backend.entities.tiles.jail.GoToJailTile;
import application.backend.entities.tiles.pass.FreePassTile;
import application.backend.entities.tiles.prison.PrisonTile;
import application.backend.entities.tiles.start.StartTile;
import application.backend.entities.tiles.tile.Tile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Board {
    private Map<Integer, Tile> board_squares;
    private Map<String, Integer> player_positions;

    public void create_board() {
        this.board_squares = new HashMap<Integer, Tile>();
        
        String absPath = new File("").getAbsolutePath();
        String relPath = "\\src\\application\\backend\\";
        Path path = Paths.get(absPath + relPath + "Tiles.txt");
        try (Stream<String>  lines = Files.lines(path)) {
            lines.forEachOrdered(line -> {
            	String[] info = line.split(",");
            	int tilePos = Integer.valueOf(info[0]);
            	String tileName = info[1];
            	if (info.length == 2) {
            		if (tileName.equals("StartTile")) {
            			board_squares.put(tilePos, new StartTile(""));
            		} else if (tileName.equals("CommunityChestTile")) {
            			board_squares.put(tilePos, new CommunityChestTile(""));
            		} else if (tileName.equals("GoToJailTile")) {
            			board_squares.put(tilePos, new GoToJailTile(""));
            		} else if (tileName.equals("PrisonTile")) {
            			board_squares.put(tilePos, new PrisonTile(""));
            		} else if (tileName.equals("FreePassTile")) {
            			board_squares.put(tilePos, new FreePassTile(""));
            		}
            	} else if (info.length == 3) {
            		board_squares.put(tilePos, new BuyableTile(Integer.valueOf(info[2]), ""));
            	}
            });
        } catch (IOException e) {}
        
        this.player_positions = new HashMap<String, Integer>();
    }

    /**
     * Set the position of the player on the board. Initial position should be set to 1 for all players.
     *
     * @param player {@link Player}
     * @param position board position
     */
    public void setPlayerPosition(Player player, int position) {
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
