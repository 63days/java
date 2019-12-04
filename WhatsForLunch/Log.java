package whatsForLunch_6;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	private Store store;
	private String date;
	private SimpleDateFormat d_format;
	
	public Log(Store store) {
		this.store = store;
		d_format = new SimpleDateFormat("yy³â MM¿ù ddÀÏ");
		Date d = new Date();
		date = d_format.format(d);
	}
	public void saveLog() throws IOException {
		FileWriter fw = null;
		try {
			fw = new FileWriter("Log.txt", true);
			fw.write(this.date+" "+store.getDoor()+" "+store.getType()+" "+store.getName() + "\r\n");
			fw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			fw.close();
		}
	}
	public static String loadLog() throws IOException {
		FileInputStream fin = new FileInputStream("Log.txt");
		InputStreamReader load = new InputStreamReader(fin, "MS949");
		int c;
		String str = "";
		try {
			while((c=load.read())!= -1) {
				str += (char)c;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			load.close();
		}
		return str;
	}
}