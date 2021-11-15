package comcave;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ErfassungWohnungGUI extends JFrame{
    JTextField tfStockwerk;
    JTextArea taBemerkungen;
    JComboBox cbAnzahlRaeume;
    JTextField tfWohnflaeche;
    JTextField tfMiete;
    JTextField tfNebenkosten;
    JComboBox cbAnschrift;
    ArrayList<Integer> anschriftIds;

    JButton btnSpeichern;

    JLabel lblStockwerk;
    JLabel lblBemerkungen;
    JLabel lblAnzahlRaeume;
    JLabel lblWohnflaeche;
    JLabel lblMiete;
    JLabel lblNebenkosten;
    JLabel lblAnschrift;

    private ErfassungWohnungListener listener;

    // Sub-Formular
    JButton btnAddAnschrift;
    JLabel lblStrasse;
    JLabel lblHausnr;
    JLabel lblPlz;
    JLabel lblOrt;
    JTextField tfStrasse;
    JTextField tfHausnr;
    JTextField tfPlz;
    JTextField tfOrt;
    JButton btnAnschriftSpeichern;


    public ErfassungWohnungGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(null);
        setTitle("Neue Wohnung erfassen");

        tfStockwerk = new JTextField();
        taBemerkungen = new JTextArea();
        cbAnzahlRaeume = new JComboBox();
        tfWohnflaeche = new JTextField();
        tfMiete = new JTextField();
        tfNebenkosten = new JTextField();
        cbAnschrift = new JComboBox();
        anschriftIds = new ArrayList<Integer>();

        btnSpeichern = new JButton("speichern");
        lblStockwerk = new JLabel("Stockwerk");
        lblBemerkungen = new JLabel("Bemerkungen");
        lblAnzahlRaeume = new JLabel("Anzahl Räume");
        lblWohnflaeche = new JLabel("Wohnfläche m2");
        lblMiete = new JLabel("Miete");
        lblNebenkosten = new JLabel("Nebenkosten");
        lblAnschrift = new JLabel("Anschrift");

        lblMiete.setBounds(20,20,100,25);
        lblNebenkosten.setBounds(20, 55,100,25);
        lblWohnflaeche.setBounds(20,90,100,25);
        lblAnzahlRaeume.setBounds(20,125,100,25);
        lblStockwerk.setBounds(20,160,100,25);
        lblBemerkungen.setBounds(20,195,100,25);
        lblAnschrift.setBounds(20,305,100,25);

        tfMiete.setBounds(150,20,100,25);
        tfNebenkosten.setBounds(150, 55,100,25);
        tfWohnflaeche.setBounds(150,90,100,25);
        cbAnzahlRaeume.setBounds(150,125,100,25);
        tfStockwerk.setBounds(150,160,100,25);
        taBemerkungen.setBounds(150,195,400, 100);
        cbAnschrift.setBounds(150,305,400,25);
        btnSpeichern.setBounds(150,340,100,25);

        add(lblMiete);
        add(lblNebenkosten);
        add(lblWohnflaeche);
        add(lblAnzahlRaeume);
        add(lblStockwerk);
        add(lblBemerkungen);
        add(lblAnschrift);
        add(tfMiete);
        add(tfNebenkosten);
        add(tfWohnflaeche);
        add(cbAnzahlRaeume);
        add(tfStockwerk);
        add(taBemerkungen);
        add(cbAnschrift);
        add(btnSpeichern);


        // Sub-Formular
        btnAddAnschrift = new JButton("+");
        lblStrasse = new JLabel("Strasse");
        lblHausnr = new JLabel("Hausnr");
        lblPlz = new JLabel("PLZ");
        lblOrt = new JLabel("Ort");
        tfStrasse = new JTextField();
        tfHausnr = new JTextField();
        tfPlz = new JTextField();
        tfOrt = new JTextField();
        btnAnschriftSpeichern = new JButton("speichern");

        add(btnAddAnschrift);
        add(lblStrasse);
        add(lblHausnr);
        add(lblPlz);
        add(lblOrt);
        add(tfStrasse);
        add(tfHausnr);
        add(tfPlz);
        add(tfOrt);
        add(btnAnschriftSpeichern);

        btnAddAnschrift.setBounds(560,305,50,25);
        lblStrasse.setBounds(620, 305, 100, 25);
        tfStrasse.setBounds(720, 305, 100, 25);
        lblHausnr.setBounds(620, 340, 100, 25);
        tfHausnr.setBounds(720, 340, 50, 25);
        lblPlz.setBounds(620, 375, 100, 25);
        tfPlz.setBounds(720, 375, 100, 25);
        lblOrt.setBounds(620, 410, 100, 25);
        tfOrt.setBounds(720, 410, 100, 25);
        btnAnschriftSpeichern.setBounds(720, 445, 100, 25);

        lblStrasse.setVisible(false);
        tfStrasse.setVisible(false);
        lblHausnr.setVisible(false);
        tfHausnr.setVisible(false);
        lblPlz.setVisible(false);
        tfPlz.setVisible(false);
        lblOrt.setVisible(false);
        tfOrt.setVisible(false);
        btnAnschriftSpeichern.setVisible(false);

        // End Subformular -----------------

        listener = new ErfassungWohnungListener(this);
        btnSpeichern.addActionListener(listener);
        btnAddAnschrift.addActionListener(listener);
        btnAnschriftSpeichern.addActionListener(listener);


        listener.getAnschriftenListe();
        for(int i = 1; i <= 7; i++)
            cbAnzahlRaeume.addItem(i + "");
        //String[] stringArray = {"1", "2", "2,5"};
        //cbAnzahlRaeume.setModel(new DefaultComboBoxModel<>(stringArray) );
    }

}
