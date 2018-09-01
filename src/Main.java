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
		InterfaceCreator iCr = new InterfaceCreator();	//Создаем интерфейс
		Printer print = new Printer();					//Генерируем принтер
		lisn = new ListenerInter(iCr, print);			//Создаем слушателя
	}
}
