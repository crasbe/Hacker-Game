
import java.util.*;

public class HackerGame {
	// Hauptklasse des Spiels mit dem das Spiel auch gestartet wird
	
	private static Charakter charakterSpiel; 	// der Charakter, mit dem gespielt wird
												// #playwithme
	private static AbstractGui guiCharAusw;
	private static AbstractGui guiHub;
	
	
	public static void main(String[] args) {
		// die Charaktere laden
		List<Charakter> defaultChars = new CharakterLader(false).getCharaktere();
		List<Charakter> saveChars = new CharakterLader(true).getCharaktere();
		
		// hier ist die Charakter Auswahl GUI aktiv
		guiCharAusw = new GuiCharAusw(defaultChars, saveChars);
		guiCharAusw.setVisible(true);
		warten(guiCharAusw);
		guiCharAusw.setVisible(false);
		charakterSpiel = ((GuiCharAusw) guiCharAusw).getCharakterAuswahl();
		
		// hier ist die Hub Gui aktiv
		guiHub = new GuiHub(new MissionLader().getMissionen());
		guiHub.initialisieren(charakterSpiel);
		guiHub.setVisible(true);
		warten(guiHub);

		
		System.exit(0);
	}
	
	public static void warten(AbstractGui gui) {
		// Das GUI-System funktioniert so, dass wenn ein Fenster
		// nicht mehr sichtbar ist, angenommen wird, dass es seine
		// Aufgabe erfüllt hat ODER es beendet wurde.
		
		// Warte, bis das Fenster nicht mehr sichtbar ist.
		while(gui.isVisible() == true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		if(gui.terminiert == true) {
			// Wenn das Fenster mit Hilfe des roten X geschlossen wurde,
			// ist das Attribut "terminiert" gesetzt und das Programm
			// wird beendet.
			
			// TODO: Abspeichern einfügen.
			System.exit(0);
		}
	}
}
