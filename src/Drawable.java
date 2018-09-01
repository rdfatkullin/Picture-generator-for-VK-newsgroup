import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Drawable {
	
	ImageIcon imgIc;
	
	public Drawable (String file) {
		imgIc = new ImageIcon(file);
	}
	
	public Drawable (URL url) {
		imgIc = new ImageIcon(url);
	}
	
	public Image getImage() {
		return imgIc.getImage();
	}
	
}


