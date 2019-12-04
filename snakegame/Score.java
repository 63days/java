package snakeGame_4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Score extends Thread{
	private static Score score = null;
	private int scoreValue;
	private int highestScore;
	private Score() { 
		scoreValue = 0;
		highestScore = 0;
	}
	public static Score getInstance() {
		if(score == null)
			score = new Score();
		return score;
	}
	
	public int getScoreValue() { return scoreValue; }
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	@Override
	public void run() {
		autoScoreUp();
	}
	
	public void autoScoreUp() {
		while(true) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scoreValue += 1;
		}
			
		}
	
	public void byFoodScoreUp() {
		scoreValue += 100;
	}
	
	public void resetScore() {
		if(highestScore == 0) {
			highestScore = scoreValue;
		} else {
			highestScore = Math.max(highestScore, scoreValue);
		}
		scoreValue = 0;
	}
	
	public void drawScore(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(String.valueOf(scoreValue), 20, 550);
		g.drawString("Highest Score: ", 100,550);
		g.drawString(String.valueOf(highestScore), 330, 550);
	}
}
