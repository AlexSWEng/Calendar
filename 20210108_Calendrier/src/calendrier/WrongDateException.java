package calendrier;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class WrongDateException extends Exception {
	
	String msg;
	public WrongDateException(String s) {
		this.msg = s;

	}
	public String getMsg() {
		return msg;
	}
	
	
	
}
