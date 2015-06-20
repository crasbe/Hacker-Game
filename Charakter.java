import java.io.*;
import java.util.*;


public class Charakter {

	private double money;
	private int skills;
	private int serverleistung;
	private int schlafbedarf;
	private int matebedarf;
	private String name;
	private String speicherdatum;
	private String kurzbeschreibung;
	
	public Charakter(Properties props) {		
		
		// Auslesen der Informationen der Properties-Datei
		money = Double.parseDouble(props.getProperty("money"));
		skills = Integer.parseInt(props.getProperty("skills"));
		serverleistung = Integer.parseInt(props.getProperty("serverleistung"));
		schlafbedarf = Integer.parseInt(props.getProperty("schlafbedarf"));
		matebedarf = Integer.parseInt(props.getProperty("matebedarf"));
		name = props.getProperty("name");
		speicherdatum = props.getProperty("speicherdatum");
		kurzbeschreibung = props.getProperty("kurzbeschreibung");
		

	}
	
	public double getMoney() {
		
		return money;
	}
	
	public int getSkills() {
		
		return skills;
	}
	
	public int getServerleistung() {
		
		return serverleistung;
	}
	
	public int getSchlafbedarf() {
		
		return schlafbedarf;
	}
	
	public int getMatebedarf() {
		return matebedarf;
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getSpeicherdatum() {
		
		return speicherdatum;
	}
	public String getKurzbeschreibung() {
		return kurzbeschreibung;
	}
}
