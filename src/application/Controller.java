package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.resources.Utils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller implements Initializable {
    
	@FXML
	public Pane main; // main pane
	public Pane welcome, select; // pages
	public AnchorPane header; // header
	public Button exit, minimize; // exit and minimize buttons
	public Button prev, next; // prev and next navigation buttons
	
	private int currView = 0; // current page view number [0,3]
//	private Array
	
    @FXML
    private void exitClick(ActionEvent e) {
        Platform.exit();
    }
    
    @FXML
    private void minClick(ActionEvent e) {
        ((Stage) minimize.getScene().getWindow()).setIconified(true);
    }
    
    @FXML
    private void slideNext(ActionEvent e) {
    	System.out.println("next");
    	
    }
    
    @FXML
    private void slidePrev(ActionEvent e) {
    	System.out.println("prev");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resources) {}   
	
}
