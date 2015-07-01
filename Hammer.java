import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.07.2015
  * @author 
  */

public class Hammer extends AbstractMiniGame {
  // Anfang Attribute
  private static String title = "Hammer";
  
  private JButton b1 = new JButton();
  private JButton b2 = new JButton();
  private JButton b3 = new JButton();
  private JButton b4 = new JButton();
  private JButton b5 = new JButton();
  private JButton b6 = new JButton();
  private JButton b7 = new JButton();
  private int rand; 
  private int h1 = 0;
  private int h2 = 0;
  private int h3 = 0;
  private int h4 = 0;
  private int h5 = 0;
  private int h6 = 0;
  private int h7 = 0;
  private int kill = 0;
  private int win = 0;
  private JButton btnStart = new JButton();
  // Ende Attribute
  private ActionListener t1 = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      //System.out.println(""+erg1+" "+erg2+" "+erg3+" "+erg4+" "+erg5);
      rand = (int) ((Math.random() * 6) + 0);
      if (rand == 0) {
        b1.setVisible(true);
        kill++;  
      } // end of if
      else if (rand == 1) {
        b2.setVisible(true);
        kill++; 
      } // end of if
      else if (rand == 2) {
        b3.setVisible(true);
        kill++; 
      } // end of if
      else if (rand == 3) {
        b4.setVisible(true);
        kill++; 
      } // end of if
      else if (rand == 4) {
        b5.setVisible(true);
        kill++; 
      } // end of if
      else if (rand == 5) {
        b6.setVisible(true);
        kill++; 
      } // end of if
      else if (rand == 6) {
        b7.setVisible(true);
        kill++; 
      } // end of if
      /*durchgaenge1++;
      if (durchgaenge1 == 8) {
      durchgaenge1 = 0;
      }*/
      if (kill == 4) {                  //hier Schwierigleit verändern
        new MiniGamesLoseScreen("MISSLUNGEN");
        tm1.stop(); 
        this.erfolg = false;
        this.versuche = 1;
        this.fertig = true;
        setVisible(false);
      } // end of if
      if (win == 8) {                  //hier Schwierigleit verändern
        new MiniGamesWinScreen("ERFOLG"); 
        tm1.stop();       
        this.erfolg = true;
        this.versuche = 1;
        this.fertig = true;
        setVisible(false);
      } // end of if
      
      
    }
  };
  
  private Timer tm1 = new Timer(1200, t1);    // hier Schwierigkeit verstellen
  public Hammer(int Schwierigkeitsgrad) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 404; 
    int frameHeight = 386;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    b1.setBounds(112, 120, 129, 41);
    b1.setText("0");
    b1.setMargin(new Insets(2, 2, 2, 2));
    b1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b1_ActionPerformed(evt);
      }
    });
    b1.setBackground(Color.BLACK);
    b1.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b1.setForeground(Color.GREEN);
    b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b1);
    b1.setVisible(false);
    b2.setBounds(144, 24, 57, 65);
    b2.setText("0");
    b2.setMargin(new Insets(2, 2, 2, 2));
    b2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b2_ActionPerformed(evt);
      }
    });
    b2.setBackground(Color.BLACK);
    b2.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b2.setForeground(Color.GREEN);
    b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b2);
    b2.setVisible(false);
    b3.setBounds(40, 136, 57, 97);
    b3.setText("0");
    b3.setMargin(new Insets(2, 2, 2, 2));
    b3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b3_ActionPerformed(evt);
      }
    });
    b3.setBackground(Color.BLACK);
    b3.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b3.setForeground(Color.GREEN);
    b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b3);
    b3.setVisible(false);
    b4.setBounds(216, 64, 129, 49);
    b4.setText("0");
    b4.setMargin(new Insets(2, 2, 2, 2));
    b4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b4_ActionPerformed(evt);
      }
    });
    b4.setBackground(Color.BLACK);
    b4.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b4.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b4.setForeground(Color.GREEN);
    b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b4);
    b4.setVisible(false);
    b5.setBounds(32, 64, 89, 41);
    b5.setText("0");
    b5.setMargin(new Insets(2, 2, 2, 2));
    b5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b5_ActionPerformed(evt);
      }
    });
    b5.setBackground(Color.BLACK);
    b5.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b5.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b5.setForeground(Color.GREEN);
    b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b5);
    b5.setVisible(false);
    b6.setBounds(272, 128, 57, 97);
    b6.setText("0");
    b6.setMargin(new Insets(2, 2, 2, 2));
    b6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b6_ActionPerformed(evt);
      }
    });
    b6.setBackground(Color.BLACK);
    b6.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b6.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b6.setForeground(Color.GREEN);
    b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b6);
    b6.setVisible(false);
    b7.setBounds(168, 184, 81, 49);
    b7.setText("0");
    b7.setMargin(new Insets(2, 2, 2, 2));
    b7.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        b7_ActionPerformed(evt);
      }
    });
    b7.setBackground(Color.BLACK);
    b7.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    b7.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    b7.setForeground(Color.GREEN);
    b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(b7);
    b7.setVisible(false);
    btnStart.setBounds(48, 256, 289, 73);
    btnStart.setText("Start");
    btnStart.setMargin(new Insets(2, 2, 2, 2));
    btnStart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnStart_ActionPerformed(evt);
      }
    });
    btnStart.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnStart.setBackground(Color.BLACK);
    btnStart.setBorder(new javax.swing.border.LineBorder(Color.RED, 2));
    btnStart.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    btnStart.setForeground(Color.GREEN);
    cp.add(btnStart);
    cp.setBackground(Color.BLACK);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Hammer
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    AbstractMiniGame reflKey = new ReflKey(0);
    reflKey.initialisieren();
    reflKey.setVisible(true);
  } // end of main
  
  public void b1_ActionPerformed(ActionEvent evt) {
    h1++;
    
    if (h1 == 5) {
      b1.setVisible(false);
      kill--;
      win++;
      h1 = 0;
    } // end of if
    b1.setText(""+h1);
  } // end of b1_ActionPerformed
  
  public void b2_ActionPerformed(ActionEvent evt) {
    h2++;
    
    if (h2 == 5) {
      b2.setVisible(false);
      kill--;
      win++;
      h2 = 0;
    } // end of if// TODO hier Quelltext einfügen
    b2.setText(""+h2);
  } // end of b2_ActionPerformed
  
  public void b3_ActionPerformed(ActionEvent evt) {
    h3++;
    
    if (h3 == 5) {
      b3.setVisible(false);
      kill--;
      win++;
      h3 = 0;
    } // end of if// TODO hier Quelltext einfügen
    b3.setText(""+h3);
  } // end of b3_ActionPerformed
  
  public void b4_ActionPerformed(ActionEvent evt) {
    h4++;
    
    if (h4 == 5) {
      b4.setVisible(false);
      kill--;
      win++;
      h4 = 0;
    } // end of if// TODO hier Quelltext einfügen
    b4.setText(""+h4);
  } // end of b4_ActionPerformed
  
  public void b5_ActionPerformed(ActionEvent evt) {
    h5++;
    
    if (h5 == 5) {
      b5.setVisible(false);
      kill--;
      win++;
      h5 = 0;
    } // end of if// TODO hier Quelltext einfügen
    b5.setText(""+h5);
  } // end of b5_ActionPerformed
  
  public void b6_ActionPerformed(ActionEvent evt) {
    h6++;
    
    if (h6 == 5) {
      b6.setVisible(false);
      kill--;
      win++;
      h6 = 0;
    } // end of if// TODO hier Quelltext einfügen
    b6.setText(""+h6);
  } // end of b6_ActionPerformed
  
  public void b7_ActionPerformed(ActionEvent evt) {
    h7++;
    
    if (h7 == 5) {
      b7.setVisible(false);
      kill--;
      win++;
      h7 = 0;
    } // end of if// TODO hier Quelltext einfügen
    b7.setText(""+h7);
  } // end of b7_ActionPerformed
  
  public void btnStart_ActionPerformed(ActionEvent evt) {
    tm1.setInitialDelay(0);
    tm1.start(); 
  } // end of btnStart_ActionPerformed
  
  // Ende Methoden
} // end of class Hammer
