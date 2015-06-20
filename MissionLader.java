
import java.io.*;
import java.util.*;

public class MissionLader extends AbstractLader {

	// Attribute
	private List<Mission> missionen = new ArrayList<Mission>();
	
	// Konstruktor
	public MissionLader() {
		super("missionen");
		
		// Hier werden final und endlich die Missionsobjekte initialisiert.
		// Das hätte auch in die for-Schleife oben hineingekonnt, aber der
		// Übersichtlichkeit halber ist es in drei separaten Schleifen.
		// Außeredem wird das ja nur einmal aufgerufen :)
		for(int i = 0; i < props.size(); i++) {
			missionen.add(new Mission(props.get(i)));
		}
	}
	
	public List<Mission> getMissionen() {
		// die fertig initialisierten Missionen in einem Array zurückgeben
		return missionen;
	}
}
