package application.resources.pages.play;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import application.MainController;
import application.resources.animations.Bezier;
import application.resources.create.Init.DisplayInfo;
import application.resources.pages.AfterPage;
import application.resources.pages.InitPage;
import application.resources.pages.TransitionPage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class InitPlay extends InitPage implements TransitionPage, AfterPage {

	private Bezier bezier;
	private ArrayList<Pane> tiles;
	private ArrayList<String> words;
	private BoardInfo infoBoard;
	private ArrayList<Color> playerColors = new ArrayList<>();
	
	private class BoardInfo {
		
		public double width, height, startX, startY;
		
		public BoardInfo(double width, double height, double startX, double startY) {
			this.width = width;
			this.height = height;
			this.startX = startX;
			this.startY = startY;
		}
		
	}
	
	public InitPlay(MainController controller, DisplayInfo info) {
		
		super(controller, info);
		
		tiles = new ArrayList<>();
		
		words = new ArrayList<>();
		words.add("One");
		words.add("Two");
		words.add("Three");
		words.add("Four");
		
		playerColors.add(Color.BLUE);
		playerColors.add(Color.GREEN);
		playerColors.add(Color.ORANGE);
		playerColors.add(Color.BLACK);
		
		setPage();
		BoardInfo infoBoard = genBaord();
		this.infoBoard = infoBoard;
		setBoardImg(infoBoard);
		setPlayerInfo(infoBoard);
//		setChance(infoBoard);
		setButtons(infoBoard);
		setRoller(infoBoard);
		setHelp();
		
	}
	
	private void setPage() {
		
		super.getController().play.setPrefSize(
				super.getDisplayInfo().width, 
				super.getDisplayInfo().height
		);
		super.getController().play.setLayoutY(super.startingY());
		super.getController().play.setOpacity(0);
		super.getController().play.toBack();
		
	}

	private void genBottomRow(double startX, double startY, double width, double height) {
		
		for (int i = 8; i != -1; i--) {			
			VerticalTile pane = new VerticalTile(width, height, false, super.getController().moveController.isBuyable(2 + (8 - i)));
			pane.setCornerPos(startX + height + (i * width), startY + height + (width * 9));
			
			super.getController().play.getChildren().add(pane);
			tiles.add(pane);
		}
	}
	
	private void genLeftCol(double startX, double startY, double width, double height) {
		for (int i = 0; i != 9; i++) {
			HorizontalTile pane = new HorizontalTile(width, height, true, super.getController().moveController.isBuyable(12 + i));
			pane.setCornerPos(startX + width, startY + width + ((8 - i) * height));
			
			super.getController().play.getChildren().add(pane);
			tiles.add(pane);
		}
	}
	
	private void genTopRow(double startX, double startY, double width, double height) {		
		for (int i = 0; i != 9; i++) {
			VerticalTile pane = new VerticalTile(width, height, true, super.getController().moveController.isBuyable(22 + i));
			pane.setCornerPos(startX + height + (i * width), startY);
			
			super.getController().play.getChildren().add(pane);
			tiles.add(pane);
		}
	}
	
	private void genRightCol(double startX, double startY, double width, double height) {
		for (int i = 0; i != 9; i++) {			
			HorizontalTile pane = new HorizontalTile(width, height, false, super.getController().moveController.isBuyable(32 + i));
			pane.setCornerPos(startX + width + (height * 9), startY + width + (i * height));
			
			super.getController().play.getChildren().add(pane);
			tiles.add(pane);
		}
	}
	
	private BoardInfo genBaord() {
		
		double boardsize = super.getUtils().asPer(super.getDisplayInfo().height, 90);
		double startX = (super.getDisplayInfo().width - boardsize) / 2; // top left X pos
		double startY = super.getUtils().asPer(super.getDisplayInfo().height, 5); // top left Y pos
		double cornerSize = boardsize * 0.125;
		double horHeight = (boardsize - (2 * cornerSize)) / 9; // the height of horizontal tile
		
		// start at go (bottom right), go clockwise for panels
		
		CornerTile go = new CornerTile(cornerSize, false);
		go.setCornerPos(startX + cornerSize + (horHeight * 9), startY + cornerSize + (horHeight * 9));
		super.getController().play.getChildren().add(go);
		tiles.add(go);
		genBottomRow(startX, startY, horHeight, cornerSize);		
		
		CornerTile jail = new CornerTile(cornerSize, true);
		jail.setCornerPos(startX + cornerSize, startY + cornerSize + (horHeight * 9));
		super.getController().play.getChildren().add(jail);
		tiles.add(jail);
		genLeftCol(startX, startY, cornerSize, horHeight);

		CornerTile free = new CornerTile(cornerSize, true);
		free.setCornerPos(startX + cornerSize, startY);
		super.getController().play.getChildren().add(free);
		tiles.add(free);
		genTopRow(startX, startY, horHeight, cornerSize);
		
		CornerTile goTo = new CornerTile(cornerSize, false);
		goTo.setCornerPos(startX + cornerSize + (horHeight * 9), startY);
		super.getController().play.getChildren().add(goTo);
		tiles.add(goTo);
		genRightCol(startX, startY, cornerSize, horHeight);
		
		double extraWidth = ((HorizontalTile) tiles.get(11)).getOutsideWidth();
		
		super.getController().tiles = tiles;
		
		return new BoardInfo(boardsize + (2 * extraWidth), boardsize, startX - extraWidth , startY);
		
	}
	
	/**
	 * Set image slots of players for tiles
	 */
	public void setBoardImg(BoardInfo info) {
		
		ImageView imgView = (ImageView) super.getController().play.lookup("#playImgBoard");
		try {
			
			Image img = new Image(new FileInputStream("C:\\Users\\jboob\\eclipse-workspace\\Test2\\src\\application\\resources\\board.png"));
			imgView.setImage(img);
			imgView.setFitWidth(info.height);
			imgView.setFitHeight(info.height);
			imgView.setLayoutX(info.startX + ((HorizontalTile) tiles.get(11)).getOutsideWidth());
			imgView.setLayoutY(info.startY);
			imgView.toFront();
//			imgView.setOpacity(0.5);
			imgView.setMouseTransparent(true);
			imgView.toBack();
			
		} catch (FileNotFoundException e) { System.out.println("yurr");
		} catch (NullPointerException e2) {System.out.println("yuh");}
		
	}
	
	/**
	 * set where players balance is displayed
	 */
	private void setPlayerInfo(BoardInfo info) {
		
		Pane wrapper = (Pane) super.getController().play.lookup("#playPanePlayers");
		double wrapperWidth = super.getUtils().asPer((super.getDisplayInfo().width - info.height) / 2, 50);
		double wrapperHeight = super.getUtils().asPer(super.getDisplayInfo().height, 50);
		wrapper.setPrefSize(
				wrapperWidth,
				wrapperHeight
		);
		wrapper.setLayoutX(wrapperWidth * 0.15);
		wrapper.setLayoutY(super.getUtils().asPer(super.getDisplayInfo().height, 50) - (wrapperHeight / 2));
		
		int numPlayers = 4;
		double playerWidthOuter = wrapperWidth * 0.35;
		double vertPadding = (wrapperHeight - (playerWidthOuter * 4)) / 5;		
		for (int i = 0; i != numPlayers; i++) {
			Circle outer = new Circle();
			outer.setId("playCircle" + words.get(i));
			outer.setRadius(playerWidthOuter / 2);
			double midY = (vertPadding * (i + 1)) + (i * playerWidthOuter) + (playerWidthOuter / 2);
			outer.setLayoutY(midY);
			outer.setLayoutX((playerWidthOuter / 2) + super.getUtils().asPer(wrapperWidth, 2.5));
			outer.setStroke(playerColors.get(i));
			outer.setStrokeWidth(playerWidthOuter * 0.1);
			wrapper.getChildren().add(outer);
			
			Label label = new Label();
			label.setId("playLabPlayer" + words.get(i));
			label.setText("500");
			label.setFont(Font.font(playerWidthOuter / 2));
			wrapper.getChildren().add(label);			
		}
	}
	
	private void setChance(BoardInfo info) {
				
		Pane wrapper = new Pane();
		
		double remaining = (super.getDisplayInfo().width - info.width) / 2;
		double wrapperWidth = super.getUtils().asPer(remaining, 75);
		double wrapperHeight = super.getUtils().asPer(super.getDisplayInfo().height, 30);
		wrapper.setPrefSize( 
				wrapperWidth, 
				wrapperHeight 
		);
		wrapper.setLayoutX(info.startX + info.width + (remaining / 2) - (wrapperWidth / 2));
		wrapper.setLayoutY(info.startY + ((HorizontalTile) tiles.get(39)).getInsideWidth());
		wrapper.setStyle("-fx-background-color: rgb(0,0,0);");
		
		Label title = new Label("Chest");
		title.setFont(Font.font(wrapperHeight / 8));
		title.setTextFill(Color.WHITE);
		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(wrapperWidth, wrapperHeight * 0.5);
		vbox.setLayoutX(0);
		vbox.setLayoutY(0);
		
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setPrefSize(wrapperWidth, wrapperHeight * 0.5);
		hbox.setLayoutX(0);
		hbox.setLayoutY(0);
		
		hbox.getChildren().add(title);
		vbox.getChildren().add(hbox);
		wrapper.getChildren().add(vbox);
		
		super.getController().play.getChildren().add(wrapper);

	}

	private void setButtons(BoardInfo info) {
		
		double chanceEnd = info.startY + 
				((HorizontalTile) tiles.get(39)).getInsideWidth() + 
				super.getUtils().asPer(super.getDisplayInfo().height, 30);
		double remaining = (super.getDisplayInfo().width - info.width) / 2;
		double buttonPadding = super.getUtils().asPer(super.getDisplayInfo().height, 5);
		
//		Button buy = new Button();
//		buy.setId("playBtnBuy");
		Button buy = (Button) super.getController().play.lookup("#playBtnBuy");
		double buttonWidth = remaining * 0.5;
		double buttonHeight = buttonWidth * 0.667;
		buy.setPrefSize(buttonWidth, buttonHeight);
		buy.setLayoutX(info.startX + info.width + (remaining / 2) - (buttonWidth / 2));
		buy.setLayoutY(chanceEnd + buttonPadding);
		buy.setStyle("-fx-background-color: rgb(143,188,114);");
//		super.getController().play.getChildren().add(buy);
		
		Label title = new Label("Buy");
		title.setFont(Font.font(buttonHeight / 2));
		title.setTextFill(Color.BLACK);
		title.setMouseTransparent(true);
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(buttonWidth, buttonHeight);
		vbox.setLayoutX(info.startX + info.width + (remaining / 2) - (buttonWidth / 2));
		vbox.setLayoutY(chanceEnd + buttonPadding);
		HBox hbox = new HBox();
		hbox.setMouseTransparent(true);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPrefSize(buttonWidth, buttonHeight);
		hbox.setLayoutX(0);
		hbox.setLayoutY(0);
		hbox.getChildren().add(title);
		vbox.getChildren().add(hbox);
		vbox.setMouseTransparent(true);
		super.getController().play.getChildren().add(vbox);
		
		
		double newEnd = chanceEnd + buttonPadding + buttonHeight;
		
		Button sell = new Button();
		sell.setPrefSize(buttonWidth, buttonHeight);
		sell.setLayoutX(info.startX + info.width + (remaining / 2) - (buttonWidth / 2));
		sell.setLayoutY(newEnd + buttonPadding);
		sell.setStyle("-fx-background-color: rgb(143,188,114);");
		super.getController().play.getChildren().add(sell);
		
		Label title2 = new Label("Sell");
		title2.setFont(Font.font(buttonHeight / 2));
		title2.setTextFill(Color.BLACK);
		VBox vbox2 = new VBox();
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setPrefSize(buttonWidth, buttonHeight);
		vbox2.setLayoutX(info.startX + info.width + (remaining / 2) - (buttonWidth / 2));
		vbox2.setLayoutY(newEnd + buttonPadding);
		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setPrefSize(buttonWidth, buttonHeight);
		hbox2.setLayoutX(0);
		hbox2.setLayoutY(0);
		hbox2.getChildren().add(title2);
		vbox2.getChildren().add(hbox2);
		super.getController().play.getChildren().add(vbox2);
		
	}
	
	private void setRoller(BoardInfo info) {
		
		double radius = ((HorizontalTile) tiles.get(39)).getBoardHeight() * 0.75;
		
		Circle circle = (Circle) super.getController().play.lookup("#playCircleRoller");
		circle.setRadius(radius);
		double mid = ((info.startY + info.height - ((HorizontalTile) tiles.get(39)).getTotalWidth()) + (super.getDisplayInfo().height / 2)) / 2;
		circle.setLayoutY(mid);
		circle.setLayoutX(super.getDisplayInfo().width / 2);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(radius * 0.1);
//		circle.toFront();
		
		Label label = new Label("5");
		label.setMouseTransparent(true);
		label.setId("playRollerLab");
		label.setFont(Font.font(radius * 1.75));
		label.setTextFill(Color.BLACK);
		super.getController().play.getChildren().add(label);
//		label.toFront();
		
	}
	
	private void setHelp() {
		
		Button help = (Button) super.getController().play.lookup("#playBtnHelp");
		double buttonSize = super.getUtils().asPer(super.getDisplayInfo().width, 3);
		double padding = super.getUtils().asPer(super.getDisplayInfo().width, 0.5);
		help.setPrefSize(buttonSize, buttonSize);
		help.setLayoutX(super.getDisplayInfo().width - padding - buttonSize);
		help.setLayoutY(padding);
		help.setStyle("-fx-background-color: rgb(143,188,114);");
		
		Label title = new Label("?");
		title.setFont(Font.font(buttonSize / 2));
		title.setTextFill(Color.BLACK);
		title.setMouseTransparent(true);
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(buttonSize, buttonSize);
		vbox.setLayoutX(super.getDisplayInfo().width - padding - buttonSize);
		vbox.setLayoutY(padding);
		HBox hbox = new HBox();
		hbox.setMouseTransparent(true);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPrefSize(buttonSize, buttonSize);
		hbox.setLayoutX(0);
		hbox.setLayoutY(0);
		hbox.getChildren().add(title);
		vbox.getChildren().add(hbox);
		vbox.setMouseTransparent(true);
		super.getController().play.getChildren().add(vbox);
		
	}
	
	@Override
	public void initAfter() {
		
		bezier = new Bezier(getAnimLength(), 0, super.getAnimPx(), super.getAnimPx());
		
		setLabelsPos();
		setRollerPos();
		
	}
	
	private void setLabelsPos() {
		
		Pane wrapper = (Pane) super.getController().play.lookup("#playPanePlayers");
		
		int numPlayers = 4;
		double wrapperWidth = wrapper.getWidth();
		double wrapperHeight = wrapper.getHeight();
		double playerWidthOuter = wrapperWidth * 0.35;
		double vertPadding = (wrapperHeight - (playerWidthOuter * 4)) / 5;	
		for (int i = 0; i != numPlayers; i++) {
			Label label = (Label) wrapper.lookup("#playLabPlayer" + words.get(i));
			double midY = (vertPadding * (i + 1)) + (i * playerWidthOuter) + (playerWidthOuter / 2);
			label.setLayoutY(midY - (label.getHeight() / 2));
			label.setLayoutX(playerWidthOuter + (playerWidthOuter * 0.35));
		}
		
	}

	/**
	 * Add players. True if to add this player
	 */
	private void addPlayers(ArrayList<Boolean> arr) {
		
		Pane wrapper = (Pane) super.getController().play.lookup("#playPanePlayers");
		
		int j = 0;
		for (int i = 0; i != arr.size(); i++) {
			if (arr.get(i)) {
				Image img = super.getController().images.get(i);
				((Circle) wrapper.lookup("#playCircle" + words.get(j))).setFill(new ImagePattern(img));
				((AddableTile) tiles.get(0)).addPlayer(img, super.getController().names.get(j));
				System.out.println("name " + super.getController().names.get(j));
				j++;
			}
		}
		
		for (int i = j; i != arr.size(); i++) {
			((Circle) wrapper.lookup("#playCircle" + words.get(i))).setOpacity(0);
			((Label) wrapper.lookup("#playLabPlayer" + words.get(i))).setOpacity(0);
		}
		
		
	}
	
	private void setRollerPos() {
		
		double mid = (((infoBoard.startY + infoBoard.height - ((HorizontalTile) tiles.get(39)).getTotalWidth()) + (super.getDisplayInfo().height / 2)) / 2);
		Label label = (Label) super.getController().play.lookup("#playRollerLab");
		label.setLayoutY(mid - (label.getHeight() / 2));
		label.setLayoutX((super.getDisplayInfo().width / 2) - (label.getWidth() / 2));
		label.setText("");
		
	}
	
	@Override
	public void in() {
		
		ArrayList<Image> imgs = super.getController().images;
		ArrayList<Boolean> bools = new ArrayList<>();
		for (Image img : imgs) {
			bools.add(img != null);
		}
		addPlayers(bools);
		
		Pane pane = super.getController().play;
		pane.toFront();
		double maxInterval = bezier.getMaxInterval();
		double start = super.startingY();
		double end = super.getDisplayInfo().startY;
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		  int i = 0;
		  @Override
		  public void run() {
			  Bezier.BezierInfo bezierRes = bezier.calc(i);
			  pane.setLayoutY(start - bezierRes.curr);
			  pane.setOpacity(i / maxInterval);
			  
			  if (i >= maxInterval) {
				  pane.setOpacity(1);
				  pane.setLayoutY(end);
				  timer.cancel();
			  }
			  i++;
		  }
		}, 0, Math.round(bezier.getTimeDelta()));
		
	}

	@Override
	public void out() {}
	
}
