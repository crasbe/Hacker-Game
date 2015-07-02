import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.List;
import java.util.ArrayList;

public class Hammer extends AbstractMiniGame {
  // Anfang Attribute
  private static String title = "Hammer";

  private JButton btnStart = new JButton();
  
  private List<JButton> buttons = new ArrayList<JButton>();
  
  private int kill = 0;
  private int win = 0;
  
  private AbstractGui guiWinScreen = new GuiWinScreen();
  private AbstractGui guiLoseScreen = new GuiLoseScreen();
  
  private ActionListener t1 = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      int rand = (int) ((Math.random() * 6) + 0);
      
      kill++;

      if (kill == 6 - schwierigkeit) { // hier Schwierigleit verändern
        guiLoseScreen.setVisible(true);
        tm1.stop();
        erfolg = false;
        versuche = 1;
        fertig = true;
      } else if (win == 5 + schwierigkeit) { // hier Schwierigleit verändern
        guiWinScreen.setVisible(true);
        tm1.stop();
        erfolg = true;
        versuche = 1;
        fertig = true;
      } else {
        buttons.get(rand).setVisible(true);
      }
    }
  };

  private Timer tm1 = new Timer(800 + 700/schwierigkeit, t1); // hier Schwierigkeit verstellen
  
  public Hammer(int schwierigkeit) {
    super(title);
    
    this.schwierigkeit = schwierigkeit;
    
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

    // Sieben Buttons werden initialisiert
    for(int i = 0; i < 7; i++) {
      buttons.add(new JButton());
      buttons.get(i).setText("0");
      buttons.get(i).setMargin(new Insets(2, 2, 2, 2));
      buttons.get(i).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          buttons_ActionPerformed(evt);
        }
      });
      // um die Buttons beim generischen ActionListener zu unterscheiden
      buttons.get(i).setActionCommand(""+i);
      buttons.get(i).setBackground(Color.BLACK);
      buttons.get(i).setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
      buttons.get(i).setFont(new Font("Fixedsys", Font.PLAIN, 12));
      buttons.get(i).setForeground(Color.GREEN);
      buttons.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
      buttons.get(i).setVisible(false);
      cp.add(buttons.get(i));
    }
    
    buttons.get(0).setBounds(112, 120, 129, 41);
    buttons.get(1).setBounds(144, 24, 57, 65);
    buttons.get(2).setBounds(40, 136, 57, 97);
    buttons.get(3).setBounds(216, 64, 129, 49);
    buttons.get(4).setBounds(272, 128, 57, 97);
    buttons.get(5).setBounds(272, 128, 57, 97);
    buttons.get(6).setBounds(168, 184, 81, 49);
    
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
  }

  public static void main(String[] args) {
    AbstractMiniGame reflKey = new Hammer(0);
    reflKey.initialisieren();
    reflKey.setVisible(true);
  } // end of main

  private void buttons_ActionPerformed(ActionEvent evt) {
    int btnNummer = Integer.parseInt(evt.getActionCommand());
    
    int hTmp = Integer.parseInt(buttons.get(btnNummer).getText());
    
    hTmp++;
    buttons.get(btnNummer).setText(""+hTmp);
    
    if(hTmp == 5) {
      buttons.get(btnNummer).setVisible(false);
      buttons.get(btnNummer).setText("0");
      kill--;
      win++;
    }
  }

  private void btnStart_ActionPerformed(ActionEvent evt) {
    // wenn das Spiel gestartet wurde, soll es nicht nochmal gestartet werden
    btnStart.setEnabled(false);
    
    tm1.setInitialDelay(0);
    tm1.start();
  }
  
  public void initialisieren() {
    // den Startbutton wieder klickbar machen
    btnStart.setEnabled(true);
    
    // die Buttons und die Zähler zurücksetzen
    for(int i = 0; i < buttons.size(); i++) {
      buttons.get(i).setText("0");
      buttons.get(i).setVisible(false);
    }
    
    // zurück auf Start :)
    versuche = 0;
    kill = 0;
    win = 0;
    fertig = false;
    erfolg = false;
  }
  
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
}
