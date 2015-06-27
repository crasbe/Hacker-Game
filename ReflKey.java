import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReflKey extends AbstractMiniGame {
	// Anfang Attribut
	private static String titel = "ReflKey";
	
	private int kill = 0;
	private boolean dec = false;
	private int eingabe;
	private int code;
	private int erg1 = (int) ((Math.random() * 9) + 0);
	private int erg2 = (int) ((Math.random() * 9) + 0);
	private int erg3 = (int) ((Math.random() * 9) + 0);
	private int erg4 = (int) ((Math.random() * 9) + 0);
	private int erg5 = (int) ((Math.random() * 9) + 0);
	private JTextField txtfueberschrift = new JTextField();
	private JButton decstart = new JButton();
	private JTextField nrfErgebnis = new JTextField();
	private JTextField zahl1 = new JTextField();
	private JTextField zahl2 = new JTextField();
	private JTextField zahl3 = new JTextField();
	private JTextField zahl4 = new JTextField();
	private JTextField zahl5 = new JTextField();
	private JLabel jLabel1 = new JLabel();
	private JTextField ueberschrift2 = new JTextField();

	private int durchgaenge = 0;
	private String[] text1 = { " Q", " " + erg1, " K", " ?", " §", " A", " &",
			" C" };
	private String[] text2 = { " H", " $", " M", " " + erg2, " %", " S", " =",
			" P" };
	private String[] text3 = { " B", " %", " Y", " !", " N", " !", " " + erg3,
			" F" };
	private String[] text4 = { " L", " (", " " + erg4, " /", " K", " =", " V",
			" §" };
	private String[] text5 = { " X", " !", " D", " &", " " + erg5, " ?", " T",
			" $" };

	private ActionListener buchAnz = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(""+erg1+" "+erg2+" "+erg3+" "+erg4+" "+erg5);
			zahl1.setText(text1[durchgaenge]);
			zahl2.setText(text2[durchgaenge]);
			zahl3.setText(text3[durchgaenge]);
			zahl4.setText(text4[durchgaenge]);
			zahl5.setText(text5[durchgaenge]);
			durchgaenge++;
			if (durchgaenge == 8) {
				tm.stop();
			}
		}
	};

	private Timer tm = new Timer(1000, buchAnz);
	private JTextField achtung = new JTextField();

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

		setVisible(true);
	} // end of public ReflKey

	// Anfang Methoden

	public static void main(String[] args) {
		new ReflKey(0);
	} // end of main

	public void nrfErgebnis_ActionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(nrfErgebnis)) {
			code = erg1 * 10000 + erg2 * 1000 + erg3 * 100 + erg4 * 10 + erg5;
			eingabe = Integer.parseInt(nrfErgebnis.getText());
			if (code == eingabe) {
				achtung.setVisible(true);
				achtung.setText("  Hackversuch Erfolgreich!");
			} // end of if
			else {
				achtung.setVisible(true);
				achtung.setText("  Passwort Fehlerhaft.");
			} // end of if-else
		} // end of if
	}

	public void decstart_MousePressed(MouseEvent evt) {
		if (kill <= 6) {
			durchgaenge = 0;
			tm.setInitialDelay(0);
			tm.start();
		} // end of if
		else {
			achtung.setVisible(true);
			achtung.setText("     Hack Misslungen.");
		} // end of if-else
		kill = kill + 1;
		if (kill == 6) {
			achtung.setVisible(true);
			achtung.setText("   WARNUNG: Last Try.");
		} // end of if
	}
	// Ende Methoden
}
