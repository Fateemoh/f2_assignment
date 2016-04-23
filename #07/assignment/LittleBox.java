package assignment;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.AlphaComposite;

public class LittleBox extends Sprite{
	
	private int step = 12;
	private boolean alive = true;
	public static final int Y_TO_DIE = 600;
	public static final int Y_TO_FADE = 400;
	
	public LittleBox(int x, int y) {
		super(x, y, 5, 10);
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED); //Color little box
		g2d.fillRect(x, y, w, h); //Show little box
		
		//If big box crash little box game over
		if(y < Y_TO_FADE)
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		else{
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(Y_TO_DIE - y)/(Y_TO_DIE - Y_TO_FADE)));
		}
		
	}
	
	//Little box move down
	public void proceed(){
		y += step;
		//Count score
		if(y > Y_TO_DIE){
			alive = false;
		}
	}
	
	//Count score
	public boolean isAlive(){
		return alive;
	}
}