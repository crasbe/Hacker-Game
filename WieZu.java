import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 23.06.2015
  * @author 
  */

public class WieZu extends AbstractMiniGame {
  // Anfang Attribute
 private class QuizLader extends AbstractLader {
    public QuizLader() {
      super ("quiz");
    }
  }  
  // DummyKlasse  
  // DummyKlasse                                 
  private JRadioButton antw2 = new JRadioButton();
  private JRadioButton antw3 = new JRadioButton();
  private JRadioButton antw4 = new JRadioButton();
  private ButtonGroup antwGroup = new ButtonGroup();
  private JRadioButton antw1 = new JRadioButton();
  private JTextField aufgabe = new JTextField();
  private int antw;
  private String richt;
  private int pktCnt = 0;
  private int rndCnt = 1;
  private AbstractLader quizLader = new QuizLader();
  private Properties quizProp = quizLader.getProps().get(0);
  private String auswahl = "";
  private JButton btnAbschicken = new JButton();
  private MiniGamesWinScreen WinScreen;
  private MiniGamesLoseScreen LoseScreen;
  // Ende Attribute
  
  public WieZu(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 457; 
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
    
    antw2.setBounds(56, 176, 233, 41);
    antw2.setText("");
    antw2.setActionCommand("a2");
    antw2.setOpaque(true);
    antw2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw2_ActionPerformed(evt);
      }
    });
    antw2.setBackground(Color.BLACK);
    antw2.setForeground(Color.GREEN);
    antw2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    antw2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(antw2);
    antw3.setBounds(56, 224, 241, 41);
    antw3.setText("");
    antw3.setActionCommand("a3");
    
    antw3.setOpaque(true);
    antw3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw3_ActionPerformed(evt);
      }
    });
    antw3.setBackground(Color.BLACK);
    antw3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    antw3.setForeground(Color.GREEN);
    antw3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(antw3);
    antw4.setBounds(56, 272, 183, 41);
    antw4.setText("");
    antw4.setActionCommand("a4");
    antw4.setOpaque(true);
    antw4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw4_ActionPerformed(evt);
      }
    });
    antw4.setBackground(Color.BLACK);
    antw4.setForeground(Color.GREEN);
    antw4.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    antw4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(antw4);
    antw1.setBounds(56, 128, 233, 41);
    antw1.setText("");
    antw1.setActionCommand("a1");
    antw1.setOpaque(true);
    antw1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw1_ActionPerformed(evt);
      }
    });
    antw1.setBackground(Color.BLACK);
    antw1.setForeground(Color.GREEN);
    antw1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    antw1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(antw1);
    aufgabe.setBounds(72, 48, 297, 65);
    aufgabe.setBackground(Color.BLACK);
    aufgabe.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    aufgabe.setForeground(Color.GREEN);
    aufgabe.setEditable(false);
    cp.add(aufgabe);
    antwGroup.add(antw1);
    antwGroup.add(antw2);
    antwGroup.add(antw3);
    antwGroup.add(antw4);
    btnAbschicken.setBounds(240, 272, 137, 57);
    btnAbschicken.setText("weiter");
    btnAbschicken.setMargin(new Insets(2, 2, 2, 2));
    btnAbschicken.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnAbschicken_ActionPerformed(evt);
      }
    });
    btnAbschicken.setBackground(Color.BLACK);
    btnAbschicken.setBorder(new javax.swing.border.LineBorder(Color.RED, 2));
    btnAbschicken.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    btnAbschicken.setForeground(Color.GREEN);
    btnAbschicken.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cp.add(btnAbschicken);
    cp.setBackground(Color.BLACK);
    setzeQuizfragen();
    
    setVisible(true);
  } // end of public WieZu
  
  
  // Anfang Methoden
  
  private void setzeQuizfragen(){
    richt = quizProp.getProperty("richt" + rndCnt);
    aufgabe.setText(quizProp.getProperty("aufgabe" + rndCnt));
    int a = 4 * (rndCnt - 1);
    antw1.setText(quizProp.getProperty("antw"+ (1 + a)));
    antw2.setText(quizProp.getProperty("antw"+ (2 + a)));
    antw3.setText(quizProp.getProperty("antw"+ (3 + a)));
    antw4.setText(quizProp.getProperty("antw"+ (4 + a)));
    
    antwGroup.clearSelection(); // den ausgewählten Button für die
    // nächste Runde zurücksetzen
    
    
  }
  public void antw1_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } 
  
  public void antw2_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw2_ActionPerformed
  
  public void antw3_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw3_ActionPerformed
  
  public void antw4_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw3_ActionPerformed
  protected void btnAbschicken_ActionPerformed(ActionEvent evt) {
    System.out.println("Erfolg Platzhalter"); 
    
    if (auswahl.equals(richt)) {
      pktCnt++;
      System.out.println("Niederlage Platzhalter");
      //nächste
    } // end of if
    else {
      pktCnt--;
      System.out.println("dies");
    } // end of if-else
    
    if (rndCnt == 2) {
      if (pktCnt == 2) {
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
    } // end of if
    rndCnt++;
    setzeQuizfragen();
    
    
  }
  // Ende Methoden
  
  public static void main(String[] args) {
    new WieZu("WieZu");
  } // end of main
  
} // end of class WieZu
