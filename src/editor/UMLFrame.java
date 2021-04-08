package editor;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class UMLFrame extends JFrame{
	
	// Frame size
	final int WIDTH = 1000;
	final int HEIGHT = 700;
	
	// Frame title
	final String TITLE = "UML editor";
	
	// Component
    Canvas Canvas;
	ToolBar toolBar;
	MenuBar menuBar;
	
	UMLFrame(){
		
		// Initialize component
		Canvas  = Canvas.getInstance();
		toolBar = new ToolBar();
		menuBar = new MenuBar();
		
		// Initialize frame
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		// Add component into frame
		this.add(Canvas,BorderLayout.CENTER);
		this.add(toolBar,BorderLayout.WEST);
		this.setJMenuBar(menuBar);
	}
	

}
