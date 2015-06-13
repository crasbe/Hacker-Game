import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 13.06.2015
  * @author 
  */

public class ReflKey extends JFrame {
  // Anfang Attribut
  private boolean dec = false;
  private int erg1 = (int)((Math.random()*9)+0);
  private int erg2 = (int)((Math.random()*9)+0);
  private int erg3 = (int)((Math.random()*9)+0);
  private int erg4 = (int)((Math.random()*9)+0);
  private int erg5 = (int)((Math.random()*9)+0);
  private JTextField txtfueberschrift = new JTextField();
  private JButton decstart = new JButton();
  private JNumberField nrfErgebnis = new JNumberField();
  private JTextField zahl1 = new JTextField();
  private JTextField zahl2 = new JTextField();
  private JTextField zahl3 = new JTextField();
  private JTextField zahl4 = new JTextField();
  private JTextField zahl5 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  // Ende Attribute
  
  public ReflKey(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 289; 
    int frameHeight = 300;
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
    txtfueberschrift.setText("      REFLEX KEY");
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
    nrfErgebnis.setBounds(72, 208, 129, 41);
    nrfErgebnis.setText("");
    nrfErgebnis.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    nrfErgebnis.setForeground(Color.BLACK);
    nrfErgebnis.setBackground(Color.BLACK);
    nrfErgebnis.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        nrfErgebnis_ActionPerformed(evt);
      }
    });
    cp.add(nrfErgebnis);
    cp.setBackground(Color.BLACK);
    setTitle("REFLEX KEY");
    setUndecorated(true);
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
    // Ende Komponenten
    
    setVisible(true);
  } // end of public ReflKey
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new ReflKey("ReflKey");
  } // end of main
  public void nrfErgebnis_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of nrfErgebnis_ActionPerformed
  
  public void decstart_MousePressed(MouseEvent evt) {
    // TODO hier Quelltext einfügen
    zahl1.setText(" Q");
    sleep(5000);
    sleep(1000);
    zahl1.setText(" K");
    sleep(1000);
    zahl1.setText(" " +erg1);
    sleep(1000);
    zahl1.setText(" C"); 
  } 
  public static void sleep (int time) {
    try{
      Thread.sleep(time);
    } catch (Exception e) {}
  }
} 
