import javax.swing.JFrame;

// da Java keine Mehrfachvererbung kann, bekommt einfach jedes Minigame
// durch seine Mutterklasse den JFrame reingewürgt :)
public abstract class AbstractMiniGame extends JFrame {
	// das ist die "Mutterklasse" für jedes Minigame
	
	// jedes Minigame muss das Attribut "schwierigkeit" implementieren,
	// mit dem entschieden wird, welches Spiel für einen Hackvorgang
	// ausgewählt wird
	// Es gibt die Schwierigkeitsgrade 1-3 und 0 bedeutet "nicht ausführen!".
	public int schwierigkeit;
	
	public int versuche = 0;
	public boolean erfolg = false;
	public boolean fertig = false;
	
	// Da diese zwei Fenster sowieso von allen Minigames benutzt werden,
	// können sie auch schon in der abstrakten Mutterklasse definiert werden.
	public AbstractGui guiWinScreen = new GuiWinScreen();
	public AbstractGui guiLoseScreen = new GuiLoseScreen();
	
	public AbstractMiniGame(String titel) {
		// hier wird der Konstruktor von JFrame aufgerufen und der
		// Titel des Fensters/der Name des Minigames übergeben
		super(titel);
	}
	
	// Diese Methode sorgt für die Initialisierung der Minigames,
	// z.B. fürs Füllen von Rechenaufgaben.
	// Jedes Minigame muss diese Methode implementieren.
	public void initialisieren() {
		// ein bisschen grundsätzliches Initialisieren, was bei jedem
		// Minigame gleich ist.
		erfolg = false;
		versuche = 0;
		fertig = false;
	};
	
	// Aufruf: fertig()? -> erfolgreichGeloest()? -> anzahlVersuche()
	
	public boolean erfolgreichGeloest() {
		// diese Methode gibt zurück, ob die Aufgabe erfolgreich gelöst
		// wurde
		return erfolg;
	}
	
	public int anzahlVersuche() {
		// diese Methode gibt die Anzahl der Versuche zur Lösung zurück
		return versuche;
	}
	
	public boolean fertig() {
		// diese Methode gibt zurück, ob das Spiel fertig/abgeschlossen ist
		return fertig;
	}
	
	@Override
	public void setVisible(boolean b) {
		// Die Methode "setVisible" der Mutterklasse wird überschrieben,
		// damit auch die anderen Fenster geschlossen werden
		if(b == false) {
			guiLoseScreen.setVisible(false);
			guiWinScreen.setVisible(false);
		}
		
		// die eigentliche Funktion (die Überschrieben wurde), aufrufen.
		super.setVisible(b);
	}
}
