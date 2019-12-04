package snakeGame_4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

enum PixelID {
	EMPTY, BODY, FOOD, WALL
}

public abstract class Pixel {
	private int x;
	private int y;
	public final static int SIZE = 23;

	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void draw(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}

class Body extends Pixel {
	public Body(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getX() * Pixel.SIZE + Main.SCREEN_START_X, getY() * Pixel.SIZE + Main.SCREEN_START_Y, Pixel.SIZE, Pixel.SIZE);
	}
}

class Head extends Pixel {
	public Head(int x, int y) {
		super(x, y);
	}
	
	public void draw(Graphics g) {
		
	}
}

class Wall extends Pixel {

	public Wall(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.drawRect(getX() * Pixel.SIZE + Main.SCREEN_START_X, getY() * Pixel.SIZE + Main.SCREEN_START_Y, Pixel.SIZE, Pixel.SIZE);
	}
}

class Empty extends Pixel {
	public Empty(int x, int y) {
		super(x, y);
	}

	public void draw(Graphics g) {
		g.clearRect(getX() * Pixel.SIZE + Main.SCREEN_START_X, getY() * Pixel.SIZE + Main.SCREEN_START_Y, Pixel.SIZE, Pixel.SIZE);
	}
}

class Food extends Pixel {
	private static Food food = null;
	private Food(int x, int y) {
		super(x, y);
	}
	public static Food getInstance() {
		if(food == null)
			food = new Food(7, 8);
		return food;
	}
	private Random rand = new Random();
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRoundRect(getX() * Pixel.SIZE + Main.SCREEN_START_X, getY() * Pixel.SIZE + Main.SCREEN_START_Y, Pixel.SIZE, Pixel.SIZE, 5, 5);
	}
	
	public void beEaten() {
		setX(rand.nextInt(Main.WIDTH) + 1);
		setY(rand.nextInt(Main.HEIGHT) + 1);
	}
}