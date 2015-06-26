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
	
	public MissionLader(List<String> abgeschlossen) {
		super("missionen");
		
		// das ist ein alternativer Konstrukter, der abgeschlossene
		// Missionen nicht hinzufügt
		
		for(int i = 0; i < props.size(); i++) {
			Mission tmpMission = new Mission(props.get(i));
			System.out.println(abgeschlossen.isEmpty());
			if(abgeschlossen.contains(tmpMission.getName())) {
				continue;
			} else {
				missionen.add(tmpMission);
			}
		}
	}
	
	public List<Mission> getMissionen() {
		// die fertig initialisierten Missionen in einem Array zurückgeben
		return missionen;
	}
}
