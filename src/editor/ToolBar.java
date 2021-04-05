package editor;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar{
	
	private final int btnNum = 6; 
	
	ImageIcon selectIcon = new ImageIcon("img/select.png");
	ImageIcon associationIcon = new ImageIcon("img/association.png");
	ImageIcon generalizationIcon = new ImageIcon("img/generalization.png");
	ImageIcon compositionIcon = new ImageIcon("img/composition.png");
	ImageIcon classIcon = new ImageIcon("img/class.png");
	ImageIcon useCaseIcon = new ImageIcon("img/useCase.png");
	
	ToolBar() {
		
		// ToolBar setting
		this.setLayout(new GridLayout(btnNum,1));
		this.setFloatable(false); // can't be moved
		
		// Create button
		JButton selectBtn = new JButton(selectIcon);
		JButton associationBtn = new JButton(associationIcon);
		JButton generalizationBtn = new JButton(generalizationIcon);
		JButton compositionBtn = new JButton(compositionIcon);
		JButton classBtn = new JButton(classIcon);
		JButton useCaseBtn = new JButton(useCaseIcon);
		
		// Add button into toolBar
		this.add(selectBtn);
		this.add(associationBtn);
		this.add(generalizationBtn);
		this.add(compositionBtn);
		this.add(classBtn);
		this.add(useCaseBtn);
		
	
	}
}
