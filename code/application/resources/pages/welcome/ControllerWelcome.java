package application.resources.pages.welcome;

import application.MainController;

public class ControllerWelcome {

    private MainController controller;

    public ControllerWelcome(MainController controller) {

        this.controller = controller;

        onEnter();
        onExit();
        onClick();

    }

    /**
     * on mouse enter play button
     */
    private void onEnter() {

        controller.welcomeBtnPlay.setOnMouseEntered(e -> {
            controller.welcomeBtnPlay.setStyle("-fx-background-color: rgb(0,128,0);");
        });

    }

    /**
     * on mouse exit play button
     */
    private void onExit() {

        controller.welcomeBtnPlay.setOnMouseExited(e -> {
            controller.welcomeBtnPlay.setStyle("-fx-background-color: rgb(143,188,114);");
        });

    }

    /**
     * on mouse click play button
     */
    private void onClick() {

        controller.welcomeBtnPlay.setOnMouseClicked(e -> {
            controller.initSelect.in(); // animate page in
        });

    }

}