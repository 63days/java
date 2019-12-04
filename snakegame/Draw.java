package snakeGame_4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Draw {
	private static Draw draw = null;
	private Draw() {};

	public Draw getInstance() {
		if (draw == null)
			draw = new Draw();
		return draw;
	}
	public static void draw(Graphics2D g) {
		DrawScreen.getInstance().drawScreen(g);
		DrawSnake.getInstance().drawSnake(Snake.getInstance().getBodies(), g);
		DrawFood.getInstance().drawFood(g);
		Score.getInstance().drawScore(g);
	}
	
}

class DrawFood {
	private static DrawFood drawFood = null;
	private DrawFood() { }
	public static DrawFood getInstance() {
		if(drawFood == null)
			drawFood = new DrawFood();
		return drawFood;
	}
	
	public void drawFood(Graphics g) {
		Food.getInstance().draw(g);
	}
}

class DrawScreen {
	private static DrawScreen drawScreen = null;
	private DrawScreen() { };
	
	public static DrawScreen getInstance() {
		if(drawScreen == null)
			drawScreen = new DrawScreen();
		return drawScreen;
	}
	
	private Pixel[][] screen = new Pixel[Main.HEIGHT + 2][Main.WIDTH + 2];

	public void drawScreen(Graphics g) {
		for (int y = 0; y < Main.HEIGHT + 2; y++) {
			for (int x = 0; x < Main.WIDTH + 2; x++) {
				if (y == 0 || y == Main.HEIGHT + 1 || x == 0 || x == Main.WIDTH + 1) {
					screen[y][x] = new Wall(x, y);
				} else {
					screen[y][x] = new Empty(x, y);
				}
				screen[y][x].draw(g);
			}
		}
	}
	
	public Pixel[][] getScreen() { return screen; }
}

class DrawSnake {
	private static DrawSnake drawSnake = null;
	private DrawSnake() { };
	
	public static DrawSnake getInstance() {
		if(drawSnake == null)
			drawSnake = new DrawSnake();
		return drawSnake;
	}
	
	public void drawSnake(ArrayList<Body> snakes, Graphics g) {
		for(int i = 0; i < snakes.size(); i++) {
			snakes.get(i).draw(g);
		}
	}
}
