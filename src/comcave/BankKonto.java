package comcave;

public class BankKonto {
	private String iban;
	private String bic;
	private String bank;
	
	public BankKonto() {
		// TODO Auto-generated constructor stub
	}

	public BankKonto(String iban, String bic, String bank) {
		super();
		this.iban = iban;
		this.bic = bic;
		this.bank = bank;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
}
