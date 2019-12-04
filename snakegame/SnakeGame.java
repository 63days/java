package snakeGame_4;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SnakeGame extends JFrame{
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background;
	
	public SnakeGame() {
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		addKeyListener(MyKeyListener.getInstance());
		Game.getInstance().start();
		Score.getInstance().start();
		setTitle("snake game");
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		Draw.draw(g);
		this.repaint();
	}
}
