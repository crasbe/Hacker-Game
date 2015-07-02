import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.07.2015
  * @author 
  */

public class Merken extends AbstractMiniGame {
  // Anfang Attribute
    private static String title = "Merken";
    private List<JButton> buttons = new ArrayList<JButton>();
    //private List<Integer> c = Arrays.asList(1,2,3,4,5,6,7,8,9);
    private JButton bStart = new JButton();
    private int a ;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int c1;
    private int c2;
    private int c3;
    private int c4;
    private int c5;
 
    private AbstractGui guiWinScreen = new GuiWinScreen();
    private AbstractGui guiLoseScreen = new GuiLoseScreen();
  // Ende Attribute
  private ActionListener t1 = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      int rand = (int) ((Math.random() * 8) + 0);
      a = rand;
      
      if (b == 0) {
        c1 = a;
      } // end of if
      else if (b == 1) {
        c2 = a;
      } // end of if
      else if (b == 2) {
        c3 = a;
      } // end of if
      else if (b == 3) {
        c4 = a;
      } // end of if
      else if (b == 4) {
        c5 = a;
        
      } // end of if
      
      
      
      buttons.get(rand).setBackground(Color.GREEN);
      buttons.get(rand).setBorder(new javax.swing.border.LineBorder(Color.RED, 3));
      buttons.get(rand).setFont(new Font("Fixedsys", Font.PLAIN, 12));
      buttons.get(rand).setForeground(Color.GREEN);
      buttons.get(rand).setCursor(new Cursor(Cursor.HAND_CURSOR));
      buttons.get(rand).setVisible(true);
      tm2.setInitialDelay(500);
      tm2.start();
      b++;
    }
  };
  private Timer tm1 = new Timer(1500 - 50*schwierigkeit, t1); // hier Schwierigkeit verstellen
  private ActionListener t2 = new ActionListener() {
    public void actionPerformed(ActionEvent e){
      buttons.get(a).setBackground(Color.BLACK);
      buttons.get(a).setBorder(new javax.swing.border.LineBorder(Color.GRAY, 3));
      buttons.get(a).setFont(new Font("Fixedsys", Font.PLAIN, 12));
      buttons.get(a).setForeground(Color.BLACK);
      buttons.get(a).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      tm2.stop();
      d++;
      if (d == 5) {
        tm1.stop();
        //System.out.println("Hallo");
        for (int z = 0;z < 9 ;z++ ) {
          buttons.get(z).setEnabled(true);
          buttons.get(z).setText("KLICK");
          buttons.get(z).setFont(new Font("Fixedsys", Font.PLAIN, 12));
          buttons.get(z).setForeground(Color.GREEN);
          buttons.get(z).setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
        } // end of for
        
      } // end of if
    }
  };
  private Timer tm2 = new Timer(700 - 25*schwierigkeit, t2);  //SChwierigkeit verstellen
  
  public Merken(int schwierigkeit) { 
    // Frame-Initialisierung
    super(title);
    this.schwierigkeit = schwierigkeit;
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 378; 
    int frameHeight = 465;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    for(int i = 0; i < 9; i++) {
      buttons.add(new JButton());
      buttons.get(i).setText("");
      buttons.get(i).setMargin(new Insets(2, 2, 2, 2));
      buttons.get(i).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          buttons_ActionPerformed(evt);
        }
      });
      // um die Buttons beim generischen ActionListener zu unterscheiden
      buttons.get(i).setBackground(Color.BLACK);
      buttons.get(i).setBorder(new javax.swing.border.LineBorder(Color.GRAY, 3));
      buttons.get(i).setFont(new Font("Fixedsys", Font.PLAIN, 12));
      buttons.get(i).setForeground(Color.BLACK);
      buttons.get(i).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      buttons.get(i).setActionCommand(""+i);
      buttons.get(i).setEnabled(false);
      buttons.get(i).setVisible(true);
      cp.add(buttons.get(i));
    }
    buttons.get(0).setBounds(56, 40, 73, 73);
    buttons.get(1).setBounds(144, 40, 73, 73);
    buttons.get(2).setBounds(232, 40, 73, 73);
    buttons.get(3).setBounds(56, 128, 73, 73);
    buttons.get(4).setBounds(144, 128, 73, 73);
    buttons.get(5).setBounds(232, 128, 73, 73);
    buttons.get(6).setBounds(56, 216, 73, 73);
    buttons.get(7).setBounds(144, 216, 73, 73);
    buttons.get(8).setBounds(232, 216, 73, 73);
    
    
    
    
    bStart.setBounds(56, 328, 249, 57);
    bStart.setText("Start");
    bStart.setMargin(new Insets(2, 2, 2, 2));
    bStart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bStart_ActionPerformed(evt);
      }
    });
    bStart.setBackground(Color.BLACK);
    bStart.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    bStart.setForeground(Color.GREEN);
    bStart.setBorder(new javax.swing.border.LineBorder(Color.RED, 2));
    cp.add(bStart);
    cp.setBackground(Color.BLACK);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Merken
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    AbstractMiniGame merken = new Merken(0);
    merken.initialisieren();
    merken.setVisible(true);
  } // end of main
  
  private void buttons_ActionPerformed(ActionEvent evt) {
    int btnNummer = Integer.parseInt(evt.getActionCommand());
    buttons.get(btnNummer).setBackground(Color.GREEN);
    if (e == 0) {
      if (c1 == btnNummer) {   
        f++;  
      } // end of if
      else {
        guiLoseScreen.setVisible(true);
        erfolg = false;
        versuche = 1;
        fertig = true;
      } // end of if-else
    } // end of if
    else if (e == 1) {
      System.out.println("A");
      if (c2 == btnNummer) {
        f++; 
      } // end of if
      else {
        guiLoseScreen.setVisible(true);
        erfolg = false;
        versuche = 1;
        fertig = true;
      } // end of if-else
    } // end of if
    else if (e == 2) {
      if (c3 == btnNummer) {  
        f++;
      } // end of if
      else {
        guiLoseScreen.setVisible(true);
        erfolg = false;
        versuche = 1;
        fertig = true;
      } // end of if-else
    } // end of if
    else if (e == 3) {
      if (c4 == btnNummer) {  
        f++;
      } // end of if
      else {
        guiLoseScreen.setVisible(true);
        erfolg = false;
        versuche = 1;
        fertig = true;
      } // end of if-else
    } // end of if
    else if (e == 4) {
      if (c5 == btnNummer) {
        f++;  
      } // end of if
      else {
        guiLoseScreen.setVisible(true);
        erfolg = false;
        versuche = 1;
        fertig = true;
      } // end of if-else
    }
    if (f == 5) {
      guiWinScreen.setVisible(true);
      erfolg = true;
      versuche = 1;
      fertig = true;
    } // end of if
    e++;
    
  }
  public void bStart_ActionPerformed(ActionEvent evt) {
    bStart.setEnabled(false);
    
    tm1.setInitialDelay(0);
    tm1.start();
  } // end of bStart_ActionPerformed
  public void setVisible(boolean b) {
    // Die Methode "setVisible" der Mutterklasse wird überschrieben,
    // damit auch die anderen Fenster geschlossen werden
    if(b == false) {
      guiLoseScreen.setVisible(false);
      guiWinScreen.setVisible(false);
    }
    
    // die eigentliche Funktion (die Überschrieben wurde), aufrufen.
    super.setVisible(b);
  }
  // Ende Methoden
} // end of class Merken
