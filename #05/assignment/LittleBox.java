package assignment;

import java.awt.Graphics2D;
import java.awt.Color;

public class LittleBox extends Sprite{
	
	private int step = 12;
	
	public LittleBox(int x, int y) {
		super(x, y, 5, 10);
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED); //Color little box
		g2d.fillRect(x, y, w, h); //Show little box
		
	}
	
	//Little box move down
	public void proceed(){
		y += step;
	}
}