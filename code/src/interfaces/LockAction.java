// Author: Dennis Yakovlev

package interfaces;

import observers.GameLock;

/**
 * Interface for class which wishes to have full control of the game.
 * That is, pause all other events and be the sole state changer of all actors.
 * 
 * <p>From {@link LockAction#begin(GameLock)} to {@link LockAction#end(GameLock)} the child class
 * will be the only class making changes to any states. </p>
 * 
 * <p>ANY class which wishes to change the states of actors involved in the game must
 * implement this. </p>
 * 
 * <p>See {@link GameLock} for more </p>
 */
public interface LockAction {
    
    /**
     * Must request the lock.
     * 
     * @param gameLock {@link GameLock}
     */
    public void begin();

    /**
     * Must release the lock.
     * 
     * @param gameLock {@link GameLock}
     */
    public void end();

}
