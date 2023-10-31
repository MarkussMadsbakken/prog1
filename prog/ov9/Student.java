package prog.ov9;

public class Student {
    private final String navn;
    private int antOppg;

    public Student(String n) {
        navn = n;
        antOppg = 0;
    }

    public Student(String n, int a) {
        navn = n;
        antOppg = a;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void okAntOppg(int a) {
        antOppg += a;
    }

    public String toString() {
        return getNavn() + ": " + getAntOppg();
    }
}
