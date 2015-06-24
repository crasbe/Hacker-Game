import javax.swing.JFrame;

// da Java keine Mehrfachvererbung kann, bekommt einfach jedes Minigame
// durch seine Mutterklasse den JFrame reingewürgt :)
public abstract class AbstractMiniGame extends JFrame {
	// das ist die "Mutterklasse" für jedes Minigame
	
	public AbstractMiniGame(String titel) {
		// hier wird der Konstruktor von JFrame aufgerufen und der
		// Titel des Fensters/der Name des Minigames übergeben
		super(titel);
	}
	
	// Diese Methode sorgt für die Initialisierung der Minigames,
	// z.B. fürs Füllen von Rechenaufgaben.
	// Jedes Minigame muss diese Methode implementieren.
	public void initialisieren() {};
	
	// Diese Methode wird so lange aufgerufen, bis der Rückgabewert
	// auf "true" wechselt.
	// Dann wird "anzahlVersuche" aufgerufen, um die Anzahl der
	// Versuche, die bis zur Lösung gebraucht wurden, aufgerufen.
	public boolean erfolgreichGeloest() {
		return false;
	};
	public int anzahlVersuche() {
		return 0;
	}
	
	// jedes Minigame muss das Attribut "schwierigkeit" implementieren,
	// mit dem entschieden wird, welches Spiel für einen Hackvorgang
	// ausgewählt wird
	// Es gibt die Schwierigkeitsgrade 1-3 und 0 bedeutet "nicht ausführen!".
	public int schwierigkeit;
	
}
