package application.resources.pages.play;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public interface AddableTile {
	
	public class Info {
		public int pos;
		public Paint img;
		
		public Info(int pos, Paint img) {
			this.pos = pos;
			this.img = img;
		}
	}

	public void addPlayer(Image img, String name);
	
	public void addPlayer(Paint img, String name);
	
	public void removePlayer(String name);
	
	public Info getInfo(String name);
	
	public void setCircle(Color col);
	
}
