package prog.ov10;

import java.util.ArrayList;

public class MenyRegister {
    ArrayList<Rett> retter = new ArrayList<>();
    ArrayList<Meny> menyer = new ArrayList<>();

    public void addRett(Rett rett) {
        retter.add(rett);
    }

    public Rett finnRettFraNavn(String navn){
        for (Rett rett : retter) {
            if (rett.navn.equals(navn)) {
                return rett;
            }
        }
        return null;
    }

    public Rett[] finnRetterFraType(String type){
        ArrayList<Rett> retter = new ArrayList<>();

        for (Rett rett : retter) {
            if (rett.type.equals(type)) {
                retter.add(rett);
            }
        }
        return retter.toArray(new Rett[retter.size()]);
    }

    public void addMeny(Rett[] retter){
        menyer.add(new Meny(retter));
    }



}
