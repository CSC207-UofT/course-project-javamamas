package application.backend.interfaces;

import application.backend.entities.tiles.buyable.BuyableTile;

/**
 * Used for object which state is not guarenteed to be ready for use
 * upon construction. Force the object to meet requirements determined
 * by that object to allow for safe use.
 * 
 * <p> Say we want to allow for default construction of a {@link BuyableTile}
 * (we want to, this is incredibly useful), that is, we dont set the price of 
 * the tile when creating it. This can create issues because what if we try 
 * to now use this tile as if it has a price? So, implementing this interface will
 * allow a user to check whether the tile price has been set. If the price
 * has been set (the tile has been initialized) the method returns true and
 * it is safe to use that tile. </p>
 */
public interface Initializable {
    
    /**
     * @return true if object has been initialized as specified
     * by the class, false otherwise
     */
    public boolean initialized();

}
