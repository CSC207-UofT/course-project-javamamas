package cmd_interface;

import java.util.Scanner;

import controllers.MoveController;
import entities.player.Player;

public class Main {
    
    // args should have
    // - number of players
    // - player names for every player
    // - which turned number they are
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of players: ");
        int numPlayers = scanner.nextInt();
        
        System.out.println();
        
        Scanner scannerName = new Scanner(System.in);
        Scanner scannerPos = new Scanner(System.in);
        MoveController controller = new MoveController(numPlayers);
        int i = 0;
        while (i != numPlayers) {
            
            // get player name
            Player player = new Player();
            
            System.out.print("Enter Player Name: ");
            String name = scannerName.nextLine();
            while (!player.isValidName(name)) {
                System.out.print("Enter Player Name: ");
                name = scannerName.nextLine();
            }
            player.setName(name);
            
            // get player turn
            System.out.print("Enter Player Turn Position: ");
            int turn = scannerPos.nextInt();
            while (!controller.canAddTurn(i) || !controller.isValidTurn(i)) {
                System.out.print("Enter Player Turn Position: ");
                turn = scannerPos.nextInt();
            }

            controller.addPlayer(turn, player);

            i++;
        }

        scanner.close();
        scannerName.close();
        scannerPos.close();

    }

}
