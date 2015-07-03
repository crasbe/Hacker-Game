import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;


public class GuiHub extends AbstractGui {
	
	private java.util.List<Mission> missionen = new ArrayList<Mission>();
	private Mission missionAusgewaehlt;
	private AbstractGui guiMissInf;

	private int schwierigkeitsgrad;
	private double charakterGeld;
	
	private boolean zuBasis = false;

	private static String titel = "HUB";
	
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
		lstHauptmiss.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lstHauptmiss.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstHauptmiss.setForeground(Color.GREEN);
		lstHauptmiss.setBackground(Color.BLACK);
		
		lstHauptmiss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cp.add(lstHauptmissScrollPane);
		lstNebenmiss.setModel(lstNebenmissModel);
		lstNebenmissScrollPane.setBounds(24, 104, 337, 57);
		lstNebenmiss.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		lstNebenmiss.setForeground(Color.GREEN);
		lstNebenmiss.setBackground(Color.BLACK);
		lstNebenmiss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cp.add(lstNebenmissScrollPane);
		
		lstHauptmiss.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lst_MousePressed(e, "hauptmiss");
			}
		});
		lstNebenmiss.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lst_MousePressed(e, "nebenmiss");
			}
		});
	}

	@Override
	public boolean isVisible() {
		if(guiMissInf != null) {
			if(guiMissInf.isVisible() == false) {
				if(guiMissInf.terminiert == false) {
					guiMissInf.dispose();
					setVisible(false);
					return false;
				}
			}
		}
		
		return super.isVisible();
	}

	private void lst_MousePressed(MouseEvent e, String lst) {
		String element = "";
		
		// Über den String lst kann ich herausfinden, welche Liste das Event getriggert hat.
		// Das ginge zwar auch mit zwei verschiedenen Methoden, wäre aber redundanter Code.
		if(lst == "hauptmiss") {
			if(lstHauptmissModel.isEmpty()) {
				return;
			}
			element = lstHauptmiss.getSelectedValue().toString();
			lstNebenmiss.clearSelection();
		} else if(lst == "nebenmiss") {
			if(lstNebenmissModel.isEmpty()) {
				return;
			}
			element = lstNebenmiss.getSelectedValue().toString();
			lstHauptmiss.clearSelection();
		} else {
			System.out.println("Wo zum Teufel kam das Event her?");
			System.exit(-1);
		}
		
		for(int i = 0; i < missionen.size(); i++) {
			if(missionen.get(i).getName().equals(element)) {
				if(guiMissInf != null) {
					if(guiMissInf.isVisible()) {
						guiMissInf.guiAusblenden();
					}
				}
				guiMissInf = new GuiMissInf(missionen.get(i));
				missionAusgewaehlt = missionen.get(i);
				if(missionen.get(i).getSchwierigkeit() > schwierigkeitsgrad ||
						   missionen.get(i).getKosten() > charakterGeld) {
					// wenn die Mission über dem Schwierigkeitsgrad ist oder zu viel
					// kostet, dann kann man sie nicht starten.
					((GuiMissInf) guiMissInf).hackButtonDeaktivieren();
				}
				guiMissInf.setVisible(true);
			}
		}
		
	}

	// Anfang Methoden

	public void initialisieren(Charakter charakter) {
		this.guiCharInf = new GuiCharInf(charakter);
		this.schwierigkeitsgrad = charakter.berechneMglSchwierigkeitsgrad();
		this.charakterGeld = charakter.getMoney();
		
		// passende Missionen hinzufügen
		for(int i = 0; i < missionen.size(); i++) {
			if(missionen.get(i).isHauptmission()) {
				lstHauptmissModel.addElement(missionen.get(i).getName());
				continue;
			}
			
			if(missionen.get(i).getSchwierigkeit() <= schwierigkeitsgrad &&
			   missionen.get(i).getKosten() <= charakterGeld) {
				lstNebenmissModel.addElement(missionen.get(i).getName());
			}
		}	
		
		zuBasis = false;
	}

	public Mission getAusgewaehlteMission() {
		return missionAusgewaehlt;
	}
	
	public void btnCharinfo_ActionPerformed(ActionEvent evt) {
		guiCharInf.setVisible(true);
	}

	public void btnBasis_ActionPerformed(ActionEvent evt) {
		zuBasis = true;
		setVisible(false);
	}

	public boolean zuBasis() {
		return zuBasis;
	}
}
