package prog.ov10;

public class Meny {
    private Rett[] retter;

    public Meny(Rett[] retter) {
        this.retter = retter;
    }

    public int getTotalPris(){
        int total = 0;
        for (Rett rett : retter) {
            total += rett.pris;
        }
        return total;
    }
}
