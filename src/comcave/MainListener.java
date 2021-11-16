package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainListener implements ActionListener {

    MainGUI window;

    public MainListener(MainGUI mainGUI) {
        window = mainGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(window.menuItemWohnungNeu)) {
        new ErfassungWohnungGUI().setVisible(true);
    }else if(e.getSource().equals(window.menuItemWohnungenAnzeigen)){
        new AnzeigeWohnungenGUI().setVisible(true);
    }

    }
}
