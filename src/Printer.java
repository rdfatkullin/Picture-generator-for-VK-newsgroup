import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Printer extends JFrame{
	
	Drawable back;
	Drawable peng;
	int x;
	int y;
	int y0;
	int y1;
	TreeMap<String, Integer []> colors;
	BufferedImage buf;
	Graphics imgGrap;
	
	public Printer() {
		//Создаем новый фрейм, задаем размеры, создаем treemap с цветами
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		colors = new TreeMap<String, Integer []>();
		colors.put("Черный", new Integer[] {23, 22, 22});
		colors.put("Синий", new Integer[] {1, 23, 53});
		colors.put("Белый", new Integer[] {247, 247, 247});
	}
	
	public void setWidgth(String w) {
		Dimension d = new Dimension();
		x = Integer.parseInt(w);
		y = (int) (Double.parseDouble(w)/16 * 9);
		d.setSize(x, y);
		getContentPane().setPreferredSize(d);
		pack();
	}
	
	
	public void getBackground(URL url) {
		//Запоминаем картинку по ссылке
		back = new Drawable(url);
	}
	
	public void printStrip() {
		// Устанавливаем цвета для градиента, сам градиент + рисуем ленту
		Graphics2D gg = (Graphics2D) imgGrap;
		Color startColor = new Color (252,252,252,204);
		Color endColor = new Color (220,233,250,204);
		gg.setPaint(new GradientPaint(5,3, startColor, 100, 200, endColor));
		y0 = (int) Math.round(0.85 * y);
		y1 = (int) Math.round(0.94 * y);
		gg.fillRect(0, y0, getWidth(), y1-y0);
		imgGrap = gg;
	}
	
	public void printText(String title, String up, String angle, String colorUp, String colorAngle) {
		// Рисуем надписи, начинаем с основной
		title = title.toUpperCase();
		Graphics2D gg = (Graphics2D) imgGrap;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gg.setColor(new Color (colors.get("Синий")[0], colors.get("Синий")[1], colors.get("Синий")[2]));
		int fontSize = getFont(title);
		gg.setFont(new Font("Segoe UI Light", Font.PLAIN, fontSize));
		gg.drawString(title, x/2 - (int) (x*0.12) - (int) Math.round(fontSize*title.length()*0.3), y0 + (y1 - y0)/2+ (int) Math.round(0.34*fontSize));

		//Рисуем надпись выше основной
		fontSize = getFont(up);
		up = up.toUpperCase();
		gg.setColor(new Color (colors.get(colorUp)[0], colors.get(colorUp)[1], colors.get(colorUp)[2]));
		gg.setFont(new Font("Segoe UI Light", Font.PLAIN, (int) Math.round(fontSize*0.5)));
		gg.drawString(up, x/2 - (int) Math.round(up.length()*0.125), y0 - (int)Math.round(y * 0.005));
		
		//Рисуем надпись под углом
		fontSize = getFont(angle);
		angle = angle.toUpperCase();
		gg.setColor(new Color (colors.get(colorAngle)[0], colors.get(colorAngle)[1], colors.get(colorAngle)[2]));
		gg.setFont(new Font("Segoe UI Light", Font.PLAIN, (int) Math.round(fontSize*0.7)));
		gg.rotate(-0.5);
		gg.drawString(angle, x/2 - (int) Math.round(up.length()*0.3), y0 + (int)Math.round(y * 0.22));
		gg.rotate(0.2);
		
		imgGrap = gg;
	}
	
	public int getFont(String s) {
		if (s.length() < 26) {
			return (int) (Math.round(0.08 * y));
		} else {
			return (int) (Math.round(0.08 * y) - s.length()*0.3);
		}
	}
	
	public void saveImage() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		try {
			ImageIO.write(buf, "PNG", new File("resources/output/" + dateFormat.format(date) + ".PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printAll(String btn, String title, String up, String angle, String colorUp, String colorAngle) {
		//Выводим все на экран
		buf = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
		imgGrap = buf.getGraphics();
		peng = new Drawable("resources/ping/" + btn + ".png");
		imgGrap.drawImage(back.getImage(), 0, 0, x, y, 0, 0, back.imgIc.getIconWidth(), back.imgIc.getIconHeight(), null);					// Рисуем фон
		printStrip();
		printText(title, up, angle, colorUp, colorAngle);
        int px = (int) Math.round(0.4*x);
        int py = (int) Math.round(0.7*y);
		imgGrap.drawImage(peng.getImage(), px, py, x, (int) (1.74*y), 0, 0, peng.imgIc.getIconWidth(), peng.imgIc.getIconHeight(), null);	// Рисуем пингвина
        saveImage();
		
		JPanel pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(buf, 0, 0, null);
			}
		};
		add(pane);
		setVisible(true);
		return;
	}

}
