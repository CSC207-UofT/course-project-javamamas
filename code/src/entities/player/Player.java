// Author: Dennis Yakovlev

package entities.player;

import cmd_interface.Main;
import interfaces.Initializable;
import interfaces.LockAction;

/**
 * Player class.
 * <p> Invariants </p>
 * <p>
 * - {@link #name} can only be set once
 * </p>
 */
public class Player implements Initializable, LockAction {
 
    /**
     * @param name name
     * @return true if valid name, false otherwise
     */
    private boolean _validName(String name) {
        return !name.equals(INVALID_NAME);
    }

    /**
     * Add name of player.
     * Check that name is valid and that name for player has not been set yet.
     * 
     * @param name name
     * @return true if name added, false otherwise
     * @throws PlayerNameException
     */
    private void _setName(String name) throws PlayerNameException {
        
        if (_validName(name) && !_validName(this.name)) {
            this.name = name;

            return;
        } 
            
        throw new PlayerNameException(name);

    }

    private static final String INVALID_NAME = "_"; // starting invalid name
    private static final int LOCK_ID = -8978194;

    private String name = INVALID_NAME; // name of player

    public Player() {} // allow default construction

    public Player(String name) {

        begin();

        // try adding name
        try {
            _setName(name);
        } catch (PlayerNameException e) {
            e.printStackTrace();
        }

        end();

    }

    /**
     * {@link #_validName(String) }
     */
    public boolean isValidName(String name) {
        return _validName(name);
    }

    /**
     * {@link #_addName(String)}
     */
    public void setName(String name) {

        begin();

        try {
            _setName(name);
        } catch (PlayerNameException e) {
            e.printStackTrace();
        }

        end();

    }

    /**
     * 
     * @return copy of name
     */
    public String getName() {

        return new String(name);

    }

    /**
     * @return true if name has been set, false otherwise
     */
    @Override
    public boolean initialized() {
        
        return _validName(name);

    }

    @Override
    public void begin() {
        Main.GAMELOCK.lock(Player.LOCK_ID);
    }

    @Override
    public void end() {
        Main.GAMELOCK.unlock(Player.LOCK_ID);        
    }

}
