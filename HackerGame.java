import java.util.*;

public class HackerGame {
	// Hauptklasse des Spiels mit dem das Spiel auch gestartet wird
	
	private static Charakter charakterSpiel; 	 // der Charakter, mit dem gespielt wird
	private static boolean charakterAusgewaehlt = false; // #playwithme
	private static AbstractGui guiCharAusw;
	private static AbstractGui guiHub;
	private static AbstractGui guiBasis;
	
	
	public static void main(String[] args) {
		// die Charaktere laden
		List<Charakter> defaultChars = new CharakterLader(false).getCharaktere();
		List<Charakter> saveChars = new CharakterLader(true).getCharaktere();
		
		// hier ist die Charakter Auswahl GUI aktiv
		guiCharAusw = new GuiCharAusw(defaultChars, saveChars);
		guiCharAusw.setVisible(true);
		warten(guiCharAusw);
		guiCharAusw.guiAusblenden();
		charakterSpiel = ((GuiCharAusw) guiCharAusw).getCharakterAuswahl();
		charakterAusgewaehlt = true;
		
		while(true) {
			
			// hier ist die Hub Gui aktiv
			guiHub = new GuiHub(new MissionLader(charakterSpiel.getAbgeschMissionen()).getMissionen());
			guiHub.initialisieren(charakterSpiel);
			guiHub.setVisible(true);
			warten(guiHub);
			guiHub.guiAusblenden();
			
			if(((GuiHub) guiHub).zuBasis()) {
				// Basis
				guiBasis = new GuiBasis(charakterSpiel);
				guiBasis.initialisieren();
				guiBasis.setVisible(true);
				warten(guiBasis);
				guiBasis.guiAusblenden();
				charakterSpiel = ((GuiBasis) guiBasis).getChar();
				continue;
			}
			
			Mission missionAuswahl = ((GuiHub) guiHub).getAusgewaehlteMission();
			
			MissionPlayer missionLauncher = new MissionPlayer(missionAuswahl);
			
			missionLauncher.starten();
			
			while(missionLauncher.isFertig() == false) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(missionLauncher.isFail()) {
				charakterSpiel.missionFehlschlag(missionAuswahl);
			} else {
				charakterSpiel.missionErfolg(missionAuswahl);
			}
			
			missionLauncher.beenden();
			
			speichern();
		}
		
		//System.exit(0);
	}
	
	private static void speichern() {
		if(charakterAusgewaehlt == true) {
			// sobald der Spieler einen Charakter ausgewählt hat, kann auch etwas
			// gespeichert werden. 
			class TmpSaver extends AbstractLader {}; // der AbstractLader wird hier
													 // ein bisschen missbraucht...
			new TmpSaver().saveProp("savegames", charakterSpiel.getProp());
		}
	}
	
	private static void warten(AbstractGui gui) {
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
			// wird beendet (vorher wird gespeichert).
			
			speichern();
			System.exit(0);
		}
	}
}
