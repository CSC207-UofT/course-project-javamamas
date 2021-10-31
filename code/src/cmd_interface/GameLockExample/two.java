package cmd_interface.GameLockExample;

public class two {

    public void func() {

        // this function will also make changed to the balances of the players in the bank

        // however the outer method should not have to account for this

        MainExample.lock.lock(4); // error

        MainExample.lock.unlock(4);

    }
    
}
