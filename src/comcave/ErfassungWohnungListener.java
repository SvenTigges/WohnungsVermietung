package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ErfassungWohnungListener implements ActionListener{

    ErfassungWohnungGUI window;
    Datenbank datenbank;

    public ErfassungWohnungListener(ErfassungWohnungGUI erfassungWohnungGUI) {
        window = erfassungWohnungGUI;
        datenbank = new Datenbank();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(window.btnSpeichern)) {
            // Wohnung in DB speichern
            int id = window.anschriftIds.get(window.cbAnschrift.getSelectedIndex());
            Anschrift anschrift = new Anschrift();
            anschrift.setId(id);

            Wohnung wohnung = new Wohnung();
            wohnung.setMiete(Double.parseDouble( window.tfMiete.getText() ));
            wohnung.setBemerkungen( window.taBemerkungen.getText() );
            wohnung.setNebenkosten( Double.parseDouble( window.tfNebenkosten.getText() ) );
            wohnung.setStockwerk( window.tfStockwerk.getText() );
            wohnung.setWohnflaeche( Double.parseDouble( window.tfWohnflaeche.getText() ) );
            wohnung.setAnzRaeume( Integer.parseInt( window.cbAnzahlRaeume.getSelectedItem().toString() ) );
            wohnung.setAnschrift(anschrift);

            if(datenbank.wohnungSpeichern(wohnung)) {
                JOptionPane.showMessageDialog(window, "Wohnung wurde erfolgreich gespeichert");
                clearWohnungGUI();
            }


        }else if(e.getSource().equals(window.btnAddAnschrift)) {
            subFormularSichtbar(true);
        }else if(e.getSource().equals(window.btnAnschriftSpeichern)) {
            subFormularSichtbar(false);
            // Anschrift in DB speichern
            Anschrift anschrift = new Anschrift(
                    window.tfStrasse.getText(),
                    window.tfHausnr.getText(),
                    window.tfPlz.getText(),
                    window.tfOrt.getText());

            datenbank.anschriftSpeichern(anschrift);
            getAnschriftenListe();

            // Anschrift Felder leeren
            clearAnschriftGUI();
        }



    }

    public void getAnschriftenListe() {
        ArrayList<Anschrift> anschriften = datenbank.getAnschriften();
        window.cbAnschrift.removeAllItems();
        window.anschriftIds.clear();

        for(Anschrift anschrift : anschriften) {
            String daten = "";
            daten += anschrift.getStrasse() + " ";
            daten += anschrift.getHausnr() + " ";
            daten += anschrift.getPlz() + " ";
            daten += anschrift.getOrt();
            window.cbAnschrift.addItem(daten);
            window.anschriftIds.add( anschrift.getId() );
        }
    }


    public void subFormularSichtbar(boolean sichtbar) {
        window.lblStrasse.setVisible(sichtbar);
        window.tfStrasse.setVisible(sichtbar);
        window.lblHausnr.setVisible(sichtbar);
        window.tfHausnr.setVisible(sichtbar);
        window.lblPlz.setVisible(sichtbar);
        window.tfPlz.setVisible(sichtbar);
        window.lblOrt.setVisible(sichtbar);
        window.tfOrt.setVisible(sichtbar);
        window.btnAnschriftSpeichern.setVisible(sichtbar);

    }

    public void clearWohnungGUI() {

    }

    public void clearAnschriftGUI() {
        window.tfStrasse.setText("");
        window.tfHausnr.setText("");
        window.tfPlz.setText("");
        window.tfOrt.setText("");
    }

}

