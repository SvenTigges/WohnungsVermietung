package comcave;

public class Anschrift {
    private String strasse;
    private String hausnr;
    private String plz;
    private String ort;



    public Anschrift() {
    }

    public Anschrift(String strasse, String hausnr, String plz, String ort) {
        super();
        this.strasse = strasse;
        this.hausnr = hausnr;
        this.plz = plz;
        this.ort = ort;
    }


    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnr() {
        return hausnr;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }
}
