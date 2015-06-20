import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;


public class GuiHub extends AbstractGui {
	
	private java.util.List<Mission> missionen = new ArrayList<Mission>();
	
	// Anfang Attribute
	private static String titel = "HUB";
	
	private DefaultComboBoxModel jComboBox1Model = new DefaultComboBoxModel();
	private JButton btnCharinfo = new JButton();
	private JButton btnBasis = new JButton();
	private JList lstHauptmiss = new JList();
	private DefaultListModel lstHauptmissModel = new DefaultListModel();
	private JScrollPane lstHauptmissScrollPane = new JScrollPane(lstHauptmiss);
	private JList lstNebenmiss = new JList();
	private DefaultListModel lstNebenmissModel = new DefaultListModel();
	private JScrollPane lstNebenmissScrollPane = new JScrollPane(lstNebenmiss);

	private AbstractGui guiCharInf;
	
	// Ende Attribute

	public GuiHub(java.util.List<Mission> missionen) {
		super();
		
		this.missionen = missionen;
		
		// Frame-Initialisierung
		setTitle(titel);
		int frameWidth = 725;
		int frameHeight = 230;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		btnCharinfo.setBounds(376, 24, 297, 57);
		btnCharinfo.setText("Charakterinfo");
		btnCharinfo.setMargin(new Insets(2, 2, 2, 2));
		btnCharinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCharinfo_ActionPerformed(evt);
			}
		});
		btnCharinfo.setBackground(Color.BLACK);
		btnCharinfo
				.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
		btnCharinfo.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnCharinfo.setForeground(Color.GREEN);
		cp.add(btnCharinfo);
		btnBasis.setBounds(376, 104, 297, 57);
		btnBasis.setText("Basis");
		btnBasis.setMargin(new Insets(2, 2, 2, 2));
		btnBasis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnBasis_ActionPerformed(evt);
			}
		});
		btnBasis.setBackground(Color.BLACK);
		btnBasis.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
		btnBasis.setForeground(Color.GREEN);
		btnBasis.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		cp.add(btnBasis);
		setTitle("HUB");
		cp.setBackground(Color.BLACK);
		lstHauptmiss.setModel(lstHauptmissModel);
		lstHauptmissScrollPane.setBounds(24, 24, 337, 57);
		lstHauptmissModel.addElement(" - NSA Server übernehmen");
		lstHauptmissModel.addElement(" - Merkels Nacktfotos vernichten");
		lstHauptmissModel.addElement("");
		lstHauptmiss.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lstHauptmiss.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstHauptmiss.setForeground(Color.GREEN);
		lstHauptmiss.setBackground(Color.BLACK);
		lstHauptmiss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cp.add(lstHauptmissScrollPane);
		lstNebenmiss.setModel(lstNebenmissModel);
		lstNebenmissScrollPane.setBounds(24, 104, 337, 57);
		lstNebenmissModel.addElement(" - Pizza liefern lassen");
		lstNebenmissModel.addElement(" - Fahndungsinformationen manipulieren");
		lstNebenmissModel.addElement(" - PornHub Premium Account hacken");
		lstNebenmissModel.addElement(" - Matelieferungen umlenken");
		lstNebenmiss.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstNebenmiss.setForeground(Color.GREEN);
		lstNebenmiss.setBackground(Color.BLACK);
		lstNebenmiss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cp.add(lstNebenmissScrollPane);
		// Ende Komponenten

	} // end of public GuiHub

	// Anfang Methoden

	public void initialisieren(Charakter charakter) {
		this.guiCharInf = new GuiCharInf(charakter);
	}

	public void btnCharinfo_ActionPerformed(ActionEvent evt) {
		guiCharInf.setVisible(true);
	}

	public void btnBasis_ActionPerformed(ActionEvent evt) {
		// TODO hier Quelltext einfügen
	} // end of btnBasis_ActionPerformed

	// Ende Methoden
}
