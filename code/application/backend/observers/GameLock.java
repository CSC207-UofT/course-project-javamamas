package application.backend.observers;

import application.backend.interfaces.LockAction;

/**
 * Whether actions should be allowed to be done in the game.
 * 
 * <p>This class stops multiple states of actors from being changed from
 * different levels on the call stack. If multiple states are to be 
 * changed, they must be changed within the same level of the call stack.</p>
 * 
 * <p> Say a tile is in the onAction method and wants to give money to some players. This request
 * is made through the bank, which would put a lock on the game as it was changing the amount
 * of money each player has. This gaurentees the only change made is that money is given
 * to the players, and nothing else, like say a players position on the board changing. The 
 * class onAction is on does not need to implement {@link LockAction} since it not the
 * class changing the state, Bank is. </p>
 * 
 * <p>See example located in cmd_interface.GameLockExample</p>
 */
public class GameLock {

    private static final int ILLEGAL_ID = -1;
    private int id = GameLock.ILLEGAL_ID; // locking id

    private void _lock(int id) throws GameLockException {

        if (this.id != GameLock.ILLEGAL_ID && id != GameLock.ILLEGAL_ID) { // not equal to illegal id means already has id
            throw new GameLockException();
        }

    }

    /**
     * try to unlock
     * 
     * @param id id used to lock
     * @throws GameLockException if wrong id
     */
    private void _unlock(int id) throws GameLockException {

        if (this.id != id) {
            throw new GameLockException(id);
        }

    }

    /**
     * lock the game
     * 
     * @param id unique id of lock
     */
    public void lock(int id) {

        try {
            _lock(id);
        } catch (GameLockException e) {
            e.printStackTrace();
        }

        this.id = id;

    }

    /**
     * unlock the game
     * 
     * @param id unique id of lock which was used to set lock
     */
    public void unlock(int id) {

        try {
            _unlock(id);
        } catch (GameLockException e) {
            e.printStackTrace();
        }

        this.id = GameLock.ILLEGAL_ID;

    }
    
    public boolean isValidId() {
    	return id != -1;
    }
    
}