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

public class gui2_hub extends JFrame {
  // Anfang Attribute
    private DefaultComboBoxModel jComboBox1Model = new DefaultComboBoxModel();
  private JButton btnCharinfo = new JButton();
  private JButton btnBasis = new JButton();
  private JList lstHauptmiss = new JList();
    private DefaultListModel lstHauptmissModel = new DefaultListModel();
    private JScrollPane lstHauptmissScrollPane = new JScrollPane(lstHauptmiss);
  private JList lstNebenmiss = new JList();
    private DefaultListModel lstNebenmissModel = new DefaultListModel();
    private JScrollPane lstNebenmissScrollPane = new JScrollPane(lstNebenmiss);
  // Ende Attribute
  
  public gui2_hub(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 725; 
    int frameHeight = 230;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    btnCharinfo.setBounds(376, 24, 297, 57);
    btnCharinfo.setText("Charakterinfo");
    btnCharinfo.setMargin(new Insets(2, 2, 2, 2));
    btnCharinfo.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnCharinfo_ActionPerformed(evt);
      }
    });
    btnCharinfo.setBackground(Color.BLACK);
    btnCharinfo.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    btnCharinfo.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    btnCharinfo.setForeground(Color.GREEN);
    cp.add(btnCharinfo);
    btnBasis.setBounds(376, 104, 297, 57);
    btnBasis.setText("Basis");
    btnBasis.setMargin(new Insets(2, 2, 2, 2));
    btnBasis.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btnBasis_ActionPerformed(evt);
      }
    });
    btnBasis.setBackground(Color.BLACK);
    btnBasis.setBorder(new javax.swing.border.LineBorder(Color.GREEN, 3));
    btnBasis.setForeground(Color.GREEN);
    btnBasis.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    cp.add(btnBasis);
    setTitle("HUB");
    cp.setBackground(Color.BLACK);
    lstHauptmiss.setModel(lstHauptmissModel);
    lstHauptmissScrollPane.setBounds(24, 24, 337, 57);
    lstHauptmissModel.addElement(" - NSA Server übernehmen");
    lstHauptmissModel.addElement(" - Merkels Nacktfotos vernichten");
    lstHauptmissModel.addElement("");
    lstHauptmiss.setCursor(new Cursor(Cursor.HAND_CURSOR));
    lstHauptmiss.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    lstHauptmiss.setForeground(Color.GREEN);
    lstHauptmiss.setBackground(Color.BLACK);
    lstHauptmiss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cp.add(lstHauptmissScrollPane);
    lstNebenmiss.setModel(lstNebenmissModel);
    lstNebenmissScrollPane.setBounds(24, 104, 337, 57);
    lstNebenmissModel.addElement(" - Pizza liefern lassen");
    lstNebenmissModel.addElement(" - Fahndungsinformationen manipulieren");
    lstNebenmissModel.addElement(" - PornHub Premium Account hacken");
    lstNebenmissModel.addElement(" - Matelieferungen umlenken");
    lstNebenmiss.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    lstNebenmiss.setForeground(Color.GREEN);
    lstNebenmiss.setBackground(Color.BLACK);
    lstNebenmiss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    cp.add(lstNebenmissScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public gui2_hub
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new gui2_hub("gui2_hub");
  } // end of main
  
  public void btnCharinfo_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of btnCharinfo_ActionPerformed

  public void btnBasis_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of btnBasis_ActionPerformed

  // Ende Methoden
} // end of class gui2_hub
