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
		storeList.add(new Store("�ʹ��н�", "�н�", "�ʹ�", "��", "������, Ƣ��, ����"));
		storeList.add(new Store("���ٿ� �н�", "�н�", "�ʹ�", "��", "������, Ƣ��, ����, ġŲ"));

		storeList.add(new Store("��ġ�н�", "�ѽ�", "�ʹ�", "��", "�����Ұ��, ġ���ġ���ܹ�"));
		storeList.add(new Store("����ī��", "�ѽ�", "�ʹ�", "��", "��㱸��, �δ��"));
		storeList.add(new Store("�츮�н�", "�ѽ�", "�ʹ�", "��", "��⺺��, ���κ��"));
		storeList.add(new Store("������ �ҽ� ���", "�ѽ�", "�ʹ�", "��", "���� ���, ������ ���"));
		storeList.add(new Store("����", "�ѽ�", "�ʹ�", "��", "���ۻ�㺺����, ����ġŲ����"));
		storeList.add(new Store("������", "�ѽ�", "�ʹ�", "��", "��������, ��ź��"));
		storeList.add(new Store("������ �����", "�ѽ�", "�ʹ�", "��", "��ġ�� �����"));

		storeList.add(new Store("�ϰ����", "�߽�", "�ʹ�", "��", "¥���, «��, ������"));
		storeList.add(new Store("«����", "�߽�", "�ʹ�", "��", "«��, ���� ������"));

		storeList.add(new Store("������ġ", "���", "�ʹ�", "��", "���̹���, ȭ��Ʈ��������"));
		storeList.add(new Store("�긮�� �ͽ�������", "���", "�ʹ�", "��", "���� �긮��, ��� �긮��"));
		storeList.add(new Store("����� ����", "���", "�ʹ�", "��", "�����߳� ��ũ ����, ġ�� ���"));
		storeList.add(new Store("��� ����", "���", "�ʹ�", "��", "���� ġ�� ���, ���� ���, ���� ���"));

		storeList.add(new Store("���̸���", "�Ͻ�", "�ʹ�", "��", "������ ���, �쵿, �Ե�"));
		storeList.add(new Store("���� ���̰���", "�Ͻ�", "�ʹ�", "��", "�ʹ似Ʈ"));
		storeList.add(new Store("�ʹ���", "�Ͻ�", "�ʹ�", "��", "�����ʹ� ��Ʈ, ���������"));
		// �ʹ�
		storeList.add(new Store("�ﵵ ���", "�ѽ�", "����", "��", "���, �ߵ�����"));
		storeList.add(new Store("����Ĵ� �����", "�ѽ�", "����", "��", "���, ���, ���"));
		storeList.add(new Store("���ֱ���", "�ѽ�", "����", "��", "��������, ���뱹��"));
		storeList.add(new Store("��ȭ �Ĵ�", "�ѽ�", "����", "��", "��������, ����"));

		storeList.add(new Store("������", "�߽�", "����", "��", "ĥ�� ����, ���꽽, �������"));

		storeList.add(new Store("���̴� ��Ź", "���", "����", "��", "���, ���Ƕ��̽�, ������"));
		storeList.add(new Store("��ġ����Ʋ", "���", "����", "��", "����, ������ ��ġ ������, �귱ġ"));

		storeList.add(new Store("�뱸���", "�Ͻ�", "����", "��", "������ ���, �̼Ҷ��"));
		// ����
		storeList.add(new Store("�нĽҷ�", "�н�", "�Ϲ�", "��", "��� ������, ����Ƣ��, �������"));

		storeList.add(new Store("��� ��Ź", "�ѽ�", "�Ϲ�", "��", "�η�ġ��, �������, ��ġ�"));
		storeList.add(new Store("����̾� ����", "�ѽ�", "�Ϲ�", "��", "����, ġ�� �Ҵ�, �ҺҰ��"));
		storeList.add(new Store("¤�Ÿſ����", "�ѽ�", "�Ϲ�", "��", "�� ������, �����, ��ġ���� �ָԹ�"));
		storeList.add(new Store("�ѳ�����", "�ѽ�", "�Ϲ�", "��", "�ſ� ������, ���񸸵�"));
		storeList.add(new Store("�����Ĵ�", "�ѽ�", "�Ϲ�", "��", "�η�ġ��, ��ġ��, ��ġ����"));
		storeList.add(new Store("���ļҹ�", "�ѽ�", "�Ϲ�", "��", "����, ������, ����"));

		storeList.add(new Store("����", "���", "�Ϲ�", "��", "���ݺ� ���� �ø��� ���� �Ľ�Ÿ, �Ҷ��䴢 ������ �Ľ�Ÿ"));
		storeList.add(new Store("ȫ���Թٱ�", "���", "�Ϲ�", "��", "���� �Թٱ�, ���� ����"));
		storeList.add(new Store("1992������ũ & ��", "���", "�Ϲ�", "��", "�ƶ�ġ��, ���� ������ �Ľ�Ÿ"));
		storeList.add(new Store("��Ÿ����", "���", "�Ϲ�", "��", "�����Ը��� ����, ���۷δ� ����, ���ڶ� ����, ���� ������"));
		storeList.add(new Store("��������", "���", "�Ϲ�", "��", "��� �ʶ���, ���� �ʶ���, �ػ깰 �丶�� �Ľ�Ÿ"));

		storeList.add(new Store("���", "�߽�", "�Ϲ�", "��", "���� ũ�� «��, ���� ũ�� ����"));
		storeList.add(new Store("ȫ�����0410", "�߽�", "�Ϲ�", "��", "«��, ¥���, ���¥��"));
		storeList.add(new Store("�߳��� ����", "�߽�", "�Ϲ�", "��", "�߳��쵿, ������"));
		storeList.add(new Store("ȫ¥��", "�߽�", "�Ϲ�", "��", "«��, ¥���"));
		storeList.add(new Store("Ī����", "�߽�", "�Ϲ�", "��", "�粿ġ, «��"));

		storeList.add(new Store("���ϴ� ����", "�Ͻ�", "�Ϲ�", "��", "��ī�� ��ġ ����, ī�� �����, ��ġ�� ũ�� �쵿"));
		storeList.add(new Store("���ϵ� ����", "�Ͻ�", "�Ϲ�", "��", "����, ��Ű��Ű �쵿"));
		storeList.add(new Store("�ٰ���", "�Ͻ�", "�Ϲ�", "��", "�ٰ��� ���, ������ ���"));
		storeList.add(new Store("���������� ��� ��", "�Ͻ�", "�Ϲ�", "��", "ī���̰�����, ������ ���"));
		storeList.add(new Store("88�Ĵ�", "�Ͻ�", "�Ϲ�", "��", "ī��ư� ����, �󹫳�"));
		// �Ϲ�
		storeList.add(new Store("����", "�ѽ�", "����", "��", "�����, ���屹"));
		storeList.add(new Store("����޴� ��������", "�ѽ�", "����", "��", "��������"));
		storeList.add(new Store("����", "�ѽ�", "����", "��", "���"));

		storeList.add(new Store("Ȳ�ݼ�", "�߽�", "����", "��", "�߳��쵿, ����¥��"));
		storeList.add(new Store("��Ȳ��", "�߽�", "����", "��", "¥���, «��, ������"));
		// ����
		setUndecorated(true);
		setSize(800, 600);
		setTitle("���� �� ����?");
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
				selectedDoor = "�ʹ�";
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
				selectedDoor = "����";
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
				selectedDoor = "�Ϲ�";
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
				selectedDoor = "����";
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
				selectedMenu = "�ѽ�";
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
				selectedMenu = "�߽�";
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
				selectedMenu = "���";
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
				selectedMenu = "�н�";
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
				selectedMenu = "�Ͻ�";
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
