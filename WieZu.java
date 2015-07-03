import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class WieZu extends AbstractMiniGame {
	// Anfang Attribute
	
	private static String titel = "Quiz";
	
	// Dummy-Klasse
	private class QuizLader extends AbstractLader {
		public QuizLader() {
			super("quiz");
		}
	};
	private AbstractLader quizLader = new QuizLader();
	private List<Properties> quizProps = quizLader.getProps();
	private Properties quizProp = new Properties();

	private ButtonGroup antwGroup = new ButtonGroup();
	private JTextField aufgabe = new JTextField();
	private JButton btnAbschicken = new JButton();
	
	private List<JRadioButton> antw = new ArrayList<JRadioButton>();
	
	private int richt;
	private int pktCnt = 0;
	private int rndCnt = 1;
	private int rundenzahl = 0;

	private int auswahl = 0;
	
	private GuiWinScreen guiWinScreen = new GuiWinScreen();
	private GuiLoseScreen guiLoseScreen = new GuiLoseScreen();

	// Ende Attribute

	public WieZu(int schwierigkeit) {
		// Frame-Initialisierung
		super(titel);
		
		int frameWidth = 457;
		int frameHeight = 386;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		for(int i = 0; i < 4; i++) {
			antw.add(new JRadioButton());
			antw.get(i).setText("");
			antw.get(i).setActionCommand(""+i);
			antw.get(i).setOpaque(false);
			antw.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					antw_ActionPerformed(evt);
				}
			});
			antw.get(i).setBackground(Color.BLACK);
			antw.get(i).setForeground(Color.GREEN);
			antw.get(i).setFont(new Font("Fixedsys", Font.PLAIN, 12));
			antw.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
			cp.add(antw.get(i));
			antwGroup.add(antw.get(i));
		}
		
		antw.get(0).setBounds(56, 128, 233, 41);
		antw.get(1).setBounds(56, 176, 233, 41);
		antw.get(2).setBounds(56, 224, 233, 41);
		antw.get(3).setBounds(56, 272, 184, 41);
		
		aufgabe.setBounds(72, 48, 297, 65);
		aufgabe.setBackground(Color.BLACK);
		aufgabe.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		aufgabe.setForeground(Color.GREEN);
		aufgabe.setEditable(false);
		cp.add(aufgabe);
		btnAbschicken.setOpaque(true);
		btnAbschicken.setBounds(240, 272, 137, 57);
		btnAbschicken.setText("weiter");
		btnAbschicken.setMargin(new Insets(2, 2, 2, 2));
		btnAbschicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAbschicken_ActionPerformed(evt);
			}
		});
		btnAbschicken.setBackground(Color.BLACK);
		btnAbschicken
				.setBorder(new javax.swing.border.LineBorder(Color.RED, 2));
		btnAbschicken.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnAbschicken.setForeground(Color.GREEN);
		btnAbschicken.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cp.add(btnAbschicken);
		cp.setBackground(Color.BLACK);
		
		// so lange den benötigten Schwierigkeitsgrad senken, bis ein Quiz auftaucht
		// (für 100 verschiedene Quiz reichte die Zeit nicht)
		for(int i = schwierigkeit; i >= 1; i--) {
			for(int j = 0; j < quizProps.size(); j++) {
				if(quizProp.isEmpty() == false) {
					// wenn schon eins gefunden wurde, kein neues zuweisen
					break;
				}

				if(quizProps.get(j).get("name").equals("quiz"+i)) {
					quizProp = quizProps.get(j);
					break;
				}
			}
		}
	}

	private void setzeQuizfragen() {
		richt = Integer.parseInt(quizProp.getProperty("richt" + rndCnt));
		aufgabe.setText(quizProp.getProperty("aufgabe" + rndCnt));
		
		int a = 4 * (rndCnt - 1) + 1;
		for(int i = 0; i < 4; i++) {
			antw.get(i).setText(quizProp.getProperty("antw" + ( i + a )));
		}

		// den ausgewählten Button für die nächste Runde zurücksetzen
		antwGroup.clearSelection();
	}

	public void antw_ActionPerformed(ActionEvent evt) {
		auswahl = Integer.parseInt(evt.getActionCommand());
	}

	private void btnAbschicken_ActionPerformed(ActionEvent evt) {
		if(auswahl == (richt-(rndCnt-1)*4)-1) {
			pktCnt++;
		} else {
			pktCnt--;
		}

		if (rndCnt == rundenzahl) {
			if (pktCnt == rundenzahl) { // TODO: an Schwierigkeit anpassen
				guiWinScreen.setVisible(true);
				this.erfolg = true;
			} else {
				guiLoseScreen.setVisible(true);
				this.erfolg = false;
			}

			this.versuche = 1;
			this.fertig = true;
		} else {
			rndCnt++;
			setzeQuizfragen();
		}
	}

	public static void main(String[] args) {
		AbstractMiniGame wieZu = new WieZu(25);
		wieZu.initialisieren();
		wieZu.setVisible(true);
	} // end of main
	
	public void initialisieren() {
		// die Initialisierungsfunktion der Mutterklasse aufrufen
		super.initialisieren();
		
		// die Anzahl an Aufgaben ermitteln
		int i = 0;
		do {
			i++;
		} while(quizProp.containsKey("aufgabe"+(i+1)));
		rundenzahl = i;
		
		rndCnt = 1;
		pktCnt = 0;
		auswahl = 0;
		
		setzeQuizfragen();
	}
}
