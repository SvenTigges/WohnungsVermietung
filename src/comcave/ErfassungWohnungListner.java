package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ErfassungWohnungListner implements ActionListener {

    ErfassenWohnungGUI window;
    Datenbank datenbank;

    public ErfassungWohnungListner(ErfassenWohnungGUI erfassenWohnungGUI) {
        window = erfassenWohnungGUI;
        datenbank = new Datenbank();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals((window.btnSpeichern))){
            //Wohnungspeichern DB
            datenbank.wohnungSpeichern(null);
        }else if(e.getSource().equals(window.btnAddAnschrift)){
            subFormularSichtbar(true);
        }else if (e.getSource().equals(window.btnAnschriftSpeichern)){
            subFormularSichtbar(false);
            //Anschrift in Datenbank speichern
            Anschrift anschrift = new Anschrift(window.tfStrasse.getText(), window.tfHausnr.getText(), window.tfPlz.getText(), window.tfOrt.getText());
            datenbank.anschriftSpeichern(anschrift);
            getAnschriftenListe();

            // Anschrift Felder leeren
            window.tfStrasse.setText("");
            window.tfHausnr.setText("");
            window.tfPlz.setText("");
            window.tfOrt.setText("");
        }
    }

    public void getAnschriftenListe(){
        ArrayList<Anschrift> anschriften = datenbank.getAnschriften();
        window.cbAnschrift.removeAllItems();
        for(Anschrift anschrift : anschriften){
            String daten = "";
            daten += anschrift.getStrasse() + " " +anschrift.getHausnr() + " " +anschrift.getPlz() +" "+ anschrift.getHausnr();
            window.cbAnschrift.addItem(daten);
            window.anschritIds.add(anschrift.getId());
        }
    }
    public void subFormularSichtbar(boolean sichtbar){
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
}
