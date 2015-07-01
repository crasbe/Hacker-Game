import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 30.06.2015
  * @author 
  */

public class Roller extends AbstractMiniGame {
  // Anfang Attribute
  private static String title = "Roller";
  
  private JTextField zahl1 = new JTextField();
  private JTextField zahl2 = new JTextField();
  private JTextField zahl3 = new JTextField();
  private JTextField zahl4 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JButton btnStop = new JButton();
  
  private int erg1 = (int) ((Math.random() * 30) + 20);
  private int erg2 = (int) ((Math.random() * 30) + 20);
  private int erg3 = (int) ((Math.random() * 30) + 20);
  private int erg4 = (int) ((Math.random() * 30) + 20);
  private int erg5 = (int) ((Math.random() * 30) + 20);
  private JButton btnStart = new JButton();
  private int durchgaenge1 = 0;
  private int durchgaenge2 = 0;
  private int durchgaenge3 = 0;
  private int durchgaenge4 = 0;
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
  
  private int sto = 0;
  private double ri1;
  private double ri2;
  private double ri3;
  private double ri4;
  
  private JTextField txtri4 = new JTextField();
  private JTextField txtri3 = new JTextField();
  private JTextField txtri2 = new JTextField();
  private JTextField txtri1 = new JTextField();
  // Ende Attribute
  private String[] text1 = { " " + (erg1+1), " " + erg1, " " + (erg1-2), " " + (erg1+4), " " + (erg1-3), " " + (erg1-4), " " + (erg1+3),
" " + (erg1-1),  " " + (erg1+1), " " + erg1 };
 
  private String[] text2 = { " " + (erg2+1), " " + (erg2+4), " " + (erg2-2), " " + erg2, " " + (erg2-3), " " + (erg2-4), " " + (erg2+3),
  " " + (erg2-1),  " " + (erg2+1), " " + (erg2+4) };
  
  private String[] text3 = { " " + (erg3+1), " " + (erg3+3), " " + (erg3-2), " " + (erg3+4), " " + (erg3-3), " " + (erg3-4), " " + erg3,
  " " + (erg3-1),  " " + (erg3+1), " " + (erg3+3) };
 
  private String[] text4 = { " " + (erg4+1), " " + (erg4-2), " " + erg4, " " + (erg4+4), " " + (erg4-3), " " + (erg4-4), " " + (erg4+3),
  " " + (erg4-1),  " " + (erg4+1), " " + (erg4-2) };
  
  
private ActionListener t1 = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    //System.out.println(""+erg1+" "+erg2+" "+erg3+" "+erg4+" "+erg5);
    z1_1.setText(text1[durchgaenge1 + 2]);
    z1_2.setText(text1[durchgaenge1 + 1]);
    z1_3.setText(text1[durchgaenge1]);
    
    durchgaenge1++;
    if (durchgaenge1 == 8) {
      durchgaenge1 = 0;
    }
  }
};
  
  private Timer tm1 = new Timer(500, t1);
private ActionListener t2 = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    //System.out.println(""+erg1+" "+erg2+" "+erg3+" "+erg4+" "+erg5);
    z2_1.setText(text2[durchgaenge2 + 2]);
    z2_2.setText(text2[durchgaenge2 + 1]);
    z2_3.setText(text2[durchgaenge2]);
    
    durchgaenge2++;
    if (durchgaenge2 == 8) {
      durchgaenge2 = 0;
    }
  }
};
  
  private Timer tm2 = new Timer(500, t2);
private ActionListener t3 = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    //System.out.println(""+erg1+" "+erg2+" "+erg3+" "+erg4+" "+erg5);
    z3_1.setText(text3[durchgaenge3 + 2]);
    z3_2.setText(text3[durchgaenge3 + 1]);
    z3_3.setText(text3[durchgaenge3]);
    
    
    durchgaenge3++;
    if (durchgaenge3 == 8) {
      durchgaenge3 = 0;
    }
  }
};
  
  private Timer tm3 = new Timer(500, t3);
private ActionListener t4 = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    //System.out.println(""+erg1+" "+erg2+" "+erg3+" "+erg4+" "+erg5);
    z4_1.setText(text4[durchgaenge4 + 2]);
    z4_2.setText(text4[durchgaenge4 + 1]);
    z4_3.setText(text4[durchgaenge4]);
    
    
    durchgaenge4++;
    if (durchgaenge4 == 8) {
      durchgaenge4 = 0;
    }
  }
};
  
  private Timer tm4 = new Timer(500, t4);
  
public Roller(int Schwierigkeitsgrad) { 
  // Frame-Initialisierung
  super(title);
  
  setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
  
  zahl1.setBounds(96, 104, 49, 153);
  cp.add(zahl1);
  zahl2.setBounds(160, 104, 49, 153);
  cp.add(zahl2);
  zahl3.setBounds(224, 104, 49, 153);
  cp.add(zahl3);
  zahl4.setBounds(288, 104, 49, 153);
  cp.add(zahl4);
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
  cp.add(btnStop);
  txtri1.setBounds(104, 48, 33, 49);
  txtri1.setText("  "+erg1);
  cp.add(txtri1);
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
  jPanel1.add(z1_1);
  z1_2.setBounds(0, 56, 49, 33);
  jPanel1.add(z1_2);
  z1_3.setBounds(0, 96, 49, 33);
  jPanel1.add(z1_3);
  z2_1.setBounds(160, 120, 49, 33);
  cp.add(z2_1);
  z2_3.setBounds(160, 200, 49, 33);
  cp.add(z2_3);
  z2_2.setBounds(160, 160, 49, 33);
  cp.add(z2_2);
  z3_1.setBounds(0, 16, 49, 33);
  jPanel3.add(z3_1);
  z3_3.setBounds(0, 96, 49, 33);
  jPanel3.add(z3_3);
  z3_2.setBounds(0, 56, 49, 33);
  jPanel3.add(z3_2);
  z4_1.setBounds(0, 16, 49, 33);
  jPanel4.add(z4_1);
  z4_3.setBounds(0, 96, 49, 33);
  jPanel4.add(z4_3);
  z4_2.setBounds(0, 56, 49, 33);
  jPanel4.add(z4_2);
  txtri4.setBounds(296, 48, 33, 49);
  txtri4.setText("  "+erg4);
  cp.add(txtri4);
  txtri3.setBounds(232, 48, 33, 49);
  txtri3.setText("  "+erg3);
  cp.add(txtri3);
  txtri2.setBounds(168, 48, 33, 49);
  txtri2.setText("  "+erg2);
  cp.add(txtri2);
  // Ende Komponenten
  
  setVisible(true);
} // end of public Roller
  
  // Anfang Methoden
public void btnStop_ActionPerformed(ActionEvent evt) {
  sto++;
  if (sto == 1) {
    tm1.stop();
  } // end of if
  else if (sto == 2) {
    tm2.stop();
  } // end of if
  else if (sto == 3) {
    tm3.stop();
  } // end of if-else
  else if (sto == 4) {
    tm4.stop();
    ri1 = Double.parseDouble(z1_2.getText());
    ri2 = Double.parseDouble(z2_2.getText());
    ri3 = Double.parseDouble(z3_2.getText());
    ri4 = Double.parseDouble(z4_2.getText());
    if (erg1 == ri1 && erg2 == ri2 && erg3 == ri3 && erg4 == ri4) {
      new MiniGamesWinScreen("ERFOLG");
      this.erfolg = true;
    } // end of if
    else {
      new MiniGamesLoseScreen("MISSLUNGEN");
      this.erfolg = false;
    } // end of if-else
    
    this.versuche = 1;
    this.fertig = true;
    setVisible(false);
  } // end of if-else
} // end of btnStop_ActionPerformed
  
public void btnStart_ActionPerformed(ActionEvent evt) {
  tm1.setInitialDelay(0);
  tm1.start();
  tm2.setInitialDelay(0);
  tm2.start();
  tm3.setInitialDelay(0);
  tm3.start();
  tm4.setInitialDelay(0);
  tm4.start();
} // end of btnStart_ActionPerformed
  
  // Ende Methoden
  
public static void main(String[] args) {
  AbstractMiniGame roller = new Roller(0);
  roller.initialisieren();
  roller.setVisible(true);
} // end of main
  
} // end of class Roller
