package prog.ov8;
import java.io.Console;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.Callable;


public class oppg1 {
    public static void main(String[] args) {
        System.out.println(KlientProgram.ConsoleColors.BLUE_BACKGROUND_BRIGHT);
        System.out.println("0+9834209384");

        System.out.println(KlientProgram.ConsoleColors.RESET);

        KlientProgram klient = new KlientProgram();

        klient.menu();
    }

    
    public static class KlientProgram{
        ArbTaker[] arbTakerListe;
        Scanner scanner = new Scanner(System.in);
        ConsoleColors color = new ConsoleColors();

        public KlientProgram(){
            addArbtaker("Ola", "Nordmann", 1990, 1, 2010, 30000, 22.5);
            addArbtaker("Kari", "Nordmann", 1995, 2, 2015, 30000, 22.5);
            addArbtaker("Per", "Nordmann", 1990, 3, 2010, 30000, 22.5);
            addArbtaker("Pål", "Nordmann", 1990, 4, 2010, 30000, 22.5);
            addArbtaker("Espen", "Nordmann", 1990, 5, 2010, 30000, 22.5);
            addArbtaker("ole", "Andersen", 1990, 6, 2010, 30000, 22.5);
            addArbtaker("jenny", "Andersen", 1990, 7, 2010, 30000, 22.5);
            addArbtaker("Ola", "Nordmann", 1990, 1, 2010, 30000, 22.5);
            addArbtaker("Kari", "Nordmann", 1995, 2, 2015, 30000, 22.5);
            addArbtaker("Per", "Nordmann", 1990, 3, 2010, 30000, 22.5);
            addArbtaker("Pål", "Nordmann", 1990, 4, 2010, 30000, 22.5);
            addArbtaker("Espen", "Nordmann", 1990, 5, 2010, 30000, 22.5);
            addArbtaker("ole", "Andersen", 1990, 6, 2010, 30000, 22.5);
            addArbtaker("jenny", "Andersen", 1990, 7, 2010, 30000, 22.5);
            addArbtaker("Ola", "Nordmann", 1990, 1, 2010, 30000, 22.5);
            addArbtaker("Kari", "Nordmann", 1995, 2, 2015, 30000, 22.5);


            arbTakerListe[0].aarAnsatt();
        } 

        public void menu(){

            while(true){
                int input;

                //System.out.println(getOrd(" side     2")[0]+" "+getOrd(" side     2")[1]);

                //headline
                color.h1();
                System.out.println("********************  Hovedmeny ********************");

                color.options();
                System.out.println("1: Legg til arbeidstaker");
                System.out.println("2: Bla igjennom arbeidstakere");
                System.out.println("3: Søk etter arbeidstaker");
                System.out.println("4: Skriv ut alle arbeidstakere");
                System.out.println("5: Avslutt");

                color.h1();
                System.out.println("****************************************************");
                
                color.reset();

                try {
                    input = scanner.nextInt();
                    scanner.nextLine();

                    if(input == 1){
                        addArbtakerMeny();
                    } else if(input == 2){
                        blaIgjennomArbtaker();
                    } else if(input == 3){
                        System.out.println("Søk etter arbeidstaker");
                        System.out.println("");
                    } else if(input == 4){
                        printArbtakerListe();
                    } else {
                        System.out.println("Avslutt");
                        break;
                    }
                } catch (Exception e){
                    break;
                }
            }



        }

        public void visArbTakerInfo(ArbTaker arbTaker){
            while(true){
                color.h1();
                System.out.println("******************  Arbeidstaker ******************");

                color.info();
                System.out.println("Fornavn: " + arbTaker.getFornavn());
                System.out.println("Etternavn: " + arbTaker.getEtternavn());
                System.out.println("Fødselsår: " + arbTaker.getFodselsaar());
                System.out.println("Arbeidstakernummer: " + arbTaker.getArbTakerNr());
                System.out.println("Ansettelsesår: " + arbTaker.getAnsettelsesAar());
                System.out.println("Månedslønn: " + arbTaker.getMaanedsLonn() +"kr");
                System.out.println("Skatteprosent: " + arbTaker.getSkatteProsent() + "%");
                System.out.println("Månedsskatt: " + arbTaker.getMSkatt() + "kr");
                System.out.println("Bruttolønn: " + arbTaker.getAarsBruttolonn() + "kr");
                System.out.println("Årsskatt: " + arbTaker.getAarsSkatt() + "kr");
                System.out.println("År ansatt: " + arbTaker.aarAnsatt());

            

                color.input();
                System.out.println("");
                System.out.println("Skriv inn en egenskap + hva");
                System.out.println("egenskapen skal endres til");
                System.out.print("eller trykk enter for å gå tilbake: ");
                String input = scanner.nextLine();
                
                String [] alleOrd = getOrd(input);

                if(alleOrd[0].toLowerCase().equals("fornavn") || alleOrd[0].toLowerCase().equals("etternavn") || alleOrd[0].toLowerCase().equals("fødselsår") || alleOrd[0].toLowerCase().equals("fodselsaar")){
                    color.error();
                    System.out.println("Fornavn, etternavn eller fødselsår kan ikke endres");
                    color.reset();
                } else if(alleOrd[0].toLowerCase().equals("arbeidstakernummer") || alleOrd[0].toLowerCase().equals("arbnr")){
                    try{
                        int arbTakerNr = Integer.parseInt(alleOrd[1]);
                        arbTaker.setArbTakerNr(arbTakerNr);
                        color.success();
                        System.out.println("Arbeidstakernummer endret til " + arbTakerNr);
                        color.reset();

                    } catch (Exception e){
                        color.error();
                        System.out.println("Arbeidstakernummer må være et heltall");
                        color.reset();
                    }
                } else if(alleOrd[0].toLowerCase().equals("ansettelsesaar") || alleOrd[0].toLowerCase().equals("ansaar") || alleOrd[0].toLowerCase().equals("ansettelsesår") || alleOrd[0].toLowerCase().equals("ansår")){
                    try{
                        int ansettelsesAar = Integer.parseInt(alleOrd[1]);
                        arbTaker.setAnsettelsesAar(ansettelsesAar);
                        color.success();
                        System.out.println("Ansettelsesår endret til " + ansettelsesAar);
                        color.reset();

                    } catch (Exception e){
                        color.error();
                        System.out.println("Ansettelsesår må være et heltall");
                        color.reset();
                    }
                } else if(alleOrd[0].toLowerCase().equals("maanedslonn") || alleOrd[0].toLowerCase().equals("mlonn") || alleOrd[0].toLowerCase().equals("månedslønn") || alleOrd[0].toLowerCase().equals("mlønn")){
                    try{
                        double maanedsLonn = Double.parseDouble(alleOrd[1]);
                        arbTaker.setMaanedsLonn(maanedsLonn);
                        color.success();
                        System.out.println("Månedslønn endret til " + maanedsLonn);
                        color.reset();

                    } catch (Exception e){
                        color.error();
                        System.out.println("Månedslønn må være et tall");
                        color.reset();
                    }
                } else if(alleOrd[0].toLowerCase().equals("skatteprosent") || alleOrd[0].toLowerCase().equals("skatt")){
                    try{
                        double skatteProsent = Double.parseDouble(alleOrd[1]);
                        arbTaker.setSkatteProsent(skatteProsent);
                        color.success();
                        System.out.println("Skatteprosent endret til " + skatteProsent);
                        color.reset();

                    } catch (Exception e){
                        color.error();
                        System.out.println("Skatteprosent må være et tall");
                        color.reset();
                    }
                } else if(alleOrd[0].toLowerCase().equals("maanedsskatt") || alleOrd[0].toLowerCase().equals("mskatt") || alleOrd[0].toLowerCase().equals("månedsskatt") || alleOrd[0].toLowerCase().equals("bruttolønn") || alleOrd[0].toLowerCase().equals("blønn") || alleOrd[0].toLowerCase().equals("bruttolonn") || alleOrd[0].toLowerCase().equals("blonn") || alleOrd[0].toLowerCase().equals("årskatt") || alleOrd[0].toLowerCase().equals("aaransatt") || alleOrd[0].toLowerCase().equals("aar") || alleOrd[0].toLowerCase().equals("åransatt") || alleOrd[0].toLowerCase().equals("år")){
                    color.error();
                    System.out.println("Månedsskatt, bruttolønn, skatt og år ansatt kan ikke endres. Endre andre egenskaper for å påvirke dette");
                }

                else if(alleOrd[0].equals("")){
                    break;
                } else {
                    color.error();
                    System.out.println("Egenskapen finnes ikke");
                    color.reset();
                }
            }


            

            color.h1();
            System.out.println("");
            System.out.println("****************************************************");


            color.reset();
        }

        public void blaIgjennomArbtaker(){
            color.h1();
            System.out.println("******************  Arbeidstakere ******************");
            color.info();

            if(arbTakerListe == null){
                System.out.println("Ingen arbeidstakere!");
                return;
            } 

            int currSide = 0;

            while(true){
                printArbTakerSide(currSide);

                color.input();
                System.out.println("");
                System.out.println("Skriv inn et tall for å vise mer informasjon,");
                System.out.println("skriv inn 'side' + sidetall for å gå til en");
                System.out.print("annen side eller trykk enter for å gå tilbake: ");
                String input = scanner.nextLine();
                color.reset();

                try{
                    int inputInt = Integer.parseInt(input);
                    visArbTakerInfo(arbTakerListe[currSide*15+inputInt-1]);

                } catch (Exception e){

                    String[] a = getOrd(input);


                    if(a[0].equals("side")){
                        try{
                            int side = Integer.parseInt(a[1]);
                            currSide = side-1;
                        } catch (Exception e2){
                            color.error();
                            System.out.println("Siden finnes ikke");
                            color.reset();
                        }
                    } else if(a[0].length() > 4){
                        if(a[0].substring(0, 4).equals("side")){
                            try{
                                int side = Integer.parseInt(a[0].substring(4, a[0].length()));
                                currSide = side-1;
                                
                            } catch (Exception e2){
                                color.error();
                                System.out.println("Siden finnes ikke");
                                color.reset();
                            }
                        } else {
                            color.h1();
                            System.out.println("****************************************************");
                            color.reset();

                            System.out.println("");
                            System.out.println("");

                            break;
                        }
                    } else{
                        color.h1();
                        System.out.println("****************************************************");
                        color.reset();

                        System.out.println("");
                        System.out.println("");
                        break;
                    }
                }

            }

        }

        public String[] getOrd(String input){

            //skip alle inn-mellomrom før første bokstav:

            int start = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) != " ".charAt(0)){
                    start = i;
                    break;
                }
            }
            input = input.substring(start, input.length()); 

            //hent antall ord
            long antall = 1;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == " ".charAt(0) && input.charAt(i+1) != " ".charAt(0)){
                    antall++;
                }
            }

            //lag ny liste med lengde av antall ord
            String[] res = new String[(int)antall];

            for(int i = 0; i < res.length; i++){ //sett alle elementer til en tom string2
                res[i] = "";
            }

            //lagre alle ord i listen
            int j = 0;
            for(int i = 0; i <input.length(); i++){ //for alle tegn
                if(input.charAt(i) != " ".charAt(0)){ //hvis tegnet ikke er et mellomrom
                    res[j] += input.charAt(i); //lagre
                } else if (i+1<input.length() ? input.charAt(i+1) != " ".charAt(0) : true){ //hvis tegnet er et mellomrom, og tegnet etterpå også ikke er det
                    j++; //inkrimeter j
                }
            }

            return res;

        }

        public void printArbTakerSide(int side){
            System.out.println("******************     side "+(side+1)+"   ********************"); 
            System.out.println("");

            int slutt = 15;

            if(side*15 > arbTakerListe.length){ 
                slutt = arbTakerListe.length;
            }

            color.info();
            for(int i = 0; i < slutt; i++){
                if(arbTakerListe.length > side*15+i){
                    System.out.println(i+1 + ": "+arbTakerListe[side*15+i].getFulltNavn());
                }
            }
        }
        
        public void printArbtakerListe(){
            color.h1();
            System.out.println("******************  Arbeidstakere ******************");
            color.info();

            if(arbTakerListe == null){
                System.out.println("Ingen arbeidstakere!");
                return;
            } 

            color.info();

            for(int i = 0; i < arbTakerListe.length; i++){
                System.out.println(arbTakerListe[i].getFulltNavn());
            }

            color.input();
            System.out.println("");
            System.out.print("Enter for å gå tilbake");
            scanner.nextLine();
            color.h1();
            System.out.println("****************************************************");
            color.info();

            System.out.println("");
            System.out.println("");

            color.reset();
        }

        public void addArbtakerMeny() {

            while(true){

                try{
                    System.out.println("");

                    color.h1();
                    System.out.println("Legg til arbeidstaker");

                    color.input();

                    System.out.print("Fornavn (string): ");
                    String fornavn = scanner.nextLine();

                    System.out.print("Etternavn (string): ");
                    String etternavn = scanner.nextLine();

                    System.out.print("Fødselsår (int): ");
                    int fodselsaar = scanner.nextInt();

                    System.out.print("Arbeidstakernummer (int): ");
                    int arbTakerNr = scanner.nextInt();
                    
                    System.out.print("Ansettelsesår (int): ");
                    int ansettelsesAar = scanner.nextInt();

                    System.out.print("Månedslønn (float): ");
                    double maanedsLonn = scanner.nextDouble();

                    System.out.print("Skatteprosent (float): ");
                    double skatteProsent = scanner.nextDouble();

                    color.warning();
                    System.out.println("");
                    System.out.println("Du vil legge til:");
                    color.info();
                    System.out.println("Fornavn: " + fornavn);
                    System.out.println("Etternavn: " + etternavn);
                    System.out.println("Fødselsår: " + fodselsaar);
                    System.out.println("Arbeidstakernummer: " + arbTakerNr);
                    System.out.println("Ansettelsesår: " + ansettelsesAar);
                    System.out.println("Månedslønn: " + maanedsLonn);
                    System.out.println("Skatteprosent: " + skatteProsent);

                    color.input();
                    System.out.print("Er dette riktig? (y/n): ");

                    String input = scanner.next();
                    System.out.println("");
                    if(input.equals("y") || input.equals("Y")){
                        System.out.println("");
                        color.success();
                        System.out.println(addArbtaker(fornavn, etternavn, fodselsaar, arbTakerNr, ansettelsesAar, maanedsLonn, skatteProsent));
                        color.reset();

                        System.out.println("");
                        System.out.println("");
                        break;
                    }

                    color.error();
                    System.out.println("Avbrutt av bruker");
                    color.reset();

                    System.out.println("");
                    System.out.println("");
                    break;

            } catch (Exception e){

                color.error();
                System.out.println("Feil input");
                color.reset();
                scanner.nextLine();
            }

            }
        }

        public String addArbtaker(String fornavn, String etternavn, int fodselsaar, int arbTakerNr, int ansettelsesAar, double maanedsLonn, double skatteProsent){

            if(arbTakerListe == null){ //hvis listen er tom
                arbTakerListe = new ArbTaker[1]; //lag ny liste med lengde 1
                arbTakerListe[0] = new ArbTaker(fornavn, etternavn, fodselsaar, arbTakerNr, ansettelsesAar, maanedsLonn, skatteProsent); //legg til det nye elementet
                return "Arbeidstaker lagt til";
            }

            ArbTaker[] res = new ArbTaker[arbTakerListe.length+1]; //lag ny liste med lengde + 1

            for(int i = 0; i < arbTakerListe.length; i++){ //legg til alle de tildigere elementene
                res[i] = arbTakerListe[i];
            }

            res[res.length-1] = new ArbTaker(fornavn, etternavn, fodselsaar, arbTakerNr, ansettelsesAar, maanedsLonn, skatteProsent); //legg til det nye elementet

            arbTakerListe = res; //sett den nye listen som den gamle

            return "Arbeidstaker lagt til";
        }

        
        public class ConsoleColors {
            // Reset
            public static final String RESET = "\033[0m";  // Text Reset
        
            // Regular Colors
            public static final String BLACK = "\033[0;30m";   // BLACK
            public static final String RED = "\033[0;31m";     // RED
            public static final String GREEN = "\033[0;32m";   // GREEN
            public static final String YELLOW = "\033[0;33m";  // YELLOW
            public static final String BLUE = "\033[0;34m";    // BLUE
            public static final String PURPLE = "\033[0;35m";  // PURPLE
            public static final String CYAN = "\033[0;36m";    // CYAN
            public static final String WHITE = "\033[0;37m";   // WHITE
        
            // Bold
            public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
            public static final String RED_BOLD = "\033[1;31m";    // RED
            public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
            public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
            public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
            public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
            public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
            public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
        
            // Underline
            public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
            public static final String RED_UNDERLINED = "\033[4;31m";    // RED
            public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
            public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
            public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
            public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
            public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
            public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
        
            // Background
            public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
            public static final String RED_BACKGROUND = "\033[41m";    // RED
            public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
            public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
            public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
            public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
            public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
            public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
        
            // High Intensity
            public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
            public static final String RED_BRIGHT = "\033[0;91m";    // RED
            public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
            public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
            public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
            public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
            public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
            public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
        
            // Bold High Intensity
            public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
            public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
            public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
            public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
            public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
            public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
            public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
            public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
        
            // High Intensity backgrounds
            public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
            public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
            public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
            public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
            public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
            public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
            public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
            public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

            public void reset(){
                System.out.print(RESET);
            }

            public void h1(){
                System.out.print(RED);
            }

            public void options(){
                System.out.print(BLUE);
            }

            public void input(){
                System.out.print(GREEN);
            }

            public void success(){
                System.out.print(GREEN_UNDERLINED);
            }

            public void error(){
                System.out.print(RED_BOLD);
            }

            public void warning(){
                System.out.print(YELLOW);
            }

            public void info(){
                System.out.print(CYAN);
            }
        }

    }


    public static class Person{
        String fornavn;
        String etternavn;
        int fodselsaar;

        public Person(String fornavn, String etternavn, int fodselsaar){
            this.fornavn = fornavn;
            this.etternavn = etternavn;
            this.fodselsaar = fodselsaar;
        }

        public String getFornavn(){
            return fornavn;
        }

        public String getEtternavn(){
            return etternavn;
        }

        public int getFodselsaar(){
            return fodselsaar;
        }

        public String getFulltNavn(){
            return etternavn + ", " + fornavn;
        }
    }

    public static class ArbTaker extends Person{
        int arbTakerNr;
        int ansettelsesAar;
        double maanedsLonn;
        double skatteProsent;
        java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
        

        public ArbTaker(String fornavn, String etternavn, int fodselsaar, int arbTakerNr, int ansettelsesAar, double maanedsLonn, double skatteProsent){
            super(fornavn, etternavn, fodselsaar);
            this.arbTakerNr = arbTakerNr;
            this.ansettelsesAar = ansettelsesAar;
            this.maanedsLonn = maanedsLonn;
            this.skatteProsent = skatteProsent;
        }

        public ArbTaker(String fornavn, String etternavn, int fodselsaar, int arbTakerNr, double maanedsLonn, double skatteProsent){
            super(fornavn, etternavn, fodselsaar);
            this.arbTakerNr = arbTakerNr;
            this.ansettelsesAar = kalender.get(Calendar.YEAR);
            this.maanedsLonn = maanedsLonn;
            this.skatteProsent = skatteProsent;
        }

        //get/set

        public void setArbTakerNr(int arbTakerNr){
            this.arbTakerNr = arbTakerNr;
        }

        public void setAnsettelsesAar(int ansettelsesAar){
            this.ansettelsesAar = ansettelsesAar;
        }

        public void setMaanedsLonn(double maanedsLonn){
            this.maanedsLonn = maanedsLonn;
        }

        public void setSkatteProsent(double skatteProsent){
            this.skatteProsent = skatteProsent;
        }

        public int getArbTakerNr(){
            return arbTakerNr;
        }

        public int getAnsettelsesAar(){
            return ansettelsesAar;
        }

        public double getMaanedsLonn(){
            return maanedsLonn;
        }

        public double getSkatteProsent(){
            return skatteProsent;
        }

        
        public double getMSkatt(){ //månedsskatt
            return maanedsLonn * (skatteProsent/100);
        }

        public double getAarsBruttolonn(){ //års bruttolønn
            return maanedsLonn * 12;
        }

        public double getAarsSkatt(){ //års skatt
            return getMSkatt() * 10.5;
        }

        public int aarAnsatt(){
            int aar = kalender.get(Calendar.YEAR);
            return aar-ansettelsesAar;
        }
    }
}