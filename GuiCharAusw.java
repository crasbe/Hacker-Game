import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
	public Charakter charAusgewaehlt;
	
	private JRadioButton rbtnAuswahl1 = new JRadioButton();
	private JRadioButton rbtnAuswahl2 = new JRadioButton();
	private JRadioButton rbtnAuswahl3 = new JRadioButton();
	private ButtonGroup rbtnGroup = new ButtonGroup();
	private JPanel jPanel1 = new JPanel(null, true);
	private JButton btnConfirm = new JButton();
	private JList lstCharinf = new JList();
	private DefaultListModel lstCharinfModel = new DefaultListModel();
	private JScrollPane lstCharinfScrollPane = new JScrollPane(lstCharinf);
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField1 = new JTextField();

	// Ende Attribute

	public GuiCharAusw(Charakter charakter1, Charakter charakter2, Charakter charakter3) {
		super(titel);
		
		
		// hier werden die drei Auswahlmöglichkeiten an interne Variablen
		// übergeben, damit sie nicht nur im Konstruktor zur Verfügung
		// stehen.
		char1 = charakter1;
		char2 = charakter2;
		char3 = charakter3;
		
		// die Radio-Buttons werden mit den Namen der drei Charaktere gefüllt
		String rbtnText1 = char1.getName(); // = "xXgr0nkhcrafter01Xx";
		String rbtnText2 = char2.getName(); // = "Herr von Frass";
		String rbtnText3 = char3.getName(); // = "Mister X";
		
		// Frame-Initialisierung
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

		rbtnAuswahl1.setBounds(24, 48, 233, 65);
		rbtnAuswahl1.setText(" - "+rbtnText1);
		rbtnAuswahl1.setActionCommand(rbtnText1);
		rbtnAuswahl1.setOpaque(false);
		rbtnAuswahl1.setForeground(Color.GREEN);
		rbtnAuswahl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnAuswahl1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		cp.add(rbtnAuswahl1);
		rbtnAuswahl2.setBounds(24, 136, 233, 65);
		rbtnAuswahl2.setText(" - "+rbtnText2);
		rbtnAuswahl2.setActionCommand(rbtnText2);
		rbtnAuswahl2.setOpaque(false);
		rbtnAuswahl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnAuswahl2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		rbtnAuswahl2.setForeground(Color.GREEN);
		cp.add(rbtnAuswahl2);
		rbtnAuswahl3.setBounds(24, 224, 233, 65);
		rbtnAuswahl3.setText(" - "+rbtnText3);
		rbtnAuswahl3.setActionCommand(rbtnText3);
		rbtnAuswahl3.setOpaque(false);
		rbtnAuswahl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rbtnAuswahl3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		rbtnAuswahl3.setForeground(Color.GREEN);
		cp.add(rbtnAuswahl3);
		
		// die Radio Button Group sorgt dafür, dass nur ein
		// Radio Button zur Zeit ausgewählt sein kann
		rbtnGroup.add(rbtnAuswahl1);
		rbtnGroup.add(rbtnAuswahl2);
		rbtnGroup.add(rbtnAuswahl3);
		
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
		lstCharinfScrollPane.setBounds(24, 136, 217, 209);
		lstCharinf.setToolTipText("");
		lstCharinf.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstCharinf.setForeground(Color.GREEN);
		lstCharinf.setBackground(Color.BLACK);
		lstCharinf.setSelectionBackground(Color.BLACK);
		lstCharinf.setSelectionForeground(Color.BLACK);
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
	

	public void btnConfirm_ActionPerformed(ActionEvent evt) {
		if(charAusgewaehlt != null) {
			schliessMich = true;
		}
		
	}

	public Charakter getCharakterAuswahl() {
		return charAusgewaehlt;
	}
	
	private void rbtn_ActionPerformed(ActionEvent evt) {
		String auswahl = evt.getActionCommand();
		
		if(auswahl == char1.getName()) {
			charAusgewaehlt = char1;
		} else if(auswahl == char2.getName()) {
			charAusgewaehlt = char2;
		} else if(auswahl == char3.getName()) {
			charAusgewaehlt = char3;
		}
		
		jTextField1.setText("  "+auswahl);

		lstCharinfModel.set(1, "- Money: "+charAusgewaehlt.getMoney());
		lstCharinfModel.set(3, "- Serverleistung: "+charAusgewaehlt.getServerleistung());
		lstCharinfModel.set(5, "- Skill: "+charAusgewaehlt.getSkills());
		lstCharinfModel.set(7, "- Matekonsum: "+charAusgewaehlt.getMatebedarf());
		lstCharinfModel.set(9, "- Schlafbedarf: "+charAusgewaehlt.getSchlafbedarf());
	}

	
	// Ende Methoden
} // end of class GuiCharInf
