package editor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;


public class ToolBar extends JToolBar{
	
	private final int btnNum = 6; 
	
	// Image source
	ImageIcon selectIcon = new ImageIcon("img/select.png");
	ImageIcon associationIcon = new ImageIcon("img/association.png");
	ImageIcon generalizationIcon = new ImageIcon("img/generalization.png");
	ImageIcon compositionIcon = new ImageIcon("img/composition.png");
	ImageIcon classIcon = new ImageIcon("img/class.png");
	ImageIcon useCaseIcon = new ImageIcon("img/useCase.png");
	
	// Setting
	DrawBtn holdBtn = null;
	
	ToolBar() {
		
		// ToolBar setting
		this.setLayout(new GridLayout(btnNum,1));
		this.setFloatable(false); // can't be moved
		
		// Create button
		DrawBtn selectBtn = new DrawBtn(selectIcon, 0);
		DrawBtn associationBtn = new DrawBtn(associationIcon, 1);
		DrawBtn generalizationBtn = new DrawBtn(generalizationIcon, 2);
		DrawBtn compositionBtn = new DrawBtn(compositionIcon, 3);
		DrawBtn classBtn = new DrawBtn(classIcon, 4);
		DrawBtn useCaseBtn = new DrawBtn(useCaseIcon, 5);
		
		// Add button into toolBar
		this.add(selectBtn);
		this.add(associationBtn);
		this.add(generalizationBtn);
		this.add(compositionBtn);
		this.add(classBtn);
		this.add(useCaseBtn);
	
	}
	

	
	private class DrawBtn extends JButton {
		
		int managerNum = -1;
		
		DrawBtn(ImageIcon icon, int managerNum) {
			this.setIcon(icon);
			this.managerNum = managerNum;
			this.addActionListener(new BtnListener());
		}
		
		private class BtnListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("trigger");
				
				// Set button color
				if(holdBtn != null) {
					holdBtn.setBackground(Color.white);
				}
				holdBtn = (DrawBtn) e.getSource();
				holdBtn.setBackground(Color.gray);
				
				//System.out.println(managerNum);
				// Set Canvas mode
				Canvas.getInstance().setMode(managerNum);
			}
			
		}
		
	}
}
