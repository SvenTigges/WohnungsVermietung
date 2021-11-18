package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainListener implements ActionListener{

	MainGUI window;
	Datenbank datenbank;
	
	public MainListener(MainGUI mainGUI) {
		window = mainGUI;
		datenbank = new Datenbank();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals( window.menuItemWohnungNeu )) {
			ErfassungWohnungGUI.getInstance().setVisible(true);
		}else if(e.getSource().equals( window.menuItemWohnungenAnzeigen )) {
			AnzeigeWohnungenGUI.getInstance().setVisible(true);
		}else if(e.getSource().equals( window.menuItemMieterNeu )) {
			ErfassungMieterGUI.getInstance().setVisible(true);
		}else if(e.getSource().equals( window.menuItemMieterAnzeigen )) {
			AnzeigeMieterGUI.getInstance().setVisible(true);
		}else if(e.getSource().equals( window.menuItemMieterAnzeigen )) {
			datenbank.bankdatenImport();
		}
	}

}
