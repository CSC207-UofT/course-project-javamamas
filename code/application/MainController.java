package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.backend.controllers.move.MoveController;
import application.resources.Animate;
import application.resources.Utils;
import application.resources.animations.Bezier;
import application.resources.pages.Create;
import application.resources.pages.help.InitHelp;
import application.resources.pages.play.ControllerPlay;
import application.resources.pages.play.InitPlay;
import application.resources.pages.select.ControllerSelect;
import application.resources.pages.select.InitSelect;
import application.resources.pages.welcome.ControllerWelcome;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainController implements Initializable {
    
	@FXML
	public Pane main; // main pane
	
	// welcome page
	@FXML public Pane welcome;
	@FXML public Label welcomeLabAuthors, welcomeLabTitle;
	@FXML public Button welcomeBtnPlay;
	
	// select page
	@FXML public Pane select;
	@FXML public Pane selectPanePlayers, selectPaneOne, selectPaneTwo, selectPaneThree, selectPaneFour; // entire player pane wrapper
	@FXML public Pane selectImageOne, selectImageTwo, selectImageThree, selectImageFour; // image display wrapper pane
	@FXML public TextField selectTextOne, selectTextTwo, selectTextThree, selectTextFour; // text fields for player name
	@FXML public ImageView selectDisplayOne, selectDisplayTwo, selectDisplayThree, selectDisplayFour; // image display for player photo
	@FXML public Label selectLabOne, selectLabTwo, selectLabThree, selectLabFour; // click to select image labels
	@FXML public Label selectLabTitle; // title
	@FXML public Button selectBtnNext; // to next page

	// play page
	@FXML public Pane play;
	@FXML public ImageView view;
	@FXML public Circle playCircleRoller;
	
	public InitSelect initSelect; // init select object
	public InitPlay initPlay; // init play object
	public InitHelp initHelp;
	public MoveController moveController;	
	public ArrayList<Image> images; // images for players
	public ArrayList<Pane> tiles;
	public ArrayList<String> names;
	public Scene mainScene;
	
	public Pane howPlay; // how to play page
	public AnchorPane header; // header
	public Button exit, minimize; // exit and minimize buttons
	public Button prev, next, help; // prev, next navigation buttons
	
	public Create.Info info;

	private Utils utils = new Utils();
	
    @FXML
    private void exitClick(ActionEvent e) {
        Platform.exit();
    }
    
    @FXML
    private void minClick(ActionEvent e) {
        ((Stage) minimize.getScene().getWindow()).setIconified(true);
    }
    
    @FXML
    private void displayHelp(ActionEvent e) {
    	
    	System.out.println("help");
    	
    	double animHeight = utils.asPer(info.height, Utils.slideAnimPer);
    	
    	howPlay.toFront();
    	header.toFront();
    	help.toFront();
    	
    	Animate.applyAnimVer(howPlay, Bezier.genEaseIn(animHeight));
    	
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {
    	images = new ArrayList<>();
    	images.add(null);
    	images.add(null);
    	images.add(null);
    	images.add(null);
    	
    	ControllerWelcome controllerWelcome = new ControllerWelcome(this); // need to pass the InitSelected object
    	ControllerSelect controllerSelect = new ControllerSelect(this); 
    	ControllerPlay controllerPlay = new ControllerPlay(this);
    	
    	moveController = new MoveController();
    	
    }   
	
}
