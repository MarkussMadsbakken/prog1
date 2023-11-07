package prog.ov11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * En klasse som representerer en meny
 */

public class Menu {
    ArrayList<MenuElement> menuElements = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    private boolean run = true;

    /**
     * Konstruktør for Menu.
     * 
     * Legger til et avslutt-element
     */

    Menu() {
        menuElements.add(new MenuElement("Avslutt", (Void) -> {
            System.out.println("Avslutter");
            run = false;
            return null;
        }));
    }

    /**
     * Starter menyen
     */

    public void start() {
        while (run) {
            printMenu();
            Integer a = (Integer) getInput(new Integer(0));
            if (a != null && a < menuElements.size() && a >= 0) {
                openMenuElement((Integer) a);
            }

            if (run) {
                System.out.print("Enter for å gå tilbake");
                scanner.nextLine();
                System.out.println(" ");
            }

        }
    }

    /**
     * Metode for å legge til et menyelement
     * 
     * @param menuElement
     */

    public void addMenuElement(MenuElement menuElement) {
        menuElements.add(menuElement);
    }

    /**
     * Metode for å skrive ut menyen
     */

    public void printMenu() {
        for (int i = 0; i < menuElements.size(); i++) {
            System.out.println(i + ": " + menuElements.get(i).getName());
        }
    }

    /**
     * Metode for å åpne et menyelement
     * 
     * @param index
     */

    public void openMenuElement(int index) {
        menuElements.get(index).onOpen.apply(null);
    }

    /**
     * Metode for å hente input fra brukeren
     * 
     * @param o objekt som representerer typen input som skal hentes
     * @return Objekt med type speisifisert i parameteret
     */

    public Object getInput(Object o) {

        while (true) {

            String s = scanner.nextLine();

            try {
                switch (o.getClass().getSimpleName()) {
                    case "String":
                        return s;

                    case "Integer":
                        return Integer.parseInt(s);

                    case "Double":
                        return Double.parseDouble(s);

                    case "Long":
                        return Long.parseLong(s);
                }

            } catch (Exception e) {
            }
        }
    }

    /**
     * Metode for å åpne et menyelement ved navn
     * 
     * @param name
     */

    public void openMenuElement(String name) {
        for (int i = 0; i < menuElements.size(); i++) {
            if (menuElements.get(i).getName().equals(name)) {
                menuElements.get(i).onOpen.apply(null);
                return;
            }
        }
    }
}
