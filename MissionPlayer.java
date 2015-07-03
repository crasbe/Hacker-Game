
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
	
	public void starten(int spielerGeld) {
		// die Konsole sichtbar machen
		guiKonsole.setVisible(true);
		
		guiKonsole.addLine("Mission \""+mission.getName()+"\" gestartet...");
		sleep(2);
		
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
				sleep(1);
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
		
		if(mission.getName() == "Die NSA hacken" && fail == false) {
			// GEWONNEN!!!
			win();
		} else if((spielerGeld - mission.getKosten() + mission.getGewinn()) <= 0) {
			// Spieler ist pleite => verloren.
			fail();
		} else {		
			sleep(3);
			
			fertig = true;
		}
	}
	
	public static void main(String[] args) {
		MissionPlayer mp = new MissionPlayer(new MissionLader().getMissionen().get(0));
		mp.guiKonsole.setVisible(true);
		//mp.win();
		//mp.fail();
		mp.credits();
	}
	
	private void credits() {
		guiKonsole.addLine();
		guiKonsole.addLine();
		guiKonsole.addLine();

		guiKonsole.addLine(" _   _    __    ___  _  _  ____  ____          ___    __    __  __  ____ ");
		guiKonsole.addLine("( )_( )  /__\\  / __)( )/ )( ___)(  _ \\ ___    / __)  /__\\  (  \\/  )( ___)");
		guiKonsole.addLine(" ) _ (  /(__)\\( (__  )  (  )__)  )   /(___)  ( (_-. /(__)\\  )    (  )__) ");
		guiKonsole.addLine("(_) (_)(__)(__)\\___)(_)\\_)(____)(_)\\_)        \\___/(__)(__)(_/\\/\\_)(____)");
		
		guiKonsole.addLine();
		guiKonsole.addLine("by Doran Nettig and Christopher Büchse, 2015");
		
		sleep(7);
		
		guiKonsole.addLine();
		guiKonsole.addLine("Dieses Spiel entstand mit Java,");
		sleep(3);
		guiKonsole.addLine("Code, der vorher noch nicht da war.");
		sleep(3);
		guiKonsole.addLine("Viele Stunden Schweiß und Sorgen,");
		sleep(3);
		guiKonsole.addLine("Fertig sein solls heut', nicht morgen.");
		sleep(3);
		guiKonsole.addLine();
		sleep(3);
		guiKonsole.addLine("Der Lehrer hat nun Spaß und Pflicht,");
		sleep(3);
		guiKonsole.addLine("Die Spiele testen, sonst gehts nicht.");
		sleep(3);
		guiKonsole.addLine("Und wird er lesen diese Zeilen,");
		sleep(3);
		guiKonsole.addLine("Nicht mehr allzu lang beim Spiel verweilen.");
		sleep(3);
		guiKonsole.addLine();
		sleep(3);
		guiKonsole.addLine("Missionen gelöst oder Geld ist leer,");
		sleep(3);
		guiKonsole.addLine("Manche, waren wirklich schwer.");
		sleep(3);
		guiKonsole.addLine("Doch was ist's, was macht uns froh?");
		sleep(3);
		guiKonsole.addLine("'Ne gute Note, sowieso.");
		sleep(3);
		guiKonsole.addLine();
		sleep(3);
		guiKonsole.addLine("Christopher, 03.07.2015, 15:45");
		sleep(60);
	}
	
	private void win() {
		guiKonsole.clear();
		
		// ASCII-Art von http://www.network-science.de/ascii/
		guiKonsole.addLine("         _________ _       ");
		guiKonsole.addLine("|\\     /|\\__   __/( (    /|");
		guiKonsole.addLine("| )   ( |   ) (   |  \\  ( |");
		guiKonsole.addLine("| | _ | |   | |   |   \\ | |");
		guiKonsole.addLine("| |( )| |   | |   | (\\ \\) |");
		guiKonsole.addLine("| || || |   | |   | | \\   |");
		guiKonsole.addLine("| () () |___) (___| )  \\  |");
		guiKonsole.addLine("(_______)\\_______/|/    )_)");
		guiKonsole.addLine();
		
		credits();
		System.exit(0);
	}
	
	private void fail() {
		guiKonsole.clear();
		
		// ASCII-Art von http://www.network-science.de/ascii/
		guiKonsole.addLine("  _______  _______ _________ _       ");
		guiKonsole.addLine(" (  ____ \\(  ___  )\\__   __/( \\      ");
		guiKonsole.addLine(" | (    \\/| (   ) |   ) (   | (      ");
		guiKonsole.addLine(" | (__    | (___) |   | |   | |      ");
		guiKonsole.addLine(" |  __)   |  ___  |   | |   | |      ");
		guiKonsole.addLine(" | (      | (   ) |   | |   | |      ");
		guiKonsole.addLine(" | )      | )   ( |___) (___| (____/\\");
		guiKonsole.addLine(" |/       |/     \\|\\_______/(_______/");
		
		credits();
		System.exit(0);
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
