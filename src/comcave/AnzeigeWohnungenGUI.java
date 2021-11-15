package comcave;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class AnzeigeWohnungenGUI extends JFrame {

    JComboBox status;
    JScrollPane scrollpane;
    JTable tabelle;
    DefaultTableModel model;
    AnzeigeWohnungenListener listener;

    public AnzeigeWohnungenGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(null);
        setTitle("Wohnungsliste");

        status = new JComboBox();
        model = new DefaultTableModel();
        tabelle = new JTable(model);
        scrollpane = new JScrollPane(tabelle);

        add(status);
        add(scrollpane);

        status.setBounds(20, 20, 150, 25);
        scrollpane.setBounds(20, 55, 950, 700);

        status.addItem("nicht vermietet");
        status.addItem("vermietet");

        listener = new AnzeigeWohnungenListener(this);
        status.addItemListener(listener);

        // Datenschreiben erzeugen
        ArrayList<Wohnung> wohnungsListe = Datenbank.getWohnungen();
        // Vector für Überschrift
            Vector<String> kopf = new Vector<String>();
            kopf.add("Strasse");
            kopf.add("hausnr");
            kopf.add("plz");
            kopf.add("ort");
            kopf.add("Stockwerk");
            kopf.add("Bemerkungen");
            kopf.add("AnzhalRäume");
            kopf.add("Wohnflaeche");
            kopf.add("Miete");
            kopf.add("Nebenkosten");
            kopf.add("id");

            Vector<Vector<String>> daten = new Vector<Vector<String>>();

            for (Wohnung wohnung : wohnungsListe) {
                Vector<String> zeile = new Vector<String>();

                zeile.add(wohnung.getStockwerk());
                zeile.add(wohnung.getBemerkungen());
                zeile.add(String.valueOf(wohnung.getAnzRaeume()));
                zeile.add(String.valueOf(wohnung.getWohnflaeche()));
                zeile.add(String.valueOf(wohnung.getMiete()));
                zeile.add(String.valueOf(wohnung.getNebenkosten()));
                zeile.add(String.valueOf(wohnung.getId()));

                Anschrift anschrift = new Anschrift();


                zeile.add(anschrift.getStrasse());
                zeile.add(anschrift.getHausnr());
                zeile.add(anschrift.getPlz());
                zeile.add(anschrift.getPlz());


            }
            model = new DefaultTableModel(daten, kopf);

        }

    }


