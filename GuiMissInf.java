import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMissInf extends AbstractGui {
	// Anfang Attribute
	private String titel = "Mission Information";
	
	private JTextArea taMissName = new JTextArea("");
	private JScrollPane taMissNameScrollPane = new JScrollPane(taMissName);
	private JTextArea taBeschreibung = new JTextArea("");
	private JScrollPane taBeschreibungScrollPane = new JScrollPane(taBeschreibung);
	private JTextArea taInfoVor = new JTextArea("");
	private JScrollPane taInfoVorScrollPane = new JScrollPane(taInfoVor);
	private JTextArea taInfoNach = new JTextArea("");
	private JScrollPane taInfoNachScrollPane = new JScrollPane(taInfoNach);
	private JSeparator jSeparator1 = new JSeparator();
	private JButton btnHack = new JButton();

	// Ende Attribute

	public GuiMissInf(Mission mission) {
		super();

		String name				= ""+mission.getName();
		String gewinn			= ""+mission.getGewinn();
		String kosten			= ""+mission.getKosten();
		String beschreibung		= ""+mission.getBeschreibung();
		String schwierigkeit 	= ""+mission.getSchwierigkeit();
		String skillverbesserung= ""+mission.getSkillverbesserung();
		
		
		// Frame-Initialisierung
		setTitle(titel);
		int frameWidth = 624;
		int frameHeight = 325;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		
		// Anfang Komponenten
		taMissName.setEditable(false);
		taMissNameScrollPane.setBounds(16, 24, 177, 57);
		taMissName.setBackground(Color.BLACK);
		taMissName.setText("\n   "+name);
		taMissName.setFont(new Font("Fixedsys", Font.PLAIN, 18));
		taMissName.setForeground(Color.GREEN);
		cp.add(taMissNameScrollPane);
		
		taBeschreibung.setEditable(false);
		taBeschreibungScrollPane.setBounds(16, 96, 177, 177);
		taBeschreibung.setBackground(Color.BLACK);
		taBeschreibung.setText(	"Beschreibung:\n"+
								"------------------------\n"+
								beschreibung);
		taBeschreibung.setForeground(Color.GREEN);
		taBeschreibung.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		cp.add(taBeschreibungScrollPane);
		
		taInfoVor.setEditable(false);
		taInfoVorScrollPane.setBounds(216, 24, 361, 73);
		taInfoVor.setBackground(Color.BLACK);
		taInfoVor.setText(	" - Schwierigkeit: "+schwierigkeit+
							"\n - Kosten: "+kosten+
							"\n - ...");
		taInfoVor.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		taInfoVor.setForeground(Color.GREEN);
		cp.add(taInfoVorScrollPane);
		
		taInfoNach.setEditable(false);
		taInfoNachScrollPane.setBounds(216, 128, 361, 73);
		taInfoNach.setBackground(Color.BLACK);
		taInfoNach.setText(	" - Gewinn: "+gewinn+
							"\n - Skillverbesserung: "+skillverbesserung+
							"\n - ...");
		taInfoNach.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		taInfoNach.setForeground(Color.GREEN);
		cp.add(taInfoNachScrollPane);
		jSeparator1.setBounds(216, 112, 361, 9);
		jSeparator1.setBackground(Color.GREEN);
		jSeparator1.setForeground(Color.GREEN);
		jSeparator1.setFont(new Font("Dialog", Font.BOLD, 48));
		cp.add(jSeparator1);
		cp.setBackground(Color.BLACK);
		btnHack.setBounds(320, 216, 257, 49);
		btnHack.setText("Hack");
		btnHack.setMargin(new Insets(2, 2, 2, 2));
		btnHack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnHack_ActionPerformed(evt);
			}
		});
		btnHack.setBackground(Color.RED);
		btnHack.setForeground(Color.BLACK);
		btnHack.setFont(new Font("Fixedsys", Font.BOLD, 20));
		cp.add(btnHack);
		// Ende Komponenten
		
	}

	// Anfang Methoden

	public static void main(String[] args) {
		new GuiMissInf(new MissionLader().getMissionen().get(0)).setVisible(true);
	} // end of main
	
	public void btnHack_ActionPerformed(ActionEvent evt) {
		setVisible(false);
	} // end of btnHack_ActionPerformed

	public void hackButtonDeaktivieren() {
		btnHack.setEnabled(false);
		btnHack.setBackground(Color.LIGHT_GRAY);
	}
	
	// Ende Methoden
} // end of class gui3_missinf
