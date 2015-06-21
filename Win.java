import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.06.2015
  * @author 
  */
// Definition des Endscreens für Sieg (bislang nur Platzhalter)
public class Win extends JFrame {
  // Anfang Attribute
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  // Ende Attribute
  
  public Win(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 205;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTextArea1ScrollPane.setBounds(40, 40, 217, 81);
    jTextArea1.setText("Gewonnen! (Platzhalter)");
    cp.add(jTextArea1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Win
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Win("Win");
  } // end of main
  
  // Ende Methoden
} // end of class Win
