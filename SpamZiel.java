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

public class SpamZiel extends AbstractMiniGame {
  // Anfang Attribute
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private SKMelde skMelde;  // Die Spamnachrichten
  private int spam;
  private int durchgaenge;
  private int x = 500;
  private int y = 250;
  private int end = 1;
  private int ko = 1;
  private boolean ende = false;
  private TodesSpam kill; // Die Endscreens
  private Win win;        // "             "
  // Ende Attribute
  // Diese Timerschleife lässt nach dem JButton1 gedrückt wurde (s.u.) Spamnachrichten (SKMelde Objekte) erscheinen,
  // die jeweils leicht veränderte x und y koordinaten besitzen
  private ActionListener buchAnz = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if (ende == false) {                     // da an anderer Stelle das Ende tatsächlich
                                               // erreicht wird verhindert dieser boolean ein weiteres Spawnen von Spam 
        jButton2.setEnabled(true);             // der Fertigstellknopf wird freigeschaltet, damit man sich durch den Timerdelay keinen Sieg
        new SKMelde("Blau").setLocation(x,y);  // erbuggen kann
        if (spam == 0) {
          x = x + 50;  
        } // end of if
        else if (spam == 1){
          y = y + 25;  
        } // end of if-else
        else if (spam == 2){
          x = x + 50;  
        } // end of if-else
        else if (spam == 3){
          y = y + 25;  
        } // end of if-else
        else if (spam == 4){
          x = x + 50;
        }  
        spam++;                              // die Spamnachrichtenschübe sind auf eine Anzahl "spam" reduziert
        if (spam == 5) {
          tinm1.stop();
          tm2.setInitialDelay(1000);         // mit etwas Delay wird der nächste Schub vorbereitet
          tm2.start();
          x = 500;                           // x und y werden zurückgesetzt damit alle Spamnachrichten den "Fertigstellenbutton"
          y = 250;                           // verdecken
        }
      }
    };
  }; 
  private Timer tinm1 = new Timer(800, buchAnz);
  private ActionListener resta = new ActionListener() {
    public void actionPerformed(ActionEvent evt){
      spam = 0;                              // dieser zweite Timer hat mehrere Aufgaben: zunächst wird der nächste Spamschub initialisiert
      tinm1.setInitialDelay(0);
      tinm1.start();
      tm2.stop();
      end++;
      if (end == 5) {                        // außerdem findet sich hier die Niederlagenbedingung die den Bildschirm mit TodesSpam Objekten zukleistert
        while (ko <= 100) { 
          x = (int)(Math.random() * 1000) + 1; 
          y = (int)(Math.random() * 500) + 1; 
          new TodesSpam("TOD").setLocation(x,y);
          ko++; 
          ende = true; 
        } // end of while
      } // end of if
    }
  };
  private Timer tm2 = new Timer(5000, resta); 
  
  public SpamZiel(String title) {      // Der eigentliche SpamZiel Frame wird definiert
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 611; 
    int frameHeight = 308;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = 400;
    int y = 180;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTextArea1ScrollPane.setBounds(88, 16, 417, 169);
    jTextArea1.setText("Missionsbeschreibung (Damit du verstehst was\n                      zu tun ist)\n----------------------------------------------\n- Drück Installieren\n- Schließe die Spemnachrichten\n- Drück Fertigstellen\n- Wenn du zu langsam bist und die Spams sich\n  fünf mal wiederholt erneuert haben verlierst\n  du\nPLATZHALTERPLATZHALTERPLATZHALTERPLATZHALTER");
    jTextArea1.setBackground(Color.BLACK);
    jTextArea1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jTextArea1.setForeground(Color.GREEN);
    cp.add(jTextArea1ScrollPane);
    jButton1.setBounds(104, 192, 169, 33);
    jButton1.setText("Installieren");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setBackground(Color.BLACK);
    jButton1.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    jButton1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jButton1.setForeground(Color.GREEN);
    cp.add(jButton1);
    jButton2.setBounds(320, 192, 169, 33);
    jButton2.setText("Fertigstellen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jButton2.setEnabled(false);
    jButton2.setBackground(Color.BLACK);
    jButton2.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    jButton2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jButton2.setForeground(Color.GREEN);
    cp.add(jButton2);
    cp.setBackground(Color.BLACK);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public SpamZiel
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new SpamZiel("SpamZiel");
    
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {        // der "Installieren" Button startet die Spamnachrichten über den ersten Timer (s.o.)
    spam = 0;
    tinm1.setInitialDelay(0);
    tinm1.start();
    
    
  } // end of jButton1_ActionPerformed
  
  public void jButton2_ActionPerformed(ActionEvent evt) {      // der durch t1 aktivierte "Fertigstellen" Button ist die Siegbedingung. Bisher erzeugt 
    new Win("Win");                                            // diese nur ein Platzhalter Fenster
    ende = true;
  } // end of jButton2_ActionPerformed
  
  public SKMelde getSkMelde() {
    return skMelde;
  }
  
  public TodesSpam getKill() {
    return kill;
  }
  
  public Win getWin() {
    return win;
  }
  
  // Ende Methoden
} // end of class SpamZiel
