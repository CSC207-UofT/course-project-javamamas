package application.resources;

import application.Controller;

public class Sizer {

	private class Info {
		public double width, height, startY;
		
		public Info(double width, double height, double startY) {
			this.width = width;
			this.height = height;
			this.startY = startY;
		}
	}
	
	private Controller controller;
	private Utils utils;
	
	public Sizer(Controller controller) {
		
		this.controller = controller;
		utils = new Utils();
		
	}
	
	/**
	 * Set header sizes.
	 * 
	 * @return remaining height
	 */
	private Info initHeader() {
		
		double headerWidth = utils.sizeAsPerWidth(controller.main, 100);
		double headerHeight = utils.sizeAsPerWidth(controller.main, 3);
		controller.header.setPrefSize(headerWidth, headerHeight); // header size
		
		// exit button
		controller.exit.setPrefSize(headerHeight, headerHeight);
		controller.exit.setLayoutX(headerWidth - headerHeight);
		controller.exit.setLayoutY(0);
		
		// minimize button
		controller.minimize.setPrefSize(headerHeight, headerHeight);
		controller.minimize.setLayoutX(headerWidth - (headerHeight * 2) - 1);
		controller.minimize.setLayoutY(0);
		
		return new Info(headerWidth, utils.sizeAsPerHeight(controller.main, 100) - headerHeight, headerHeight);
	}
	
	/**
	 * Set sizes for welcome page.
	 * 
	 * @param info
	 */
	private void initWelcome(Info info) {
		
		controller.welcome.setLayoutY(info.startY);	
		controller.welcome.setPrefSize(info.width, info.height);
		
	}
	
	/**
	 * Set sizes for select page.
	 * 
	 * @param info
	 */
	private void initSelect(Info info) {
		
		controller.select.setLayoutY(info.startY);	
		controller.select.setPrefSize(info.width, info.height);
		
	}
	
	/**
	 * Set navigation button sizes.
	 * 
	 * @param info
	 */
	private void initButton(Info info) {
		
		double buttonSize = utils.asPer(info.width, 3);
		double adjust = buttonSize / 2;
		double yPos = utils.asPer(info.height, 50) - adjust + info.startY;
		
		controller.prev.setPrefSize(buttonSize, buttonSize);
		controller.prev.setLayoutX(utils.asPer(info.width, 10) - adjust);
		controller.prev.setLayoutY(yPos);
		controller.prev.setDisable(true); // disable initally
		
		controller.next.setPrefSize(buttonSize, buttonSize);
		controller.next.setLayoutX(utils.asPer(info.width, 90) - adjust);
		controller.next.setLayoutY(yPos);
		
	}
	
	/**
	 * Set all sizes for elements
	 */
	public void setAllSizes() {
		
		Info info = initHeader();
		
		initButton(info);
		initWelcome(info);
		initSelect(info);
		
	}
	
}
