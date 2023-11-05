package prog.ov11;

import java.util.ArrayList;

public class EiendomsRegister {
    private ArrayList<Eiendom> eiendommer = new ArrayList<>();

    public void addEiendom(Eiendom eiendom) {
        eiendommer.add(eiendom);
    }

    public void slettEiendom(String id) {
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getId().equals(id)) {
                eiendommer.remove(eiendom);
                return;
            }
        }
    }

    public int getAntallEiendommer() {
        return eiendommer.size();
    }

    public Eiendom[] getEiendommer() {
        return eiendommer.toArray(new Eiendom[eiendommer.size()]);
    }

    public Eiendom getEiendomFromID(String id) {
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getId().equals(id)) {
                return eiendom;
            }
        }
        return null;
    }

    public Eiendom[] getEiendommerFromGardsnummer(int gardsnummer){
        ArrayList<Eiendom> temp = new ArrayList<>();

        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getGardsnummer() == gardsnummer) {
                temp.add(eiendom);
            }
        }
        return temp.toArray(new Eiendom[temp.size()]);
    }

    public double getSnittAreal() {
        double sum = 0;
        for (Eiendom eiendom : eiendommer) {
            sum += eiendom.getAreal();
        }
        return sum / eiendommer.size();
    }
}
