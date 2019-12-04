package whatsForLunch_6;

import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogFrame extends JFrame{
	private JTextArea logText = new JTextArea(10 ,30);
	
	public LogFrame() {
		setVisible(true);
		setTitle("±‚∑œ√¢");
		setResizable(false);
		setSize(400,700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			logText.append(Log.loadLog());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logText.setEditable(false);
		add(logText);
	}
}
