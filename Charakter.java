import java.util.*;

public class Charakter {

	private Properties prop;
	
	public Charakter(Properties prop) {	
		// Übernehmen der Properties
		this.prop = prop;
	}
	
	// ein ganzer Haufen getter und setter...
	public Properties getProp() {
		return prop;
	}
	
	public double getMoney() {
		// die Geldmenge aus den Properties auslesen
		return Double.parseDouble(prop.getProperty("money"));
	}
	
	public void setMoney(double money) {
		// die Geldmenge in die Properties schreiben
		prop.setProperty("money", ""+money);
	}
	
	public int getSkills() {
		// die Skills aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("skills"));
	}
	
	public void setSkills(int skills) {
		// die Skills in die Properties schreiben
		prop.setProperty("skills", ""+skills);
	}
	
	public int getServerleistung() {
		// die Serverleistung aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("serverleistung"));
	}
	
	public void setServerleistung(int serverleistung) {
		// die Serverleistung in die Properties schreiben
		prop.setProperty("serverleistung", ""+serverleistung);
	}
	
	public int getSchlafbedarf() {
		// den Schlafbedarf aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("schlafbedarf"));
	}
	
	public void setSchlafbedarf(int schlafbedarf) {
		// den Schlafbedarf in die Properties schreiben
		prop.setProperty("schlafbedarf", ""+schlafbedarf);
	}
	
	public int getMatebedarf() {
		// den Matebedarf aus den Properties auslesen
		return Integer.parseInt(prop.getProperty("matebedarf"));
	}
	
	public void setMatebedarf(int matebedarf) {
		// den Matebedarf in die Properties schreiben
		prop.setProperty("matebedarf", ""+matebedarf);
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
}
