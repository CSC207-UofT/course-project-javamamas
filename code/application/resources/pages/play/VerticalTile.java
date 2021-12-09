package application.resources.pages.play;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class VerticalTile extends Pane implements AddableTile {
	
	private double sizeMult = 1.25; // the size multiplier to make room for players
	boolean isTop; // whether this vertical tile is on top row
	private double totalHeight, height, width, playersHeight; 
	private int numPlayers = 0;
	private ArrayList<String> names = new ArrayList<>();
	private Circle owner;

	/**
	 * 
	 * @param width width of tile
	 * @param height height of the board tile
	 * @param isTop whether is on top row
	 * @param uh
	 */
	public VerticalTile(double width, double height, boolean isTop, boolean canBuy) {
		
		names.add("_");
		names.add("_");
		names.add("_");
		names.add("_");
		
		this.playersHeight = height * sizeMult;
		this.width = width;
		this.height = height;
		this.totalHeight = height + playersHeight;
		this.isTop = isTop;
		
		this.setPrefSize(width, totalHeight);
		
		setPlayers();
		if (canBuy) {
			setOwner();
		}
		
	}
	
	/**
	 * Set up room for players
	 */
	private void setPlayers() {
		
		Pane pane = new Pane();
		pane.setPrefSize(width, playersHeight);
		pane.setLayoutX(0);
		pane.setLayoutY(isTop ? height : 0);
//		pane.setStyle("-fx-background-color: rgb(0,0,0);");
		
		double playerHeight = playersHeight / 5;
		double padding = playerHeight / 5;
		
		
		for (int i = 0; i != 4; i++) {
			Circle player = new Circle();
			player.setRadius(playerHeight / 2);
//			player.setFill(Color.WHITE);
			player.setLayoutY((padding * (i + 1)) + playerHeight * i + (playerHeight / 2));
			player.setLayoutX((width / 2));
			player.setOpacity(0);
			
			pane.getChildren().add(player);
		}
		
		this.getChildren().add(pane);
		
	}
	
	private void setOwner() {
		
		owner = new Circle();
		owner.setFill(Color.WHITE);
		owner.setRadius(height * 0.32994 * 0.5 * 0.5);
		owner.setLayoutX(width / 2);
		owner.setLayoutY(isTop ? height - (height * 0.71066) : playersHeight + (height * 0.71066));
		
		this.getChildren().add(owner);
		
	}
	
	/**
	 * Lock the wanted position of the top left corner
	 * @param x
	 * @param y
	 */
	public void setCornerPos(double x, double y) {
		this.setLayoutX(x);
		this.setLayoutY(isTop ? y : y - playersHeight);
	}

	private Circle getCircle(int num) {
		
		return (Circle) ((Pane) this.getChildren().get(0)).getChildren().get(num);
		
	}
	
	private int getAdjusted(int num) {
		
		return isTop ? num : 3 - num;
		
	}
	
	@Override
	public void addPlayer(Image img, String name) {
		
		Circle circ = getCircle(getAdjusted(numPlayers));
		circ.setOpacity(1);
		circ.setFill(new ImagePattern(img));
		
		names.set(numPlayers, name);
		
		numPlayers++;
		
	}
	
	@Override
	public void addPlayer(Paint img, String name) {
		
		Circle circ = getCircle(getAdjusted(numPlayers));
		circ.setOpacity(1);
		circ.setFill(img);
		
		names.set(numPlayers, name);
		
		numPlayers++;
		
	}
	
	@Override
	public void removePlayer(String name) {
		
		int pos = 0;
		for (int i = 0; i != numPlayers - 1; i++) {
			if (names.get(i).equals(name)) {
				pos = i;
				break;
			}
		}
		
		names.set(pos, "_");
		
		for (int i = pos; i < numPlayers - 1; i++) {
			getCircle(getAdjusted(i)).setFill(getCircle(getAdjusted(i + 1)).getFill());
		}
		
		getCircle(getAdjusted(numPlayers - 1)).setOpacity(0);
		
		numPlayers--;
		
	}
	
	@Override
	public Info getInfo(String name) {
		
		for (int i = 0; i != names.size(); i++) {
			if (names.get(i).equals(name)) {
				return new Info(i, getCircle(getAdjusted(i)).getFill());
			}
		}
		
		System.out.println("GETTING NULL INFO");
		
		return null;
		
	}
	
	@Override
	public void setCircle(Color col) {
		owner.setFill(col);
	}
	
}
