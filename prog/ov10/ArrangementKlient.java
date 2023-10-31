package prog.ov10;

public class ArrangementKlient {
    private Menu menu;

    public ArrangementKlient() {
        menu = new Menu();

        menu.addMenuElement(new MenuElement("Legg til arrangement", (Void) -> {
            System.out.println("Legg til arrangement");
            System.out.print("Navn: ");
            String navn = (String) menu.getInput(new String());
            System.out.println("");

            System.out.print("Sted: ");
            String sted = (String) menu.getInput(new String());
            System.out.println("");

            System.out.print("Arrangor: ");
            String arrangor = (String) menu.getInput(new String());
            System.out.println("");

            System.out.print("Tidspunkt: ");
            Long dato = (Long) menu.getInput(new Long(0));
            System.out.println("");

            return null;
        }));

        menuElements[2] = new MenuElement("Hent antall studenter", (Void) -> {
            System.out.println("Antall studenter: " + oversikt.getAntStud());
            return null;
        });

        menuElements[3] = new MenuElement("Hent antall oppgaver", (Void) -> {
            System.out.print("Navn: ");
            System.out.print(oversikt.getOppg((String) getInput(new String())));
            return null;
        });

        menuElements[4] = new MenuElement("Øk antall oppgaver", (Void) -> {
            System.out.print("Navn: ");
            oversikt.okAntOppg((String) getInput(new String()));
            return null;
        });
    }

}
