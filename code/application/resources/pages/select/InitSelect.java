package application.resources.pages.select;

import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class InitSelect extends InitPage implements TransitionPage, AfterPage {

    private Bezier bezier;
    private ArrayList<String> words;

    public InitSelect(MainController controller, DisplayInfo info) {

        super(controller, info);

        words = new ArrayList<>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");

        setPage();
        setChooseSize();
        setBtnSize();

    }

    /**
     * set the page dimensions
     */
    private void setPage() {

        super.getController().select.setLayoutY(super.startingY());
        super.getController().select.setPrefSize(super.getDisplayInfo().width, super.getDisplayInfo().height);
        super.getController().select.setOpacity(0);
        super.getController().select.toBack();

    }

    /**
     * set the players box size
     */
    private void setChooseSize() {

        super.getController().selectPanePlayers.setPrefSize(
                super.getUtils().asPer(super.getDisplayInfo().width, 70),
                super.getUtils().asPer(super.getDisplayInfo().height, 40)
        );

    }

    /**
     * set the button size
     */
    private void setBtnSize() {

        double length = super.getUtils().asPer(super.getDisplayInfo().width, 15);
        super.getController().selectBtnNext.setPrefSize(length, length * 0.667);
        super.getController().selectBtnNext.setLayoutX(super.getUtils().asPer(super.getDisplayInfo().width, 50) - (length / 2));
        super.getController().selectBtnNext.setLayoutY(
                super.getUtils().asPer(super.getDisplayInfo().height, 85) -
                        ((length * 0.667) / 2)
        );


    }

    @Override
    public void in() {

        Pane pane = super.getController().select;
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
    public void out() {



    }

    @Override
    public void initAfter() {

        bezier = new Bezier(getAnimLength(), 0, super.getAnimPx(), super.getAnimPx());

        setChoosePos();
        setPlayers();

    }

    /**
     * set the players box pos
     */
    private void setChoosePos() {

        super.getController().selectPanePlayers.setLayoutX(
                super.getUtils().asPer(super.getDisplayInfo().width, 50) -
                        (super.getController().selectPanePlayers.getWidth() / 2)
        );
        super.getController().selectPanePlayers.setLayoutY(
                super.getUtils().asPer(super.getDisplayInfo().height, 30)
        );

    }

    /**
     * Select image
     */
    private void addClickImage(Pane imagePane, int pos, double width, double height) {

        VBox vbox = (VBox) imagePane.getChildren().get(0);
        vbox.setPrefSize(super.getUtils().asPer(width, 80), super.getUtils().asPer(height, 60));
        HBox hbox = (HBox) vbox.getChildren().get(0);
        hbox.setPrefSize(super.getUtils().asPer(width, 80), super.getUtils().asPer(height, 60));

        imagePane.setOnMouseClicked(e -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("*.png", "*.jpeg", "*.jpg");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(imagePane.getScene().getWindow());

            try {

                Image img = new Image(new FileInputStream(file.getAbsolutePath()));

                if (super.getController().images.get(pos) == null) {
                    ((Pane) ((Pane) imagePane.getChildren().get(0)).getChildren().get(0)).getChildren().remove(0); // remove label
                }

                ImageView view = (ImageView) imagePane.lookup("#selectDisplay" + words.get(pos));
                view.setFitHeight(imagePane.getHeight());
                view.setFitWidth(imagePane.getWidth());
                view.setPreserveRatio(true);
                view.setImage(img);
                view.toFront();

                super.getController().images.set(pos, img);

            } catch (FileNotFoundException e1) {
            } catch (NullPointerException e2) {
            }
        });

    }

    private void setPlayerPane(Pane pane, int pos, double width, double height) {

        pane.setPrefSize(width, height);
        pane.setLayoutY(0);
        pane.setLayoutX(pos * width);

        TextField field = ((TextField) pane.lookup("#selectText" + words.get(pos)));
        field.setPrefSize(
                super.getUtils().asPer(width, 80),
                super.getUtils().asPer(height, 10)
        );
        field.setLayoutX(super.getUtils().asPer(width, 10));
        field.setLayoutY(super.getUtils().asPer(height, 10));

        Pane imagePane = (Pane) pane.lookup("#selectImage" + words.get(pos));
        imagePane.setPrefSize(
                super.getUtils().asPer(width, 80),
                super.getUtils().asPer(height, 60)
        );
        imagePane.setLayoutX(super.getUtils().asPer(width, 10));
        imagePane.setLayoutY(super.getUtils().asPer(height, 35));
        imagePane.setStyle("-fx-background-color: rgb(255,255,255);");
        addClickImage(imagePane, pos, width, height);

        ((Label) pane.lookup("#selectLab" + words.get(pos))).setFont(Font.font(20));

    }

    private void setPlayers() {

        double width = super.getController().selectPanePlayers.getWidth() / words.size();
        double height = super.getController().selectPanePlayers.getHeight();

        for (int i = 0; i != words.size(); i++) {
            Pane pane = (Pane) super.getController().selectPanePlayers.lookup("#selectPane" + words.get(i));
            setPlayerPane(pane, i, width, height);
        }
    }

}