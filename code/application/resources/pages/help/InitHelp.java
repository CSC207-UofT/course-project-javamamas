package application.resources.pages.help;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InitHelp {

	private MainController controller;
	public Scene InstructionPage1, InstructionPage2, InstructionPage3;
	
	
	public InitHelp(MainController controller) {
		
		this.controller = controller;
		
		try {
			setAll();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setAll() throws FileNotFoundException {
		

        Group group = new Group();
        Group group2 = new Group();
        Group group3 = new Group();

        //Monopoly Board Colour
        Color MonopolyColor = Color.web("BFDBAE");
        Color buttonColours = Color.web("8FBC72");
        
        String userDirectory = new File("").getAbsolutePath();
        String relDirectory = "\\src\\application\\resources\\pages\\help\\";
        String currDirectory = userDirectory + relDirectory;

        //Title
        Image title = new Image(new FileInputStream(currDirectory + "HowToPlayTitle.png"));
        ImageView titlePic = new ImageView(title);
        titlePic.setX(400);
        titlePic.setY(70);

        //Right Arrow
        Image arrow = new Image(new FileInputStream(currDirectory + "Arrow.png"));
        ImageView nextarrowRight = new ImageView(arrow);
        nextarrowRight.setFitWidth(50);
        nextarrowRight.setFitHeight(50);

        Stage stage = (Stage) controller.play.getScene().getWindow();
        
        //Left Arrow
        ImageView leftarrow = new ImageView (arrow);
        leftarrow.setFitWidth(50);
        leftarrow.setFitHeight(50);
        leftarrow.setRotate(180);

        //Second Right Arrow
        Image secondarrow = new Image(new FileInputStream(currDirectory + "Arrow.png"));
        ImageView secondnextarrowRight = new ImageView(secondarrow);
        secondnextarrowRight.setFitWidth(50);
        secondnextarrowRight.setFitHeight(50);

        //Second Left Arrow
        ImageView secondLeftArrow = new ImageView(secondarrow);
        secondLeftArrow.setFitWidth(50);
        secondLeftArrow.setFitHeight(50);
        secondLeftArrow.setRotate(180);

        //Home Page Image
        Image MonopolyMan = new Image (new FileInputStream(currDirectory + "MonopolyMan.png"));
        ImageView homeIcon = new ImageView(MonopolyMan);
        homeIcon.setFitHeight(25);
        homeIcon.setFitWidth(25);

        //Next Page Button
        Button nextpage = new Button("", nextarrowRight);
        nextpage.setStyle("-fx-background-color: #8FBC72; -fx-border-color: #000000;" +
                " -fx-border-width: 1px; -fx-font-size:14");
        nextpage.setPrefSize(120, 75);
        nextpage.setLayoutX(1100);
        nextpage.setLayoutY(700);

        //Home Page Button
        Button homepage = new Button ("Back to Main", homeIcon);
        homepage.setStyle("-fx-background-color: #8FBC72; -fx-border-color: #000000;" +
                " -fx-border-width: 1px; -fx-font-size:14");
        homepage.setPrefSize(150, 75);
        homepage.setLayoutX(300);
        homepage.setLayoutY(700);
        
        homepage.setOnMouseClicked(e -> {
            stage.setScene(controller.mainScene);
            stage.show();
        });

        //Second Scene Right Button
        Button rightbutton = new Button("", secondnextarrowRight);
        rightbutton.setStyle("-fx-background-color: #8FBC72; -fx-border-color: #000000;" +
                " -fx-border-width: 1px; -fx-font-size:14");
        rightbutton.setPrefSize(120, 75);
        rightbutton.setLayoutX(1100);
        rightbutton.setLayoutY(700);

        //Second Scene Left Button
        Button leftbutton = new Button ("", secondLeftArrow);
        leftbutton.setStyle("-fx-background-color: #8FBC72; -fx-border-color: #000000;" +
                " -fx-border-width: 1px; -fx-font-size:14");
        leftbutton.setPrefSize(120, 75);
        leftbutton.setLayoutX(300);
        leftbutton.setLayoutY(700);

        //Third Scene Left Button
        Button SecondLeftbutton = new Button ("", leftarrow);
        SecondLeftbutton.setStyle("-fx-background-color: #8FBC72; -fx-border-color: #000000;" +
                " -fx-border-width: 1px; -fx-font-size:14");
        SecondLeftbutton.setPrefSize(120, 75);
        SecondLeftbutton.setLayoutX(300);
        SecondLeftbutton.setLayoutY(700);

        //TEXT FOR INSTRUCTION PAGES

        //Objective
        Text objective = new Text(400, 250, "OBJECTIVE - ");
        objective.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text objectiveText = new Text(600, 250, "The object of the game is to become the " +
                "wealthiest player through buying and renting property.");
        objectiveText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        objectiveText.setWrappingWidth(500);

        //Play
        Text play = new Text(400, 350, "THE PLAY - ");
        play.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text playText = new Text(600, 350, "When it's your turn, roll the die. Your token will start on " +
                "the corner marked, and will move in the direction of the arrow the number of spaces " +
                "indicated by the dice. After you have completed your play, the turn passes to the next " +
                "player. The tokens remain on the spaces occupied and proceed from that point on the player's next " +
                "turn. Two or more tokens may rest on the same space at the same time. According to the space your " +
                "token reaches, you may be entitled to buy real estate or other properties or obliged to pay rent, " +
                "pay taxes, draw a Community Chest card, to Jail, etc.");
        playText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        playText.setWrappingWidth(500);

        //Go
        Text Go = new Text (400, 100, "Go -");
        Go.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Text goText = new Text (600, 100, "Each time a player's token lands on or passes over GO, " +
                "whether by throwing the dice or drawing a card, the Bank pays him/her a $200 salary. The $200 " +
                "is paid only once each time around the board.");
        goText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        goText.setWrappingWidth(500);

        //Buying Property
        Text buyingProperty = new Text (400, 220, "BUYING PROPERTY -");
        buyingProperty.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        buyingProperty.setWrappingWidth(120);

        Text buyingPropertytext = new Text (600, 220, "Whenever you land on an unowned property you may " +
                "buy that property from the Bank at its marked price. If you do not wish to buy the property, the " +
                "property may remain unowned.");
        buyingPropertytext.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        buyingPropertytext.setWrappingWidth(500);

        //Paying Rent
        Text payingRent = new Text (400, 340, "PAYING RENT -");
        payingRent.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        payingRent.setWrappingWidth(120);

        Text payingRenttext = new Text (600, 340, "When you land on a property owned by another " +
                "player, the owner collects rent from you");
        payingRenttext.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        payingRenttext.setWrappingWidth(500);

        //Community Chance
        Text communityChance = new Text (400, 420, "COMMUNITY CHANCE -");
        communityChance.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        communityChance.setWrappingWidth(150);

        Text communityChancetext = new Text (600, 420, "When you land on a property owned by another " +
                "player, the owner collects rent from you");
        communityChancetext.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        communityChancetext.setWrappingWidth(500);

        //Jail
        Text Jail = new Text (400, 100, "JAIL -");
        Jail.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Jail.setWrappingWidth(150);

        Text Jailtext = new Text (600, 100, "You land in Jail when your token lands on the space" +
                " marked Go to Jail; When you are sent to Jail you cannot collect your $200 salary in that" +
                " move since, regardless of where your token is on the board, you must move it directly into " +
                "Jail. Your turn ends when you are sent to Jail. If you are not sent to Jail but in the ordinary " +
                "course of play land on that space, you are Just Visiting, you incur no penalty, and you move " +
                "ahead in the usual manner on your next turn. You get out of Jail by missing three turns. You " +
                "cannot collect rent if you are in jail.");
        Jailtext.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        Jailtext.setWrappingWidth(500);

        //Free Parking
        Text freeParking = new Text (400, 400, "FREE PARKING -");
        freeParking.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        freeParking.setWrappingWidth(175);

        Text freeParkingText = new Text (600, 400, "A player landing on this place does not receive " +
                "any money, property or reward of any kind. This is just a free resting place.");
        freeParkingText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        freeParkingText.setWrappingWidth(500);

        //Bankruptcy
        Text bankruptcy = new Text (400, 500, "BANKRUPTCY -");
        bankruptcy.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        bankruptcy.setWrappingWidth(175);

        Text bankruptcyText = new Text (600, 500, "You are declared bankrupt if you owe more than" +
                " you can pay either to another player or to the Bank. If your debt is to another player, you must" +
                " turn over to that player all that you have of value and retire from the game.\n");
        bankruptcyText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        bankruptcyText.setWrappingWidth(500);

        //End of Game
        Text endOfGame = new Text (400, 640, "END OF GAME -");
        endOfGame.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 20));
        endOfGame.setWrappingWidth(175);

        Text endOfGameText = new Text (600, 640, "The game ends when there is one player left in " +
                "the game, creating a monopoly. This will be if all the players go bankrupt or if all the properties" +
                "are sold.");
        endOfGameText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 20));
        endOfGameText.setWrappingWidth(500);

        Image monopolyMan = monopolyMan = new Image(new FileInputStream(currDirectory + "MonopolyMan.gif"));
        ImageView monopolyManpic = new ImageView (monopolyMan);
        monopolyManpic.setX(600);
        monopolyManpic.setY(500);
        monopolyManpic.setFitHeight(300);
        monopolyManpic.setFitWidth(300);

        group.getChildren().addAll(nextpage, homepage, titlePic, objective, objectiveText, play, playText);
        group2.getChildren().addAll(leftbutton, rightbutton, Go, goText, buyingProperty, buyingPropertytext,
                payingRent, payingRenttext, communityChance, communityChancetext, Jail, Jailtext, monopolyManpic);
        group3.getChildren().addAll(SecondLeftbutton, Jail, Jailtext, freeParking, freeParkingText, bankruptcy,
                bankruptcyText, endOfGame, endOfGameText);

        InstructionPage1 = new Scene(group, 1504, 963, MonopolyColor);
        InstructionPage2 = new Scene (group2, 1504, 963, MonopolyColor);
        InstructionPage3 = new Scene (group3, 1504, 963, MonopolyColor);
        
        nextpage.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.setScene(InstructionPage2);
                stage.show();
            }
        });

        leftbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.setScene(InstructionPage1);
                stage.show();
            }
        });

        rightbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.setScene(InstructionPage3);
                stage.show();
            }
        });

        SecondLeftbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.setScene(InstructionPage2);
                stage.show();
            }
        });        
	}
}
