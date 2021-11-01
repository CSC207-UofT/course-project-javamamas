// Author: Dennis Yakovlev

package entities.player;

public class PlayerNameException extends Exception {

    /**
     * Invalid player name.
     * 
     * @param name player name
     */
    public PlayerNameException(String name) {
        super(name + " is not valid player name");
    }

}
