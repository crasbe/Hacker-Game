
public class MissionPlayer {
	// der MissionPlayer ist jene Klasse, die die Mission "abspielt"
	
	private boolean fail = false;	// falls ein MiniGame nicht erfolgreich abgeschlossen
									// wird, wird "fail" true und die Mission gilt als
									// gescheitert
	private boolean fertig = false;
	
	private GuiKonsole guiKonsole = new GuiKonsole();
		// in der Konsole findet der Hackvorgang statt
	private MiniGameLader lader;
	private Mission mission;     // speichern der übergebenen Mission
	
	public MissionPlayer(Mission mission) {
		
		this.mission = mission;
		
		lader = new MiniGameLader(mission.getSchwierigkeit());
			// hier werden alle MiniGames geladen mit der gegebenen Schwierigkeit
	}
	
	public void starten() {
		// die Konsole sichtbar machen
		guiKonsole.setVisible(true);
		
		guiKonsole.addLine("Mission \""+mission.getName()+"\" gestartet...");
		sleep(2);
		guiKonsole.addLine("blablubb test");
		
		for(int i = 1; i <= mission.getSpielzahl(); i++) {
			// so lange MiniGames starten, bis die obere Grenze erreicht ist
			
			guiKonsole.addLine("Starte Herausforderung "+i+" von "+mission.getSpielzahl()+"...");
			while(guiKonsole.isQueueEmpty() == false) {
				sleep(1);
			}
			
			// hier wird ein zufälliges Spiel aus den geladenen Spielen ausgesucht
			AbstractMiniGame miniGame = lader.miniGameWaehlen();
			
			miniGame.initialisieren();	// das Minigame initialisieren und z.B.
										// Zufallszahlen bilden.
			miniGame.setVisible(true); // Lasset die Spiele beginnen!
			
			while(miniGame.fertig() == false && miniGame.isVisible() == true) {
				// so lange das Spiel noch nicht fertig ist oder das Fenster nicht
				// geschlossen wurde, wird gewartet
				sleep(1);
			}
			
			if(miniGame.erfolgreichGeloest() == true) {
				guiKonsole.addLine("Herausforderung "+i+" erfolgreich gelöst!");
				sleep(1);
				miniGame.setVisible(false);
				miniGame.dispose();
			} else {
				guiKonsole.addLine("An der Herausforderung "+i+" gescheitert...");
				sleep(1);
				miniGame.setVisible(false);
				miniGame.dispose();
				fail = true;
				break;
			}
		}
		
		if(fail == true) {
			guiKonsole.addLine("Mission gescheitert!");
			guiKonsole.addLine();
			guiKonsole.addLine("Du hast für die Mission "+mission.getKosten()+"€ ausgegeben.");
		} else {
			guiKonsole.addLine("Du hast alle Herausforderungen gelöst!");
			guiKonsole.addLine();
			guiKonsole.addLine("Die Mission \""+mission.getName()+"\" ist erfolgreich abgeschlossen!");
			guiKonsole.addLine("Folgende Belohnungen erwarten dich:");
			guiKonsole.addLine("Geld:");
			guiKonsole.addLine("  Ausgaben: "+mission.getKosten());
			guiKonsole.addLine("  Einnahmen: "+mission.getGewinn());
			guiKonsole.addLine("   -> Gewinn: "+(mission.getGewinn()-mission.getKosten()));
			guiKonsole.addLine();
			guiKonsole.addLine("Skillverbesserung: "+mission.getSkillverbesserung());
			
		}
		
		guiKonsole.addLine();
		guiKonsole.addLine("Dein Schlafbedarf hat sich um "+mission.getSchlafbedarf()+" erhöht.");
		
		fertig = true;
	}
	
	private void sleep(int sekunden) {
		// kleine Methode, um redundante try-catches zu vermeiden
		try {
			Thread.sleep(sekunden*1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isFertig() {
		// erst ausschreiben lassen!
		return fertig && guiKonsole.isQueueEmpty();
	}
	
	public boolean isFail() {
		return fail;
	}
	
	public void beenden() {
		guiKonsole.setVisible(false);
		guiKonsole.clear();
	}
	
}
