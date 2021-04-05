package editor;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class UMLFrame extends JFrame{
	
	// Frame size
	final int WIDTH = 1000;
	final int HEIGHT = 700;
	
	// Component
	DrawingArea drawingArea;
	ToolBar toolBar;
	MenuBar menuBar;
	
	UMLFrame(){
		
		// Initialize component
		drawingArea = new DrawingArea();
		toolBar = new ToolBar();
		menuBar = new MenuBar();
		
		// Initialize frame
		this.setTitle("UML editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		// Add component into frame
		this.add(drawingArea,BorderLayout.CENTER);
		this.add(toolBar,BorderLayout.WEST);
		this.add(menuBar,BorderLayout.NORTH);
	}
	

}
