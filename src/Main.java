import java.awt.Font;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class Main {
	Graphics grph;
	JFrame frame;
	JFrame interf;
	static ListenerInter lisn;

	public static void main(String[] args) {
		InterfaceCreator iCr = new InterfaceCreator();		//Creating user interface
		Printer print = new Printer();				//Creating printer object (for handling operation with graphics)
		lisn = new ListenerInter(iCr, print);			//Creating action listener for user interface
	}
}
