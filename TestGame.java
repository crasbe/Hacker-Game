import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TestGame extends MiniGame {
	
	// Definierung von Titel und Schwierigkeitsgrad
	// 0 bedeutet "nicht ausführen!"
	public int schwierigkeit = 0;
	private static String titel = "Testspiel";
	
	// interner Krams für das Beispiel
	private Random rand = new Random();
	private int ergebnisZahl;
	
	// JFrame-Krams	
	private JLabel ueberschrift = new JLabel();
	private JTextField erstezahl = new JTextField();
	private JTextField zahlzwei = new JTextField();
	private JTextField ergebnis = new JTextField();
	private JLabel gleichzeichen = new JLabel();
	private JLabel operator = new JLabel();
	private JButton abschickenButton = new JButton();
	
	public TestGame() {
		// das Schwierigkeitslevel der abtrakten Mutterklasse
		// initialisieren
		
		// Frame-Initialisierung
	    super(titel);
	    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    int frameWidth = 214; 
	    int frameHeight = 156;
	    setSize(frameWidth, frameHeight);
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (d.width - getSize().width) / 2;
	    int y = (d.height - getSize().height) / 2;
	    setLocation(x, y);
	    setResizable(false);
	    Container cp = getContentPane();
	    cp.setLayout(null);
	    // Anfang Komponenten
	    
	    ueberschrift.setBounds(16, 16, 155, 19);
	    ueberschrift.setText("Erfülle die Rechenaufgabe!");
	    ueberschrift.setFont(new Font("Dialog", Font.BOLD, 10));
	    cp.add(ueberschrift);
	    erstezahl.setBounds(16, 56, 25, 25);
	    erstezahl.setText("");
	    erstezahl.setEditable(false);
	    cp.add(erstezahl);
	    zahlzwei.setBounds(72, 56, 25, 25);
	    zahlzwei.setText("");
	    zahlzwei.setEditable(false);
	    cp.add(zahlzwei);
	    ergebnis.setBounds(128, 56, 65, 25);
	    ergebnis.setText("");
	    cp.add(ergebnis);
	    gleichzeichen.setBounds(104, 56, 19, 28);
	    gleichzeichen.setText("=");
	    gleichzeichen.setFont(new Font("Dialog", Font.BOLD, 20));
	    cp.add(gleichzeichen);
	    operator.setBounds(48, 56, 19, 28);
	    operator.setText("+");
	    operator.setFont(new Font("Dialog", Font.BOLD, 20));
	    cp.add(operator);
	    abschickenButton.setBounds(104, 88, 89, 25);
	    abschickenButton.setText("OK!");
	    abschickenButton.setMargin(new Insets(2, 2, 2, 2));
	    abschickenButton.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent evt) { 
	    		abschickenButton_ActionPerformed(evt);
	    	}
	    });
	    cp.add(abschickenButton);
	    // Ende Komponenten
	    
	    setVisible(true);
	}
	  
	public static void main(String[] args) {
		MiniGame thisgame = new TestGame();
		  
		thisgame.initialisieren();	  
	}
	
	// Hier wird die Methode initialisieren implementiert
	// und die Textfelder mit zufälligen Zahlen gefüllt.
	// Man könnte auch den Operator ändern, aber naja.. ist nur ein Test.
	public void initialisieren() {
		int zahl1 = rand.nextInt(25);
		int zahl2 = rand.nextInt(25);
		  
		ergebnisZahl = zahl1 + zahl2;
		  
		erstezahl.setText(""+zahl1);
		zahlzwei.setText(""+zahl2);
	}
	  
	public void abschickenButton_ActionPerformed(ActionEvent evt) {
		// wenn dat Knöppsche gedrückt wurde, den Inhalt von dem
		// Ergebnisfeld holen und überprüfen, obs stimmt
		int spielerEingabe = Integer.parseInt(ergebnis.getText());
		
		if(spielerEingabe == ergebnisZahl) {
			System.out.println("richtige Antwort!");
			ueberschrift.setText("Hurra!");
		}
	}
}
