package prog.ov6;

import java.util.Random;


public class oppg1 {
    public static void main(String[] args){
        skrivListe(hentRandom(100));
        //rundAv(4549);
    }

    public static int[] hentRandom(double antall){
        Random random = new Random();
        int[] res = new int[10];
        for(int i = 0; i < antall; i++){
            res[random.nextInt(10)]++;
        }
        return res;
    }

    public static void skrivListe(int[] liste){
        for(int i = 0; i < liste.length; i++){
            System.out.print(i + ": " + liste[i]);

            System.out.print(" ");
            for (int j = 0; j < liste[i]/10; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static int rundAv(int tall){ 
        String sTall = String.valueOf(tall);
        int lengde = sTall.length();
        String ans = "";
        boolean rundetOpp = false;

        int l = 3;
        int rest = 0;
        System.out.println(lengde);
        if(lengde < 2){
            System.out.println("1");
            l = lengde;
        } else {
            rest = lengde-l;
        }

        for(int i = l; i > 0; i--){
            if (rundetOpp){
                if(i == 1){
                    ans = (Integer.parseInt(String.valueOf(sTall.charAt(i)))+1) + ans;

                } else if(Integer.parseInt(String.valueOf(sTall.charAt(i))) > 3){
                    ans = "0" + ans;
                    rundetOpp = true;

                } else {
                    ans = "0" + ans;
                    rundetOpp = false;
                }
            } else {
                if(i == 1){
                    ans = sTall.charAt(i) + ans;
                } else if(Integer.parseInt(String.valueOf(sTall.charAt(i))) > 4){
                    ans = "0" + ans;
                    rundetOpp = true;
                    
                } else {
                    ans = "0" + ans;
                    rundetOpp = false;
                }
            }
        }

        for (int i = rest; i > 0; i--){
            System.out.println("2");
            ans = sTall.charAt(i-1) + ans;
        }

        return Integer.parseInt(ans);
    }
}
