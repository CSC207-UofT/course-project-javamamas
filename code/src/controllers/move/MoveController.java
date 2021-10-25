package controllers.move;

import java.util.HashMap;
import java.util.Map;

import entities.player.Player;
import entities.player.PlayerNameException;
import interfaces.Initializable;

/**
 * Controls moves of players.
 * <p> Invariants </p>
 * <p>
 * - {@link #numPlayers} can only be set once
 * </p>
 */
public class MoveController implements Initializable {
    
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

        if (_validTurn(i) && _possibleAddTurn(i) && initialized()) {
            if (_possibleAddPlayerName(player.getName())) {
                turns.put(i, player);
    
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

        return i > 1 && i <= 5; // TODO i dont know the maximum number of players we allow.

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

    private Map<Integer, Player> turns;
    private int numPlayers; // number of players

    /**
     * Default initialization of Controller.
     */
    private void _defaultInit() {

        turns = new HashMap<Integer,Player>();

    }

    public MoveController() {

        _defaultInit();

    }

    public MoveController(int numPlayers) {

        _defaultInit();

        // try setting number of players
        try {
            _setNumPlayers(numPlayers);
        } catch (MoveAddException e) {
            e.printStackTrace();
        }

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
     * @return true if number of turns has been set
     */
    @Override
    public boolean initialized() {

        return _validNumPlayers(numPlayers);

    }

}