package application;
	
import application.resources.Sizer;
import application.resources.Utils;
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
        
        Sizer resizer = new Sizer(loader.getController());
        resizer.setAllSizes(); // set all the sizes
        
        primaryStage.show();
	}
}
