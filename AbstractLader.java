import java.io.*;
import java.text.*;
import java.util.*;

public abstract class AbstractLader {
	// die Properties sind eine ganz nette Methode, die Charakter-Eigenschaften
	// nicht hardcoded in den Sourcecode einzubauen und damit auch sehr leicht
	// Speicherstände zu ermöglichen
	
	// Speicher für die geöffneten Properties
	protected List<Properties> props = new ArrayList<Properties>();
	
	// Dummy-Konstruktor zum Speichern
	public AbstractLader() {};
	
	public AbstractLader(String ladeort) {
		String path = generierePfad(ladeort);
				
		// zuerst werden alle Properties-Dateien aus dem Ordner "missionen" gesucht
		List<String> propDateien = new ArrayList<String>();
		 
		File f = new File(path);		// hier wird der Ordner geöffnet
		File[] files = f.listFiles();	// und hier der Inhalt gelesen
		if(files != null) {
			// wenn der Order lesbar war, enthält das Attribut files die Dateien
			for(int i = 0; i < files.length; i++) {
				if(files[i].isFile() && files[i].getName().endsWith(".properties")) {
					// wenn es eine Datei (kein Ordner) und wenn der Dateiname auf
					// ".properties" endet, wird die Datei  dem Array hinzugefügt
					propDateien.add(files[i].getAbsolutePath());
				}
			}
		}
		
		// hier werden die Properties-Dateien geladen und in das entsprechende Array
		// gespeichert
		for(int i = 0; i < propDateien.size(); i++) {
			try {
				FileInputStream in = new FileInputStream(propDateien.get(i));
				
				try {
					// tmpprop ist die aktuell geladene Properties-Datei
					Properties tmpprop = new Properties();
					tmpprop.load(in);
					
					props.add(tmpprop); // die geladenen Properties in das Mutterschiff beamen
					
					in.close(); // den FileInputStream nach Gebrauch wieder schließen
				} catch (IOException e) {
					System.out.println("ERROR: Datei ist nicht lesbar!");
					e.printStackTrace();
					System.exit(-1);
				}
				
			} catch (FileNotFoundException e) {
				System.out.println("ERROR: Datei nicht gefunden!");
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	public List<Properties> getProps() {
		return props;
	}
	
	public void saveProp(String speicherort, Properties prop) {
		// das gehört hier jetzt eigentlich so nicht rein, weil das ja der
		// Abstract LADER ist, aber eine eigene Klasse dafür aufzumachen ist
		// auch witzlos..
		
		Date dt = new Date();
		// Festlegung des Formats
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		df.setTimeZone(TimeZone.getDefault());
		
		prop.setProperty("speicherdatum", df.format(dt));
		
		String path = generierePfad(speicherort);
		
		// hier ist die Annahme, dass die Property "name" == Dateiname
		path = path+prop.getProperty("name")+".properties";
		
		File f = new File(path); // öffnen der Properties-Datei
		
		try {
			FileOutputStream out = new FileOutputStream(f);
			// der FileOutputStream ist das Äquivalent zum
			// FileInputStream, und ermöglicht das Speichern in der Datei
			
			try {
				prop.store(out, "");
				// hier wird das Properties-Objekt in den Stream geschrieben
				
				out.close(); // .. der hier geschlossen wird
				
			} catch (IOException e) {
				System.out.println("ERROR: Datei ist nicht lesbar!");
				e.printStackTrace();
				System.exit(-1);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Datei nicht gefunden!");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	private String generierePfad(String ladeort) {
		// Doran benutzt Windows und Christopher Linux und bei Eclipse/Linux liegen
		// die Sourcen in dem Unterordner /src/ und irgendwie muss
		// das da mit reingehackt werden
		
		if(System.getProperty("os.name").equals("Linux")) {
			return System.getProperty("user.dir")+"/src/"+ladeort+"/"; 
		} else if(System.getProperty("os.name").contains("Windows")) {
			// Windows 8.1 gibt sich nicht mehr als "Windows" aus,
			// sondern als "Windows 8.1"...
			return System.getProperty("user.dir")+"\\"+ladeort+"\\";
		} else {
			// UNIX anyone? :D
			return System.getProperty("user.dir")+"/"+ladeort+"/";
		}
	}
}
