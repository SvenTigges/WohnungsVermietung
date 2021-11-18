package comcave;

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
	
	public void fillJTable() {
		System.out.println(window.status.getSelectedIndex() );
		ArrayList<Wohnung> wohnungen = datenbank.getWohnungen( window.status.getSelectedIndex() );
		
		// Vector für JTable Spaltenüberschriften
		Vector<String> kopf = new Vector<String>();
		kopf.add("Strasse/Nr");
		kopf.add("PLZ");
		kopf.add("Ort");
		kopf.add("Miete");
		kopf.add("Nebenkosten");
		kopf.add("Wohnfläche");
		kopf.add("Räume");
		kopf.add("Stockwerk");
		kopf.add("Bemerkungen");
		
		// Vector für Daten
		Vector<Vector<String>> daten = new Vector<Vector<String>>();
		for(Wohnung wohnung : wohnungen) {
			Vector<String> zeile = new Vector<String>();
			daten.add(zeile);
			Anschrift anschrift = wohnung.getAnschrift();
			zeile.add(anschrift.getStrasse() + " " + anschrift.getHausnr());
			zeile.add(anschrift.getPlz());
			zeile.add(anschrift.getOrt());
			zeile.add(wohnung.getMiete() + "");
			zeile.add(wohnung.getNebenkosten() + "");
			zeile.add(wohnung.getWohnflaeche() + "");
			zeile.add(wohnung.getAnzRaeume() + "");
			zeile.add(wohnung.getStockwerk());
			zeile.add(wohnung.getBemerkungen());
			// Double.toString(9.99) / Integer.toString(123)
			// String.valueOf()
			
		}
		
		
		window.model.setDataVector(daten, kopf);
		// window.model = new DefaultTableModel(daten, kopf);
		// window.tabelle.setModel(window.model);
	}

}
