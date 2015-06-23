import java.io.*;
import java.util.*;



public abstract class AbstractLader {
	// die Properties sind eine ganz nette Methode, die Charakter-Eigenschaften
	// nicht hardcoded in den Sourcecode einzubauen und damit auch sehr leicht
	// Speicherstände zu ermöglichen
	
	
	
	// Speicher für die geöffneten Properties
	protected List<Properties> props = new ArrayList<Properties>();
	
	public AbstractLader(String ladeort) {
		// wieder der gleiche Hack wie bei den Charakteren..
		String path;
		
		if(System.getProperty("os.name").equals("Linux")) {
			path = System.getProperty("user.dir")+"/src/"+ladeort+"/"; 
		} else if(System.getProperty("os.name").contains("Windows")) {
			path = System.getProperty("user.dir")+"\\"+ladeort+"\\";
		} else {
			path = System.getProperty("user.dir")+"/"+ladeort+"/";
		}
		
		// zuerst werden alle Properties-Dateien aus dem Ordner "missionen" gesucht
		List<String> propDateien = new ArrayList<String>();
		 
		File f = new File(path);		// hier wird der Ordner geöffnet
		File[] files = f.listFiles();	// und hier der Inhalt gelesen
		if(files != null) {
			// wenn der Order lesbar war, enthält das Attribut files die Dateien
			for(int i = 0; i < files.length; i++) {
				if(files[i].isFile()) {
					// wenn es eine Datei und kein Ordner ist, wird die Datei
					// dem Array hinzugefügt
					// TODO: Überprüfung der Dateiendung
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
}
