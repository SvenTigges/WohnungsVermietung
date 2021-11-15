package comcave;

public class Wohnung {

    private Anschrift anschrift;
    private String stockwerk;
    private String bemerkung;
    private int anzRaeume;
    private double wohnflaeche;
    private double miete;
    private double nebenkosten;
    private boolean vermietet;

    public Wohnung(){
    }

    public Wohnung(Anschrift anschrift, String stockwerk, String bemerkung, int anzRaeume, double wohnflaeche, double miete, double nebenkosten, boolean vermietet) {
        super();
        this.anschrift = anschrift;
        this.stockwerk = stockwerk;
        this.bemerkung = bemerkung;
        this.anzRaeume = anzRaeume;
        this.wohnflaeche = wohnflaeche;
        this.miete = miete;
        this.nebenkosten = nebenkosten;
        this.vermietet = vermietet;
    }

    public void setAnschrift(Anschrift anschrift) {
        this.anschrift = anschrift;
    }

    public void setStockwerk(String stockwerk) {
        this.stockwerk = stockwerk;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public void setAnzRaeume(int anzRaeume) {
        this.anzRaeume = anzRaeume;
    }

    public void setWohnflaeche(double wohnflaeche) {
        this.wohnflaeche = wohnflaeche;
    }

    public void setMiete(double miete) {
        this.miete = miete;
    }

    public void setNebenkosten(double nebenkosten) {
        this.nebenkosten = nebenkosten;
    }

    public void setVermietet(boolean vermietet) {
        this.vermietet = vermietet;
    }

    public Anschrift getAnschrift() {
        return anschrift;
    }

    public String getStockwerk() {
        return stockwerk;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public int getAnzRaeume() {
        return anzRaeume;
    }

    public double getWohnflaeche() {
        return wohnflaeche;
    }

    public double getMiete() {
        return miete;
    }

    public double getNebenkosten() {
        return nebenkosten;
    }

    public boolean isVermietet() {
        return vermietet;
    }
}
