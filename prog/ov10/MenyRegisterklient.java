package prog.ov10;

import java.util.ArrayList;

public class MenyRegisterklient {
    private Menu menu;
    private MenyRegister menyRegister;

    public MenyRegisterklient() {
        menyRegister = new MenyRegister();
        menu = new Menu();
        menu.addMenuElement(new MenuElement("Vis alle menyer", v -> {
            menyRegister.printAlleMenyer();
            return null;
        }));

        menu.addMenuElement(new MenuElement("Vis alle retter", v -> {
            menyRegister.printAlleRetter();
            return null;
        }));

        menu.addMenuElement(new MenuElement("Legg til rett", v -> {
            System.out.print("Navn: ");
            String navn = (String) menu.getInput(new String());

            System.out.print("Type: ");
            String type = (String) menu.getInput(new String());

            System.out.print("Pris: ");
            int pris = (int) menu.getInput(new Integer(0));

            System.out.print("Oppskrift: ");
            String oppskrift = (String) menu.getInput(new String());

            menyRegister.addRett(new Rett(navn, type, pris, oppskrift));
            return null;
        }));

        menu.addMenuElement(new MenuElement("Finn retter fra type", v -> {
            System.out.print("Type: ");
            String type = (String) menu.getInput(new String());

            Rett[] retter = menyRegister.finnRetterFraType(type);

            if (retter != null) {
                for (Rett rett : retter) {
                    System.out.println(rett);
                }
                return null;
            }

            System.out.println("Fant ingen retter");
            return null;
        }));

        menu.addMenuElement(new MenuElement("Finn rett fra navn", v -> {
            System.out.print("Navn: ");
            String navn = (String) menu.getInput(new String());

            Rett rett = menyRegister.finnRettFraNavn(navn);

            if (rett != null) {
                System.out.println(rett);
                return null;
            }

            System.out.println("Fant ingen retter");
            return null;
        }));

        menu.addMenuElement(new MenuElement("Finn menyer innenfor prisintervall", v -> {

            System.out.print("Nedre grense: ");
            int nedre = (int) menu.getInput(new Integer(0));

            System.out.print("Øvre grense: ");
            int ovre = (int) menu.getInput(new Integer(0));

            Meny[] menyer = menyRegister.finnMenyerInnenforPrisintervall(nedre, ovre);

            if (menyer.length == 0) {
                System.out.println("Fant ingen menyer");
                return null;
            }

            for (Meny meny : menyer) {
                System.out.println(meny);
            }
            return null;
        }));

        menu.addMenuElement(new MenuElement("Legg til meny", v -> {

            System.out.print("Navn: ");
            String navn = (String) menu.getInput(new String());

            ArrayList<Rett> retter = new ArrayList<>();

            while (true) {
                System.out.println("Velg rett");
                System.out.println("0: Legg til rett");
                menyRegister.printAlleRetterMedIndex();

                int i = (int) menu.getInput(new Integer(0));
                if (i == 0) {
                    break;
                }

                if (i > menyRegister.getRetter().length || i < 0) {
                    System.out.println("Ugyldig index");
                    continue;
                }
                retter.add(menyRegister.getRetter()[i - 1]);
            }

            if (retter.size() == 0) {
                System.out.println("Ingen retter valgt");
                return null;
            }
            menyRegister.addMeny(retter.toArray(new Rett[retter.size()]), navn);
            System.out.println("Rett lagt til");

            return null;
        }));
    }

    public void init() {
        menyRegister.addRett(new Rett("Pizza", "Hovedrett", 100, "Stek pizza"));
        menyRegister.addRett(new Rett("Pasta", "Hovedrett", 88, "Kok pasta"));
        menyRegister.addRett(new Rett("Kake", "Dessert", 50, "Bak kake"));
        menyRegister.addRett(new Rett("Is", "Dessert", 30, "Frys is"));
        menyRegister.addRett(new Rett("Brus", "Drikke", 20, "Åpne brus"));
        menyRegister.addRett(new Rett("Vann", "Drikke", 10, "Fyll vann"));

        menyRegister.addMeny(
                new Rett[] { menyRegister.getRetter()[0], menyRegister.getRetter()[1], menyRegister.getRetter()[2] },
                "Middag");
    }

    public void start() {
        menu.start();
    }
}
