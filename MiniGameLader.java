import java.util.*;


public class MiniGameLader {
	
	// in miniGames werden alle initialisierten MiniGames gespeichert
	private List<AbsractMiniGame> miniGames = new ArrayList<AbstractMiniGame>();
	
	private Random rand = new Random();
	
	public MiniGameLader() {
		// die Objekte der Minigames werden hier initialisiert und dem
		// Array hinzugefügt.
		// (Mit Arrays arbeiten zu wollen kommt von Python :))
		miniGames.add(new TestGame());
		
	}
	
	public AbstactMiniGame miniGameWaehlen(int schwierigkeit) {
		// diese Methode gibt ein zufälliges MiniGame-Objekt zurück
		// welches nach der Schwierigkeit bestimmt wird
		
		// dieses Attribut speichert die MiniGames, die nach der
		// Schwierigkeit her in Frage kommen
		List<AbstractMiniGame> ausgewaehlteMiniGames = new ArrayList<AbstractMiniGame>();
		
		for(int i = miniGames.size(); i > 0; i--) {
			if(miniGames.get(i).schwierigkeit == schwierigkeit) {
				ausgewaehlteMiniGames.add(miniGames.get(i));
			}
		}
		
		int randomGame = rand.nextInt(ausgewaehlteMiniGames.size());
		
		return ausgewaehlteMiniGames.get(randomGame);
	}

}
