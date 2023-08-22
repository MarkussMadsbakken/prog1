package prog.ov1;

public class oppg1 {
    public static void main(String[] args){
        tilCm(0);
        tilCm(100);
        tilCm(-100);
    }
    
    public static void tilCm(float tommer){
        if(tommer < 0){
            System.out.println("Lenger kan ikke være negative");
            return;
        }
        System.out.println(tommer +" tommer blir " + tommer*(float)2.54 + "cm");
    }
    
}
