package comcave;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class AnzeigeWohnungenListener implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("test");
    }
}
