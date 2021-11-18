package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

public class ErfassungMieterListener implements ActionListener{

	ErfassungMieterGUI window;
	Datenbank datenbank;
	
	public ErfassungMieterListener(ErfassungMieterGUI erfassungMieterGUI) {
		window = erfassungMieterGUI;
		datenbank = new Datenbank();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String vorname = window.tfVorname.getText();
		String nachname = window.tfNachname.getText();
		String iban = window.tfIban.getText();
		String bic = window.tfBic.getText();
		String bank = window.tfBank.getText();
		String[] datum = window.tfMietBeginn.getText().split("\\.");
		Date beginn = new GregorianCalendar(
				Integer.parseInt(datum[2]), 
				Integer.parseInt(datum[1]) - 1, 
				Integer.parseInt(datum[0])
		).getTime();
		int wohnung_id = Integer.parseInt(window.tfWohnungID.getText());
		
		Mieter mieter = new Mieter();
		mieter.setVorname(vorname);
		mieter.setNachname(nachname);
		BankKonto bankKonto = new BankKonto();
		mieter.setBankKonto(bankKonto);
		bankKonto.setIban(iban);
		bankKonto.setBic(bic);
		bankKonto.setBank(bank);		
		
		Wohnung wohnung = new Wohnung();
		wohnung.setId(wohnung_id);
		
		Vermietung vermietung = new Vermietung();
		vermietung.setBeginn(beginn);
		vermietung.setMieter(mieter);
		vermietung.setWohnung(wohnung);
		
		datenbank.mieterSpeichern(vermietung);
		
		
	}

	
	
}
