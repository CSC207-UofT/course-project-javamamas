
package application.resources.pages.select;

import java.util.ArrayList;

import application.MainController;
import application.backend.controllers.move.MoveController;
import application.backend.entities.player.Player;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControllerSelect {

    private MainController controller;
    private ArrayList<String> words;

    public ControllerSelect(MainController controller) {

        this.controller = controller;

        words = new ArrayList<>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");

        onClickBtn();
        onClickField();
        onKeyPressField();

    }

    /**
     * when next button is clicked
     */
    private void onClickBtn() {

        controller.selectBtnNext.setOnMouseClicked(e -> {

            ArrayList<Integer> turns = new ArrayList<>();

            for (int i = 0; i != words.size(); i++) {
                TextField input = (TextField) controller.selectPanePlayers.lookup("#selectText" + words.get(i));
                if (!input.getText().equals("Enter Player " + words.get(i) + " Name")) { // entered a name
                    turns.add(i);
                }
            }

            if (turns.size() >= 2) {
                ArrayList<Player> players = new ArrayList<>();
                MoveController mover = new MoveController();
                mover.setNumPlayers(turns.size());
                boolean isValidCombos = turns.size() >= 2;
                for (int i : turns) {
                    TextField input = (TextField) controller.selectPanePlayers.lookup("#selectText" + words.get(i));

                    Player player = new Player();
                    player.setName(input.getText());
                    player.setBalance(500);

                    if (mover.isValidPlayerName(input.getText())) { // is a valid name
                        isValidCombos = isValidCombos && ((ImageView) controller.selectPanePlayers.lookup("#selectDisplay" + words.get(i))).getImage() != null; // make sure image is selected
                        mover.addPlayer(turns.indexOf(i) + 1, player);
                        players.add(player);
                    } else { // not valid
                        isValidCombos = false;
                        controller.selectPanePlayers.lookup("#selectText" + words.get(i)).setStyle("-fx-background-color: rgb(255,0,0);");
                    }
                }



                if (isValidCombos) { // users entered valid information
                    ArrayList<String> names = new ArrayList<>();
                    for (int i = 0; i != players.size(); i++) {
                        names.add(players.get(i).getName());
                    }
                    controller.moveController = mover;
                    controller.names = names;
                    controller.initPlay.in();
                }
            }


        });

    }

    /**
     * when field is clicked
     */
    private void onClickField() {

        for (String name : words) {
            TextField input = (TextField) controller.selectPanePlayers.lookup("#selectText" + name);
            input.setOnMouseClicked(e -> {
                input.setText("");
            });
        }

    }

    /**
     * when key is pressed in field
     */
    private void onKeyPressField() {

        for (int i = 0; i != words.size(); i++) {
            String name = words.get(i);

            TextField input = (TextField) controller.selectPanePlayers.lookup("#selectText" + name);
            input.setOnKeyPressed(e -> {
                input.setStyle("");
            });
        }

    }

}