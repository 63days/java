package snakeGame_4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter{
	private static MyKeyListener myKeyListener = null;
	private MyKeyListener() { }
	private int direction = Main.RIGHT;
	private int preDirection;
	public static MyKeyListener getInstance() {
		if(myKeyListener == null)
			myKeyListener = new MyKeyListener();
		return myKeyListener;
	}
	@Override
	public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == e.VK_LEFT) {
				preDirection = direction;
				direction = Main.LEFT;
				if(isInvalidDirection())
					direction = preDirection;
			}
			else if(e.getKeyCode() == e.VK_RIGHT) {
				preDirection = direction;
				direction = Main.RIGHT;	
				if(isInvalidDirection())
					direction = preDirection;
			}
			else if(e.getKeyCode() == e.VK_UP) {
				preDirection = direction;
				direction = Main.UP;
				if(isInvalidDirection())
					direction = preDirection;
			}
			else if(e.getKeyCode() == e.VK_DOWN) {
				preDirection = direction;
				direction = Main.DOWN;
				if(isInvalidDirection())
					direction = preDirection;
			}
			else if(e.getKeyCode() == e.VK_SPACE) {
				Snake.getInstance().sizeUp();
			}			
		
	}
	public int getDirection() { return direction; }
	public int getPreDirection() { return preDirection; }
	
	public boolean isInvalidDirection() {
		if(Snake.getInstance().getLength() > 1) {
			if(direction == Main.LEFT && preDirection == Main.RIGHT) {
				return true;
			} else if (direction == Main.RIGHT && preDirection == Main.LEFT) {
				return true;
			} else if (direction == Main.UP && preDirection == Main.DOWN) {
				return true;
			} else if (direction == Main.DOWN && preDirection == Main.UP) {
				return true;
			}
		}
		return false;
	}
}
