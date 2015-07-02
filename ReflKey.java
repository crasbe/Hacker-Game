import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class ReflKey extends AbstractMiniGame {
	// Anfang Attribut
	private static String titel = "ReflKey";

	private int kill = 0;
	private int eingabe;
	private int code;
	private int durchgaenge; // die Anzahl an Durchgängen im Text
	private Random rand = new Random();
	
	private JTextField txtfueberschrift = new JTextField();
	private JButton decstart = new JButton();
	private JTextField nrfErgebnis = new JTextField();
	private JTextField zahl1 = new JTextField();
	private JTextField zahl2 = new JTextField();
	private JTextField zahl3 = new JTextField();
	private JTextField zahl4 = new JTextField();
	private JTextField zahl5 = new JTextField();
	private JTextField ueberschrift2 = new JTextField();
	private JTextField achtung = new JTextField();
	
	// die Win-/ und Lose-Screens initialisieren
	private AbstractGui guiLoseScreen = new GuiLoseScreen();
	private AbstractGui guiWinScreen = new GuiWinScreen();

	// variable Elemente: 1+0, 3+8, 6+16, 2+24, 4+32
	//                    1,   11,  22,   26,   36
	private List<String> text = Arrays.asList(	
			" Q", "", " K", " ?", " §", " A", " &", " C",
			" H", " $", " M", " ", " %", " S", " =", " P",
			" B", " %", " Y", " !",	 " N", " !", " ", " F",
			" L", " (", " ", " /", " K", " =", " V", " §",
			" X", " !", " D", " &", " ", " ?", " T", " $" );

	private ActionListener buchAnz = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			zahl1.setText(text.get(durchgaenge+0));
			zahl2.setText(text.get(durchgaenge+8));
			zahl3.setText(text.get(durchgaenge+16));
			zahl4.setText(text.get(durchgaenge+24));
			zahl5.setText(text.get(durchgaenge+32));
			durchgaenge++;
			if (durchgaenge == 8) {
				tm.stop();
			}
		}
	};

	private Timer tm = new Timer(1000, buchAnz);

	// Ende Attribute

	public ReflKey(int schwierigkeit) {
		// Frame-Initialisierung
		super(titel);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 289;
		int frameHeight = 431;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		txtfueberschrift.setBounds(40, 40, 193, 41);
		txtfueberschrift.setEditable(false);
		txtfueberschrift.setText("                   REFLEX KEY");
		txtfueberschrift.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtfueberschrift.setForeground(Color.GREEN);
		txtfueberschrift.setBackground(Color.BLACK);
		cp.add(txtfueberschrift);
		decstart.setBounds(56, 88, 161, 33);
		decstart.setText("DECODER STARTEN");
		decstart.setMargin(new Insets(2, 2, 2, 2));
		decstart.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		decstart.setForeground(Color.GREEN);
		decstart.setBackground(Color.BLACK);
		decstart.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				decstart_MousePressed(evt);
			}
		});
		decstart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cp.add(decstart);
		nrfErgebnis.setBounds(72, 256, 129, 41);
		nrfErgebnis.setText("");
		nrfErgebnis.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		nrfErgebnis.setForeground(Color.GREEN);
		nrfErgebnis.setBackground(Color.BLACK);
		nrfErgebnis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nrfErgebnis_ActionPerformed(evt);
			}
		});
		cp.add(nrfErgebnis);
		cp.setBackground(Color.BLACK);
		setTitle("REFLEX KEY");
		setUndecorated(false);
		zahl1.setText("");
		zahl1.setBounds(40, 136, 33, 57);
		zahl1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		zahl1.setForeground(Color.GREEN);
		zahl1.setBackground(Color.BLACK);
		zahl1.setEditable(true);
		cp.add(zahl1);
		zahl2.setText("");
		zahl2.setBounds(80, 136, 33, 57);
		zahl2.setBackground(Color.BLACK);
		zahl2.setEditable(false);
		zahl2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		zahl2.setForeground(Color.GREEN);
		cp.add(zahl2);
		zahl3.setText("");
		zahl3.setBounds(120, 136, 33, 57);
		zahl3.setBackground(Color.BLACK);
		zahl3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		zahl3.setForeground(Color.GREEN);
		zahl3.setEditable(false);
		cp.add(zahl3);
		zahl4.setText("");
		zahl4.setBounds(160, 136, 33, 57);
		zahl4.setBackground(Color.BLACK);
		zahl4.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		zahl4.setForeground(Color.GREEN);
		zahl4.setEditable(false);
		cp.add(zahl4);
		zahl5.setText("");
		zahl5.setBounds(200, 136, 33, 57);
		zahl5.setBackground(Color.BLACK);
		zahl5.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		zahl5.setForeground(Color.GREEN);
		zahl5.setEditable(false);
		cp.add(zahl5);
		ueberschrift2.setBounds(48, 208, 177, 41);
		ueberschrift2.setBackground(Color.BLACK);
		ueberschrift2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		ueberschrift2.setForeground(Color.GREEN);
		ueberschrift2.setText(" Enter Code Below To Move On");
		cp.add(ueberschrift2);
		achtung.setBounds(16, 304, 241, 81);
		achtung.setBackground(Color.RED);
		achtung.setEditable(false);

		achtung.setFont(new Font("Fixedsys", Font.PLAIN, 18));
		achtung.setForeground(Color.BLACK);
		achtung.setVisible(false);
		cp.add(achtung);
		// Ende Komponenten

	} // end of public ReflKey

	// Anfang Methoden

	public static void main(String[] args) {
		AbstractMiniGame reflKey = new ReflKey(0);
		reflKey.initialisieren();
		reflKey.setVisible(true);
	}

	private void nrfErgebnis_ActionPerformed(ActionEvent evt) {
		// die Eingabe des Spielers ins Integer-Format bringen
		eingabe = Integer.parseInt(nrfErgebnis.getText());
		
		// das 
		if(code == eingabe) {
			guiWinScreen.setVisible(true);
			achtung.setText("  Hackversuch erfolgreich!");
			this.erfolg = true;
			this.fertig = true;
			this.versuche = kill;
		}
		else {
			guiLoseScreen.setVisible(true);
			achtung.setText("  Passwort fehlerhaft.");
		}
		// das Hinweisfeld sichtbar machen
		achtung.setVisible(true);
	}
	
	public void decstart_MousePressed(MouseEvent evt) {
		kill++;
		
		// TODO: von der gegebenen Schwierigkeit abhängig machen
		if(kill <= 6) { // 6 mal darf man auf den Decoder-Button drücken
			durchgaenge = 0;
			tm.setInitialDelay(0);
			tm.start();
		}
		else {
			guiLoseScreen.setVisible(true);
			
			achtung.setVisible(true);
			achtung.setText("     Hack misslungen.");
			this.erfolg = false;
			this.fertig = true;
		}
		if(kill == 6) {
			achtung.setVisible(true);
			achtung.setText("   WARNUNG: Last Try.");
		}
	}

	public void initialisieren() {
		// hier werden alle Zufallszahlen neu generiert und der
		// Code daraus gebildet.
		int erg1 = rand.nextInt(10);
		int erg2 = rand.nextInt(10);
		int erg3 = rand.nextInt(10);
		int erg4 = rand.nextInt(10);
		int erg5 = rand.nextInt(10);
		
		text.set(1+0,  " "+erg1); // das Textarray wird mit den Zahlen gefüllt
		text.set(3+8,  " "+erg2);
		text.set(6+16, " "+erg3);
		text.set(2+24, " "+erg4);
		text.set(4+32, " "+erg5);
		
		code = erg1 * 10000 + erg2 * 1000 + erg3 * 100 + erg4 * 10 + erg5;
		System.out.print((erg1==0)?"0":"");
		System.out.println(code);
		
		// zurück auf Start :)
		durchgaenge = 0;
		versuche = 0;
		fertig = false;
		erfolg = false;
		zahl1.setText("");
		zahl2.setText("");
		zahl3.setText("");
		zahl4.setText("");
		zahl5.setText("");
		nrfErgebnis.setText("");
		achtung.setVisible(false);
		
	}
	
	public void setVisible(boolean b) {
		// Die Methode "setVisible" der Mutterklasse wird überschrieben,
		// damit auch die anderen Fenster geschlossen werden
		if(b == false) {
			guiLoseScreen.setVisible(false);
			guiWinScreen.setVisible(false);
		}
		
		// die eigentliche Funktion (die Überschrieben wurde), aufrufen.
		super.setVisible(b);
	}
}
