// Author: Dennis Yakovlev

package cmd_interface;

import java.util.Scanner;

import controllers.move.MoveController;
import entities.player.Player;
import observers.GameLock;

public class Input {
    
    public static MoveController setUp() {

        MoveController controller = new MoveController();

        // get number of players
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of players: ");
        int numPlayers = scanner.nextInt();
        while (!controller.isValidNumPlayers(numPlayers)) {
            System.out.print("Enter Number of players: ");
            numPlayers = scanner.nextInt();
        }
        controller.setNumPlayers(numPlayers); // set number of players
        
        System.out.println(); // formatting
        
        Scanner scannerName = new Scanner(System.in);
        Scanner scannerPos = new Scanner(System.in);
        int i = 0;
        while (i != numPlayers) {
            
            Player player = new Player();
            
            // get player name
            System.out.print("Enter Player Name: ");
            String name = scannerName.nextLine();
            while (!player.isValidName(name) || !controller.isValidPlayerName(name)) {
                System.out.print("Enter Player Name: ");
                name = scannerName.nextLine();
            }
            player.setName(name);
            
            // get player turn
            System.out.print("Enter Player Turn Position: ");
            int turn = scannerPos.nextInt();
            // System.out.println(controller.isValidTurn(turn) + " " + controller.canAddTurn(turn));
            while (!controller.isValidTurn(turn) || !controller.canAddTurn(turn)) {
                System.out.print("Enter Player Turn Position: ");
                turn = scannerPos.nextInt();
            }

            controller.addPlayer(turn, player); // add a player

            i++;
        }

        scanner.close();
        scannerName.close();
        scannerPos.close();

        return controller;

    }

}
