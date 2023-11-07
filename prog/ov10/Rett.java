package prog.ov10;

public class Rett {
    public final String navn;
    public String type;
    public int pris;
    public String oppskrift;

    public Rett(String navn, String type, int pris, String oppskrift) {
        this.navn = navn;
        this.type = type;
        this.pris = pris;
        this.oppskrift = oppskrift;
    }

    public String toString() {
        return navn + " " + type + " " + pris + " " + oppskrift;
    }
}
