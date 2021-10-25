// Author: Dennis Yakovlev

package entities.player;

import interfaces.Initializable;

/**
 * Player class.
 * <p> Invariants </p>
 * <p>
 * - {@link #name} can only be set once
 * </p>
 */
public class Player implements Initializable {
 
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

    private String name = INVALID_NAME; // name of player

    public Player() {} // allow default construction

    public Player(String name) {

        // try adding name
        try {
            _setName(name);
        } catch (PlayerNameException e) {
            // Do nothing, fail silently 
        }

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

        try {
            _setName(name);
        } catch (PlayerNameException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    /**
     * @return true if name has been set, false otherwise
     */
    @Override
    public boolean initialized() {
        
        return _validName(name);

    }

}
