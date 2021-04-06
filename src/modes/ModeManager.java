package modes;

import java.util.ArrayList;


public class ModeManager {

	private ArrayList<Mode> modes = new ArrayList<Mode>();
	
	private final int TOTALMODE = 6;
	
	Mode currentMode = null;
	
	public ModeManager() {
		//Set all mode
		modes.add(new SelectMode());
		modes.add(new AssociationMode());
		modes.add(new GeneralizationMode());
		modes.add(new CompositionMode());
		modes.add(new ClassMode());
		modes.add(new UseCaseMode());
	}
	
	public void setCurrentMode(int i) {
		if(i >= 0 && i < TOTALMODE)
			currentMode = modes.get(i);
	}
	
	public Mode GetCurrentMode() {
		return currentMode;
	}
	
}
