package application.resources.pages.play;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CornerTile extends Pane implements AddableTile {
	
	private double sizeMult = 1.25; // the size multiplier to make room for players
	private double length, totalLength, playersLength;
	private boolean isLeft;
	private int numPlayers = 0;
	private ArrayList<String> names = new ArrayList<>();
	
	public CornerTile(double length, boolean isLeft) {
		
		names.add("_");
		names.add("_");
		names.add("_");
		names.add("_");
		
		this.length = length;
		this.playersLength = length * sizeMult;
		this.totalLength = length + playersLength;
		this.isLeft = isLeft;
		
		this.setPrefSize(totalLength, length);
		
		setPlayers();
		
	}
	
	private void setPlayers() {
		
		Pane pane = new Pane();
		pane.setPrefSize(playersLength, length);
		pane.setLayoutX(isLeft ? 0 : length);
		pane.setLayoutY(0);
		
		double playerHeight = playersLength / 5;
		double padding = playerHeight / 5;
		
		for (int i = 0; i != 4; i++) {
			Circle player = new Circle();
			player.setRadius(playerHeight / 2);
			player.setLayoutX((padding * (i + 1)) + playerHeight * i + (playerHeight / 2));
			player.setLayoutY(length / 2);
			player.setOpacity(0);
			
			pane.getChildren().add(player);
		}
		
		this.getChildren().add(pane);
		
	}
	
	/**
	 * Lock the wanted position of the top left corner
	 * @param x
	 * @param y
	 */
	public void setCornerPos(double x, double y) {
		this.setLayoutX(isLeft ? x - totalLength : x);
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
	}
}
