package application;
	
import application.resources.Utils;
import application.resources.create.Init;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/sample.fxml")); // get fxml
		Parent root = loader.load();

        Utils utils = new Utils();
                
        Scene scene = new Scene(root, utils.screenSize().getWidth(), utils.screenSize().getHeight()); // set to screen width
        scene.getStylesheets().add(App.class.getResource("resources/styles.css").toExternalForm()); // get style sheet
        
        primaryStage.initStyle(StageStyle.UNDECORATED); // no bar
        primaryStage.setScene(scene);
        
        Init creator = new Init(loader.getController());
        creator.initPages(); // set up all pages
        
        ((MainController) loader.getController()).initSelect = creator.getInitSelect();
        ((MainController) loader.getController()).initPlay = creator.getInitPlay();
        ((MainController) loader.getController()).initHelp = creator.getInitHelp();
        
        ((MainController) loader.getController()).mainScene = scene;
        
        primaryStage.show();
                
        // once window is loaded set up 
        creator.afterShow();
	}
}
