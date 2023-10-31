package prog.ov9;

public class TestOppgaveOversikt {
    public static void main(String[] args) {
        Student s1 = new Student("Ole Olsen");
        Student s2 = new Student("Mari Olsen");
        Student s3 = new Student("Per Olsen", 2);
        Student s4 = new Student("Lise Olsen", 5);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        OppgaveOversikt oversikt = new OppgaveOversikt();
        oversikt.nyStud(s1.getNavn());
        oversikt.nyStud(s2.getNavn());
        oversikt.nyStud(s3.getNavn());
        oversikt.nyStud(s4.getNavn());
    }
}