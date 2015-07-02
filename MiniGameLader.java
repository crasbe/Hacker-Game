import java.util.*;

public class MiniGameLader {
	
	// in miniGames werden alle initialisierten MiniGames gespeichert
	private List<AbstractMiniGame> miniGames = new ArrayList<AbstractMiniGame>();
	
	private Random rand = new Random();

	public MiniGameLader(int schwierigkeit) {
		// die Objekte der Minigames werden hier initialisiert und dem
		// Array hinzugefügt.
		// (Mit Arrays arbeiten zu wollen kommt von Python :))
		//miniGames.add(new TestGame(schwierigkeit));
		miniGames.add(new ReflKey(schwierigkeit));
		miniGames.add(new Roller(schwierigkeit));
		miniGames.add(new Hammer(schwierigkeit));
		miniGames.add(new WieZu(schwierigkeit));
		miniGames.add(new SpamZiel(schwierigkeit));
		miniGames.add(new Merken(schwierigkeit));
	}
	
	public AbstractMiniGame miniGameWaehlen() {
		// diese Methode gibt ein zufälliges MiniGame-Objekt zurück
		
		int randomGame = rand.nextInt(miniGames.size());
		
		return miniGames.get(randomGame);
	}
}
