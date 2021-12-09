package application.resources.pages.play;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class HorizontalTile extends Pane implements AddableTile {

	private double sizeMult = 1.25; // the size multiplier to make room for players
	boolean isLeft; // whether this vertical tile is on top row
	private double totalWidth, height, width, playersWidth;
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
	public HorizontalTile(double width, double height, boolean isLeft, boolean canBuy) {
		
		names.add("_");
		names.add("_");
		names.add("_");
		names.add("_");
		
		this.playersWidth = width * sizeMult;
		this.width = width;
		this.height = height;
		this.totalWidth = width + playersWidth;
		this.isLeft = isLeft;
		
		this.setPrefSize(totalWidth, height);
				
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
		pane.setPrefSize(playersWidth, height);
		pane.setLayoutX(isLeft ? 0 : width);
		pane.setLayoutY(0);
//		pane.setStyle("-fx-background-color: transparent;");
		
		double playerHeight = playersWidth / 5;
		double padding = playerHeight / 5;
		
		for (int i = 0; i != 4; i++) {
			Circle player = new Circle();
			player.setRadius(playerHeight / 2);
//			player.setFill(Color.WHITE);
			player.setLayoutX((padding * (i + 1)) + playerHeight * i + (playerHeight / 2));
			player.setLayoutY(height/ 2);
			player.setOpacity(0);
			
			pane.getChildren().add(player);
		}
		
		this.getChildren().add(pane);
		
	}
	
	private void setOwner() {
		
		Circle circ = new Circle();
		circ.setFill(Color.WHITE);
		circ.setRadius(width * 0.32994 * 0.5 * 0.5);
		circ.setLayoutY(height / 2);
		circ.setLayoutX(isLeft ? totalWidth - (width * 0.71066) : width * 0.71066);
		
		this.getChildren().add(circ);
		
		this.owner = circ;
		
	}
	
	/**
	 * Lock the wanted position of the top left corner
	 * @param x
	 * @param y
	 */
	public void setCornerPos(double x, double y) {
		this.setLayoutX(isLeft ? x - totalWidth : x);
		this.setLayoutY(y);
	}
	
	private Circle getCircle(int num) {
		
		return (Circle) ((Pane) this.getChildren().get(0)).getChildren().get(num);
		
	}
	
	private int getAdjusted(int num) {
		
		return isLeft ? 3 - num : num;
		
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
		this.owner.setFill(col);
	}
	
	public double getTotalWidth() {
		return totalWidth;
	}

	public double getOutsideWidth() {
		return playersWidth;
	}
	
	public double getInsideWidth() {
		return width;
	}
	
	public double getBoardHeight() {
		return height;
	}
	
	
	
}
