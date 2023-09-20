package prog.ov9;

public class oppg1 {
    public static void main(String[] args) {
        KlientProgram klient = new KlientProgram();
        klient.menu();
        
    }

    public static class KlientProgram{
        OppgaveOversikt oversikt = new OppgaveOversikt();

        public void menu(){
            oversikt.nyStud("Per");
            oversikt.nyStud("Ole");
            oversikt.nyStud("Kari");
            oversikt.nyStud("Nils");
            oversikt.nyStud("Mona");
            oversikt.nyStud("Jenny");
            oversikt.nyStud("Knut");
            oversikt.nyStud("Kari");

            System.out.println(oversikt.toString());
        }

    }
    
    public static class Student{
        private String navn;
        private int antOppg;

        public Student(String n){
            navn = n;
            antOppg = 0;
        }

        public Student(String n, int a){
            navn = n;
            antOppg = a;
        }

        public String getNavn(){
        return navn;
        }

        public int getAntOppg(){
            return antOppg;
        }

        public void okAntOppg(int a){
            antOppg += a;
        }

        public String toString(){
            return getNavn() +": "+getAntOppg();
        }
    }

    public static class OppgaveOversikt{
        private Student[] studenter;
        private int antStud = 0;

        public int getAntStud(){
            return antStud;
        }

        public void okAntStud(){
            antStud++;
        }

        public void nyStud(String navn){
            okAntStud();
            int ant = getAntStud();
            Student[] temp = new Student[ant];
            for(int i = 0; i < ant-1; i++){
                temp[i] = studenter[i];
            }
            temp[ant-1] = new Student(navn);
            studenter = temp;
        }

        public int getOppg(String navn){
            for(int i = 0; i < antStud; i++){
                if(studenter[i].getNavn().equals(navn)){
                    return studenter[i].getAntOppg();
                }
            }

            return 0; //hvis studenten ikke finnes
        }

        public void okAntOppg(String navn){
            for(int i = 0; i < antStud; i++){
                if(studenter[i].getNavn().equals(navn)){
                    studenter[i].okAntOppg(1);
                }
            }
        }

        public String toString(){
            String res = "";
            for(int i = 0; i < antStud; i++){
                res += studenter[i].toString() + "\n";
            }
            return res;
        }
    }
}
