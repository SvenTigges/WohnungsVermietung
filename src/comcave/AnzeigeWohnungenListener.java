package comcave;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

public class AnzeigeWohnungenListener implements ItemListener{

    AnzeigeWohnungenGUI window;
    Datenbank datenbank;

    public AnzeigeWohnungenListener(AnzeigeWohnungenGUI anzeigeWohnungenGUI) {
        window = anzeigeWohnungenGUI;
        datenbank = new Datenbank();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    fillJTable();
    }
    public void fillJTable(){
        ArrayList<Wohnung> wohnungen = datenbank.getWohnungen(window.status.getSelectedIndex());

        Vector<String> kopf = new Vector<String>();
        kopf.add("Strasse/Nr");
        kopf.add("PLZ");
        kopf.add("Ort");
        kopf.add("Miete");
        kopf.add("Nebenkosten");
        kopf.add("Wohnflaeche");
        kopf.add("Räume");
        kopf.add("Stockwerk");
        kopf.add("Bemerkungen");


        Vector<Vector<String>> daten = new Vector<Vector<String>>();
        for (Wohnung wohnung : wohnungen) {
            Vector<String> zeile = new Vector<String>();
            daten.add(zeile);
            Anschrift anschrift = wohnung.getAnschrift();

            zeile.add(anschrift.getStrasse() + " " + anschrift.getHausnr());
            zeile.add(anschrift.getPlz());
            zeile.add(anschrift.getOrt());
            zeile.add(String.valueOf(wohnung.getMiete()));
            zeile.add(String.valueOf(wohnung.getNebenkosten()));
            zeile.add(String.valueOf(wohnung.getWohnflaeche()));
            zeile.add(String.valueOf(wohnung.getAnzRaeume()));
            zeile.add(wohnung.getStockwerk());
            zeile.add(wohnung.getBemerkungen());
        }
        window.model.setDataVector(daten, kopf);
        //window.model = new DefaultTableModel(daten, kopf);
    }

}

