package application.resources.create;

import application.MainController;
import application.resources.Utils;
import application.resources.pages.help.InitHelp;
import application.resources.pages.play.InitPlay;
import application.resources.pages.select.InitSelect;
import application.resources.pages.welcome.InitWelcome;

/**
 * Set up all elements of window
 *
 */
public class Init {

	/**
	 * Class which contains size of usable screen after header has been set.
	 *
	 */
	public class DisplayInfo {
		public double width, height, startY;
		
		public DisplayInfo(double width, double height, double startY) {
			this.width = width;
			this.height = height;
			this.startY = startY;
		}
	}
	
	private MainController controller;
	private Utils utils;
	private DisplayInfo info;
	private InitWelcome welcome;
	private InitSelect select;
	private InitPlay play;
	private InitHelp help;
	
	public Init(MainController controller) {
		
		this.controller = controller;
		utils = new Utils();
		
		info = initHeader();
		
	}
	
	/**
	 * Set header size.
	 * 
	 * @return remaining height
	 */
	private DisplayInfo initHeader() {
		
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
		
		return new DisplayInfo(headerWidth, utils.sizeAsPerHeight(controller.main, 100) - headerHeight, headerHeight);
	}
	
	/**
	 * Initialize all pages.
	 */
	public void initPages() {
		
		welcome = new InitWelcome(controller, info);
		select = new InitSelect(controller, info);
		play = new InitPlay(controller, info);
		help = new InitHelp(controller);
		
	}
	
	/**
	 * Initialize all pages once window is shown
	 */
	public void afterShow() {
		
		welcome.initAfter();
		select.initAfter();
		play.initAfter();		
		
	}
	
	public DisplayInfo getDisplayInfo() {
		return info;
	}
	
	public InitSelect getInitSelect() {
		return select;
	}
	
	public InitPlay getInitPlay() {
		return play;
	}

	public InitHelp getInitHelp() {
		return help;
	}

}
