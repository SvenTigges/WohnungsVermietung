package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErfassungMieterListener implements ActionListener {
    ErfassungMieterGUI window;
    Datenbank datenbank;

    public ErfassungMieterListener(ErfassungMieterGUI erfassungMieterGUI) {
        window = erfassungMieterGUI;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Mieter mieter;
        BankKonto bankkoto;
        Wohnung wohung;
    }
}
