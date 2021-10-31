package cmd_interface.GameLockExample;

import observers.GameLock;

// demonstrate use for gamelock

public class MainExample {
    
    public static final GameLock lock = new GameLock();

    public static void main(String[] args) {

        one o = new one();

        o.func();

    }

}

