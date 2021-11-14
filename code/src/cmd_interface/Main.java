// Author: Dennis Yakovlev

package cmd_interface;

import controllers.move.MoveController;
import observers.GameLock;


public class Main {

    public static final GameLock GAMELOCK = new GameLock();
    
    public static void main(String[] args) {
     
        MoveController controller = Input.setUp(); // create move controller for game
        var tiles = TileFactory.setUp(); // create tiles

        

    }
        

}
