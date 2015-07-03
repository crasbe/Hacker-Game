import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiBasis extends AbstractGui {
	// Anfang Attribute
	private String titel = "Basis";
	
	private JTextField tfMoney = new JTextField();
	private JTextField tfServ = new JTextField();
	private JTextField tfMate = new JTextField();
	private JTextField tfSchlaf = new JTextField();
	private JLabel lblPfeil = new JLabel();
	private JButton btnKaufServ = new JButton();
	private JTextField tfPreisServ = new JTextField();
	private JButton btnKaufMate = new JButton();
	private JTextField tfPreisMate = new JTextField();
	private JButton btnMateAnw = new JButton();
	private JButton btnHub = new JButton();
	
	private int preisMate = 1;
	private int preisServ = 5;
	
	private Charakter charakter;

	// Ende Attribute

	public GuiBasis(Charakter charakter) {
		// Frame-Initialisierung
		super();
		
		this.charakter = charakter;
		
		setTitle(titel);
		int frameWidth = 513;
		int frameHeight = 354;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		tfMoney.setBounds(24, 24, 129, 49);
		tfMoney.setFont(new Font("Fixedsys", Font.BOLD, 14));
		tfMoney.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		tfMoney.setForeground(Color.green);
		tfMoney.setBackground(Color.black);
		cp.add(tfMoney);
		tfServ.setBounds(80, 88, 145, 41);
		tfServ.setBackground(Color.black);
		tfServ.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		tfServ.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		tfServ.setForeground(Color.green);
		cp.add(tfServ);
		tfMate.setBounds(80, 144, 145, 41);
		tfMate.setBackground(Color.black);
		tfMate.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		tfMate.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		tfMate.setForeground(Color.green);
		cp.add(tfMate);
		tfSchlaf.setBounds(80, 248, 145, 41);
		tfSchlaf.setBackground(Color.black);
		tfSchlaf.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		tfSchlaf.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		tfSchlaf.setForeground(Color.green);
		cp.add(tfSchlaf);
		lblPfeil.setBounds(136, 192, 43, 49);
		lblPfeil.setText("  V");
		lblPfeil.setBackground(Color.black);
		lblPfeil.setOpaque(true);
		lblPfeil.setForeground(Color.green);
		lblPfeil.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		cp.add(lblPfeil);
		btnKaufServ.setBounds(256, 88, 153, 25);
		btnKaufServ.setText("Kaufen");
		btnKaufServ.setMargin(new Insets(2, 2, 2, 2));
		btnKaufServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnKaufServ_ActionPerformed(evt);
			}
		});
		btnKaufServ.setBackground(Color.black);
		btnKaufServ
				.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		btnKaufServ.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnKaufServ.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnKaufServ.setForeground(Color.green);
		cp.add(btnKaufServ);
		tfPreisServ.setBounds(256, 112, 153, 25);
		tfPreisServ.setBackground(Color.black);
		tfPreisServ.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		tfPreisServ.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		tfPreisServ.setForeground(Color.green);
		tfPreisServ.setText("");
		cp.add(tfPreisServ);
		btnKaufMate.setBounds(256, 144, 153, 25);
		btnKaufMate.setText("Kaufen");
		btnKaufMate.setMargin(new Insets(2, 2, 2, 2));
		btnKaufMate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnKaufMate_ActionPerformed(evt);
			}
		});
		btnKaufMate.setBackground(Color.black);
		btnKaufMate
				.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		btnKaufMate.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnKaufMate.setForeground(Color.green);
		cp.add(btnKaufMate);
		tfPreisMate.setBounds(256, 168, 153, 25);
		tfPreisMate.setBackground(Color.black);
		tfPreisMate.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		tfPreisMate.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		tfPreisMate.setForeground(Color.green);
		cp.add(tfPreisMate);
		btnMateAnw.setBounds(184, 200, 97, 33);
		btnMateAnw.setText("Anwenden");
		btnMateAnw.setMargin(new Insets(2, 2, 2, 2));
		btnMateAnw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMateAnw_ActionPerformed(evt);
			}
		});
		btnMateAnw.setBackground(Color.black);
		btnMateAnw.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		btnMateAnw.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMateAnw.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnMateAnw.setForeground(Color.green);
		cp.add(btnMateAnw);
		cp.setBackground(Color.black);
		btnHub.setBounds(296, 248, 145, 41);
		btnHub.setText("Zurück zum HUB");
		btnHub.setMargin(new Insets(2, 2, 2, 2));
		btnHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnHub_ActionPerformed(evt);
			}
		});
		btnHub.setBackground(Color.black);
		btnHub.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 2));
		btnHub.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHub.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnHub.setForeground(Color.green);
		cp.add(btnHub);
		// Ende Komponenten

	} // end of public GuiBasis

	// Anfang Methoden

	public void initialisieren() {
		updateFelder();
		updateButtons();
		
	}
	
	private void updateFelder() {
		tfMoney.setText(" Money: "+(int)charakter.getMoney()+"€");
		tfMate.setText(" Mate: "+charakter.getMatebedarf());
		tfServ.setText(" Serverleist.: "+charakter.getServerleistung());
		tfPreisMate.setText(""+preisMate+"€");
		tfPreisServ.setText(""+preisServ+"€");
		tfSchlaf.setText(" Schlafbedarf: "+charakter.getSchlafbedarf());
	}
	
	public static void main(String[] args) {
		AbstractGui guiBasis = new GuiBasis(new CharakterLader(false).getCharaktere().get(0));
		guiBasis.initialisieren();
		guiBasis.setVisible(true);
	} // end of main
	
	private void updateButtons() {
		if(charakter.getServerleistung() == 10 || charakter.getMoney() < preisServ) {
			btnKaufServ.setEnabled(false);
		} else {
			btnKaufServ.setEnabled(true);
		}
		if(charakter.getMatebedarf() == 10 || charakter.getMoney() < preisMate) {
			btnKaufMate.setEnabled(false);
		} else {
			btnKaufMate.setEnabled(true);
		}
		if(charakter.getSchlafbedarf() == 1 || charakter.getMatebedarf() == 1) {
			btnMateAnw.setEnabled(false);
		} else {
			btnMateAnw.setEnabled(true);
		}
	}

	public void btnKaufServ_ActionPerformed(ActionEvent evt) {
		charakter.addServerleistung(1);
		charakter.addMoney(0-preisServ);
		
		preisServ *= 2;
		
		charakter.setPreisServerleistung((int) preisServ);
		updateFelder();
		updateButtons();
	} // end of btnKaufServ_ActionPerformed

	public void btnKaufMate_ActionPerformed(ActionEvent evt) {

		charakter.addMatebedarf(1);
		charakter.addMoney(0-preisMate);
		
		preisMate *= 2;
		
		charakter.setPreisMate((int) preisMate);
		
		updateFelder();
		updateButtons();
	} // end of btnKaufMate_ActionPerformed

	public void btnMateAnw_ActionPerformed(ActionEvent evt) {

		charakter.addSchlafbedarf(-1);
		charakter.addMatebedarf(-1);
		updateFelder();
		updateButtons();
	} // end of btnMateAnw_ActionPerformed

	public void btnHub_ActionPerformed(ActionEvent evt) {
		setVisible(false);
	} // end of btnHub_ActionPerformed
	
	public Charakter getChar() {
		return charakter;
	}
}
