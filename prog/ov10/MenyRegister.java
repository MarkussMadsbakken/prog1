package prog.ov10;

import java.util.ArrayList;

public class MenyRegister {
    private ArrayList<Rett> retter = new ArrayList<>();
    private ArrayList<Meny> menyer = new ArrayList<>();

    public void addRett(Rett rett) {
        retter.add(rett);
    }

    public Rett finnRettFraNavn(String navn) {
        for (Rett rett : retter) {
            if (rett.navn.equals(navn)) {
                return rett;
            }
        }
        return null;
    }

    public Rett[] finnRetterFraType(String type) {
        ArrayList<Rett> a = new ArrayList<>();

        for (Rett rett : retter) {
            if (rett.type.equals(type)) {
                a.add(rett);
            }
        }
        return a.toArray(new Rett[a.size()]);
    }

    public Meny[] finnMenyerInnenforPrisintervall(int nedre, int ovre) {
        ArrayList<Meny> a = new ArrayList<>();

        for (Meny meny : menyer) {
            if (meny.getTotalPris() >= nedre && meny.getTotalPris() <= ovre) {
                a.add(meny);
            }
        }
        return a.toArray(new Meny[a.size()]);
    }

    public void addMeny(Rett[] retter, String navn) {
        menyer.add(new Meny(retter, navn));
    }

    public void printMeny(Meny meny) {
        System.out.println(meny);
    }

    public void printAlleMenyer() {
        for (Meny meny : menyer) {
            printMeny(meny);
        }
    }

    public void printAlleRetter() {
        for (Rett rett : retter) {
            System.out.println(rett);
        }
    }

    public void printAlleRetterMedIndex() {
        for (int i = 0; i < retter.size(); i++) {
            System.out.println(i + 1 + ": " + retter.get(i));
        }
    }

    public Rett[] getRetter() {
        return retter.toArray(new Rett[retter.size()]);
    }

    public Meny[] getMenyer() {
        return menyer.toArray(new Meny[menyer.size()]);
    }
}
