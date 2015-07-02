import java.util.*;

public class Charakter {

	private Properties prop;
	
	public Charakter(Properties prop) {	
		// Übernehmen der Properties
		this.prop = prop;
		
		// eine kleine Überprüfung, ob alle Properties gesetzt sind
		boolean fail = false;	// wenn das Attribut "fail" auf true wechselt, wird das
								// Programm am Ende der Überprüfung terminiert
    
    	String[] charProps = {	"abgeschlossen", "money", "skills", "serverleistung",
    							"schlafbedarf", "matebedarf", "name", "speicherdatum",
    							"kurzbeschreibung" };

		for (int i = 0; i < charProps.length; i++) {
			if (prop.containsKey(charProps[i]) == false) {
				System.out.println("Charakter-Property '"+charProps[i]+"' fehlt!");
				fail = true;
			}
		}
		if (fail == true) {
			System.out.println("Property "+prop.getProperty("name"));
			System.exit(-1);
		}
	}
	
	// ein ganzer Haufen getter und setter...
	public Properties getProp() {
		return prop;
	}
	
	public int getMoney() {
		// die Geldmenge aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("money"));
	}
	
	public void setMoney(int money) {
		// die Geldmenge in die Properties schreiben
		prop.setProperty("money", ""+money);
	}
	
	public void addMoney(int money) {
		prop.setProperty("money", ""+(this.getMoney()+money));
	}
	
	public int getSkills() {
		// die Skills aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("skills"));
	}
	
	public void setSkills(int skills) {
		// die Skills in die Properties schreiben
		prop.setProperty("skills", ""+skills);
	}
	
	public void addSkills(int skills) {
		prop.setProperty("skills", ""+(this.getSkills()+skills));
	}
	
	public int getServerleistung() {
		// die Serverleistung aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("serverleistung"));
	}
	
	public void setServerleistung(int serverleistung) {
		// die Serverleistung in die Properties schreiben
		prop.setProperty("serverleistung", ""+serverleistung);
	}
	
	public void addServerleistung(int serverleistung) {
		prop.setProperty("serverleistung", ""+(this.getServerleistung()+serverleistung));
	}
	
	public int getSchlafbedarf() {
		// den Schlafbedarf aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("schlafbedarf"));
	}
	
	public void setSchlafbedarf(int schlafbedarf) {
		// den Schlafbedarf in die Properties schreiben
		prop.setProperty("schlafbedarf", ""+schlafbedarf);
	}
	
	public void addSchlafbedarf(int schlafbedarf) {
		prop.setProperty("schlafbedarf", ""+(this.getSchlafbedarf()+schlafbedarf));
	}
	
	public int getMatebedarf() {
		// den Matebedarf aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("matebedarf"));
	}
	
	public void setMatebedarf(int matebedarf) {
		// den Matebedarf in die Properties schreiben
		prop.setProperty("matebedarf", ""+matebedarf);
	}
	
	public void addMatebedarf(int matebedarf) {
		prop.setProperty("matebedarf", ""+(this.getMatebedarf()+matebedarf));
	}
	
	public String getName() {
		// den Namen aus den Properties auslesen
		return prop.getProperty("name");
	}
	
	public void setName(String name) {
		// den Namen in die Properties schreiben
		prop.setProperty("name", name);
	}
	
	public String getSpeicherdatum() {
		// das Speicherdatum aus den Properties auslesen
		return prop.getProperty("speicherdatum");
	}
	
	public void setSpeicherdatum(String datum) {
		// das Speicherdatum in die Properties schreiben
		prop.setProperty("speicherdatum", datum);
	}
	
	public String getKurzbeschreibung() {
		// die Kurzbeschreibung aus den Properties auslesen
		return prop.getProperty("kurzbeschreibung");
	}
	
	public int getPreisServerleistung() {
		return Integer.parseInt(prop.getProperty("preisserv"));
	}
	
	public void setPreisServerleistung(int preis) {
		prop.setProperty("preisserv", ""+preis);
	}
	
	public int getPreisMate() {
		return Integer.parseInt(prop.getProperty("matepreis"));
	}
	
	public void setPreisMate(int preis) {
		prop.setProperty("preismate", ""+preis);
	}
	
	public List<String> getAbgeschMissionen() {
		// die abgeschlossenen Missionen als Liste aus den Properties auslesen
		String[] abgeschMissionenTmp = prop.getProperty("abgeschlossen").split(",");
		List<String> abgeschMissionen = new ArrayList<String>();
		
		// TODO: Bessere Methode zur Typenumwandlung
		if(abgeschMissionenTmp.length > 1) {
			for(int i = 0; i < abgeschMissionenTmp.length; i++) {
				abgeschMissionen.add(abgeschMissionenTmp[i]);
			}
		}
		
		return abgeschMissionen;
		
	}
	
	public void setAbgeschMissionen(List<String> missionen) {
		// die abgeschlossenen Missionen in die Properties schreiben
		// temporärer String, in dem die abgeschlossenen Missionen
		// durch Kommata getrennt gespeichert werden
		String tmp = "";
		
		for(int i = 0; i < missionen.size(); i++) {
			tmp += missionen.get(i);
		}
		prop.setProperty(	"abgeschlossen", tmp.substring(0, tmp.length()-2));
	}
	
	public void addAbgeschMissionen(String mission) {
		// den abgeschlossenen Missionen der Properties einen Eintrag hinzufügen
		prop.setProperty("abgeschlossen", prop.getProperty("abgeschlossen")+","+mission);
	}
	
	public void missionErfolg(Mission mission) {
		this.addAbgeschMissionen(mission.getName());
		this.addMoney(mission.getGewinn()-mission.getKosten());
		this.addSkills(mission.getSkillverbesserung());
		this.addSchlafbedarf(mission.getSchlafbedarf());
	}
	
	public void missionFehlschlag(Mission mission) {
		// Geld verloren
		this.addMoney(0-mission.getKosten());
		this.addSchlafbedarf(mission.getSchlafbedarf());
	}
	
	public int berechneMglSchwierigkeitsgrad() {
		System.out.println(getSchlafbedarf());
		int tmp = (int) (getSkills() * getServerleistung() * getMatebedarf()) / getSchlafbedarf();
		int schwierigkeitsgrad;
		
		schwierigkeitsgrad = tmp/6 + 1;
		
		return schwierigkeitsgrad;
		
	}
}
