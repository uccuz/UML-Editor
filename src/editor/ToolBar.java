package editor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import modes.*;


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
	BtnListener btnListener = new BtnListener();
	Canvas canvas = Canvas.getInstance();
	
	ToolBar() {
		
		// ToolBar setting
		this.setLayout(new GridLayout(btnNum,1));
		this.setFloatable(false); // can't be moved
		
		// Create button
		DrawBtn selectBtn = new DrawBtn(selectIcon, new SelectMode());
		DrawBtn associationBtn = new DrawBtn(associationIcon, new AssociationMode());
		DrawBtn generalizationBtn = new DrawBtn(generalizationIcon, new GeneralizationMode());
		DrawBtn compositionBtn = new DrawBtn(compositionIcon, new CompositionMode());
		DrawBtn classBtn = new DrawBtn(classIcon, new ClassMode());
		DrawBtn useCaseBtn = new DrawBtn(useCaseIcon, new UseCaseMode());
		
		// Add button listener
		selectBtn.addActionListener(btnListener);
		associationBtn.addActionListener(btnListener);
		generalizationBtn.addActionListener(btnListener);
		compositionBtn.addActionListener(btnListener);
		classBtn.addActionListener(btnListener);
		useCaseBtn.addActionListener(btnListener);
		
		// Add button into toolBar
		this.add(selectBtn);
		this.add(associationBtn);
		this.add(generalizationBtn);
		this.add(compositionBtn);
		this.add(classBtn);
		this.add(useCaseBtn);
	
	}
	
	// Listen all button event
	private class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Set new hold button
			if(holdBtn != null)
				holdBtn.setBackground(Color.white);
			if(e.getSource() instanceof DrawBtn)
				holdBtn = (DrawBtn) e.getSource();
			if(holdBtn != null) {
				holdBtn.setBackground(Color.gray);
				canvas.setMode(holdBtn.getMode());
			}
		}
	}
	
	private class DrawBtn extends JButton {
		
		Mode mode = null;
		
		DrawBtn(ImageIcon icon, Mode mode) {
			this.setIcon(icon);
			this.mode = mode;
		}
		
		public Mode getMode() {
			return mode;
		}
		
	}
}
