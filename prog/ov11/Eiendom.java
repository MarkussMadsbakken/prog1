package prog.ov11;

/**
 * En klasse som representerer en eiendom
 */

public class Eiendom {
    private int kommunenummer;
    private String kommunenavn;
    private long gardsnummer;
    private long bruksnummer;
    private String bruksnavn;
    private double areal;
    private String eier;

    /**
     * Konstruktør for Eiendom
     * 
     * @param kommunenummer
     * @param kommunenavn
     * @param gardsnummer
     * @param bruksnummer
     * @param bruksnavn
     * @param areal
     * @param eier
     */

    public Eiendom(int kommunenummer, String kommunenavn, long gardsnummer, long bruksnummer, String bruksnavn,
            double areal, String eier) {
        this.kommunenummer = kommunenummer;
        this.kommunenavn = kommunenavn;
        this.gardsnummer = gardsnummer;
        this.bruksnummer = bruksnummer;
        this.bruksnavn = bruksnavn;
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Konstruktør for Eiendom uten bruksnavn
     * 
     * @param kommunenummer
     * @param kommunenavn
     * @param gardsnummer
     * @param bruksnummer
     * @param areal
     * @param eier
     */

    public Eiendom(int kommunenummer, String kommunenavn, long gardsnummer, long bruksnummer, double areal,
            String eier) {
        this.kommunenummer = kommunenummer;
        this.kommunenavn = kommunenavn;
        this.gardsnummer = gardsnummer;
        this.bruksnummer = bruksnummer;
        this.bruksnavn = "";
        this.areal = areal;
        this.eier = eier;
    }

    /**
     * Få id-en til eiendommen
     * 
     * @return komnr-gnr/brn
     */

    public String getId() {
        return kommunenummer + "-" + gardsnummer + "/" + bruksnummer;
    }

    /**
     * Få en String-representasjon av eiendommen
     * 
     * @return String
     */

    public String toString() {
        return getId() + " " + kommunenavn + " " + bruksnavn + " " + areal + " " + eier;
    }

    public int getKommunenummer() {
        return kommunenummer;
    }

    public void setKommunenummer(int kommunenummer) {
        this.kommunenummer = kommunenummer;
    }

    public String getKommunenavn() {
        return kommunenavn;
    }

    public void setKommunenavn(String kommunenavn) {
        this.kommunenavn = kommunenavn;
    }

    public long getGardsnummer() {
        return gardsnummer;
    }

    public void setGardsnummer(long gardsnummer) {
        this.gardsnummer = gardsnummer;
    }

    public long getBruksnummer() {
        return bruksnummer;
    }

    public void setBruksnummer(long bruksnummer) {
        this.bruksnummer = bruksnummer;
    }

    public String getBruksnavn() {
        return bruksnavn;
    }

    public void setBruksnavn(String bruksnavn) {
        this.bruksnavn = bruksnavn;
    }

    public Double getAreal() {
        return areal;
    }

    public void setAreal(int areal) {
        this.areal = areal;
    }

    public String getEier() {
        return eier;
    }

    public void setEier(String eier) {
        this.eier = eier;
    }

}
