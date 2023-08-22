package prog.ov1;

public class oppg3 {
    public static void main(String[] args){
        tilTid(60);
        tilTid(3600);
        tilTid(0);
        tilTid(10);
        tilTid(1029389);
    }

    public static void tilTid(int sek){
        int ntim = sek/60/60;
        int nmin = sek/60%60;
        int nsek = sek%60%60;
        System.out.println(sek + " sekunder blir " + ntim + " timer, " + nmin + " sekunder og " + nsek + " sekunder.");
    }
}