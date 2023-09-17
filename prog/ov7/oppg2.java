package prog.ov7;

public class oppg2 {
    public static void main(String[] args){

        TekstBehandling string = new TekstBehandling("Dette er en test av antall perioder og ord. Gjennomsnittet skal omtrent etter mine presise kalkulasjoner, bli 6.");
        string.print();
        System.out.println(string.antallOrd());
        System.out.println(string.ordPrPeriode());

        string.skriftUt("test","utprøving av");
        string.print();
        string.orgPrint();
        System.out.println(string.upper());
    }

    public static class TekstBehandling{
        String tekst;
        String[] skilletegn = {",", ".", "!", "?"};
        String orgTekst;

        public TekstBehandling(String tekst){
            this.tekst = tekst;
            this.orgTekst = tekst;
        }

        public void print(){
            System.out.println(tekst);
        }

        public void orgPrint(){
            System.out.println(orgTekst);
        }
        
        public String upper(){
            return tekst.toUpperCase();
        }

        public long antallOrd(){
            long antall = 1;
            for(int i = 0; i < tekst.length(); i++){
                if(tekst.charAt(i) == " ".charAt(0) && tekst.charAt(i+1) != " ".charAt(0)){
                    antall++;
                }
            }

            return antall;
        }

        public double ordPrPeriode(){
            double perioder = 1;
            long ord = antallOrd();

            for (int i = 0; i<tekst.length()-1; i++){ // for hvert tegn i teksten - siste tegn
                for(int j = 0; j < skilletegn.length; j++){ // for hvert skilletegn
                    if(tekst.charAt(i) == skilletegn[j].charAt(0)){
                        perioder++;
                    }
                }
            }  

            double gjennomsnitt = ord/perioder;
            return gjennomsnitt;
        }

        public void skriftUt(String inn, String ut){

            long ord = antallOrd();
            String res = "";

            for(int i = 0; i < ord; i++){ //for alle ordene
                String[] nesteOrd = getNesteOrd(i); //get neste ord

                if(nesteOrd[0].equals(inn)){ //hvis order er likt som ordet inn
                    res += ut; //legg til ordet som skal erstattes
                } else { //hvis order er ulikt
                    res += nesteOrd[0]; //legg til det originale orde 
                }
                
                res += nesteOrd[1]; //legg til evt. skilletegn
                res+=" "; //legg til mellomrom
            }

            tekst = res; //oppdater tekst
        }

        public String[] getNesteOrd(int ordNr){ //returnerer en liste med: element 0 som string, element 1 som evt skilletegn

            //loop til ordet nevnt er funnet

            //loop igjennom til slutten av ordet er funnet, enten av mellomrom eller skilletegn

            int ordFunnet = 0;
            String ord = "";
            String sTegn = "";
            for(int i = 0; i < tekst.length(); i++){

                if(tekst.charAt(i) == " ".charAt(0) && tekst.charAt(i+1) != " ".charAt(0) && ordNr > 0){ //looper til vi finner det første ordet
                    ordFunnet++;
                }

                if(ordFunnet == ordNr){ //hvis vi er på indeksen til ordet vi ønsker å hente ut

                    if(ordNr == 0){ //siden vi setter j til i+1, så kommer ikke første karakter for det første ordet med
                        ord += tekst.charAt(i);
                    }

                    for(int j = i+1; j < tekst.length(); j++){ //for hele tekstens lengde. Kan også skrives som en while loop, men en for loop unngår en potensiell evig loop.
                        if(tekst.charAt(j) == " ".charAt(0)){ //om karakteren er et mellomrom
                            break;
                        }

                        boolean fSkilletegn = false;
                        for(int k = 0; k < skilletegn.length; k++){ // for hvert skilletegn
                            if(tekst.charAt(j) == skilletegn[k].charAt(0)){ //hvis bokstaven er ett skilletegn, break
                                fSkilletegn = true;
                                sTegn += tekst.charAt(j);
                            }
                        }

                        if(fSkilletegn){
                            break;
                        }

                        //System.out.println(tekst.charAt(i));
                        ord += tekst.charAt(j); //legg til bokstav
                    }
                    break;
                }
            }

            String[] res = {ord,sTegn};
            return res;
        }


    }    
}
