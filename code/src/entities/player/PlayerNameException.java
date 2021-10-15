package entities.player;

public class PlayerNameException extends Exception {

    public PlayerNameException(String name) {
        super(name + " is not valid player name");
    }

}
