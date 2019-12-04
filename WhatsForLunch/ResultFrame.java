package whatsForLunch_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultFrame extends JFrame {
	private Store selectedStore;
	private Log log;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));
	private Image background = new ImageIcon(Main.class.getResource("../images/resultBackground.png")).getImage();
	private ImageIcon yesButtonBasicImage = new ImageIcon(Main.class.getResource("../images/yesButtonBasic.png"));
	private ImageIcon yesButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/yesButtonEntered.png"));
	private ImageIcon noButtonBasicImage = new ImageIcon(Main.class.getResource("../images/noButtonBasic.png"));
	private ImageIcon noButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/noButtonEntered.png"));
	private ImageIcon closeButtonBasicImage = new ImageIcon(Main.class.getResource("../images/closeButtonBasic.png"));
	private ImageIcon closeButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/closeButtonEntered.png"));
	private JLabel title = new JLabel("가게 이름 |");
	private JLabel nameText = new JLabel();
	private JLabel info = new JLabel("추천 메뉴 |");
	private JLabel infoText = new JLabel();
	private JLabel selectText = new JLabel("이 가게로 선택하시겠습니까?");
	private JButton yesButton = new JButton(yesButtonBasicImage);
	private JButton noButton = new JButton(noButtonBasicImage);
	private JButton closeButton = new JButton(closeButtonBasicImage);
	private int mouseX, mouseY;

	public ResultFrame(Store selectedStore) {
		this.selectedStore = selectedStore;
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setVisible(true);
		setSize(400, 300);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("결과 창");
		
		closeButton.setBounds(365, 0, 30, 30);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeButton.setIcon(closeButtonEnteredImage);
				closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeButton.setIcon(closeButtonBasicImage);
				closeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		add(closeButton);
		menuBar.setBounds(0, 0, 400, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		if (selectedStore == null) {
			nameText = new JLabel("일치하는 음식점이 없습니다. 다시 골라주세요.");
			nameText.setBounds(50,100,500,30);
			add(nameText);
		} else {
			log = new Log(selectedStore);
			nameText.setText(selectedStore.getName());
			infoText.setText(selectedStore.getSimpleInfo());
			title.setBounds(5,45,100,30);
			add(title);
			nameText.setBounds(75, 45, 100, 30);
			add(nameText);
			info.setBounds(5,75,100,30);
			add(info);
			infoText.setBounds(75,75,500,30);
			add(infoText);
			selectText.setBounds(100,140,500,30);
			add(selectText);
			yesButton.setBounds(70,190,100,30);
			add(yesButton);
			yesButton.setBorderPainted(false);
			yesButton.setContentAreaFilled(false);
			yesButton.setFocusPainted(false);
			yesButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					yesButton.setIcon(yesButtonEnteredImage);
					yesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					yesButton.setIcon(yesButtonBasicImage);
					yesButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						log.saveLog();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
			});
			noButton.setBounds(190,190,100,30);
			add(noButton);
			noButton.setBorderPainted(false);
			noButton.setContentAreaFilled(false);
			noButton.setFocusPainted(false);
			noButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					noButton.setIcon(noButtonEnteredImage);
					noButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					noButton.setIcon(noButtonBasicImage);
					noButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					dispose();
				}
			});
		}
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
	}
}
