package snakeGame_4;

import java.util.ArrayList;

public class Game extends Thread {
	private static Game game = null;

	private Game() {
	}

	public static Game getInstance() {
		if (game == null)
			game = new Game();
		return game;
	}

	public void move(int direction) {
		if (direction == Main.UP)
			Snake.getInstance().moveUp();
		else if (direction == Main.DOWN)
			Snake.getInstance().moveDown();
		else if (direction == Main.LEFT)
			Snake.getInstance().moveLeft();
		else if (direction == Main.RIGHT)
			Snake.getInstance().moveRight();
	}

	@Override
	public void run() {
		int moveCountTime = 75;
		int inputCountTime = 1;
		int count = 0;
		int direction;
		while (true) {
			count++;
			direction = MyKeyListener.getInstance().getDirection();
			if (count == moveCountTime / inputCountTime) {
				move(direction);
				checkGameOver();
				checkEatFood();
				count = 0;
			}
			try {
				Thread.sleep(inputCountTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void checkEatFood() {
		if (Snake.getInstance().getHx() == Food.getInstance().getX()
				&& Snake.getInstance().getHy() == Food.getInstance().getY()) {
			Snake.getInstance().eatFood();
			Food.getInstance().beEaten();
			Score.getInstance().byFoodScoreUp();
		}
	}

	public void checkGameOver() {
		if (checkCollisionWithBody() || checkCollisionWithWall()) {
			System.out.println("Game Over");
			Snake.getInstance().initialization();
			Score.getInstance().resetScore();
		}
	}

	public boolean checkCollisionWithBody() {
		ArrayList<Body> tempBody = Snake.getInstance().getBodies();

		for (int i = 1; i < tempBody.size(); i++) {
			if (Snake.getInstance().getHx() == tempBody.get(i).getX()
					&& Snake.getInstance().getHy() == tempBody.get(i).getY()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkCollisionWithWall() {
		if (Snake.getInstance().getHx() == 0 || Snake.getInstance().getHx() == Main.WIDTH + 1
				|| Snake.getInstance().getHy() == 0 || Snake.getInstance().getHy() == Main.HEIGHT + 1) {
			return true;
		}
		return false;
	}

}
