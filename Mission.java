
import java.util.*;

public class Mission {

	private String name;
	private String beschreibung;
	private int schwierigkeit;
	private int skillverbesserung;
	private double kosten;
	private double gewinn;
	private boolean hauptmission;
	
	public Mission(Properties prop) {
		name = prop.getProperty("name");
		beschreibung = prop.getProperty("beschreibung");
		schwierigkeit = Integer.parseInt(prop.getProperty("schwierigkeit"));
		skillverbesserung = Integer.parseInt(prop.getProperty("skillverbesserung"));
		kosten = Double.parseDouble(prop.getProperty("kosten"));
		gewinn = Double.parseDouble(prop.getProperty("gewinn"));
		hauptmission = Boolean.parseBoolean(prop.getProperty("hauptmission"));
		
		
	}

	// ein großer Haufen getter-Methoden
	public int getSkillverbesserung() {
		return skillverbesserung;
	}

	public String getName() {
		return name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public int getSchwierigkeit() {
		return schwierigkeit;
	}

	public double getKosten() {
		return kosten;
	}

	public double getGewinn() {
		return gewinn;
	}
	
	public boolean isHauptmission() {
		return hauptmission;
	}

}
