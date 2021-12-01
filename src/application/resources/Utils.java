package application.resources;

import java.awt.*;

import javafx.scene.layout.Pane;

public class Utils {

	/**
	 * 
	 * @return size of usable screen
	 */
	public Rectangle screenSize() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	}
	
	/**
	 * 
	 * @param parent parent pane
	 * @param per percent of width [0, 100]
	 * @return double in px which is <per> wide of width of parent
	 */
	public double sizeAsPerWidth(Pane parent, double per) {
		return parent.getWidth() * (per / 100);
	}
	
	/**
	 * 
	 * @param parent parent pane
	 * @param per percent of height [0, 100]
	 * @return double in px which is <per> high of height of parent
	 */
	public double sizeAsPerHeight(Pane parent, double per) {
		return parent.getHeight() * (per / 100);
	}
	
	/**
	 * Same as {@link Utils#sizeAsPerWidth(Pane, double)} expect take size param
	 */
	public double asPer(double sizeOuter, double per) {
		return sizeOuter * (per / 100);
	}
	
}
