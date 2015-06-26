import java.awt.event.*;

import javax.swing.*;

public abstract class AbstractGui extends JFrame {

	public volatile boolean terminiert = false;
	
	public AbstractGui() {

		// Es gibt zwei Arten, wie ein Fenster beendet wird:
		// - Der User klickt einen Button und die Aufgabe des Fensters ist erledigt.
		// - Der User drückt auf das rote X und beendet das Fenster.
		// 
		// Der zweite Fall ist hier der interessantere, weil er nicht "bewusst" passiert.
		// Bedeutet: der übergeordneten Klasse, die ein Objekt der GUI-Klasse besitzt,
		// weiß nicht, dass das Fenster geschlossen wird.
		// Die Lösung hier ist, dass die übergeordnete Klasse darauf wartet, dass das
		// Fenster nicht mehr sichtbar ist.
		// Wenn dies passiert, wird überprüft, ob die Variable "terminated" gesetzt wurde,
		// also ob das Fenster geschlossen wurde und die Aufgabe nicht erfüllt wurde.
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		// HIDE_ON_CLOSE macht das Fenster unsichtbar, wenn auf das rote X gedrückt wird
		
		addWindowListener(new WindowAdapter() { 		// Der WindowListener ist ähnlich zum
			@Override									// ActionListener und wartet auf Veränderungen
			public void windowClosing(WindowEvent e) {	// des Fensters.
				terminiert = true;
			}		// Das Fenster wurde terminiert.
		});
	}
	
	public void guiAusblenden() {
		setVisible(false);
		dispose();
	}
	
	public void initialisieren() {};
	
	public void initialisieren(Charakter charakter) {};
	
}
