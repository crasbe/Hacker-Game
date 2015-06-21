import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 20.06.2015
  * @author 
  */
// Definition des Endscreens wenn Niederlage
public class TodesSpam extends JFrame {
  // Anfang Attribute
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  // Ende Attribute
  
  public TodesSpam(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 371; 
    int frameHeight = 182;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = 500;
    int y = 250;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    
    jTextArea1ScrollPane.setBounds(0, 0, 361, 153);
    jTextArea1.setText("SPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM\nSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM");
    jTextArea1.setBackground(Color.BLACK);
    jTextArea1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jTextArea1.setForeground(Color.GREEN);
    cp.add(jTextArea1ScrollPane);
    cp.setBackground(Color.BLACK);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public TodesSpam
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new TodesSpam("TodesSpam");
  } // end of main
  
  // Ende Methoden
} // end of class TodesSpam
