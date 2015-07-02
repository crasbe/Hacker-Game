import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Roller extends AbstractMiniGame {
	// Anfang Attribute
	private static String title = "Roller";

	private JLabel jLabel1 = new JLabel();
	private JButton btnStop = new JButton();
	private JButton btnStart = new JButton();
	private JPanel jPanel1 = new JPanel(null, true);
	private JTextField z1_1 = new JTextField();
	private JTextField z1_2 = new JTextField();
	private JTextField z1_3 = new JTextField();
	private JPanel jPanel2 = new JPanel(null, true);
	private JPanel jPanel3 = new JPanel(null, true);
	private JTextField z3_1 = new JTextField();
	private JTextField z3_3 = new JTextField();
	private JTextField z3_2 = new JTextField();
	private JPanel jPanel4 = new JPanel(null, true);
	private JTextField z4_1 = new JTextField();
	private JTextField z4_3 = new JTextField();
	private JTextField z4_2 = new JTextField();
	private JTextField z2_1 = new JTextField();
	private JTextField z2_3 = new JTextField();
	private JTextField z2_2 = new JTextField();
	private JTextField txtri4 = new JTextField();
	private JTextField txtri3 = new JTextField();
	private JTextField txtri2 = new JTextField();
	private JTextField txtri1 = new JTextField();
	
	private int sto = 0;
	private int durchgaenge1 = 0;
	private int durchgaenge2 = 0;
	private int durchgaenge3 = 0;
	private int durchgaenge4 = 0;
	
	private Random rand = new Random();
	
	private List<String> text = new ArrayList<String>(40);
	private List<Integer> erg = new ArrayList<Integer>(4);
	// Ende Attribute

	private ActionListener t1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			z1_1.setText(text.get(0*10+2+durchgaenge1));
			z1_2.setText(text.get(0*10+1+durchgaenge1));
			z1_3.setText(text.get(0*10+0+durchgaenge1));

			durchgaenge1++;
			if (durchgaenge1 == 8) {
				durchgaenge1 = 0;
			}
		}
	};

	private Timer tm1 = new Timer(10 + 690/schwierigkeit, t1);
	private ActionListener t2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			z2_1.setText(text.get(1*10+2+durchgaenge2));
			z2_2.setText(text.get(1*10+1+durchgaenge2));
			z2_3.setText(text.get(1*10+0+durchgaenge2));
			
			durchgaenge2++;
			if (durchgaenge2 == 8) {
				durchgaenge2 = 0;
			}
		}
	};

	private Timer tm2 = new Timer(10 + 690/schwierigkeit, t2);
	private ActionListener t3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			z3_1.setText(text.get(2*10+2+durchgaenge3));
			z3_2.setText(text.get(2*10+1+durchgaenge3));
			z3_3.setText(text.get(2*10+0+durchgaenge3));

			durchgaenge3++;
			if (durchgaenge3 == 8) {
				durchgaenge3 = 0;
			}
		}
	};

	private Timer tm3 = new Timer(10 + 690/schwierigkeit, t3);
	private ActionListener t4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			z4_1.setText(text.get(3*10+2+durchgaenge4));
			z4_2.setText(text.get(3*10+1+durchgaenge4));
			z4_3.setText(text.get(3*10+0+durchgaenge4));

			durchgaenge4++;
			if (durchgaenge4 == 8) {
				durchgaenge4 = 0;
			}
		}
	};

	private Timer tm4 = new Timer(10 + 690/schwierigkeit, t4);

	public Roller(int schwierigkeit) {
		// Frame-Initialisierung
		super(title);
		
		this.schwierigkeit = schwierigkeit:

		int frameWidth = 488;
		int frameHeight = 378;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		jLabel1.setBounds(24, 144, 68, 65);
		jLabel1.setText("      >");
		jLabel1.setFont(new Font("Fixedsys", Font.BOLD, 20));
		jLabel1.setForeground(Color.GREEN);
		cp.add(jLabel1);
		btnStop.setBounds(352, 192, 81, 81);
		btnStop.setText("Stop");
		btnStop.setMargin(new Insets(2, 2, 2, 2));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnStop_ActionPerformed(evt);
			}
		});
		btnStop.setFont(new Font("Fixedsys", Font.BOLD, 12));
		btnStop.setForeground(Color.GREEN);
		btnStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStop.setBackground(Color.BLACK);
		btnStop.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		cp.add(btnStop);
		
		txtri1.setBounds(104, 48, 33, 49);
		txtri1.setEditable(false);
		txtri1.setBackground(Color.BLACK);
		txtri1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtri1.setForeground(Color.GREEN);
		cp.add(txtri1);
		txtri2.setBounds(168, 48, 33, 49);
		txtri2.setEditable(false);
		txtri2.setBackground(Color.BLACK);
		txtri2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtri2.setForeground(Color.GREEN);
		cp.add(txtri2);
		txtri3.setBounds(232, 48, 33, 49);
		txtri3.setEditable(false);
		txtri3.setBackground(Color.BLACK);
		txtri3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtri3.setForeground(Color.GREEN);
		cp.add(txtri3);
		txtri4.setBounds(296, 48, 33, 49);
		txtri4.setEditable(false);
		txtri4.setBackground(Color.BLACK);
		txtri4.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtri4.setForeground(Color.GREEN);
		cp.add(txtri4);
		
		btnStart.setBounds(352, 88, 81, 81);
		btnStart.setText("Start");
		btnStart.setMargin(new Insets(2, 2, 2, 2));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnStart_ActionPerformed(evt);
			}
		});
		btnStart.setFont(new Font("Fixedsys", Font.BOLD, 12));
		btnStart.setForeground(Color.GREEN);
		btnStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStart.setBackground(Color.BLACK);
		btnStart.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		cp.add(btnStart);
		
		jPanel1.setBounds(96, 104, 49, 153);
		jPanel1.setOpaque(false);
		cp.add(jPanel1);
		jPanel2.setBounds(160, 104, 49, 153);
		jPanel2.setOpaque(false);
		cp.add(jPanel2);
		jPanel3.setBounds(224, 104, 49, 153);
		jPanel3.setOpaque(false);
		cp.add(jPanel3);
		jPanel4.setBounds(288, 104, 49, 153);
		jPanel4.setOpaque(false);
		cp.add(jPanel4);
		
		z1_1.setBounds(0, 16, 49, 33);
		z1_1.setBackground(Color.BLACK);
		z1_1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z1_1.setForeground(Color.GREEN);
		jPanel1.add(z1_1);
		z1_2.setBounds(0, 56, 49, 33);
		z1_2.setBackground(Color.BLACK);
		z1_2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z1_2.setForeground(Color.GREEN);
		jPanel1.add(z1_2);
		z1_3.setBounds(0, 96, 49, 33);
		z1_3.setBackground(Color.BLACK);
		z1_3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z1_3.setForeground(Color.GREEN);
		jPanel1.add(z1_3);
		z2_1.setBounds(160, 120, 49, 33);
		z2_1.setBackground(Color.BLACK);
		z2_1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z2_1.setForeground(Color.GREEN);
		cp.add(z2_1);
		z2_3.setBounds(160, 200, 49, 33);
		z2_3.setBackground(Color.BLACK);
		z2_3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z2_3.setForeground(Color.GREEN);
		cp.add(z2_3);
		z2_2.setBounds(160, 160, 49, 33);
		z2_2.setBackground(Color.BLACK);
		z2_2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z2_2.setForeground(Color.GREEN);
		cp.add(z2_2);
		z3_1.setBounds(0, 16, 49, 33);
		z3_1.setBackground(Color.BLACK);
		z3_1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z3_1.setForeground(Color.GREEN);
		jPanel3.add(z3_1);
		z3_3.setBounds(0, 96, 49, 33);
		z3_3.setBackground(Color.BLACK);
		z3_3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z3_3.setForeground(Color.GREEN);
		jPanel3.add(z3_3);
		z3_2.setBounds(0, 56, 49, 33);
		z3_2.setBackground(Color.BLACK);
		z3_2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z3_2.setForeground(Color.GREEN);
		jPanel3.add(z3_2);
		z4_1.setBounds(0, 16, 49, 33);
		z4_1.setBackground(Color.BLACK);
		z4_1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z4_1.setForeground(Color.GREEN);
		jPanel4.add(z4_1);
		z4_3.setBounds(0, 96, 49, 33);
		z4_3.setBackground(Color.BLACK);
		z4_3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z4_3.setForeground(Color.GREEN);
		jPanel4.add(z4_3);
		z4_2.setBounds(0, 56, 49, 33);
		z4_2.setBackground(Color.BLACK);
		z4_2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		z4_2.setForeground(Color.GREEN);
		jPanel4.add(z4_2);
		

		cp.setBackground(Color.BLACK);
		// Ende Komponenten

	}

	// Anfang Methoden
	public void btnStop_ActionPerformed(ActionEvent evt) {
		sto++;
		if (sto == 1) {
			tm1.stop();
		}
		else if (sto == 2) {
			tm2.stop();
		}
		else if (sto == 3) {
			tm3.stop();
		}
		else if (sto == 4) {
			tm4.stop();
			
			if(erg.get(0) == Double.parseDouble(z1_2.getText()) &&
				erg.get(1) == Double.parseDouble(z2_2.getText()) &&
				erg.get(2) == Double.parseDouble(z3_2.getText()) &&
				erg.get(3) == Double.parseDouble(z4_2.getText())) {
					guiWinScreen.setVisible(true);
					this.erfolg = true;
			} else {
				guiLoseScreen.setVisible(true);
				this.erfolg = false;
			}

			this.versuche = 1;
			this.fertig = true;
		}
	}

	public void btnStart_ActionPerformed(ActionEvent evt) {
		// wenn das Spiel gestartet wurde, soll man es nur noch stoppen können
		btnStart.setEnabled(false);
		
		tm1.setInitialDelay(0);
		tm1.start();
		tm2.setInitialDelay(0);
		tm2.start();
		tm3.setInitialDelay(0);
		tm3.start();
		tm4.setInitialDelay(0);
		tm4.start();
	}

	public static void main(String[] args) {
		AbstractMiniGame roller = new Roller(0);
		roller.initialisieren();
		roller.setVisible(true);
	}

	public void initialisieren() {
		// die Initialisierungsfunktion der Mutterklasse aufrufen
		super.initialisieren();
		
		// den Startbutton wieder klickbar machen
		btnStart.setEnabled(true);
		
		// die richtigen Ergebnisse für den Roller initialisieren
		erg = Arrays.asList(rand.nextInt(30)+20, rand.nextInt(30)+20,
							rand.nextInt(30)+20, rand.nextInt(30)+20);
		
		// die Textfelder, die das richtige Ergebnis anzeigen, füllen
		txtri1.setText("  "+erg.get(0));
		txtri2.setText("  "+erg.get(1));
		txtri3.setText("  "+erg.get(2));
		txtri4.setText("  "+erg.get(3));
		
		// das sind Zahlen, die die einzelnen Zahlen, die durchlaufen, varriieren
		List<Integer> add = Arrays.asList(	1, 0, -2, 4, -3, -4, 3, -1, 1, 0,
											1, 4, -2, 0, -3, -4, 4, -1, 1, 4,
											1, 3, -2, 4, -3, -4, 0, -1, 1, 3,
											1, -2, 0, 4, -3, -4, 3, -1, 1, -2);
		text = new ArrayList<String>();
		
		for(int i = 0; i < erg.size(); i++) {
			for(int j = 0; j < 10; j++) {
				text.add(" "+(erg.get(i) + add.get(i*10+j)));
			}
		}
		
		z1_1.setText("");
		z1_2.setText("");
		z1_3.setText("");
		z2_1.setText("");
		z2_2.setText("");
		z2_3.setText("");
		z3_1.setText("");
		z3_2.setText("");
		z3_3.setText("");
		z4_1.setText("");
		z4_2.setText("");
		z4_3.setText("");

		// zurück auf Start :)
		sto = 0;
	}
}
