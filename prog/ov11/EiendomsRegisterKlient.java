package prog.ov11;

/**
 * Klient-klasse for EiendomsRegisteret
 */

public class EiendomsRegisterKlient {
    Menu meny = new Menu();
    EiendomsRegister register = new EiendomsRegister();

    /**
     * Konstruktør for EiendomsRegisterKlient
     * 
     * Legger til menyelementer
     */

    public EiendomsRegisterKlient() {
        meny.addMenuElement(new MenuElement("Legg til eiendom", v -> {
            System.out.println("Legg til eiendom");

            System.out.print("Kommunenummer: ");
            int komnr = (int) meny.getInput(new Integer(0));

            System.out.print("Kommunenavn: ");
            String komnavn = (String) meny.getInput(new String());

            System.out.print("Gårdsnummer: ");
            int gnr = (int) meny.getInput(new Integer(0));

            System.out.print("Bruksnummer: ");
            int brn = (int) meny.getInput(new Integer(0));

            System.out.print("Bruksnavn: ");
            String brnvn = (String) meny.getInput(new String());

            System.out.print("Areal: ");
            double areal = (double) meny.getInput(new Double(0));

            System.out.print("Eier: ");
            String eier = (String) meny.getInput(new String());

            register.addEiendom(new Eiendom(komnr, komnavn, gnr, brn, brnvn, areal, eier));
            return null;
        }));

        meny.addMenuElement(new MenuElement("Skriv ut alle eiendommer", v -> {
            Eiendom[] eiendommer = register.getEiendommer();

            for (Eiendom eiendom : eiendommer) {
                System.out.println(eiendom);
            }

            return null;
        }));

        meny.addMenuElement(new MenuElement("Søk", v -> {

            System.out.print("Skriv inn komnr-gnr/brn: ");
            String i = (String) meny.getInput(new String());

            Eiendom eiendom = register.getEiendomFromID(i);

            if (eiendom != null) {
                System.out.println("Eiendom funnet:");
                System.out.println(eiendom);
                return null;
            }

            System.out.println("Fant ikke eiendom");
            return null;

        }));

        meny.addMenuElement(new MenuElement("Beregn gjennomsnittsareal", v -> {
            System.out.println("Gjennomsnittsareal: " + register.getSnittAreal());
            return null;
        }));
    }

    /**
     * Starter klienten
     */

    void start() {
        register.addEiendom(new Eiendom(1445, "Gloppen", 77, 631, 1017.6, "Jens Olsen"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Jens Olsen"));
        meny.start();
    }
}
