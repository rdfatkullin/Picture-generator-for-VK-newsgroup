import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class ListenerInter implements ActionListener{
	InterfaceCreator in;
	Printer print;
	
	public ListenerInter(InterfaceCreator in, Printer print){
		this.in = in;
		this.print = print;
		in.button.addActionListener(this);
	}
	
	public void getURLImage() {
		//Trying to get image from URL, sending that image to printer object
		try {
			URL url = new URL(in.txtURL.getText());
			print.getBackground(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ev) {
		
		//creating whole image based on choises made
		if (in.groupPenguins.getSelection() != null) {
			print.setWidgth(in.textWidgth.getText());
			getURLImage();
			String title = in.textTitle.getText();
			String up = in.textUp.getText();
			String angle = in.textAngle.getText();
			print.printAll(in.groupPenguins.getSelection().getActionCommand(), title, up, angle, (String) in.comboBox.getSelectedItem(), (String) in.comboBox_1.getSelectedItem());
		} else {
			JOptionPane.showMessageDialog(null, "Choose a penguin");
		}			
	}
}
