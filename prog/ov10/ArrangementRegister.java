package prog.ov10;

import java.util.ArrayList;

public class ArrangementRegister {

    public enum SorteringsType{
        TIDSPUNKT, STED, TYPE
    }

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

    void sorter(SorteringsType type){
        switch (type) {
            case TIDSPUNKT:
                arrangementer.sort(Arrangement::comapareToByTime);
                break;
            case STED:
                arrangementer.sort(Arrangement::comapareToByPlace);
                break;
            case TYPE:
                arrangementer.sort(Arrangement::comapareToByType);
                break;
            default:
                break;
        }
    }

    public void printArrangementerVedSted(String sted){
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getSted().equals(sted)){
                System.out.println(arrangement);
            }
        }
    }

    public void printArrangementerVedType(Arrangement.Type type){
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getType().equals(type)){
                System.out.println(arrangement);
            }
        }
    }

    public void printArrangementerVedDato(long dato){

        for (Arrangement arrangement : arrangementer) {
            if(arrangement.getDato() == dato){
                System.out.println(arrangement);
            }
        }
    }

    public void printArrangementerMellomDatoer(long dato1, long dato2){
        arrangementer.sort(Arrangement::comapareToByTime);
        
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.getDato() >= dato1 && arrangement.getDato() <= dato2){
                System.out.println(arrangement);
            }
        }
    }

}
