package application.resources.pages.welcome;

import application.MainController;
import application.resources.create.Init.DisplayInfo;
import application.resources.pages.AfterPage;
import application.resources.pages.InitPage;
import javafx.scene.text.Font;

/**
 * set up welcome page
 *
 */
public class InitWelcome extends InitPage implements AfterPage {

    private int posPerX = 50; // x pos in %
    private int posPerY = 30; // y pos of title in %

    public InitWelcome(MainController controller, DisplayInfo info) {

        super(controller, info);

        setPage();
        setTitleSize();
        setAuthorSize();
        setPlaySize();

    }

    /**
     * set the page dimensions
     */
    private void setPage() {

        super.getController().welcome.setLayoutY(super.getDisplayInfo().startY);
        super.getController().welcome.setPrefSize(super.getDisplayInfo().width, super.getDisplayInfo().height);

    }

    /**
     * set the title size
     */
    private void setTitleSize() {

        super.getController().welcomeLabTitle.setFont(Font.font(150));

    }

    /**
     * set author size
     */
    private void setAuthorSize() {

        super.getController().welcomeLabAuthors.setFont(Font.font(20));

    }

    /**
     * set play button size
     */
    private void setPlaySize() {

        double length = super.getUtils().asPer(super.getDisplayInfo().width, 12);
        super.getController().welcomeBtnPlay.setPrefSize(length, length * 0.667);
        super.getController().welcomeBtnPlay.setFont(Font.font(length / 4));

    }

    @Override
    public void initAfter() {

        setTitlePos();
        setAuthorPos();
        setPlayPos();

    }

    /**
     * set title position
     */
    private void setTitlePos() {

        super.getController().welcomeLabTitle.setLayoutX(super.getUtils().asPer(super.getDisplayInfo().width, posPerX) - (super.getController().welcomeLabTitle.getWidth() / 2));
        super.getController().welcomeLabTitle.setLayoutY(super.getUtils().asPer(super.getDisplayInfo().height, posPerY) - (super.getController().welcomeLabTitle.getHeight() / 2));

    }

    /**
     * set author position
     */
    private void setAuthorPos() {

        super.getController().welcomeLabAuthors.setLayoutX(super.getUtils().asPer(super.getDisplayInfo().width, posPerX) - (super.getController().welcomeLabAuthors.getWidth() / 2));
        super.getController().welcomeLabAuthors.setLayoutY(super.getUtils().asPer(super.getDisplayInfo().height, posPerY) + (super.getController().welcomeLabTitle.getHeight() / 2));

    }

    /**
     * set play buttom position
     */
    private void setPlayPos() {

        super.getController().welcomeBtnPlay.setLayoutX(super.getUtils().asPer(super.getDisplayInfo().width, posPerX) - (super.getController().welcomeBtnPlay.getWidth() / 2));
        super.getController().welcomeBtnPlay.setLayoutY(super.getUtils().asPer(super.getDisplayInfo().height, 70) - (super.getController().welcomeBtnPlay.getHeight() / 2));

    }

}