package prog.ov11;

import java.util.ArrayList;

/**
 * En klasse som representerer et eiendomsregister
 */

public class EiendomsRegister {
    private ArrayList<Eiendom> eiendommer = new ArrayList<>();

    /**
     * Legger til en eiendom i registeret
     * 
     * @param eiendom
     */

    public void addEiendom(Eiendom eiendom) {
        eiendommer.add(eiendom);
    }

    /**
     * Sletter en eiendom fra registeret ved gitt id
     * 
     * @param id
     */
    public void slettEiendom(String id) {
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getId().equals(id)) {
                eiendommer.remove(eiendom);
                return;
            }
        }
    }

    /**
     * Returnerer antall eiendommer i registeret
     * 
     * @return
     */

    public int getAntallEiendommer() {
        return eiendommer.size();
    }

    /**
     * Returnerer alle eiendommene i registeret
     * 
     * @return Eiendom[]
     */

    public Eiendom[] getEiendommer() {
        return eiendommer.toArray(new Eiendom[eiendommer.size()]);
    }

    /**
     * Returnerer en eiendom fra registeret ved gitt id
     * 
     * @param id
     * @return Eiendom
     */

    public Eiendom getEiendomFromID(String id) {
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getId().equals(id)) {
                return eiendom;
            }
        }
        return null;
    }

    /**
     * Returnerer alle eiendommene i registeret fra gitt gardsnummer
     * 
     * @param gardsnummer
     * @return Eiendom[]
     */

    public Eiendom[] getEiendommerFromGardsnummer(int gardsnummer) {
        ArrayList<Eiendom> temp = new ArrayList<>();

        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getGardsnummer() == gardsnummer) {
                temp.add(eiendom);
            }
        }
        return temp.toArray(new Eiendom[temp.size()]);
    }

    /**
     * Returnerer gjennomsnittsarealet til alle eiendommene i registeret
     * 
     * @return gjennosnittsareale
     */

    public double getSnittAreal() {
        double sum = 0;
        for (Eiendom eiendom : eiendommer) {
            sum += eiendom.getAreal();
        }
        return sum / eiendommer.size();
    }
}
