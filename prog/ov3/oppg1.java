package prog.ov3;
import java.util.Scanner;

public class oppg1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Hvilke gangetabeller? skriv på formen: (starttall)-(sluttall)");
        String samletTall = input.nextLine();

        int[] startSlutt = parseTabellTall(samletTall);

        skrivDelAvGangetabell(startSlutt[0], startSlutt[1]);

        input.close();
    }

    public static void skrivDelAvGangetabell(int start, int slutt){
        System.out.println("Gangetabellene fra " + start + " til " + slutt + ":");
        for(int i = start; i < slutt + 1; i++){
            System.out.println(i + "-gangen");
            for (int j = 1; j<11; j++){
                System.out.println(i+" x " + j + " = " + i*j);
            }
            
            if(i != slutt){
                System.out.println("");
            }
        }
    }

    public static int[] parseTabellTall(String preString){
        for(int i = 0; i < preString.length(); i++){
            if((preString.charAt(i)) == '-'){
                
                int pre = 0;
                try {
                    pre = Integer.parseInt(preString.substring(0, i));
                } catch(Exception e) {
                    System.out.println("tallet før bindestreken må være et tall");
                    System.exit(0);
                }

                int post = 0;
                try {
                    post = Integer.parseInt(preString.substring(i+1));
                } catch(Exception e) {
                    System.out.println("tallet etter bindestreken må være et tall");
                    System.exit(0);
                }

                int[] res = {pre, post};
                return res;
            }
        }
        System.out.println("Skrevet på feil form. Skriv på måten (tall)-(tall)");
        System.exit(0);
        int[] res = {};
        return res;
    }
}
