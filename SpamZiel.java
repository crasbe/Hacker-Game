import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 20.06.2015
 * @author
 */

public class SpamZiel extends AbstractMiniGame {
	// Anfang Attribute
	private static String titel = "Spam Ziel";
	
	private JTextArea taBeschreibung = new JTextArea("");
	private JScrollPane taBeschreibungScrollPane = new JScrollPane(taBeschreibung);
	private JButton btInstall = new JButton();
	private JButton btFertig = new JButton();
	
	private int spam = 0;
	//private int durchgaenge;
	private int x = 500;
	private int y = 250;
	private int rndCnt = 0;
	
	private AbstractGui guiWinScreen = new GuiWinScreen();
	private AbstractGui guiLoseScreen = new GuiLoseScreen();
	
	// Ende Attribute
	
	// Diese Timerschleife lässt nach dem btInstall gedrückt wurde (s.u.)
	// Spamnachrichten (SKMelde Objekte) erscheinen,
	// die jeweils leicht veränderte x und y koordinaten besitzen
	private ActionListener alTm1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btFertig.setEnabled(true); // der Fertigstellknopf wird
										// freigeschaltet, damit man sich
										// durch den Timerdelay keinen Sieg
			new SKMelde().setLocation(x, y); // erbuggen kann
			
			spam++;
			
			switch(spam) {
				case 0: x += 50;
						break;
				case 1: y += 25;
						break;
				case 2: x += 50;
						break;
				case 3: y += 25;
						break;
				case 4: x += 50;
						break;
				case 5: tm1.stop();
						x = 500;
						y = 250;
						spam = 0;
						break;
				default:break;
			}
		};
	};
	private Timer tm1 = new Timer(800, alTm1);
	private ActionListener alTm2 = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			tm1.start();
			rndCnt++;
			
			if(rndCnt == 5) {
				// verloren!
				erfolg = false;
				fertig = true;
				guiLoseScreen.setVisible(true);
			} else {
				tm1.start(); // neue Runde starten
			}
		}
	};
	private Timer tm2 = new Timer(5000, alTm2);

	public SpamZiel(int schwierigkeit) {
		super(titel);

		this.schwierigkeit = schwierigkeit;
		
		int frameWidth = 611;
		int frameHeight = 308;
		setSize(frameWidth, frameHeight);
		int x = 400;
		int y = 180;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);

		taBeschreibungScrollPane.setBounds(88, 16, 417, 169);
		taBeschreibung.setText("Missionsbeschreibung"
				+ "\n----------------------------------------------"
				+ "\n- Drücke den Installieren-Button!"
				+ "\n- Schließe die Spamnachrichten!"
				+ "\n- Drücke zwischen den Wellen den Fertigstellen-Button!"
				+ "\n- Wenn du zu langsam bist und die fünfte Spamwelle"
				+ "\n   vorüber ist, hast du verloren!");
		taBeschreibung.setBackground(Color.BLACK);
		taBeschreibung.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		taBeschreibung.setForeground(Color.GREEN);
		cp.add(taBeschreibungScrollPane);
		
		btInstall.setBounds(104, 192, 169, 33);
		btInstall.setText("Installieren");
		btInstall.setMargin(new Insets(2, 2, 2, 2));
		btInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btInstall_ActionPerformed(evt);
			}
		});
		btInstall.setBackground(Color.BLACK);
		btInstall.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
		btInstall.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btInstall.setForeground(Color.GREEN);
		cp.add(btInstall);
		
		btFertig.setBounds(320, 192, 169, 33);
		btFertig.setText("Fertigstellen");
		btFertig.setMargin(new Insets(2, 2, 2, 2));
		btFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btFertig_ActionPerformed(evt);
			}
		});
		btFertig.setEnabled(false);
		btFertig.setBackground(Color.BLACK);
		btFertig.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
		btFertig.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btFertig.setForeground(Color.GREEN);
		cp.add(btFertig);
		cp.setBackground(Color.BLACK);
	}

	public static void main(String[] args) {
		AbstractMiniGame spamZiel = new SpamZiel(0);
		spamZiel.initialisieren();
		spamZiel.setVisible(true);
	}

	private void btInstall_ActionPerformed(ActionEvent evt) {
		// Start der Spamnachrichten
		tm2.start();
		btInstall.setEnabled(false);
	}

	private void btFertig_ActionPerformed(ActionEvent evt) {
		// wenn dieser Knopp gedrückt wurde, wurde gewonnen.
		tm1.stop();
		tm2.stop();
		
		erfolg = true;
		fertig = true;
		guiWinScreen.setVisible(true);
	}

	public void initialisieren() {
		// die Initialisierungsfunktion der Mutterklasse aufrufen
		super.initialisieren();
		
		// die Buttons konfigurieren #noloveforcheaters
		btFertig.setEnabled(false);
		btInstall.setEnabled(true);
		
		// nicht warten vor dem Timerstart
		tm1.setInitialDelay(0);
		tm2.setInitialDelay(0);
		
		// zurück auf Anfang..
		rndCnt = 0;
	}
}
