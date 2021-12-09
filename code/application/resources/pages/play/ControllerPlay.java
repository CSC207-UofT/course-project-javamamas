package application.resources.pages.play;

import java.util.ArrayList;

import application.MainController;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerPlay {

	private MainController controller;
	private ArrayList<Color> playerColors = new ArrayList<>();
	private ArrayList<String> words;
	
	public ControllerPlay(MainController controller) {
		
		this.controller = controller;
			
		words = new ArrayList<>();
		words.add("One");
		words.add("Two");
		words.add("Three");
		words.add("Four");
		
		playerColors.add(Color.BLUE);
		playerColors.add(Color.GREEN);
		playerColors.add(Color.ORANGE);
		playerColors.add(Color.BLACK);
		
		onRollerClick();
		onBuyClick();
		onHelpClick();
		
	}
	
	/**
	 * Action to do when roll button is clicked.
	 */
	private void onRollerClick() {
		
		controller.playCircleRoller.setOnMouseClicked(e -> {
			int dieRoll = controller.moveController.rollDie(); // roll die
			((Label) controller.play.lookup("#playRollerLab")).setText(Integer.toString(dieRoll)); // set die roller to rolled value
						
			String name = controller.names.get(controller.moveController.getCurrTurn());
			int oldPos = controller.moveController.getCurrPlayerPos() - 1;
						
			AddableTile.Info add = ((AddableTile) controller.tiles.get(oldPos)).getInfo(name); // get info
			
			boolean res = controller.moveController.goTurn(dieRoll); // attempt to move the player
			System.out.println("success? " + res);
			if (res) { // if move was success
				
				AddableTile tile = ((AddableTile) controller.tiles.get(oldPos + dieRoll));
				tile.addPlayer(add.img, name);
				((AddableTile) controller.tiles.get(oldPos)).removePlayer(name);
			}
		});
	}
	
	/**
	 * Action to do when buy button is clicked.
	 */
	private void onBuyClick() {
		
		controller.play.lookup("#playBtnBuy").setOnMouseClicked(e -> {
			boolean canBuy = controller.moveController.canBuyTile(controller.moveController.getPrevPlayerPos(), controller.moveController.getPrevPlayer());
			
			if (canBuy) { // can buy the tile
				
				int index = controller.moveController.getPrevPlayerPos();
				AddableTile addable = (AddableTile) controller.tiles.get(index - 1); // get addable tile
				addable.setCircle(playerColors.get(controller.moveController.getPrevTurn() - 1)); // change circle color
				controller.moveController.setBalance(
						controller.moveController.getPrevPlayer(), 
						controller.moveController.getPrevPlayer().getBalance() - controller.moveController.tilePrice(index)
				);
				((Label) controller.play.lookup(
						"#playLabPlayer" + 
						words.get(controller.moveController.getPrevTurn() - 1))).setText(
								Integer.toString(controller.moveController.getPrevPlayer().getBalance()
						)
				); // change label
			}
		});
	}
	
	/**
	 * 
	 */
	private void onHelpClick() {
		
		
		controller.play.lookup("#playBtnHelp").setOnMouseClicked(e -> {
			Stage stage = (Stage) controller.play.getScene().getWindow();
			stage.setScene(controller.initHelp.InstructionPage1);
		});
		
	}
	
}
