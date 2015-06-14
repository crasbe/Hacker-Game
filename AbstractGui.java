
import javax.swing.*;

public abstract class AbstractGui extends JFrame {

	public volatile boolean schliessMich = false;
	
	public AbstractGui(String titel) {
		super(titel);
	}
	
	public void guiAnzeigen() {
		setVisible(true);
	};
	
	public void guiAusblenden() {
		setVisible(false);
	};
	
	public void initialisieren() {};
	
}
