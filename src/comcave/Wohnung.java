package comcave;

public class Wohnung {
    private Anschrift anschrift;
    private String stockwerk;
    private String bemerkungen;
    private int anzRaeume;
    private double wohnflaeche;
    private double miete;
    private double nebenkosten;
    private boolean vermietet;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Wohnung() {

    }

    public Wohnung(Anschrift anschrift, String stockwerk, String bemerkungen, int anzRaeume, double wohnflaeche,
                   double miete, double nebenkosten, boolean vermietet) {
        super();
        this.anschrift = anschrift;
        this.stockwerk = stockwerk;
        this.bemerkungen = bemerkungen;
        this.anzRaeume = anzRaeume;
        this.wohnflaeche = wohnflaeche;
        this.miete = miete;
        this.nebenkosten = nebenkosten;
        this.vermietet = vermietet;
    }

    public Anschrift getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(Anschrift anschrift) {
        this.anschrift = anschrift;
    }

    public String getStockwerk() {
        return stockwerk;
    }

    public void setStockwerk(String stockwerk) {
        this.stockwerk = stockwerk;
    }

    public String getBemerkungen() {
        return bemerkungen;
    }

    public void setBemerkungen(String bemerkungen) {
        this.bemerkungen = bemerkungen;
    }

    public int getAnzRaeume() {
        return anzRaeume;
    }

    public void setAnzRaeume(int anzRaeume) {
        this.anzRaeume = anzRaeume;
    }

    public double getWohnflaeche() {
        return wohnflaeche;
    }

    public void setWohnflaeche(double wohnflaeche) {
        this.wohnflaeche = wohnflaeche;
    }

    public double getMiete() {
        return miete;
    }

    public void setMiete(double miete) {
        this.miete = miete;
    }

    public double getNebenkosten() {
        return nebenkosten;
    }

    public void setNebenkosten(double nebenkosten) {
        this.nebenkosten = nebenkosten;
    }

    public boolean isVermietet() {
        return vermietet;
    }

    public void setVermietet(boolean vermietet) {
        this.vermietet = vermietet;
    }


}