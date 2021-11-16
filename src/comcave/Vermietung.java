package comcave;

import java.util.Date;

public class Vermietung {
    private  Date beginn;
    private Date ende;
    private Mieter mieter;
    private Wohnung wohnung;

    public Vermietung(){

    }

    public Vermietung(Date beginn, Date ende, Mieter mieter, Wohnung wohnung) {
        this.beginn = beginn;
        this.ende = ende;
        this.mieter = mieter;
        this.wohnung = wohnung;
    }

    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }

    public void setMieter(Mieter mieter) {
        this.mieter = mieter;
    }

    public void setWohnung(Wohnung wohnung) {
        this.wohnung = wohnung;
    }

    public Date getBeginn() {
        return beginn;
    }

    public Date getEnde() {
        return ende;
    }

    public Mieter getMieter() {
        return mieter;
    }

    public Wohnung getWohnung() {
        return wohnung;
    }
}
