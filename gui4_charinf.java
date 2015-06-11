* Beschreibung
  *
  * @version 1.0 vom 11.06.2015
  * @author 
  */

public class gui4_charinf extends JFrame {
  // Anfang Attribute
  private JTextArea txtaCharname = new JTextArea("");
    private JScrollPane txtaCharnameScrollPane = new JScrollPane(txtaCharname);
  private JTextArea txtaKurzbeschr = new JTextArea("");
    private JScrollPane txtaKurzbeschrScrollPane = new JScrollPane(txtaKurzbeschr);
  private JTextArea txtaAttribute = new JTextArea("");
    private JScrollPane txtaAttributeScrollPane = new JScrollPane(txtaAttribute);
  // Ende Attribute
  
  public gui4_charinf(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 487; 
    int frameHeight = 297;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    txtaCharnameScrollPane.setBounds(24, 24, 129, 49);
    txtaCharname.setBackground(Color.BLACK);
    txtaCharname.setEditable(false);
    txtaCharname.setText("\n Charaktername");
    txtaCharname.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    txtaCharname.setForeground(Color.GREEN);
    cp.add(txtaCharnameScrollPane);
    txtaKurzbeschrScrollPane.setBounds(24, 88, 129, 145);
    txtaKurzbeschr.setEditable(false);
    txtaKurzbeschr.setBackground(Color.BLACK);
    txtaKurzbeschr.setText("Kurzbeschr.");
    txtaKurzbeschr.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    txtaKurzbeschr.setForeground(Color.GREEN);
    cp.add(txtaKurzbeschrScrollPane);
    txtaAttributeScrollPane.setBounds(184, 24, 265, 209);
    txtaAttribute.setEditable(false);
    txtaAttribute.setBackground(Color.BLACK);
    txtaAttribute.setText(" - Money:\n - Serverleistung:\n - Skill:");
    txtaAttribute.setFont(new Font("Fixedsys", Font.PLAIN, 12));
    txtaAttribute.setForeground(Color.GREEN);
    cp.add(txtaAttributeScrollPane);
    cp.setBackground(Color.BLACK);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public gui4_charinf
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new gui4_charinf("gui4_charinf");
  } // end of main
  
  // Ende Methoden
} // end of class gui4_charinf
