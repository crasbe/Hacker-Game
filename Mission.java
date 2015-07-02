import java.util.*;

public class Mission {

	// Attribute
	private Properties prop;
	
	
	// Konstruktor
	public Mission(Properties prop) {
		// die Properties übernehmen
		this.prop = prop;
	}

	
	// ein großer Haufen getter und setter...
	public Properties getProp() {
		// die Properties zurückgeben
		return prop;
	}
	
	public int getSkillverbesserung() {
		// die Skillverbesserung aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("skillverbesserung"));
	}

	public String getName() {
		// den Namen aus den Properties auslesen
		return prop.getProperty("name");
	}

	public String getBeschreibung() {
		// die Beschreibung aus den Properties auslesen
		return prop.getProperty("beschreibung");
	}

	public int getSchwierigkeit() {
		// die Schwierigkeit aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("schwierigkeit"));
	}

	public int getKosten() {
		// die Kosten aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("kosten"));
	}

	public int getGewinn() {
		// den Gewinn aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("gewinn"));
	}
	
	public boolean isHauptmission() {
		// zurückgeben, ob die Mission eine Hauptmission ist
		return Boolean.parseBoolean(prop.getProperty("hauptmission"));
	}
	
	public int getSpielzahl() {
		// gibt die Anzahl an zu spielenden Spielen zurück
		return Integer.parseInt(prop.getProperty("spielzahl"));
	}


	public int getSchlafbedarf() {
		return Integer.parseInt(prop.getProperty("schlafbedarf"));
	}
}
