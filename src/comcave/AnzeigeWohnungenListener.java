package comcave;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnzeigeWohnungenListener implements ItemListener{

    AnzeigeWohnungenGUI window;

    public AnzeigeWohnungenListener(AnzeigeWohnungenGUI anzeigeWohnungenGUI) {
        window = anzeigeWohnungenGUI;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println( window.status.getSelectedIndex() );

    }

}

