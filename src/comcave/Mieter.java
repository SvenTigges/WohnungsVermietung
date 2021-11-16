package comcave;

public class Mieter {
    private String vorname;
    private String nachname;
    private BankKonto bankKonto;

    public Mieter(){

    }

    public Mieter(String vorname, String nachname, BankKonto bankKonto) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.bankKonto = bankKonto;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setBankKonto(BankKonto bankKonto) {
        this.bankKonto = bankKonto;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public BankKonto getBankKonto() {
        return bankKonto;
    }
}


