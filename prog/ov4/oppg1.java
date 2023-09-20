package prog.ov4;

import java.util.Scanner;

public class oppg1 {
    public static void main(String[] args){

        valutta dollar = new valutta(0.094);
        valutta euro = new valutta(0.086);
        valutta sek = new valutta(1.03);

        boolean run = true;

        Scanner scanner = new Scanner(System.in);

        String ans;
        int ians;

        while(run){
            System.out.println("Velg valuta:");
            System.out.println("1: dollar");
            System.out.println("2. euro");
            System.out.println("3. svenske kroner");
            System.out.println("4. avslutt");

            ans = scanner.nextLine();

            try{
                
                ians = Integer.parseInt(ans);

                if(ians < 1 || ians > 4){
                    throw new Exception();
                }

                try{
                    switch(ians){
                        case 1:
                            System.out.println("Skriv inn mengde i dollar");
                            ans = scanner.nextLine();
                            System.out.println(dollar.tilKr(Double.parseDouble(ans)) + "kr");
                            break;

                        case 2:
                            System.out.println("Skriv inn mengde i euro");
                            ans = scanner.nextLine();
                            System.out.println(euro.tilKr(Double.parseDouble(ans)) + "kr");
                            break;

                        case 3:
                            System.out.println("Skriv inn mengde i svenske kroner");
                            ans = scanner.nextLine();
                            System.out.println(sek.tilKr(Double.parseDouble(ans)) + "kr");
                            break;

                        case 4:
                            run = false;
                            break;
                        }

                } catch(Exception e){
                    System.out.println("Skriv inn et tall");
                }

            } catch(Exception e) {
                System.out.println("Skriv inn et tall mellom 1 og 4");
            }

            System.out.println("");

        }
        scanner.close();
    }

    public static class valutta{
        double rate;

        public valutta(double _rate){
            rate = _rate;

        }
        
        public double tilKr(double mengde){
            return mengde/rate;
        }
        
        public double fraKr(double mengde){
            return mengde*rate;
        }
    }
}
