package assignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;


public class GameEngine implements KeyListener,Report{
	GamePanel panel;
	private BigBox bb;	
	private Timer time;
	
	public GameEngine(GamePanel panel, BigBox bb) {
		this.panel = panel;
		this.bb = bb;		
		
		panel.sprite.add(bb); //Show big box
		
		time = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
			
		});
		
		time.setRepeats(true);
	}
	
	public void start(){
		time.start();
	}
	
	private void process(){
		panel.updateGameUI(this);
		
	}

	//Move big box
	void controlVehicle(KeyEvent event) {
		switch (event.getKeyCode()) {
		   case KeyEvent.VK_LEFT:  //Move left
			   bb.move(-1); break;
		   case KeyEvent.VK_RIGHT: //Move right
			   bb.move(1); break;
		}
	}
	
	//Move big box by listener key press
	@Override
	public void keyPressed(KeyEvent event) {
		controlVehicle(event);
		
	}

    @Override
	public void keyReleased(KeyEvent event) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent event) {
		//do nothing		
	}
}
