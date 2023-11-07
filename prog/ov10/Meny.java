package prog.ov10;

public class Meny {
    private Rett[] retter;
    private String navn;

    public Meny(Rett[] retter, String navn) {
        this.retter = retter;
        this.navn = navn;
    }

    public Meny(Rett[] retter) {
        this.retter = retter;
        this.navn = "";
    }

    public int getTotalPris() {
        int total = 0;
        for (Rett rett : retter) {
            total += rett.pris;
        }
        return total;
    }

    public String toString() {
        String s = navn + ":" + "\n";
        for (Rett rett : retter) {
            s += rett + "\n";
        }
        s += "Totalpris: " + getTotalPris() + "\n";
        return s;
    }
}
