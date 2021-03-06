import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiLoseScreen extends AbstractGui {
	// Anfang Attribute
	private String titel = "MISSLUNGEN!";
	
	private JButton jButton1 = new JButton();
	private JPanel jPanel1 = new JPanel(null, true);
	private JLabel winMsg = new JLabel();

	// Ende Attribute

	public GuiLoseScreen() {
		// Frame-Initialisierung
		super();
		
		setTitle(titel);
		int frameWidth = 528;
		int frameHeight = 195;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		jButton1.setBounds(184, 104, 145, 41);
		jButton1.setText("OK");
		jButton1.setMargin(new Insets(2, 2, 2, 2));
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1_ActionPerformed(evt);
			}
		});
		jButton1.setBackground(Color.BLACK);
		jButton1.setBorder(new javax.swing.border.LineBorder(Color.RED, 3));
		jButton1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		jButton1.setForeground(Color.RED);
		cp.add(jButton1);
		cp.setBackground(Color.BLACK);
		jPanel1.setBounds(56, 16, 409, 81);
		jPanel1.setOpaque(true);
		jPanel1.setBorder(new javax.swing.border.LineBorder(Color.RED, 3));
		jPanel1.setBackground(Color.BLACK);
		cp.add(jPanel1);
		winMsg.setBounds(96, 8, 240, 65);
		winMsg.setText(" !!! HACK MISSLUNGEN !!! ");
		winMsg.setForeground(Color.RED);
		winMsg.setBackground(Color.BLACK);
		winMsg.setOpaque(true);
		winMsg.setFont(new Font("Fixedsys", Font.BOLD, 16));
		jPanel1.add(winMsg);
		// Ende Komponenten

	} // end of public MiniGamesWinScreen

	// Anfang Methoden

	public static void main(String[] args) {
		new GuiLoseScreen().setVisible(true);
	} // end of main

	public void jButton1_ActionPerformed(ActionEvent evt) {
		guiAusblenden();
	} // end of jButton1_ActionPerformed

	// Ende Methoden
}
