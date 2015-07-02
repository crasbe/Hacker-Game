import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;


public class Merken extends AbstractMiniGame {
	// Anfang Attribute
	private static String title = "Merken";
	private List<JButton> buttons = new ArrayList<JButton>();
	private JButton btnStart = new JButton();

	// wie weit der Spieler mit dem Wiederholen fortgeschritten ist
	private int wdhFortschritt = 0;
	// die Buttons, die geleuchtet haben
	private List<Integer> leuchtButtons = new ArrayList<Integer>();

	private Timer tm1;
	private Timer tm2;
	
	// Ende Attribute
	private ActionListener t1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int rand = (int) ((Math.random() * 8) + 0);

			leuchtButtons.add(rand); // den angezeigten Button hinzufügen
			System.out.println(leuchtButtons);
				
			// den Buttonstil anpassen
			buttons.get(rand).setBackground(Color.GREEN);
			buttons.get(rand).setBorder(
					new javax.swing.border.LineBorder(Color.RED, 3));
			buttons.get(rand).setForeground(Color.GREEN);
			
			tm2.setInitialDelay(500);
			tm2.start();
		}
	};

	private ActionListener t2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			tm2.stop();
			// alle Buttons haben aufgeleuchtet
			if(leuchtButtons.size() == 5) {
				tm1.stop();
				// alle Buttons zurücksetzen und zum Klicken vorbereiten
				for (int z = 0; z < 9; z++) {
					buttons.get(z).setEnabled(true);
					buttons.get(z).setText("KLICK");
					buttons.get(z).setBackground(Color.BLACK);
					buttons.get(z).setForeground(Color.GREEN);
					buttons.get(z).setBorder(
							new javax.swing.border.LineBorder(Color.GREEN, 3));
				}
			} else {
				// den Button zurücksetzen
				int a = leuchtButtons.get(leuchtButtons.size()-1);
				buttons.get(a).setBackground(Color.BLACK);
				buttons.get(a).setBorder(
						new javax.swing.border.LineBorder(Color.GRAY, 3));
				buttons.get(a).setForeground(Color.BLACK);
			}
		}
	};

	public Merken(int schwierigkeit) {
		// Frame-Initialisierung
		super(title);
	
		this.schwierigkeit = schwierigkeit;
		
		tm1 = new Timer(1500 - 50 * schwierigkeit, t1);
		tm2 = new Timer(700 - 25 * schwierigkeit, t2);
		
		int frameWidth = 378;
		int frameHeight = 465;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		for (int i = 0; i < 9; i++) {
			buttons.add(new JButton());
			buttons.get(i).setText("");
			buttons.get(i).setMargin(new Insets(2, 2, 2, 2));
			buttons.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					buttons_ActionPerformed(evt);
				}
			});
			// um die Buttons beim generischen ActionListener zu unterscheiden
			buttons.get(i).setBackground(Color.BLACK);
			buttons.get(i).setBorder(
					new javax.swing.border.LineBorder(Color.GRAY, 3));
			buttons.get(i).setFont(new Font("Fixedsys", Font.PLAIN, 12));
			buttons.get(i).setForeground(Color.BLACK);
			buttons.get(i).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			buttons.get(i).setActionCommand("" + i);
			buttons.get(i).setEnabled(false);
			buttons.get(i).setVisible(true);
			cp.add(buttons.get(i));
		}
		buttons.get(0).setBounds(56, 40, 73, 73);
		buttons.get(1).setBounds(144, 40, 73, 73);
		buttons.get(2).setBounds(232, 40, 73, 73);
		buttons.get(3).setBounds(56, 128, 73, 73);
		buttons.get(4).setBounds(144, 128, 73, 73);
		buttons.get(5).setBounds(232, 128, 73, 73);
		buttons.get(6).setBounds(56, 216, 73, 73);
		buttons.get(7).setBounds(144, 216, 73, 73);
		buttons.get(8).setBounds(232, 216, 73, 73);

		btnStart.setBounds(56, 328, 249, 57);
		btnStart.setText("Start");
		btnStart.setMargin(new Insets(2, 2, 2, 2));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnStart_ActionPerformed(evt);
			}
		});
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnStart.setForeground(Color.GREEN);
		btnStart.setBorder(new javax.swing.border.LineBorder(Color.RED, 2));
		cp.add(btnStart);
		cp.setBackground(Color.BLACK);
	}

	public static void main(String[] args) {
		AbstractMiniGame merken = new Merken(0);
		merken.initialisieren();
		merken.setVisible(true);
	} // end of main

	private void buttons_ActionPerformed(ActionEvent evt) {
		System.out.println(evt.getActionCommand());
		
		int btnNummer = Integer.parseInt(evt.getActionCommand());
		buttons.get(btnNummer).setBackground(Color.GREEN);
		tm2.start();
		
		System.out.println(wdhFortschritt);
		
		if(btnNummer != leuchtButtons.get(wdhFortschritt)) {
			guiLoseScreen.setVisible(true);
			erfolg = false;
			fertig = true;
		} else if(wdhFortschritt == 4) {
			guiWinScreen.setVisible(true);
			erfolg = true;
			versuche = 1;
			fertig = true;
		} else {
			wdhFortschritt++;
			return; // aus der Funktion rausspringen
		}
		// wenn der Win-/Lose-Screen erscheint, werden die Buttons deaktiviert
		for(int i = 0; i < 9; i++) {
			buttons.get(i).setEnabled(false);
		}
	}

	public void btnStart_ActionPerformed(ActionEvent evt) {
		btnStart.setEnabled(false);

		tm1.start();
	}
	
	public void initialisieren() {
		// die initialisieren-Methode der Mutterklasse aufrufen
		super.initialisieren();
		
		tm1.setInitialDelay(0);
		
		// Buttons auf den Anfangszustand zurücksetzen
		btnStart.setEnabled(true);
		for(int i = 0; i < 9; i++) {
			buttons.get(i).setEnabled(false);
			buttons.get(i).setBackground(Color.BLACK);
			buttons.get(i).setBorder(
					new javax.swing.border.LineBorder(Color.GRAY, 3));
			buttons.get(i).setForeground(Color.BLACK);
			buttons.get(i).setText("");
		}
		
		wdhFortschritt = 0;
		
		leuchtButtons = new ArrayList<Integer>();
	}
}
