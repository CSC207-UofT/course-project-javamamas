package application.resources;

import java.util.Timer;
import java.util.TimerTask;

import application.resources.animations.Bezier;
import javafx.scene.layout.Pane;

/**
 * Class to animate elements of javafx
 *
 */
public class Animate {
	
	public static void applyAnimHor(Pane pane, Bezier bezier) {
		
		double startPos = pane.getLayoutX();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		  int i = 0;
		  @Override
		  public void run() {
			  
			  Bezier.BezierInfo bezierRes = bezier.calc(i);
			  pane.setLayoutX(startPos + bezierRes.curr);
			  pane.setOpacity(i / bezier.getMaxInterval());
			  
			  if (i >= bezier.getMaxInterval()) {
				  timer.cancel();
				  pane.setOpacity(Math.round(bezierRes.currNorm));
				  pane.setLayoutX(Math.round(pane.getLayoutX()));
			  }
			  i++;
		  }
		  
		}, 0, Math.round(bezier.getTimeDelta()));
		
	}
	
	public static void applyAnimVer(Pane pane, Bezier bezier) {
		
		double startPos = pane.getLayoutY();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
		  int i = 0;
		  @Override
		  public void run() {
			  Bezier.BezierInfo bezierRes = bezier.calc(i);
			  pane.setLayoutY(startPos + bezierRes.curr);
			  pane.setOpacity(i / bezier.getMaxInterval());
			  
			  if (i >= bezier.getMaxInterval()) {
				  pane.setOpacity(Math.round(pane.getOpacity()));
				  pane.setLayoutY(Math.round(pane.getLayoutY()));
				  timer.cancel();
			  }
			  i++;
		  }
		}, 0, Math.round(bezier.getTimeDelta()));
		
	}
	
}
