package prog.ov1;

public class oppg2 {
    public static void main(String[] args){
        System.out.println(tilSek(1,1,1));
        System.out.println(tilSek(1,0,0));
        System.out.println(tilSek(0, 0, 0));
        System.out.println(tilSek(-1, 0, 0));
    }

    public static int tilSek(int tim, int min, int sek){
        return tim*3600 + min*60 + sek;
    }
}
