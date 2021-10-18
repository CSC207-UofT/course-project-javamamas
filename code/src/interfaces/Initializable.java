package interfaces;

/**
 * Used for object which state is not guarenteed to be ready for use
 * upon construction. Force the object to meet requirements determined
 * by that object to allow for safe use.
 */
public interface Initializable {
    
    /**
     * @return true if object has been initialized as specified
     * by the class, false otherwise
     */
    public boolean initialized();

}
