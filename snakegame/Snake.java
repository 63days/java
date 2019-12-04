package snakeGame_4;

import java.util.ArrayList;

public class Snake {
	private static Snake snake;
	private Snake() {
		length = 1;
		bodies.add(new Body(Main.START_X, Main.START_Y));
		hx = bodies.get(0).getX();
		hy = bodies.get(0).getY();
	}
	public static Snake getInstance() {
		if(snake == null)
			snake = new Snake();
		return snake;
	}
	private ArrayList<Body> bodies = new ArrayList<Body>();
	private int length;
	private int hx, hy;
	
	public int getHx() {
		return hx;
	}
	public int getHy() {
		return hy;
	}
	public ArrayList<Body> getBodies(){
		return bodies;
	}
	
	public int getLength() { return length; }
	
	public void moveLeft() {
		
		for(int i = length - 1; i > 0; i--) {
			bodies.get(i).setX(bodies.get(i - 1).getX());
			bodies.get(i).setY(bodies.get(i - 1).getY());
		}
		bodies.get(0).setX(--hx);
		
	}
	
	public void moveRight() {
		int temp1X, temp1Y;
		int temp2X, temp2Y;
		temp1X = bodies.get(0).getX();
		temp1Y = bodies.get(0).getY();
		hx++;
		bodies.get(0).setX(hx);
		for(int i = 1; i < length; i++) {
			temp2X = bodies.get(i).getX();
			temp2Y = bodies.get(i).getY();
			bodies.get(i).setX(temp1X);
			bodies.get(i).setY(temp1Y);
			temp1X = temp2X;
			temp1Y = temp2Y;
		}
	}
	
	public void moveUp() {
		int temp1X, temp1Y;
		int temp2X, temp2Y;
		temp1X = bodies.get(0).getX();
		temp1Y = bodies.get(0).getY();
		hy--;
		bodies.get(0).setY(hy);
		for(int i = 1; i < length; i++) {
			temp2X = bodies.get(i).getX();
			temp2Y = bodies.get(i).getY();
			bodies.get(i).setX(temp1X);
			bodies.get(i).setY(temp1Y);
			temp1X = temp2X;
			temp1Y = temp2Y;
		}
	}
	
	public void moveDown() {
		int temp1X, temp1Y;
		int temp2X, temp2Y;
		temp1X = bodies.get(0).getX();
		temp1Y = bodies.get(0).getY();
		hy++;
		bodies.get(0).setY(hy);
		for(int i = 1; i < length; i++) {
			temp2X = bodies.get(i).getX();
			temp2Y = bodies.get(i).getY();
			bodies.get(i).setX(temp1X);
			bodies.get(i).setY(temp1Y);
			temp1X = temp2X;
			temp1Y = temp2Y;
		}
	}
	
	public void eatFood() {
		sizeUp();
	}
	
	public void sizeUp() {
		bodies.add(new Body(hx, hy));
		length++;
	}
	
	public void initialization() {
		bodies.clear();
		snake = new Snake();
	}
}
