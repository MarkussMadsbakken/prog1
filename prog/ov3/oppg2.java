package prog.ov3;
import java.util.Scanner;

public class oppg2 {
    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in); //scanner
        
        boolean a = true;

        while(a){
            System.out.println("Hvilket tall ønsker du å undersøke? Skriv avslutt for å avslutte");
            String svar = input.nextLine();

            if(svar.contains("avslutt")){
                a = false;

            } else {
                try{
                    if(sjekkPrim(Long.parseLong(svar))){
                    
                        System.out.println(svar + " er et primtall");
                    } else {
                        System.out.println(svar + " er ikke et primtall");
                    }
                } catch(Exception e){
                    System.out.println(svar + " er ikke et tall");
                }
            }   
        }
        input.close();
    }

    public static boolean sjekkPrim(long tall){
        for(long i = 2; i < tall; i++){
            if(tall%i == 0){
                return false;
            }
        }

        return true;
    }
    
}
