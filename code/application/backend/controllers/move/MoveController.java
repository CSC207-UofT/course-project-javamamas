// Author: Dennis

package application.backend.controllers.move;

import java.util.HashMap;
import java.util.Map;

import application.backend.entities.player.Player;
import application.backend.entities.player.PlayerNameException;
import application.backend.use_cases.board.Board;
import application.backend.use_cases.playerstatus.PlayerStatus;
import application.backend.use_cases.propertychecker.PropertyChecker;

/**
 * Controls moves of players.
 * <p> Invariants </p>
 * <p>
 * - {@link #numPlayers} can only be set once
 * </p>
 */
public class MoveController {
    
    private Map<Integer, Player> turns;
    private int numPlayers; // number of players
    private int turnNumber = 1;
    private Board board;
    private PlayerStatus status;

    public MoveController() {

        board = new Board();
        turns = new HashMap<>();
        board.create_board();
        status = new PlayerStatus();

    }

    /**
     * 
     * @return the turns
     */
    public Map<Integer,Player> getTurns() {
        return this.turns;
    }

    /**
     * move the current turn forward
     */
    private void moveTurnForward() {

        if (turnNumber < numPlayers) {
            turnNumber++;
        } else {
            turnNumber = 1;
        }

    }

    /**
     * roll a die
     * 
     * @return the rolled die
     */
    public int rollDie() {

        return (int)(Math.random() * 5) + 1;

    }

    /**
     * 
     * @param roll number rolled on die
     * @return true if the player could move
     */
    public boolean goTurn(int roll) {

        Player currPlayer = turns.get(turnNumber);

        if (!status.checkPlayer(currPlayer)) { // player not playable
            return false;
        }
        board.setPlayerPosition(currPlayer, board.getPlayerPosition(currPlayer) + roll);

        moveTurnForward();

        return true;

    }
    
    /**
     * 
     * @return get the previous player
     */
    public Player getPrevPlayer() {
    	
    	return turns.get(turnNumber == 1 ? numPlayers : turnNumber - 1);
    	
    }
    
    /**
     * 
     * @return get previous player turn number
     */
    public int getPrevTurn() {
    	return turnNumber == 1 ? numPlayers : turnNumber - 1;
    }
    
    /**
     * 
     * @return previous player position
     */
    public int getPrevPlayerPos() {
    	
    	return board.getPlayerPosition(turns.get(turnNumber == 1 ? numPlayers : turnNumber - 1));
    	
    }
    
    /**
     * 
     * @return current player position
     */
    public int getCurrPlayerPos() {
    	
    	return board.getPlayerPosition(turns.get(turnNumber));
    	
    }

    /**
     * Set the current turns
     * 
     * @param turns turns map
     */
    public void setTurns(Map<Integer,Player> turns) {
        this.turns = turns;
    }

    /**
     * 
     * @return current number of players
     */
    public int getNumPlayers() {
        return this.numPlayers;
    }

    /**
     * 
     * @return current turn number
     */
    public int getCurrTurn() {
    	return turnNumber - 1;
    }
    
    /**
     * Checks whether <i> can be possibly allowed to be a turn.
     * Doesnt chekc whehther it can be added as turn.
     * 
     * @param i turn number
     * @return true if turn is valid turn number, false otherwise
     */
    private boolean _validTurn(int i) {

        return i > 0 && i <= this.numPlayers;

    }

    /**
     * Checks whether <i> can be added as a turn.
     * Doesnt check whehther i is allowed to be turn.
     * @param i turn number
     * @return true is turn number can be added, false otherwise
     */
    private boolean _possibleAddTurn(int i) {

        return !turns.containsKey(i);

    }

    /**
     * Check that player is initialized and its name does not already exist.
     * 
     * @param player {@link Player} 
     * @return true if player can be added
     */
    private boolean _possibleAddPlayerName(String playerName) {

        for (Integer key : turns.keySet()) { // check that player name is not already in set of names
            if (turns.get(key).getName().equals(playerName)) {
                return false;
            }
        }

        return true; // check that player has valid name

    }

    /**
     * Add a player with their corresponding turn position.
     * <p> Check that 1) i is valid 2) i can be added 3) this is initialized. </p>
     * <p> Check that 4) player can be added  </p>
     * 
     * @param i turn position
     * @param player {@link Player}
     * @throws MoveAddException
     * @throws PlayerNameException
     */
    private void _addPlayer(int i, Player player) throws MoveAddException, PlayerNameException {

        if (_validTurn(i) && _possibleAddTurn(i)) {
            if (_possibleAddPlayerName(player.getName())) {
                turns.put(i, player);
                board.setPlayerPosition(player, 1);
    
                return;
            }

            throw new PlayerNameException(player.getName());

        }

        throw new MoveAddException(i, player);

    }

    /**
     * @param i number of players
     * @return true if valid number of players.
     */
    private boolean _validNumPlayers(int i) {

        return i > 1 && i <= 5;

    }

    /**
     * Set number of players.
     * Check that i is valid and number of players has not been set.
     * 
     * @param i
     * @throws MoveAddException
     */
    private void _setNumPlayers(int i) throws MoveAddException {

        if (_validNumPlayers(i) && !_validNumPlayers(numPlayers)) {
            numPlayers = i;

            return;
        }

        throw new MoveAddException(i);

    }

    /**
     * {@link #validTurn(int)} 
     */
    public boolean isValidTurn(int i) {

        return _validTurn(i);

    }

    /**
     * {@link #possibleAddTurn(int)}
     */
    public boolean canAddTurn(int i) {

        return _possibleAddTurn(i);

    }

    /**
     * {@link #_validNumPlayers(int)}
     */
    public boolean isValidNumPlayers(int i) {

        return _validNumPlayers(i);

    }

    /**
     * {@link #_possibleAddPlayerName(Player)} 
     */
    public boolean isValidPlayerName(String playerName) {

        return _possibleAddPlayerName(playerName);

    }

    /**
     * {@link #_possibleAddPlayerName(Player)} 
     */
    public boolean isValidPlayer(Player player) {

        return _possibleAddPlayerName(player.getName());

    }

    /**
     * {@link #_addPlayer(int, Player)} 
     */
    public void addPlayer(int i, Player player) {

        try {
            _addPlayer(i, player);
        } catch (MoveAddException e) {
            e.printStackTrace();
        } catch (PlayerNameException e) {
            e.printStackTrace();
        }


    }

    /**
     * {@link #_setNumPlayers(int)} 
     */
    public void setNumPlayers(int i) {

        try {
            _setNumPlayers(i);
        } catch (MoveAddException e) {
            e.printStackTrace();
        }

    }

    /**
     * Remove a player according to the given turn position
     * 
     * @param turn turn number
     */
    public void removePlayer(int turn) {
    	
    	turns.remove(turn);
    	
    }
    
    /**
     * whether a tile can be bought
     * 
     * @param pos position of player
     * @param player player
     * @return true if player can buy tile
     */
    public boolean canBuyTile(int pos, Player player) {
    	return new PropertyChecker().isBuyable(pos, player, board);
    }
    
    /**
     * 
     * @param pos tile position
     * @return true if tile is buyable
     */
    public boolean isBuyable(int pos) {
    	return new PropertyChecker().isBuyable(pos, board);
    }
    
    /**
     * 
     * @param pos position of tile on board
     * @return price of tile
     */
    public int tilePrice(int pos) {
    	return new PropertyChecker().tilePrice(pos, board);
    }
    
    /**
     * 
     * @param player player object
     * @param bal balance to set to
     */
    public void setBalance(Player player, int bal) {
    	player.setBalance(bal);
    }
    
}
