package prog.ov9;

public class oppg1 {
    public static void main(String[] args) {
        // test();

        Menu meny = new Menu();
        meny.start();
    }

    public static void test() {
        System.out.println("Running tests");

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

        oversikt.okAntOppg("Per Olsen");

        System.out.println(oversikt.getAntStud());
        System.out.println(oversikt.getOppg("Per Olsen"));
    }
}
