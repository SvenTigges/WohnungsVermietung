package comcave;

import javax.swing.*;
import java.util.ArrayList;

public class ErfassenWohnungGUI extends JFrame {

    JLabel lblStockwerke;
    JLabel lblBemerkung;
    JLabel lblAnzRaeume;
    JLabel lblWohnflaeche;
    JLabel lblMiete;
    JLabel lblNebenkosten;
    JLabel lblAnschrift;


    JTextField tfStockwerk;
    JTextArea taBemerkung;
    JComboBox cbAnzahlRaeume;
    JTextField tfWohnflaeche;
    JTextField tfMiete;
    JTextField tfNebenkosten;
    JButton btnSpeichern;
    JComboBox cbAnschrift;
    ArrayList<Integer> anschristIds;

    private ErfassungWohnungListner listener;

    //SUB-Formular
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


    public ErfassenWohnungGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,800);
        setLayout(null);

        tfStockwerk = new JTextField();
        taBemerkung = new JTextArea();
        cbAnzahlRaeume = new JComboBox();
        tfWohnflaeche = new JTextField();
        tfMiete = new JTextField();
        tfNebenkosten = new JTextField();
        cbAnschrift = new JComboBox();
        btnSpeichern = new JButton("Speichern");

        lblStockwerke = new JLabel("Stockwerke");
        lblBemerkung = new JLabel("Bemerkung");
        lblAnzRaeume = new JLabel("Anzahl Räume");
        lblWohnflaeche = new JLabel("Wohnfläche");
        lblMiete = new JLabel("Miete");
        lblNebenkosten = new JLabel("Nebenkosten");
        lblAnschrift = new JLabel("Anschrift");

        lblMiete.setBounds(20,20,100,25);
        lblNebenkosten.setBounds(20, 55,100,25);
        lblWohnflaeche.setBounds(20,90,100,25);
        lblAnzRaeume.setBounds(20,125,100,25);
        lblStockwerke.setBounds(20,160,100,25);
        lblBemerkung.setBounds(20,195,100,25);
        lblAnschrift.setBounds(20,305,100,25);

        tfMiete.setBounds(150,20,100,25);
        tfNebenkosten.setBounds(150, 55,100,25);
        tfWohnflaeche.setBounds(150,90,100,25);
        cbAnzahlRaeume.setBounds(150,125,100,25);
        tfStockwerk.setBounds(150,160,100,25);
        taBemerkung.setBounds(150,195,400,100);
        btnSpeichern.setBounds(150,340,100,25);
        cbAnschrift.setBounds(150,305,400,25);

        add(tfMiete);
        add(tfNebenkosten);
        add(tfStockwerk);
        add(taBemerkung);
        add(cbAnzahlRaeume);
        add(tfWohnflaeche);
        add(tfNebenkosten);
        add(btnSpeichern);
        add(lblMiete);
        add(lblNebenkosten);
        add(lblWohnflaeche);
        add(lblAnzRaeume);
        add(lblStockwerke);
        add(lblBemerkung);
        add(lblAnschrift);
        add(cbAnschrift);

        //SUB-Formular
        btnAddAnschrift = new JButton("+");
        lblStrasse = new JLabel("Strasse");
        lblHausnr = new JLabel("Hausnr.");
        lblPlz = new JLabel("PLZ");
        lblOrt = new JLabel("Ort");
        tfStrasse = new JTextField();
        tfHausnr = new JTextField();
        tfHausnr = new JTextField();
        tfPlz = new JTextField();
        tfOrt = new JTextField();
        btnAnschriftSpeichern = new JButton("speicher");

        add(btnAnschriftSpeichern);
        add(lblStrasse);
        add(lblHausnr);
        add(lblPlz);
        add(lblOrt);
        add(tfStrasse);
        add(tfHausnr);
        add(tfPlz);
        add(tfOrt);
        add(btnAddAnschrift);


        btnAddAnschrift.setBounds(560,305,50,25);
        lblStrasse.setBounds(620,305,100,25);
        tfStrasse.setBounds(720,305,100,25);
        lblHausnr.setBounds(620,340,100,25);
        tfHausnr.setBounds(720,340,50,25);
        lblPlz.setBounds(620,375,100,25);
        tfPlz.setBounds(720,375,100,25);
        lblOrt.setBounds(650,410,100,25);
        tfOrt.setBounds(720,410,100,25);
        btnAnschriftSpeichern.setBounds(720,445,100,25);

        lblStrasse.setVisible(false);
        lblHausnr.setVisible(false);
        lblPlz.setVisible(false);
        lblOrt.setVisible(false);
        tfStrasse.setVisible(false);
        tfHausnr.setVisible(false);
        tfPlz.setVisible(false);
        tfOrt.setVisible(false);
        btnAnschriftSpeichern.setVisible(false);

//end Subformular-------------------------

        listener = new ErfassungWohnungListner(this);
        btnSpeichern.addActionListener(listener);

        btnAddAnschrift.addActionListener(listener);
        btnAnschriftSpeichern.addActionListener(listener);

        listener.getAnschriftenListe();
        for(int i = 1; i <= 7; i++) {
            cbAnzahlRaeume.addItem(i + "");
        }
    }

}
