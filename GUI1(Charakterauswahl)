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

public class charakterauswahl extends JFrame {
  // Anfang Attribute
  private JRadioButton rbtnAuswahl1 = new JRadioButton();
  private JRadioButton rbtnAuswahl2 = new JRadioButton();
  private JRadioButton rbtnAuswahl3 = new JRadioButton();
  private JPanel jPanel1 = new JPanel(null, true);
    private JButton jButton1 = new JButton();
    private JList lstCharinf = new JList();
      private DefaultListModel lstCharinfModel = new DefaultListModel();
      private JScrollPane lstCharinfScrollPane = new JScrollPane(lstCharinf);
    private JTextField jTextField2 = new JTextField();
  private JTextField jTextField1 = new JTextField();
  // Ende Attribute
  
  public charakterauswahl(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 645; 
    int frameHeight = 452;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    rbtnAuswahl1.setBounds(24, 48, 233, 65);
    rbtnAuswahl1.setText(" - xXgr0nkhcrafter01Xx");
    rbtnAuswahl1.setOpaque(false);
    rbtnAuswahl1.setForeground(Color.GREEN);
    rbtnAuswahl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    rbtnAuswahl1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    cp.add(rbtnAuswahl1);
    rbtnAuswahl2.setBounds(24, 136, 233, 65);
    rbtnAuswahl2.setText(" - Herr von Frass");
    rbtnAuswahl2.setOpaque(false);
    rbtnAuswahl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    rbtnAuswahl2.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    rbtnAuswahl2.setForeground(Color.GREEN);
    cp.add(rbtnAuswahl2);
    rbtnAuswahl3.setBounds(24, 224, 233, 65);
    rbtnAuswahl3.setText(" - Mister X");
    rbtnAuswahl3.setOpaque(false);
    rbtnAuswahl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    rbtnAuswahl3.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    rbtnAuswahl3.setForeground(Color.GREEN);
    cp.add(rbtnAuswahl3);
    jPanel1.setBounds(312, 8, 265, 393);
    jPanel1.setOpaque(true);
    jPanel1.setBackground(Color.BLACK);
    jPanel1.setBorder(new javax.swing.border.LineBorder(Color.GREEN));
    cp.add(jPanel1);
    jButton1.setBounds(136, 352, 113, 25);
    jButton1.setText("confirm");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jButton1.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    jButton1.setForeground(Color.GREEN);
    jButton1.setBackground(Color.BLACK);
    jPanel1.add(jButton1);
    lstCharinf.setModel(lstCharinfModel);
    lstCharinfScrollPane.setBounds(24, 136, 217, 209);
    lstCharinf.setToolTipText("");
    lstCharinf.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    lstCharinf.setForeground(Color.GREEN);
    lstCharinf.setBackground(Color.BLACK);
    lstCharinf.setSelectionBackground(Color.BLACK);
    lstCharinf.setSelectionForeground(Color.BLACK);
    lstCharinfScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    lstCharinfModel.addElement("----------------------------------------------");
    lstCharinfModel.addElement("- Money :");
    lstCharinfModel.addElement("----------------------------------------------");
    lstCharinfModel.addElement("- Serverleistung :");
    lstCharinfModel.addElement("----------------------------------------------");
    lstCharinfModel.addElement("- Skill :");
    lstCharinfModel.addElement("----------------------------------------------");
    lstCharinfModel.addElement("- Matekonsum :");
    lstCharinfModel.addElement("----------------------------------------------");
    lstCharinfModel.addElement("- Schlafbedarf : ");
    lstCharinfModel.addElement("----------------------------------------------");
    jPanel1.add(lstCharinfScrollPane);
    cp.setBackground(Color.BLACK);
    jTextField1.setBounds(336, 40, 113, 49);
    jTextField1.setText("  Mister X");
    jTextField1.setFont(new Font("Fixedsys", Font.PLAIN, 16));
    jTextField1.setForeground(Color.GREEN);
    jTextField1.setBackground(Color.BLACK);

    jTextField1.setEditable(false);
    cp.add(jTextField1);
    jTextField2.setBounds(24, 96, 137, 33);
    jTextField2.setText(" Charakterwerte");
    jTextField2.setFont(new Font("Fixedsys", Font.PLAIN, 14));
    jTextField2.setForeground(Color.GREEN);

    jTextField2.setEditable(false);
    jTextField2.setBackground(Color.BLACK);
    jPanel1.add(jTextField2);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public charakterauswahl
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new charakterauswahl("charakterauswahl");
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class charakterauswahl
