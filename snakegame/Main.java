package snakeGame_4;

public class Main {
	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 660;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 10;
	public static final int SCREEN_START_X = 30;
	public static final int SCREEN_START_Y = 60;
	public static final int LEFT = 4;
	public static final int RIGHT = 6;
	public static final int UP = 8;
	public static final int DOWN = 2;
	public static final int START_X = (Main.WIDTH + Main.SCREEN_START_X/Pixel.SIZE) / 2;
	public static final int START_Y = (Main.HEIGHT + Main.SCREEN_START_Y/Pixel.SIZE) / 2;

	public static void main(String[] args) {
		new SnakeGame();
	}
}
