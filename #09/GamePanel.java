import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Image;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D g2d;
	ArrayList<Sprite> sprite = new ArrayList<Sprite>();
	private Image Background;

	//Background
	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB); //x-axis=400, y-axis=600
		g2d = (Graphics2D) bi.getGraphics();
		
		//Change image background
		Background = Toolkit.getDefaultToolkit().getImage("picture.jpg");
		g2d.drawImage(Background, 0, 0, 400, 600,null);
		//g2d.setBackground(Color.BLACK); //Set color for background (color black because folow teacher)
	}

	public void updateGameUI(Report reporter){
		
		//change Background
		g2d.drawImage(Background, 0, 0, 400, 600,null);
		
		//Set property for big
		//g2d.clearRect(0, 0, 400, 600);
		
		//Set color score
		g2d.setColor(Color.WHITE);
		//Show Score
		g2d.drawString(String.format("%08d", reporter.getScore()), 300, 20);
		
		//Show big box
		for(Sprite s : sprite){
			s.draw(g2d);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
