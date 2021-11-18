package comcave;

public class Mieter {
	private String vorname;
	private String nachname;
	private BankKonto bankKonto;
	
	public Mieter() {
		// TODO Auto-generated constructor stub
	}

	public Mieter(String vorname, String nachname, BankKonto bankKonto) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.bankKonto = bankKonto;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public BankKonto getBankKonto() {
		return bankKonto;
	}

	public void setBankKonto(BankKonto bankKonto) {
		this.bankKonto = bankKonto;
	}
	
	
	
}
