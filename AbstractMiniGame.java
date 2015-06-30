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
	
	public AbstractMiniGame(String titel) {
		// hier wird der Konstruktor von JFrame aufgerufen und der
		// Titel des Fensters/der Name des Minigames übergeben
		super(titel);
	}
	
	// Diese Methode sorgt für die Initialisierung der Minigames,
	// z.B. fürs Füllen von Rechenaufgaben.
	// Jedes Minigame muss diese Methode implementieren.
	public void initialisieren() {};
	
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
	
	public void reset() {
	// diese Methode sorgt dafür, dass das Spiel wieder auf Start zurückgesetzt
	// wird
	// FÜR MINIGAMES: diese Methode aufrufen und selbst zurücksetzen
	
	erfolg = false;
	fertig = false;
  }  
}
