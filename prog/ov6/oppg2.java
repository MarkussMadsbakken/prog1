package prog.ov6;

public class oppg2 {
    public static void main(String[] args){
        tekstAnalyse analyse = new tekstAnalyse("EEEEøcccck....,.kkkkkkkkkkkkkkkkkkkkkkkccccccccccccccccccccbbbbbbbbbbbbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaåå...ÅØA.Av.7466546.3^^ ^v");
        analyse.print();
        System.out.println(analyse.getAntallTegn());
        System.out.println(analyse.getAntallBokstaver());
        System.out.println(analyse.getProsentBokstaver());
        System.out.println(analyse.getAntallTegn('.'));
        analyse.printForekomst();

    }

    public static class tekstAnalyse{
        int[] antallTegn = new int[30];

        public tekstAnalyse(String string){
            string = string.toLowerCase();
            
            for(int i = 0; i < string.length(); i++){
                int ucode = (int)string.charAt(i);

                if(ucode >= 97 && ucode <= 119){ // a-z
                    antallTegn[ucode-97]++;
                
                } else if(ucode == 230){ //æ
                    System.out.println(ucode);
                    antallTegn[26]++;

                } else if(ucode == 248){ //ø
                    antallTegn[27]++;

                } else if(ucode == 229){ //å
                    antallTegn[28]++;

                } else { //resten
                    antallTegn[29]++;
                }
            }
        }


        public void print(){
            for(int i = 0; i < antallTegn.length-4; i++){ //a-z
                System.out.println((char)(i+97) + ": " + antallTegn[i]);
            }

            //æøå
            System.out.println("æ: " + antallTegn[26]);
            System.out.println("ø: " + antallTegn[27]);
            System.out.println("å: " + antallTegn[28]);

            //spesielle tegn
            System.out.println("spesielle tegn: " + antallTegn[29]); 
        }

        public int getAntallTegn(){
            int sum = 0;
            for(int i = 0; i < antallTegn.length; i++){
                sum += antallTegn[i];
            }
            return sum;
        }

        public int getAntallBokstaver(){
            int sum = 0;
            for(int i = 0; i < antallTegn.length-1; i++){
                sum += antallTegn[i];
            }
            return sum;
        }

        public double getProsentBokstaver(){
            return Math.round(((double)getAntallBokstaver()/(double)getAntallTegn()) * 100.0) / 100.0;
        }

        public int getAntallTegn(char tegn){
            int ucode = (int) Character.toLowerCase(tegn);
            if(ucode >= 97 && ucode <= 119){ // a-z
                return antallTegn[ucode-97];
            
            } else if(ucode == 230){ //æ
                return antallTegn[26];

            } else if(ucode == 248){ //ø
                return antallTegn[27];

            } else if(ucode == 229){ //å
                return antallTegn[28];

            } else { //resten
                return antallTegn[29];
            }
        }

        public void printForekomst(){
            int[] forekomst = getForekomst();

            System.out.println("Tegnene det er flest av:");

            for(int i = 1; i < forekomst.length; i++){
                switch(forekomst[i]){
                    case 26:
                        System.out.println("æ: " + forekomst[0]);
                        break;
                    case 27:
                        System.out.println("ø: " + forekomst[0]);
                        break;
                    case 28:
                        System.out.println("å: " + forekomst[0]);
                        break;
                    case 29:
                        System.out.println("spesielle tegn: " + forekomst[0]);
                        break;
                    default:
                        System.out.println((char)(forekomst[i]+97) + ": " + forekomst[0]);
                        break;
                }
            }
        }

        public int[] getForekomst(){
            int[] res = new int[1]; //det første tallet indikerer hvor mange det er av hvert elment



            for(int i = 0; i < antallTegn.length; i++){
                if(antallTegn[i] > res[0]){
                    res = new int[2];
                    res[0] = antallTegn[i];
                    res[1] = i;

                } else if(antallTegn[i] == res[0]){
                    res = leggTilListe(res, i);
                }
            }

            return res;
        }

        public int[] leggTilListe(int[] liste, int e){ //funksjon for å appende liste
            int[] res = new int[liste.length+1]; //lag ny liste med lengde + 1

            for(int i = 0; i < liste.length; i++){ //legg til alle de tildigere elementene
                res[i] = liste[i];
            }

            res[res.length-1] = e; //legg til det nye elementet

            return res; //returner den nye listen
        }
    }
}
