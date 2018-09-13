import javax.swing.*;

//Creating user interface
public class InterfaceCreator extends JFrame{
	JFrame frame;
	JButton button;
	ButtonGroup groupPenguins;
	
	JTextField textTitle;
	JTextField textUp;
	JTextField textAngle;
	JTextField txtURL;
	JTextField textWidgth;
	
	JComboBox <String> comboBox;
	JComboBox <String> comboBox_1;
	
	public InterfaceCreator() {
		
		// Set close, window dimensions, location on screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(742, 280);
		setResizable(false);
		
		//Adding some text
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Основная надпись");
		label.setBounds(63, 39, 121, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Надпись над основной");
		label_1.setBounds(62, 70, 183, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Надпись под углом");
		label_2.setBounds(63, 101, 152, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Пингвины");
		label_3.setBounds(498, 11, 63, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Надписи");
		label_4.setBounds(190, 11, 72, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Ширина изображения");
		label_5.setBounds(63, 163, 152, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Цвет верхней надписи");
		label_6.setBounds(63, 195, 152, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Цвет надписи под углом");
		label_7.setBounds(418, 163, 143, 14);
		panel.add(label_7);
		
		JLabel lblUrl = new JLabel("URL картинки");
		lblUrl.setBounds(63, 132, 109, 14);
		panel.add(lblUrl);
		
		//Adding textfields
		textTitle = new JTextField();
		textTitle.setBounds(245, 36, 109, 20);
		panel.add(textTitle);
		textTitle.setColumns(10);
		
		textUp = new JTextField();
		textUp.setBounds(245, 67, 109, 20);
		panel.add(textUp);
		textUp.setColumns(10);
		
		textAngle = new JTextField();
		textAngle.setBounds(245, 98, 109, 20);
		panel.add(textAngle);
		textAngle.setColumns(10);
		
		txtURL = new JTextField();
		txtURL.setBounds(245, 129, 109, 20);
		panel.add(txtURL);
		txtURL.setColumns(10);
		
		textWidgth = new JTextField();
		textWidgth.setBounds(245, 160, 109, 20);
		panel.add(textWidgth);
		textWidgth.setColumns(10);				
		
		//Creating button set for choosing image
		groupPenguins = new ButtonGroup();
		
		JRadioButton rdbtnPs = new JRadioButton("PS4");
		rdbtnPs.setBounds(418, 72, 109, 23);
		groupPenguins.add(rdbtnPs);
		rdbtnPs.setActionCommand("PS4");
		panel.add(rdbtnPs);
		
		JRadioButton rdbtnXbox = new JRadioButton("Xbox");
		rdbtnXbox.setBounds(566, 72, 109, 23);
		groupPenguins.add(rdbtnXbox);
		rdbtnXbox.setActionCommand("Xbox");
		panel.add(rdbtnXbox);
		
		JRadioButton rdbtnPsvr = new JRadioButton("PSVR");
		rdbtnPsvr.setBounds(418, 112, 109, 23);
		groupPenguins.add(rdbtnPsvr);
		rdbtnPsvr.setActionCommand("PSVR");
		panel.add(rdbtnPsvr);
		
		JRadioButton rdbtnPc = new JRadioButton("PC");
		rdbtnPc.setBounds(566, 112, 109, 23);
		groupPenguins.add(rdbtnPc);
		rdbtnPc.setActionCommand("PC");
		panel.add(rdbtnPc);
		
		JRadioButton rdbtnSwitch = new JRadioButton("Switch1");
		rdbtnSwitch.setBounds(418, 35, 109, 23);
		groupPenguins.add(rdbtnSwitch);
		rdbtnSwitch.setActionCommand("Switch1");
		panel.add(rdbtnSwitch);
		
		JRadioButton rdbtnSwitch_1 = new JRadioButton("Switch2");
		rdbtnSwitch_1.setBounds(566, 35, 109, 23);
		groupPenguins.add(rdbtnSwitch_1);
		rdbtnSwitch_1.setActionCommand("Switch2");
		panel.add(rdbtnSwitch_1);
		
		//Creating generating button, set frame to visible
		button = new JButton("Генерировать");
		button.setBounds(466, 191, 144, 23);
		panel.add(button);
		
		//Creating combo box to choose colors
		String[] colors = {"Синий", "Черный", "Белый"};
		comboBox = new JComboBox<String>(colors);
		comboBox.setBounds(245, 191, 109, 22);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox<String>(colors);
		comboBox_1.setBounds(566, 155, 109, 22);
		panel.add(comboBox_1);
		
		
		
		setVisible(true);
	}
}
