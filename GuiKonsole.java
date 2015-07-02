import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;

import javax.swing.*;

public class GuiKonsole extends AbstractGui {
	// Anfang Attribute
	
	// dieser Timer sorgt für das Cursorblinken
	private Timer tmCursor = new Timer(500, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			tmCursor_ActionPerformed(evt);
		}
	});
	
	// und dieser Timer wird für jeden neuen Buchstaben gefeuert
	private Timer tmText = new Timer(25, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			tmText_ActionPerformed(evt);
		}
	});
	private boolean cursor = false;  // cursor sichtbar/unsichtbar
	private String textKonsole = "";
		// der komplette Inhalt der Konsole wird hier gespeichert
	
	private String textQueue = "";
		// der noch zu schreibende Text hier
	
	private JTextArea taKonsole = new JTextArea();
	private JScrollPane taKonsoleScrollPane = new JScrollPane(taKonsole);
	// Ende Attribute

	public GuiKonsole() {
		// Frame-Initialisierung
		super();
		
		setTitle("Konsole");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 830;
		int frameHeight = 520;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		taKonsole.setEditable(false);
		// wir wollen nur vertikal scrollen
		taKonsoleScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		taKonsoleScrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		taKonsoleScrollPane.setBounds(4, 4, 822, 484);
		taKonsole.setFont(new Font("Courier New", Font.PLAIN, 16));
		taKonsole.setBackground(Color.black);
		
		taKonsole.setForeground(Color.green);
		cp.add(taKonsoleScrollPane);
		// Ende Komponenten

		// go timers, go!
		tmCursor.start();
		tmText.start();
	} // end of public GuiKonsole

	private <T> T[] concatenate (T[] a, T[] b) {
		// da Java irgendwie echt scheiße ist, was Arrays angeht, muss hier eine
		// gehackte Funktion zum Mergen von zwei Arrays rein. von stackoverflow.
	    int aLen = a.length;
	    int bLen = b.length;

	    @SuppressWarnings("unchecked")
	    T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen+bLen);
	    System.arraycopy(a, 0, c, 0, aLen);
	    System.arraycopy(b, 0, c, aLen, bLen);

	    return c;
	}
	
	private void tmText_ActionPerformed(ActionEvent evt) {	
		String[] lines;
		
		// Eigenheit von Split: wenn das zweite Array leer wäre, wird es
		// wegrationalisiert...
		if(textKonsole.endsWith("\n")) {
			String[] array = {""};
			lines = concatenate(textKonsole.split("\n"), array);
		} else {
			lines = textKonsole.split("\\r?\\n");
		}
		String lastLine = lines[lines.length-1];
		
		if(textQueue.length() > 0) {
			tmCursor.stop();
			// eventuellen Cursor rausschnippeln
			if(textKonsole.endsWith("_")) {
				textKonsole = textKonsole.substring(0, textKonsole.length()-1);
			}
		} else {
			tmCursor.start();
			return;
		}
		
		if(lastLine.length() == 80) {
			textKonsole += "\n";
			taKonsole.setText(textKonsole);
			return;
		}
		
		if(textQueue.equals("\n")) {
			textKonsole += "\n";
			taKonsole.setText(textKonsole);
			textQueue = "";
			return;
		}
		
		textKonsole += textQueue.charAt(0);
		textQueue = textQueue.substring(1);
		
		taKonsole.setText(textKonsole);
		
	}

	private void tmCursor_ActionPerformed(ActionEvent evt) {		
		if(cursor) {
			if(!textKonsole.endsWith("_")) {
				textKonsole += "_";
			}
		} else {
			if(textKonsole.endsWith("_")) {
				textKonsole = textKonsole.substring(0, textKonsole.length()-1);
			}
		}
		cursor = !cursor; // anzeigen, nicht anzeigen, anzeigen, nicht anzeigen, ...
		
		taKonsole.setText(textKonsole);
	}
	
	public void addText(String text) {
		// dem Queue etwas Text hinzufügen
		this.textQueue += text;
	}
	
	public void addLine(String text) {
		// dem Queue etwas Text hinzufügen mit einer Newline
		this.textQueue += text+"\n";
	}
	
	public void addLine() {
		// dem Queue wird ein Newline hinzugefügt
		this.textQueue += "\n";
	}
	
	public boolean isQueueEmpty() {
		// diese Funktion gibt wieder, ob der Queue leer ist,
		// also ob alle Buchstaben geschrieben wurden
		
		if(this.textQueue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// ein bisschen Testkram
		GuiKonsole gui = new GuiKonsole();
		gui.setVisible(true);
		
		gui.addLine("Dies ist ein längerer Test für die Konsole und hoffentlich "+
					"fügt sie bei der 80 Zeichen Grenze einen Umbruch ein...\n");
		
		while(gui.isVisible() == true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		System.exit(0);
		
	} // end of main

	// Ende Methoden
} // end of class GuiKonsole
