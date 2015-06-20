import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

/* Beschreibung
 *
 * @version 1.0 vom 11.06.2015
 * @author 
 */

public class GuiCharAusw extends AbstractGui {
	// Anfang Attribute

	private static String titel = "Charakter Auswahl";
	
	private Charakter char1;
	private Charakter char2;
	private Charakter char3;
	private java.util.List<Charakter> saveChar = new ArrayList<Charakter>();
	public Charakter charAusgewaehlt;

	private JRadioButton rbtnNeuesSpiel = new JRadioButton();
	private JRadioButton rbtnLadeSpiel = new JRadioButton();
	private ButtonGroup rbtnSaveGroup = new ButtonGroup();
	private JList lstSaveGame = new JList();
	private DefaultListModel lstSaveGameModel = new DefaultListModel();
	private JScrollPane lstSaveGameScrollPane = new JScrollPane(lstSaveGame);
	private JRadioButton rbtnAuswahl1 = new JRadioButton();
	private JRadioButton rbtnAuswahl2 = new JRadioButton();
	private JRadioButton rbtnAuswahl3 = new JRadioButton();
	private ButtonGroup rbtnAuswGroup = new ButtonGroup();
	private JPanel jPanel1 = new JPanel(null, true);
	private JButton btnConfirm = new JButton();
	private JList lstCharinf = new JList();
	private DefaultListModel lstCharinfModel = new DefaultListModel();
	private JScrollPane lstCharinfScrollPane = new JScrollPane(lstCharinf);
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField1 = new JTextField();

	// Ende Attribute

	public GuiCharAusw(	java.util.List<Charakter> defaultChars,	// die drei Standard-Charaktere
						java.util.List<Charakter> saveChars) {	// eventuell gespeicherte Charaktere 
		super();
		
		this.saveChar = saveChars;
		
		// hier werden die drei Auswahlmöglichkeiten an interne Variablen
		// übergeben, damit sie nicht nur im Konstruktor zur Verfügung
		// stehen.
		char1 = defaultChars.get(0);
		char2 = defaultChars.get(1);
		char3 = defaultChars.get(2);
		
		// die Radio-Buttons werden mit den Namen der drei Charaktere gefüllt
		String rbtnText1 = char1.getName(); // = "xXgr0nkhcrafter01Xx";
		String rbtnText2 = char2.getName(); // = "Herr von Frass";
		String rbtnText3 = char3.getName(); // = "Mister X";
		
		// Frame-Initialisierung
		setTitle(titel);
		int frameWidth = 645;
		int frameHeight = 452;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		rbtnNeuesSpiel.setBounds(24, 24 , 233, 20);
		rbtnNeuesSpiel.setText("Neues Spiel:");
		rbtnNeuesSpiel.setActionCommand("newgame");
		rbtnNeuesSpiel.setOpaque(false);
		rbtnNeuesSpiel.setForeground(Color.GREEN);
		rbtnNeuesSpiel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnNeuesSpiel.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		rbtnNeuesSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtnNeuesSpiel_ActionPerormed(evt);
			}
		});
		cp.add(rbtnNeuesSpiel);
		
		rbtnLadeSpiel.setBounds(24, 130 , 233, 20);
		rbtnLadeSpiel.setText("Lade Spiel:");
		rbtnLadeSpiel.setActionCommand("loadgame");
		rbtnLadeSpiel.setOpaque(false);
		rbtnLadeSpiel.setForeground(Color.GREEN);
		rbtnLadeSpiel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnLadeSpiel.setFont(new Font("NeuesFixedsys", Font.PLAIN, 12));
		rbtnLadeSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtnLadeSpiel_ActionPerormed(evt);
			}
		});
		cp.add(rbtnLadeSpiel);
		
		rbtnSaveGroup.add(rbtnNeuesSpiel);
		rbtnSaveGroup.add(rbtnLadeSpiel);
		
		lstSaveGame.setEnabled(false);
		lstSaveGame.setModel(lstSaveGameModel);
		lstSaveGameScrollPane.setBounds(40, 150, 217, 204);
		lstSaveGame.setToolTipText("");
		lstSaveGame.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstSaveGame.setForeground(Color.GREEN);
		lstSaveGame.setBackground(Color.BLACK);
		lstSaveGame.setSelectionBackground(Color.BLACK);
		lstSaveGame.setSelectionForeground(Color.GREEN);
		lstSaveGame.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSaveGameScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		lstSaveGame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				lstSaveGame_MousePressed(evt);	
			}
		});
		for(int i = 0; i < saveChars.size(); i++) {
			lstSaveGameModel.addElement(saveChars.get(i).getName()+" ("+
										saveChars.get(i).getSpeicherdatum()+")");
		}
		
		cp.add(lstSaveGameScrollPane);
		
		
		rbtnAuswahl1.setEnabled(false);
		rbtnAuswahl1.setBounds(40, 50, 233, 20);
		rbtnAuswahl1.setText(" - "+rbtnText1);
		rbtnAuswahl1.setActionCommand(rbtnText1);
		rbtnAuswahl1.setOpaque(false);
		rbtnAuswahl1.setForeground(Color.GREEN);
		rbtnAuswahl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnAuswahl1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		cp.add(rbtnAuswahl1);
		
		rbtnAuswahl2.setEnabled(false);
		rbtnAuswahl2.setBounds(40, 70, 233, 20);
		rbtnAuswahl2.setText(" - "+rbtnText2);
		rbtnAuswahl2.setActionCommand(rbtnText2);
		rbtnAuswahl2.setOpaque(false);
		rbtnAuswahl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnAuswahl2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		rbtnAuswahl2.setForeground(Color.GREEN);
		cp.add(rbtnAuswahl2);
		
		rbtnAuswahl3.setEnabled(false);
		rbtnAuswahl3.setBounds(40, 90, 233, 20);
		rbtnAuswahl3.setText(" - "+rbtnText3);
		rbtnAuswahl3.setActionCommand(rbtnText3);
		rbtnAuswahl3.setOpaque(false);
		rbtnAuswahl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnAuswahl3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		rbtnAuswahl3.setForeground(Color.GREEN);
		cp.add(rbtnAuswahl3);
		
		// die Radio Button Group sorgt dafür, dass nur ein
		// Radio Button zur Zeit ausgewählt sein kann
		rbtnAuswGroup.add(rbtnAuswahl1);
		rbtnAuswGroup.add(rbtnAuswahl2);
		rbtnAuswGroup.add(rbtnAuswahl3);
		
		rbtnAuswahl1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtn_ActionPerformed(evt);
			}
		});
		rbtnAuswahl2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtn_ActionPerformed(evt);
			}
		});
		rbtnAuswahl3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtn_ActionPerformed(evt);
			}
		});
		
		jPanel1.setBounds(312, 8, 265, 393);
		jPanel1.setOpaque(true);
		jPanel1.setBackground(Color.BLACK);
		jPanel1.setBorder(new javax.swing.border.LineBorder(Color.GREEN));
		cp.add(jPanel1);
		btnConfirm.setBounds(136, 352, 113, 25);
		btnConfirm.setText("confirm");
		btnConfirm.setMargin(new Insets(2, 2, 2, 2));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnConfirm_ActionPerformed(evt);
			}
		});
		btnConfirm.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnConfirm.setForeground(Color.GREEN);
		btnConfirm.setBackground(Color.BLACK);
		jPanel1.add(btnConfirm);
		lstCharinf.setModel(lstCharinfModel);
		
		// Dieser Code sorgt dafür, dass keine Listenelemente ausgewählt werden können.
		// Die List ist ja nur rein zur Information da.
		lstCharinf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // nur ein Wert kann ausgewählt werden
		lstCharinf.setSelectionModel(new DefaultListSelectionModel() {	
			@Override													
			public void setSelectionInterval(int index0, int index) {	
				super.setSelectionInterval(-1, -1);
			}
		});
		lstCharinfScrollPane.setBounds(24, 136, 217, 209);
		lstCharinf.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstCharinf.setForeground(Color.GREEN);
		lstCharinf.setBackground(Color.BLACK);
		lstCharinf.setSelectionBackground(Color.BLACK);
		lstCharinf.setSelectionForeground(Color.GREEN);
		lstCharinfScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// Element 0
		lstCharinfModel
				.addElement("----------------------------------------------");
		// Element 1
		lstCharinfModel.addElement("- Money:");
		// Element 2
		lstCharinfModel
				.addElement("----------------------------------------------");
		// Element 3
		lstCharinfModel.addElement("- Serverleistung:");
		// Element 4
		lstCharinfModel
				.addElement("----------------------------------------------");
		// Element 5
		lstCharinfModel.addElement("- Skill:");
		// Element 6
		lstCharinfModel
				.addElement("----------------------------------------------");
		// Element 7
		lstCharinfModel.addElement("- Matekonsum:");
		// Element 8
		lstCharinfModel
				.addElement("----------------------------------------------");
		// Element 9
		lstCharinfModel.addElement("- Schlafbedarf:");
		// Element 10
		lstCharinfModel
				.addElement("----------------------------------------------");
		// Element 11
		lstCharinfModel.addElement("- Speicherdatum:");
		jPanel1.add(lstCharinfScrollPane);
		cp.setBackground(Color.BLACK);
		jTextField1.setBounds(336, 40, 200, 49);
		//jTextField1.setText("  Mister X");
		jTextField1.setFont(new Font("Fixedsys", Font.PLAIN, 16));
		jTextField1.setForeground(Color.GREEN);
		jTextField1.setBackground(Color.BLACK);

		jTextField1.setEditable(false);
		cp.add(jTextField1);
		jTextField2.setBounds(24, 96, 137, 33);
		jTextField2.setText(" Charakterwerte");
		jTextField2.setFont(new Font("Fixedsys", Font.PLAIN, 14));
		jTextField2.setForeground(Color.GREEN);

		jTextField2.setEditable(false);
		jTextField2.setBackground(Color.BLACK);
		jPanel1.add(jTextField2);
		// Ende Komponenten
	}

	// Anfang Methoden
	
	protected void lstSaveGame_MousePressed(MouseEvent evt) {
		if(lstSaveGame.getSelectedValue() != null) {
			String name = lstSaveGame.getSelectedValue().toString().split(" ")[0];
			for(int i = 0; i < saveChar.size(); i++) {
				String saveCharName = saveChar.get(i).getName();
				if(saveCharName.equals(name)) {
					charAusgewaehlt = saveChar.get(i);
					updateInfo(charAusgewaehlt);
				}
			}
		}
	}

	protected void rbtnLadeSpiel_ActionPerormed(ActionEvent evt) {
		rbtnAuswahl1.setEnabled(false);
		rbtnAuswahl2.setEnabled(false);
		rbtnAuswahl3.setEnabled(false);
		lstSaveGame.setEnabled(true);
		
	}

	protected void rbtnNeuesSpiel_ActionPerormed(ActionEvent evt) {
		rbtnAuswahl1.setEnabled(true);
		rbtnAuswahl2.setEnabled(true);
		rbtnAuswahl3.setEnabled(true);
		lstSaveGame.setEnabled(false);
		
	}
	

	public Charakter getCharakterAuswahl() {
		return charAusgewaehlt;
	}
	
	protected void btnConfirm_ActionPerformed(ActionEvent evt) {
		if(charAusgewaehlt != null) {
			setVisible(false);
		}	
	}
	
	protected void rbtn_ActionPerformed(ActionEvent evt) {
		String auswahl = evt.getActionCommand();
		
		if(auswahl == char1.getName()) {
			charAusgewaehlt = char1;
		} else if(auswahl == char2.getName()) {
			charAusgewaehlt = char2;
		} else if(auswahl == char3.getName()) {
			charAusgewaehlt = char3;
		}
		
		updateInfo(charAusgewaehlt);
	}
	
	private void updateInfo(Charakter charAusgewaehlt) {
		jTextField1.setText("  "+charAusgewaehlt.getName());

		lstCharinfModel.set(1, "- Money: "+charAusgewaehlt.getMoney());
		lstCharinfModel.set(3, "- Serverleistung: "+charAusgewaehlt.getServerleistung());
		lstCharinfModel.set(5, "- Skill: "+charAusgewaehlt.getSkills());
		lstCharinfModel.set(7, "- Matekonsum: "+charAusgewaehlt.getMatebedarf());
		lstCharinfModel.set(9, "- Schlafbedarf: "+charAusgewaehlt.getSchlafbedarf());
		lstCharinfModel.set(11, "- Speicherdatum: "+charAusgewaehlt.getSpeicherdatum());
	}

	// Ende Methoden
} // end of class GuiCharInf
