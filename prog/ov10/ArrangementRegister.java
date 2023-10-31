package prog.ov10;

import java.util.ArrayList;

public class ArrangementRegister {
    ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public ArrangementRegister(){};

    public void addArrangement(Arrangement arrangement){
        arrangementer.add(arrangement);
    }

    public void printArrangementer(){
        for (Arrangement arrangement : arrangementer) {
            System.out.println(arrangement);
        }
    }

    public void printArrangementer(String sted){
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getSted().equals(sted)){
                System.out.println(arrangement);
            }
        }
    }

    public void printArrangementer(Arrangement.Type type){
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getType().equals(type)){
                System.out.println(arrangement);
            }
        }
    }

    public void printArrangementer(long tidspunkt, long tidspunkt2){
        arrangementer.sort(Arrangement::comapareToByTime);
        
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getTidspunkt() >= tidspunkt && arrangement.getTidspunkt() <= tidspunkt2){
                System.out.println(arrangement);
            }
        }
    }

}
