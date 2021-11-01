package cmd_interface.GameLockExample;

public class one {
    
    public void func() {

        // this function will make some changes, say to the balances in bank

        MainExample.lock.lock(5); // lock the game

        two t = new two();
        t.func();

        MainExample.lock.unlock(5); // unlock the game

    }

}
