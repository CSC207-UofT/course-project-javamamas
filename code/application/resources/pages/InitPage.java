package application.resources.pages;

import application.MainController;
import application.resources.Utils;
import application.resources.create.Init.DisplayInfo;

public class InitPage {
	
	private MainController controller;
	private DisplayInfo info;
	private Utils utils;
	private int animLength = 450;
	private double animPx; // size of animation in px
	private double percentAnim = 10; // % of height to animate

	public InitPage(MainController controller, DisplayInfo info) {
		
		this.controller = controller;
		this.info = info;
		utils = new Utils();
		animPx = utils.asPer(info.height, percentAnim);
		
	}
	
	public MainController getController() {
		return controller;
	}
	
	public DisplayInfo getDisplayInfo() {
		return info;
	}
	
	public Utils getUtils() {
		return utils;
	}
	
	public int getAnimLength() {
		return animLength;
	}
	
	public double getAnimPx() {
		return animPx;
	}
	
	public double startingY() {
		return info.startY + animPx;
	}
	
}
