package editor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class DrawingArea extends JPanel {

	DrawingArea() {
		
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(Color.green);
	}
}
