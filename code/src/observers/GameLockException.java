// Author: Dennis Yakovlev

package observers;

public class GameLockException extends Exception {
    
    public GameLockException() {
        super("Lock already exists");
    }

    public GameLockException(int id){
        super("Not locked using " + id);
    } 

}
