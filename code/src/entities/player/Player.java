package entities.player;

import entities.player.PlayerNameException;

public class Player {
 
    /**
     * @param name name
     * @return true if valid name, false otherwise
     */
    private boolean validName(String name) {
        return true;
    }

    /**
     * Add name of player.
     * 
     * @param name name
     * @return true if name added, false otherwise
     * @throws PlayerNameException
     */
    private void addName(String name) throws PlayerNameException {
        
        if (validName(name)) {
            this.name = name;
        } else {
            throw new PlayerNameException(name);
        }

    }

    private static final String INVALID_NAME = "_"; // starting invalid name

    private String name = INVALID_NAME; // name of player
    private int numHouses = 0; // number of houses player owns
    private int balance = 0; // current liquid balance of the player

    public Player() {

    }

    public Player(String name) {

        // try adding name
        try {
            addName(name);
        } catch (PlayerNameException e) {
            // Do nothing, fail silently 
        }

    }

    /**
     * @return true if player has been initialized, false otherwise
     */
    public boolean initializedPlayer() {

        return validName(name);

    }

    /**
     * 
     * @param name name
     * @return true is valid name, false otherwise
     */
    public boolean isValidName(String name) {
        return validName(name);
    }

    /**
     * Set name of player
     * @param name name
     */
    public void setName(String name) {

        try {
            addName(name);
        } catch (PlayerNameException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }
}
