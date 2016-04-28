import java.awt.Graphics2D;
import java.awt.Color;

//Change image little bog
import java.awt.Toolkit;
import java.awt.Image;

public class BigBox extends Sprite{

	int step = 8;
	
	public BigBox(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		//g2d.setColor(Color.GREEN); //Set color big bog (color green because folow teacher)
		//g2d.fillRect(x, y, w, h); //Set x-axis,y-axis,width and height
		
		//Change image big bog
		Image img = Toolkit.getDefaultToolkit().getImage("SpaceShip.gif");
        g2d.drawImage(img, x, y, 50, 50, null);
	}

	//Move big box
	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - w)
			x = 400 - w;
	}
}
