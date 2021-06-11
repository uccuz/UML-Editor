package menuItems;

public class ExitItem extends MenuItem {

	public ExitItem(String name) {
		super(name);
	}

	@Override
	public void actionPerformed() {
		System.exit(0);
	}

}
