import java.util.*;

public class Mission {

	private Properties prop;
	
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

	public double getKosten() {
		// die Kosten aus den Properties auslesen
		return Double.parseDouble(prop.getProperty("kosten"));
	}

	public double getGewinn() {
		// den Gewinn aus den Properties auslesen
		return Double.parseDouble(prop.getProperty("gewinn"));
	}
	
	public boolean isHauptmission() {
		// zurückgeben, ob die Mission eine Hauptmission ist
		return Boolean.parseBoolean(prop.getProperty("hauptmission"));
	}
}
