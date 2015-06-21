import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 16.06.2015
  * @author 
  */
// Die Spamnachrichten werden seperat in dieser Klasse definiert, es ist bewusst keine MiniGame Klasse.
// Die einzige aktive Methode ist das schließen über den entsprechenden Button
public class SKMelde extends JFrame {
  // Anfang Attribute
  private JLabel spamText = new JLabel();
  private JButton btnZu = new JButton();
  
  public int end;
  // Ende Attribute
  
  public SKMelde(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 472; 
    int frameHeight = 189;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = 500;
    int y = 250;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    spamText.setBounds(80, 24, 310, 49);
    spamText.setText("SPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAMSPAM");
    spamText.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    spamText.setForeground(Color.GREEN);
    spamText.setBackground(Color.BLACK);
    spamText.setOpaque(true);
    cp.add(spamText);
    btnZu.setBounds(80, 80, 281, 33);
    btnZu.setText("Schließen");
    btnZu.setMargin(new Insets(2, 2, 2, 2));
    btnZu.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnZu_ActionPerformed(evt);
      }
    });
    btnZu.setBackground(Color.BLACK);
    btnZu.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    btnZu.setForeground(Color.GREEN);
    cp.add(btnZu);
    cp.setBackground(Color.BLACK);
    setUndecorated(true);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public SKMelde
  
  // Anfang Methoden
  public void btnZu_ActionPerformed(ActionEvent evt) {
    dispose();
    
  } // end of btnZu_ActionPerformed
  
  
  public static void main(String[] args) {
    new SKMelde("SKMelde");
    
    
  } // end of main
  
} // end of class SKMelde
