
public class HackerGame {

	
	private static Charakter charakter1;
	private static Charakter charakter2;
	private static Charakter charakter3;
	private static Charakter charakterSpiel; 	// der Charakter, mit dem gespielt wird
												// #playwithme
	
	private static AbstractGui guiCharAusw;
	
	
	public static void main(String[] args) {
		charakter1 = new Charakter("xXgr0nkhcrafter01Xx");
		charakter2 = new Charakter("Herr Von Frass");
		charakter3 = new Charakter("Mister X");
		
		guiCharAusw = new GuiCharAusw(charakter1, charakter2, charakter3);
		
		guiCharAusw.guiAnzeigen();
		
		while(guiCharAusw.schliessMich == false) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		// warte, bis die Charakter Auswahl fertig ist
		
		guiCharAusw.guiAusblenden();
		charakterSpiel = ((GuiCharAusw) guiCharAusw).getCharakterAuswahl();
		
		System.exit(0);
	}

}
