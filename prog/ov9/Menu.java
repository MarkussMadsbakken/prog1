package prog.ov9;

import java.util.Scanner;

public class Menu {
    MenuElement[] menuElements = new MenuElement[5];
    Scanner scanner = new Scanner(System.in);

    OppgaveOversikt oversikt = new OppgaveOversikt();

    private boolean run = true;

    Menu() {
        menuElements[0] = new MenuElement("Avslutt", (Void) -> {
            System.out.println("Avslutter");
            run = false;
            return null;
        });

        menuElements[1] = new MenuElement("Legg til student", (Void) -> {
            System.out.println("Legg til student");
            System.out.print("Navn: ");
            oversikt.nyStud((String) getInput(new String()));
            return null;
        });

        menuElements[2] = new MenuElement("Hent antall studenter", (Void) -> {
            System.out.println("Antall studenter: " + oversikt.getAntStud());
            return null;
        });

        menuElements[3] = new MenuElement("Hent antall oppgaver", (Void) -> {
            System.out.print("Navn: ");
            System.out.println(oversikt.getOppg((String) getInput(new String())));
            return null;
        });

        menuElements[4] = new MenuElement("Øk antall oppgaver", (Void) -> {
            System.out.print("Navn: ");
            oversikt.okAntOppg((String) getInput(new String()));
            return null;
        });
    }

    public void start() {
        while (run) {
            printMenu();
            Integer a = (Integer) getInput(new Integer(0));
            if (a != null && a < menuElements.length && a >= 0) {
                openMenuElement((Integer) a);
            }

            if (run) {
                System.out.print("Enter for å gå tilbake");
                scanner.nextLine();
                System.out.println(" ");
            }

        }
    }

    public void printMenu() {
        for (int i = 0; i < menuElements.length; i++) {
            System.out.println(i + ": " + menuElements[i].getName());
        }
    }

    public void openMenuElement(int index) {
        menuElements[index].onOpen.apply(null);
    }

    public Object getInput(Object o) throws IllegalArgumentException {
        String s = scanner.nextLine();

        try {
            switch (o.getClass().getSimpleName()) {
                case "String":
                    return s;

                case "Integer":
                    return Integer.parseInt(s);

                case "Double":
                    return Double.parseDouble(s);
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public void openMenuElement(String name) {
        for (int i = 0; i < menuElements.length; i++) {
            if (menuElements[i].getName().equals(name)) {
                menuElements[i].onOpen.apply(null);
                return;
            }
        }
    }
}
