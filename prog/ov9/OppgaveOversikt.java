package prog.ov9;

public class OppgaveOversikt {
    private Student[] studenter;
    private int antStud = 0;

    public int getAntStud() {
        return antStud;
    }

    public void okAntStud() {
        antStud++;
    }

    public void nyStud(String navn) {

        for (int i = 0; i < getAntStud(); i++) {
            if (studenter[i].getNavn().equals(navn)) {
                System.out.println("Studenten finnes allerede");
                return;
            }
        }

        okAntStud();
        int ant = getAntStud();
        Student[] temp = new Student[ant];
        for (int i = 0; i < ant - 1; i++) {
            temp[i] = studenter[i];
        }
        temp[ant - 1] = new Student(navn);
        studenter = temp;
    }

    public int getOppg(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                return studenter[i].getAntOppg();
            }
        }

        return 0; // hvis studenten ikke finnes
    }

    public void okAntOppg(String navn) {
        for (int i = 0; i < antStud; i++) {
            if (studenter[i].getNavn().equals(navn)) {
                studenter[i].okAntOppg(1);
            }
        }
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < antStud; i++) {
            res += studenter[i].toString() + "\n";
        }
        return res;
    }
}