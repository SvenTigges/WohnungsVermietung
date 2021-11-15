package comcave;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnzeigeWohnungenListener implements ItemListener{

    AnzeigeWohnungenGUI window;
    Datenbank datenbank;
    public AnzeigeWohnungenListener(AnzeigeWohnungenGUI anzeigeWohnungenGUI) {
        window = anzeigeWohnungenGUI;
        datenbank = new Datenbank();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {


    }

}

