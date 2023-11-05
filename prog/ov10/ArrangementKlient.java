package prog.ov10;

public class ArrangementKlient {
    private Menu menu;
    private ArrangementRegister oversikt = new ArrangementRegister();

    public ArrangementKlient() {
        menu = new Menu();

        menu.addMenuElement(new MenuElement("Skriv ut arrangementer", v -> {
            oversikt.printArrangementer();
            return null;
        }));

        menu.addMenuElement(new MenuElement("Legg til arrangement", v -> {
            System.out.println("Legg til arrangement");
            System.out.print("Navn: ");
            String navn = (String) menu.getInput(new String());

            System.out.print("Sted: ");
            String sted = (String) menu.getInput(new String());

            System.out.print("Arrangor: ");
            String arrangor = (String) menu.getInput(new String());

            System.out.print("Tidspunkt: ");
            Long dato = (Long) menu.getInput(new Long(0));

            System.out.println("Type: ");
            for(int i = 0; i < Arrangement.Type.values().length; i++){
                System.out.println(i + ": " + Arrangement.Type.values()[i]);
            }
            
            int type = (int) menu.getInput(new Integer(0));
            
            oversikt.addArrangement(new Arrangement(navn, sted, arrangor, Arrangement.Type.values()[type] ,dato));
            return null;
        }));
        
        menu.addMenuElement( new MenuElement("Finn arrangement ved sted", v -> {
            System.out.println("Sted: ");
            oversikt.printArrangementerVedSted((String) menu.getInput(new String()));
            return null;
        }));

        menu.addMenuElement(new MenuElement("Finn arrangement ved dato", v -> {
            System.out.print("Dato: ");
            oversikt.printArrangementerVedDato((Long) menu.getInput(new Long(0)));
            return null;
        }));

        menu.addMenuElement(new MenuElement("Finn arragementer mellom datoer", v -> {
            System.out.print("Dato 1: ");
            Long dato1 = (Long) menu.getInput(new Long(0));
            System.out.print("Dato 2: ");
            Long dato2 = (Long) menu.getInput(new Long(0));

            oversikt.printArrangementerMellomDatoer(dato1, dato2);
            return null;
        }));

        menu.addMenuElement(new MenuElement("Skriv ut arrangementer sortert", v -> {
            System.out.println("Sorter etter: ");
            System.out.println("0: Tidspunkt");
            System.out.println("1: Sted");
            System.out.println("2: Type");

            int i = (int) menu.getInput(new Integer(0));
            switch(i){
                case 0:
                    oversikt.sorter(ArrangementRegister.SorteringsType.TIDSPUNKT);
                    break;
                case 1:
                    oversikt.sorter(ArrangementRegister.SorteringsType.STED);
                    break;
                case 2:
                    oversikt.sorter(ArrangementRegister.SorteringsType.TYPE);
                    break;
            }
            oversikt.printArrangementer();
            return null;
        }));
    }

    public void start(){
        oversikt.addArrangement(new Arrangement("Konsert", "Oslo", "Konsert AS", Arrangement.Type.KONSERT, 201712121200L));
        oversikt.addArrangement(new Arrangement("Foredrag", "Oslo", "Foredrag AS", Arrangement.Type.FOREDRAG, 201712301200L));
        oversikt.addArrangement(new Arrangement("Barneteater", "Oslo", "Barneteater AS", Arrangement.Type.BARNETEATER, 201312311200L));
        menu.start();
    }

}
