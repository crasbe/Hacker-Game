import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 11.06.2015
  * @author 
  */

public class gui3_missinf extends JFrame {
  // Anfang Attribute
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JTextArea jTextArea2 = new JTextArea("");
    private JScrollPane jTextArea2ScrollPane = new JScrollPane(jTextArea2);
  private JTextArea jTextArea3 = new JTextArea("");
    private JScrollPane jTextArea3ScrollPane = new JScrollPane(jTextArea3);
  private JTextArea jTextArea4 = new JTextArea("");
    private JScrollPane jTextArea4ScrollPane = new JScrollPane(jTextArea4);
  private JSeparator jSeparator1 = new JSeparator();
  // Ende Attribute
  
  public gui3_missinf(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
    
    jTextArea1ScrollPane.setBounds(16, 24, 153, 57);
    jTextArea1.setBackground(Color.BLACK);
    jTextArea1.setText(" \n   Missionsname");
    jTextArea1.setFont(new Font("Fixedsys", Font.PLAIN, 18));
    jTextArea1.setForeground(Color.GREEN);
    cp.add(jTextArea1ScrollPane);
    jTextArea2ScrollPane.setBounds(16, 96, 177, 177);
    jTextArea2.setBackground(Color.BLACK);
    jTextArea2.setText("Beschreibung\n");
    jTextArea2.setForeground(Color.GREEN);
    jTextArea2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    cp.add(jTextArea2ScrollPane);
    jTextArea3ScrollPane.setBounds(216, 24, 361, 105);
    jTextArea3.setBackground(Color.BLACK);
    jTextArea3.setText(" - Schwierigkeit: \n - Kosten:\n - ...");
    jTextArea3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jTextArea3.setForeground(Color.GREEN);
    cp.add(jTextArea3ScrollPane);
    jTextArea4ScrollPane.setBounds(216, 144, 361, 105);
    jTextArea4.setBackground(Color.BLACK);
    jTextArea4.setText(" - Gewinn:\n - Skillverbesserung:\n - ...");
    jTextArea4.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jTextArea4.setForeground(Color.GREEN);
    cp.add(jTextArea4ScrollPane);
    jSeparator1.setBounds(216, 136, 361, 1);
    jSeparator1.setBackground(Color.GREEN);
    jSeparator1.setForeground(Color.GREEN);
    jSeparator1.setFont(new Font("Dialog", Font.BOLD, 48));
    cp.add(jSeparator1);
    cp.setBackground(Color.BLACK);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public gui3_missinf
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new gui3_missinf("gui3_missinf");
  } // end of main
  
  // Ende Methoden
} // end of class gui3_missinf
