package whatsForLunch_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WhatsForLunch extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menubar.png")));
	private Image background = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();
	private ImageIcon doorButton1BasicImage = new ImageIcon(Main.class.getResource("../images/doorButton1Basic.png"));
	private ImageIcon doorButton1EnteredImage = new ImageIcon(Main.class.getResource("../images/doorButton1Entered.png"));
	private ImageIcon doorButton2BasicImage = new ImageIcon(Main.class.getResource("../images/doorButton2Basic.png"));
	private ImageIcon doorButton2EnteredImage = new ImageIcon(Main.class.getResource("../images/doorButton2Entered.png"));
	private ImageIcon doorButton3BasicImage = new ImageIcon(Main.class.getResource("../images/doorButton3Basic.png"));
	private ImageIcon doorButton3EnteredImage = new ImageIcon(Main.class.getResource("../images/doorButton3Entered.png"));
	private ImageIcon doorButton4BasicImage = new ImageIcon(Main.class.getResource("../images/doorButton4Basic.png"));
	private ImageIcon doorButton4EnteredImage = new ImageIcon(Main.class.getResource("../images/doorButton4Entered.png"));
	private ImageIcon menuButton1BasicImage = new ImageIcon(Main.class.getResource("../images/menu1.png"));
	private ImageIcon menuButton1EnteredImage = new ImageIcon(Main.class.getResource("../images/menu1Entered.png"));
	private ImageIcon menuButton2BasicImage = new ImageIcon(Main.class.getResource("../images/menu2.png"));
	private ImageIcon menuButton2EnteredImage = new ImageIcon(Main.class.getResource("../images/menu2Entered.png"));
	private ImageIcon menuButton3BasicImage = new ImageIcon(Main.class.getResource("../images/menu3.png"));
	private ImageIcon menuButton3EnteredImage = new ImageIcon(Main.class.getResource("../images/menu3Entered.png"));
	private ImageIcon menuButton4BasicImage = new ImageIcon(Main.class.getResource("../images/menu4.png"));
	private ImageIcon menuButton4EnteredImage = new ImageIcon(Main.class.getResource("../images/menu4Entered.png"));
	private ImageIcon menuButton5BasicImage = new ImageIcon(Main.class.getResource("../images/menu5.png"));
	private ImageIcon menuButton5EnteredImage = new ImageIcon(Main.class.getResource("../images/menu5Entered.png"));
	private ImageIcon closeButtonBasicImage = new ImageIcon(Main.class.getResource("../images/closeButtonBasic.png"));
	private ImageIcon closeButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/closeButtonEntered.png"));
	private ImageIcon selectButtonBasicImage = new ImageIcon(Main.class.getResource("../images/selectButtonBasic.png"));
	private ImageIcon selectButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/selectButtonEntered.png"));
	private ImageIcon logButtonBasicImage = new ImageIcon(Main.class.getResource("../images/logButtonBasic.png"));
	private ImageIcon logButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/logButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon mainButtonBasicImage = new ImageIcon(Main.class.getResource("../images/mainButtonBasic.png"));
	private ImageIcon mainButtonEnteredImage = new ImageIcon(
			Main.class.getResource("../images/mainButtonEntered.png"));
	
	private JButton selectButton = new JButton(selectButtonBasicImage);
	private JButton doorButton1 = new JButton(doorButton1BasicImage);
	private JButton doorButton2 = new JButton(doorButton2BasicImage);
	private JButton doorButton3 = new JButton(doorButton3BasicImage);
	private JButton doorButton4 = new JButton(doorButton4BasicImage);
	private JButton menuButton1 = new JButton(menuButton1BasicImage);
	private JButton menuButton2 = new JButton(menuButton2BasicImage);
	private JButton menuButton3 = new JButton(menuButton3BasicImage);
	private JButton menuButton4 = new JButton(menuButton4BasicImage);
	private JButton menuButton5 = new JButton(menuButton5BasicImage);
	private JButton logButton = new JButton(logButtonBasicImage);
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton mainButton = new JButton(mainButtonBasicImage);
	private JButton closeButton = new JButton(closeButtonBasicImage);

	private JFrame resultFrame;
	private JFrame logFrame;

	private ArrayList<Store> storeList = new ArrayList<Store>();
	private ArrayList<Store> tempList = new ArrayList<Store>();
	private ArrayList<Store> finalList = new ArrayList<Store>();
	private Log log;

	private Store selectedStore;
	private String selectedDoor;
	private String selectedMenu;

	private String nameText;
	private String infoText;
	private int mouseX, mouseY;

	public WhatsForLunch() {
		storeList.add(new Store("쪽문분식", "분식", "쪽문", "하", "떡볶이, 튀김, 순대"));
		storeList.add(new Store("정다운 분식", "분식", "쪽문", "하", "떡볶이, 튀김, 순대, 치킨"));

		storeList.add(new Store("까치분식", "한식", "쪽문", "하", "생삼겹불고기, 치즈김치돌솥밥"));
		storeList.add(new Store("오라카이", "한식", "쪽문", "중", "삼겹구이, 부대찌개"));
		storeList.add(new Store("우리분식", "한식", "쪽문", "하", "고기볶음, 순두부찌개"));
		storeList.add(new Store("새빨간 죠스 찜닭", "한식", "쪽문", "하", "간장 찜닭, 고추장 찜닭"));
		storeList.add(new Store("행컵", "한식", "쪽문", "하", "장작삼겹볶음밥, 에그치킨마요"));
		storeList.add(new Store("종이컵", "한식", "쪽문", "하", "제육덮밥, 폭탄밥"));
		storeList.add(new Store("봉구스 밥버거", "한식", "쪽문", "하", "햄치즈 밥버거"));

		storeList.add(new Store("북경반점", "중식", "쪽문", "중", "짜장면, 짬뽕, 탕수육"));
		storeList.add(new Store("짬마담", "중식", "쪽문", "하", "짬뽕, 찹쌀 탕수육"));

		storeList.add(new Store("맘스터치", "양식", "쪽문", "하", "싸이버거, 화이트갈릭버거"));
		storeList.add(new Store("브리또 익스프레스", "양식", "쪽문", "하", "점보 브리또, 돈까스 브리또"));
		storeList.add(new Store("겸손한 밥집", "양식", "쪽문", "하", "데리야끼 포크 덮밥, 치즈 돈까스"));
		storeList.add(new Store("돈까스 백작", "양식", "쪽문", "하", "고구마 치즈 돈까스, 피자 돈까스, 고추 돈까스"));

		storeList.add(new Store("다이마루", "일식", "쪽문", "하", "돈코츠 라멘, 우동, 규동"));
		storeList.add(new Store("스시 다이가쿠", "일식", "쪽문", "하", "초밥세트"));
		storeList.add(new Store("초밥집", "일식", "쪽문", "하", "연어초밥 세트, 연어샐러드"));
		// 쪽문
		storeList.add(new Store("삼도 찜닭", "한식", "정문", "하", "찜닭, 닭도리탕"));
		storeList.add(new Store("김밥파는 사람들", "한식", "정문", "하", "김밥, 라면, 돈까스"));
		storeList.add(new Store("경주국밥", "한식", "정문", "하", "돼지국밥, 순대국밥"));
		storeList.add(new Store("성화 식당", "한식", "정문", "중", "돼지국밥, 수육"));

		storeList.add(new Store("감래등", "중식", "정문", "중", "칠리 새우, 류산슬, 마라깐베이"));

		storeList.add(new Store("모이다 식탁", "양식", "정문", "하", "돈까스, 오므라이스, 볶음밥"));
		storeList.add(new Store("위치스케틀", "양식", "정문", "중", "빙수, 베이컨 김치 볶음밥, 브런치"));

		storeList.add(new Store("대구라멘", "일식", "정문", "하", "돈코츠 라멘, 미소라멘"));
		// 정문
		storeList.add(new Store("분식쌀롱", "분식", "북문", "하", "고기 떡볶이, 수제튀김, 매참김밥"));

		storeList.add(new Store("고니 식탁", "한식", "북문", "중", "두루치기, 계란말이, 김치찌개"));
		storeList.add(new Store("보헤미안 보울", "한식", "북문", "상", "덮밥, 치즈 불닭, 소불고기"));
		storeList.add(new Store("짚신매운갈비찜", "한식", "북문", "중", "소 갈비찜, 계란찜, 참치마요 주먹밥"));
		storeList.add(new Store("한끼갈비", "한식", "북문", "하", "매운 갈비찜, 갈비만두"));
		storeList.add(new Store("정성식당", "한식", "북문", "중", "두루치기, 김치찜, 김치전골"));
		storeList.add(new Store("육식소반", "한식", "북문", "중", "삼겹살, 항정살, 우삼겹"));

		storeList.add(new Store("벨로", "양식", "북문", "중", "앤쵸비 갈릭 올리브 오일 파스타, 할라페뇨 베이컨 파스타"));
		storeList.add(new Store("홍대함바그", "양식", "북문", "하", "매콤 함바그, 달콤 갈비"));
		storeList.add(new Store("1992스테이크 & 펍", "양식", "북문", "중", "아란치니, 조개 갈비탕 파스타"));
		storeList.add(new Store("메타피자", "양식", "북문", "중", "마르게리따 피자, 페퍼로니 피자, 누텔라 피자, 수제 생맥주"));
		storeList.add(new Store("서가앤쿡", "양식", "북문", "중", "목살 필라프, 새우 필라프, 해산물 토마토 파스타"));

		storeList.add(new Store("깐담", "중식", "북문", "중", "새우 크림 짬뽕, 망고 크림 새우"));
		storeList.add(new Store("홍콩반점0410", "중식", "북문", "하", "짬뽕, 짜장밥, 쟁반짜장"));
		storeList.add(new Store("야끼한 남자", "중식", "북문", "중", "야끼우동, 탕수육"));
		storeList.add(new Store("홍짜장", "중식", "북문", "중", "짬뽕, 짜장면"));
		storeList.add(new Store("칭베이", "중식", "북문", "중", "양꼬치, 짬뽕"));

		storeList.add(new Store("밥하는 남자", "일식", "북문", "중", "돈카츠 김치 나베, 카레 고로케, 날치알 크림 우동"));
		storeList.add(new Store("와일드 스시", "일식", "북문", "중", "스시, 스키야키 우동"));
		storeList.add(new Store("텐고쿠", "일식", "북문", "중", "텐고쿠 라멘, 돈코츠 라멘"));
		storeList.add(new Store("이층남자의 면과 밥", "일식", "북문", "하", "카라이가츠동, 돈코츠 라멘"));
		storeList.add(new Store("88식당", "일식", "북문", "중", "카라아게 정식, 라무네"));
		// 북문
		storeList.add(new Store("수덕", "한식", "동문", "중", "고디탕, 해장국"));
		storeList.add(new Store("사랑받는 돼지국밥", "한식", "동문", "중", "돼지국밥"));
		storeList.add(new Store("색계", "한식", "동문", "중", "찜닭"));

		storeList.add(new Store("황금성", "중식", "동문", "중", "야끼우동, 볶음짜장"));
		storeList.add(new Store("기황후", "중식", "동문", "중", "짜장면, 짬뽕, 탕수육"));
		// 동문
		setUndecorated(true);
		setSize(800, 600);
		setTitle("오늘 뭐 먹지?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		closeButton.setBounds(765, 0, 30, 30);
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
				System.exit(0);
			}
			
		});
		add(closeButton);
		
		menuBar.setBounds(0, 0, 800, 30);
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
		
		selectButton.setBounds(60, 500, 150, 40);
		selectButton.setBorderPainted(false);
		selectButton.setContentAreaFilled(false);
		selectButton.setFocusPainted(false);
		selectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				selectButton.setIcon(selectButtonEnteredImage);
				selectButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				selectButton.setIcon(selectButtonBasicImage);
				selectButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				enterSelect();
			}
		});
		add(selectButton);

		logButton.setBounds(310, 500, 150, 40);
		logButton.setBorderPainted(false);
		logButton.setContentAreaFilled(false);
		logButton.setFocusPainted(false);
		logButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logButton.setIcon(logButtonEnteredImage);
				logButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logButton.setIcon(logButtonBasicImage);
				logButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				enterLog();
			}
		});
		add(logButton);

		exitButton.setBounds(580, 500, 150, 40);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);

		mainButton.setVisible(false);
		mainButton.setBorderPainted(false);
		mainButton.setContentAreaFilled(false);
		mainButton.setFocusPainted(false);
		mainButton.setBounds(600, 500, 150, 40);
		mainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainButton.setIcon(mainButtonEnteredImage);
				mainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainButton.setIcon(mainButtonBasicImage);
				mainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		add(mainButton);

		doorButton1.setVisible(false);
		doorButton1.setBorderPainted(false);
		doorButton1.setContentAreaFilled(false);
		doorButton1.setFocusPainted(false);
		doorButton1.setBounds(20, 170, 150, 40);
		doorButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				doorButton1.setIcon(doorButton1EnteredImage);
				doorButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				doorButton1.setIcon(doorButton1BasicImage);
				doorButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedDoor = "쪽문";
				doorIsSelcted(selectedDoor);
			}
		});
		add(doorButton1);

		doorButton2.setVisible(false);
		doorButton2.setBorderPainted(false);
		doorButton2.setContentAreaFilled(false);
		doorButton2.setFocusPainted(false);
		doorButton2.setBounds(20, 270, 150, 40);
		doorButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				doorButton2.setIcon(doorButton2EnteredImage);
				doorButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				doorButton2.setIcon(doorButton2BasicImage);
				doorButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedDoor = "정문";
				doorIsSelcted(selectedDoor);
			}
		});
		add(doorButton2);

		doorButton3.setVisible(false);
		doorButton3.setBounds(20, 370, 150, 40);
		doorButton3.setBorderPainted(false);
		doorButton3.setContentAreaFilled(false);
		doorButton3.setFocusPainted(false);
		doorButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				doorButton3.setIcon(doorButton3EnteredImage);
				doorButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				doorButton3.setIcon(doorButton3BasicImage);
				doorButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedDoor = "북문";
				doorIsSelcted(selectedDoor);
			}
		});
		add(doorButton3);

		doorButton4.setVisible(false);
		doorButton4.setBorderPainted(false);
		doorButton4.setContentAreaFilled(false);
		doorButton4.setFocusPainted(false);
		doorButton4.setBounds(20, 470, 150, 40);
		doorButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				doorButton4.setIcon(doorButton4EnteredImage);
				doorButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				doorButton4.setIcon(doorButton4BasicImage);
				doorButton4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedDoor = "동문";
				doorIsSelcted(selectedDoor);
			}
		});
		add(doorButton4);

		menuButton1.setVisible(false);
		menuButton1.setBorderPainted(false);
		menuButton1.setContentAreaFilled(false);
		menuButton1.setFocusPainted(false);
		menuButton1.setBounds(20, 170, 150, 40);
		menuButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuButton1.setIcon(menuButton1EnteredImage);
				menuButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuButton1.setIcon(menuButton1BasicImage);
				menuButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMenu = "한식";
				menuIsSelected(selectedMenu);
			}
		});
		add(menuButton1);

		menuButton2.setVisible(false);
		menuButton2.setBorderPainted(false);
		menuButton2.setContentAreaFilled(false);
		menuButton2.setFocusPainted(false);
		menuButton2.setBounds(20, 250, 150, 40);
		menuButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuButton2.setIcon(menuButton2EnteredImage);
				menuButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuButton2.setIcon(menuButton2BasicImage);
				menuButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMenu = "중식";
				menuIsSelected(selectedMenu);
			}
		});
		add(menuButton2);

		menuButton3.setVisible(false);
		menuButton3.setBounds(20, 330, 150, 40);
		menuButton3.setBorderPainted(false);
		menuButton3.setContentAreaFilled(false);
		menuButton3.setFocusPainted(false);
		menuButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuButton3.setIcon(menuButton3EnteredImage);
				menuButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuButton3.setIcon(menuButton3BasicImage);
				menuButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMenu = "양식";
				menuIsSelected(selectedMenu);
			}
		});
		add(menuButton3);

		menuButton4.setVisible(false);
		menuButton4.setBorderPainted(false);
		menuButton4.setContentAreaFilled(false);
		menuButton4.setFocusPainted(false);
		menuButton4.setBounds(20, 410, 150, 40);
		menuButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuButton4.setIcon(menuButton4EnteredImage);
				menuButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuButton4.setIcon(menuButton4BasicImage);
				menuButton4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMenu = "분식";
				menuIsSelected(selectedMenu);
			}
		});
		add(menuButton4);

		menuButton5.setVisible(false);
		menuButton5.setBorderPainted(false);
		menuButton5.setContentAreaFilled(false);
		menuButton5.setFocusPainted(false);
		menuButton5.setBounds(20, 490, 150, 40);
		menuButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuButton5.setIcon(menuButton5EnteredImage);
				menuButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuButton5.setIcon(menuButton5BasicImage);
				menuButton5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectedMenu = "일식";
				menuIsSelected(selectedMenu);
			}
		});
		add(menuButton5);

	}
	public void paint(Graphics g) {
		screenImage = createImage(800,600);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g) {
		
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	public void enterSelect() {
		background = new ImageIcon(Main.class.getResource("../images/backgroundDoor.png")).getImage();
		selectButton.setVisible(false);
		logButton.setVisible(false);
		exitButton.setVisible(false);
		mainButton.setVisible(true);
		doorButton1.setVisible(true);
		doorButton2.setVisible(true);
		doorButton3.setVisible(true);
		doorButton4.setVisible(true);
	}

	public void enterLog() {
		logFrame = new LogFrame();
	}

	public void doorIsSelcted(String selectedDoor) {
		for (int i = 0; i < storeList.size(); i++)
			if (storeList.get(i).getDoor().equals(selectedDoor))
				tempList.add(storeList.get(i));
		background = new ImageIcon(Main.class.getResource("../images/backgroundMenu.png")).getImage();
		doorButton1.setVisible(false);
		doorButton2.setVisible(false);
		doorButton3.setVisible(false);
		doorButton4.setVisible(false);
		menuButton1.setVisible(true);
		menuButton2.setVisible(true);
		menuButton3.setVisible(true);
		menuButton4.setVisible(true);
		menuButton5.setVisible(true);
	}

	public void menuIsSelected(String selectedMenu) {
		menuButton1.setVisible(false);
		menuButton2.setVisible(false);
		menuButton3.setVisible(false);
		menuButton4.setVisible(false);
		menuButton5.setVisible(false);

		Random randNum = new Random();
		for (int i = 0; i < tempList.size(); i++)
			if (tempList.get(i).getType().equals(selectedMenu))
				finalList.add(tempList.get(i));
		if (finalList.size() == 0) {
			selectedStore = null;
		} else {
			selectedStore = finalList.get(randNum.nextInt(finalList.size()));
		}
		resultFrame = new ResultFrame(selectedStore);
	}

	public void backMain() {
		background = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();
		doorButton1.setVisible(false);
		doorButton2.setVisible(false);
		doorButton3.setVisible(false);
		doorButton4.setVisible(false);
		menuButton1.setVisible(false);
		menuButton2.setVisible(false);
		menuButton3.setVisible(false);
		menuButton4.setVisible(false);
		menuButton5.setVisible(false);
		selectButton.setVisible(true);
		logButton.setVisible(true);
		exitButton.setVisible(true);
		mainButton.setVisible(false);
		tempList.clear();
		finalList.clear();
	}
	
	
}
