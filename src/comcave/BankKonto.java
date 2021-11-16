package comcave;

public class BankKonto {
    private String bank;
    private String iban;
    private String bic;

    public BankKonto(){

    }

    public BankKonto(String bank, String iban, String bic) {
        this.bank = bank;
        this.iban = iban;
        this.bic = bic;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getBank() {
        return bank;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }
}
