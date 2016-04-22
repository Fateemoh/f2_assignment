package assignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;


public class GameEngine implements KeyListener,Report{
	GamePanel panel;
	private BigBox bb;
	private ArrayList<LittleBox> littlebox = new ArrayList<LittleBox>();		
	private Timer time;
	private double difficulty = 0.1;
	private long score = 0; //score
	
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
	
	//Show lille box
	private void generateEnemy(){
		LittleBox lb = new LittleBox((int)(Math.random()*390), 30);
		panel.sprite.add(lb);
		littlebox.add(lb);
	}
	
	private void process(){
		//Random show lille box 
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		//Show lille box
		Iterator<LittleBox> lb_iter = littlebox.iterator();
		while(lb_iter.hasNext()){
			LittleBox lb = lb_iter.next();
			lb.proceed();//Little box move down
			
			//Count score
			if(!lb.isAlive()){
				lb_iter.remove();
				panel.sprite.remove(lb);
				score += 100; //Add score per 100
			}

		}
		
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
	
	//score
	public long getScore(){
		return score;
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
