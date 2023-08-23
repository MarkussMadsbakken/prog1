package prog.ov2;

public class oppg2 {
    public static void main(String[] args){
        double Avekt = 450;
        double Apris = 35.90;

        double Bvekt = 500;
        double Bpris = 39.50;

        double Akpris = kiloPris(Apris, Avekt);
        double Bkpris = kiloPris(Bpris, Bvekt);
        System.out.println(Akpris);
        System.out.println(Bkpris);

        if(kiloPris(Apris, Avekt) > kiloPris(Bpris, Bvekt)){
            System.out.println("Vare A er billigere");
        } else {
            System.out.println("Vare B er billigere");
        }
    }

    public static double kiloPris(double pris, double kilo){
        return pris/kilo;
    }
}
