import java.util.*;

public class CharakterLader extends AbstractLader {

	private List<Charakter> charaktere = new ArrayList<Charakter>();
	
	public CharakterLader(boolean savegame) {
		super((savegame) ? "savegames" : "charaktere");
		// das ist ein kleiner Hack, ein inline-if
		// Das Problem ist, dass super() unbedingt der erste Aufruf im Konstruktor
		// sein möchte und davor nichts stehen darf.
		// Hier wird überprüft, ob savegame=true, und wenn true dann wird "savegame"
		// übergeben und wenn false, dann wird "charaktere" übergeben

		
		for(int i = 0; i < props.size(); i++) {
			charaktere.add(new Charakter(props.get(i)));
		}
	}
	
	public List<Charakter> getCharaktere() {
		// die fertig initialisierten Charaktere in einem Array zurückgeben
		return charaktere;
	}
	
}
