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

public class WieZu extends JFrame {
  // Anfang Attribute
  private class QuizLader extends AbstractLader {
    public QuizLader() {
      super ("quiz");
    }
  }  
  // DummyKlasse  
  
  private JRadioButton antw2 = new JRadioButton();
  private JRadioButton antw3 = new JRadioButton();
  private JRadioButton antw4 = new JRadioButton();
  private ButtonGroup antwGroup = new ButtonGroup();
  private JRadioButton antw1 = new JRadioButton();
  private JTextField aufgabe = new JTextField();
  private int antw;
  private String richt;
  private int pktCnt;
  private int rndCnt = 1;
  private AbstractLader quizLader = new QuizLader();
  private Properties quizProp = quizLader.getProps().get(0);
  private String auswahl = "";
  private JButton btnAbschicken = new JButton();
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
    antw2.setOpaque(false);
    antw2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw2_ActionPerformed(evt);
      }
    });
    cp.add(antw2);
    antw3.setBounds(56, 224, 241, 41);
    antw3.setText("");
    antw3.setActionCommand("a3");
    
    antw3.setOpaque(false);
    antw3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw3_ActionPerformed(evt);
      }
    });
    cp.add(antw3);
    antw4.setBounds(56, 272, 233, 41);
    antw4.setText("");
    antw4.setActionCommand("a4");
    antw4.setOpaque(false);
    antw4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw4_ActionPerformed(evt);
      }
    });
    cp.add(antw4);
    antw1.setBounds(56, 128, 233, 41);
    antw1.setText("");
    antw1.setActionCommand("a1");
    antw1.setOpaque(false);
    antw1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        antw1_ActionPerformed(evt);
      }
    });
    cp.add(antw1);
    aufgabe.setBounds(72, 48, 297, 65);
    cp.add(aufgabe);
    antwGroup.add(antw1);
    antwGroup.add(antw2);
    antwGroup.add(antw3);
    antwGroup.add(antw4);
    btnAbschicken.setBounds(296, 264, 121, 57);
    btnAbschicken.setText("weiter");
    btnAbschicken.setMargin(new Insets(2, 2, 2, 2));
    btnAbschicken.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnAbschicken_ActionPerformed(evt);
      }
    });
    cp.add(btnAbschicken);
    setzeQuizfragen();
    // Ende Komponenten
    
    setVisible(true);
  } // end of public WieZu
  
  // Anfang Methoden
  
  private void setzeQuizfragen(){
    String richt = quizProp.getProperty("richt" + rndCnt);
    aufgabe.setText(quizProp.getProperty("aufgabe" + rndCnt));
    int a = 4 * (rndCnt - 1);
    antw1.setText(quizProp.getProperty("antw"+ (1 + a)));
    antw2.setText(quizProp.getProperty("antw"+ (2 + a)));
    antw3.setText(quizProp.getProperty("antw"+ (3 + a)));
    antw4.setText(quizProp.getProperty("antw"+ (4 + a)));

    antwGroup.clearSelection(); // den ausgewählten Button für die
                                // nächste Runde zurücksetzen
    
    rndCnt++;
  }
  public void antw1_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw1_ActionPerformed
  
  public void antw2_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw2_ActionPerformed
  
  public void antw3_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw3_ActionPerformed
  
  public void antw4_ActionPerformed(ActionEvent evt) {
    auswahl = evt.getActionCommand();
  } // end of antw4_ActionPerformed
  protected void btnAbschicken_ActionPerformed(ActionEvent evt) {
    
    
    if (auswahl.equals(richt)) {
      pktCnt++;
      //nächste
    } // end of if
    else {
      pktCnt--;
      //nächste
    } // end of if-else
    setzeQuizfragen();
    
  }
  // Ende Methoden
  
  public static void main(String[] args) {
    new WieZu("WieZu");
  } // end of main
  
} // end of class WieZu
