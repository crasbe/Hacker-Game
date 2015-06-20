import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiCharInf extends AbstractGui {
	// Anfang Attribute

	private static String titel = "Charakter Information";
	
	private JTextArea txtaCharname = new JTextArea("");
	private JScrollPane txtaCharnameScrollPane = new JScrollPane(txtaCharname);
	private JTextArea txtaKurzbeschr = new JTextArea("");
	private JScrollPane txtaKurzbeschrScrollPane = new JScrollPane(
			txtaKurzbeschr);
	private JTextArea txtaAttribute = new JTextArea("");
	private JScrollPane txtaAttributeScrollPane = new JScrollPane(txtaAttribute);
	private JButton btnBack = new JButton();

	// Ende Attribute

	public GuiCharInf(Charakter charakter) {
		super();
	
		String name 			=    charakter.getName();
		String money 			= ""+charakter.getMoney();
		String skills 			= ""+charakter.getSkills();
		String matebedarf		= ""+charakter.getMatebedarf();
		String schlafbedarf 	= ""+charakter.getSchlafbedarf();
		String serverleistung 	= ""+charakter.getServerleistung();
		String kurzbeschreibung = ""+charakter.getKurzbeschreibung();
		
		
		// Frame-Initialisierung
		setTitle(titel);
		int frameWidth = 487;
		int frameHeight = 297;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		txtaCharnameScrollPane.setBounds(24, 24, 140, 49);
		txtaCharname.setBackground(Color.BLACK);
		txtaCharname.setEditable(false);
		txtaCharname.setText("\n "+name);
		txtaCharname.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtaCharname.setForeground(Color.GREEN);
		cp.add(txtaCharnameScrollPane);
		txtaKurzbeschrScrollPane.setBounds(24, 88, 140, 145);
		txtaKurzbeschr.setEditable(false);
		txtaKurzbeschr.setBackground(Color.BLACK);
		txtaKurzbeschr.setText( "Kurzbeschreibung:\n"+
								"----------------------------\n"+kurzbeschreibung);
		txtaKurzbeschr.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtaKurzbeschr.setForeground(Color.GREEN);
		cp.add(txtaKurzbeschrScrollPane);
		txtaAttributeScrollPane.setBounds(184, 24, 265, 175);
		txtaAttribute.setEditable(false);
		txtaAttribute.setBackground(Color.BLACK);
		txtaAttribute.setText(	"Charakter Attribute:"+
								"\n-------------------------------"+
								"\n - Money: "+money+
								"\n - Serverleistung: "+serverleistung+
								"\n - Skills: "+skills+
								"\n - Matebedarf: "+matebedarf+
								"\n - Schlafbedarf: "+schlafbedarf);
		txtaAttribute.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		txtaAttribute.setForeground(Color.GREEN);
		cp.add(txtaAttributeScrollPane);
		btnBack.setBounds(336, 208, 113, 25);
		btnBack.setText("back to HUB");
		btnBack.setMargin(new Insets(2, 2, 2, 2));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnBack_ActionPerformed(evt);
			}
		});
		btnBack.setFont(new Font("Fixedsys", Font.PLAIN, 12));
		btnBack.setForeground(Color.GREEN);
		btnBack.setBackground(Color.BLACK);
		cp.add(btnBack);
		
		cp.setBackground(Color.BLACK);
		// Ende Komponenten

	} // end of public GuiCharInf

	// Anfang Methoden

	public static void main(String[] args) {
		new GuiCharInf(new CharakterLader(false).getCharaktere().get(0)).setVisible(true);
	} // end of main

	private void btnBack_ActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

	
	// Ende Methoden
} // end of class GuiCharInf
