package prog.ov10;

import java.util.Scanner;

public class Menu {
    MenuElement[] menuElements = new MenuElement[5];
    Scanner scanner = new Scanner(System.in);

    ArrangementRegister register = new ArrangementRegister();

    private boolean run = true;

    Menu(){
         menuElements[0] = new MenuElement("Avslutt", (Void) ->{
            System.out.println("Avslutter");
            run = false;
            return null;
        });
    }

    public void start(){
        while(run){
            printMenu();
            Integer a = (Integer)getInput(new Integer(0));
            if(a != null && a < menuElements.length && a >= 0){
                openMenuElement((Integer)a);
            }

            if(run){
                System.out.print("Enter for å gå tilbake");
                scanner.nextLine();
                System.out.println(" ");
            }

        }
    }

    public void addMenuElement(MenuElement menuElement){
        for (int i = 0; i < menuElements.length; i++) {
            if(menuElements[i] == null){
                menuElements[i] = menuElement;
                return;
            }
        }
    }

    public void printMenu(){
        for (int i = 0; i < menuElements.length; i++) {
            System.out.println(i + ": " + menuElements[i].getName());
        }
    }

    public void openMenuElement(int index){
        menuElements[index].onOpen.apply(null);
    }

    public Object getInput(Object o) throws IllegalArgumentException{
        String s = scanner.nextLine();

        try{    
            switch(o.getClass().getSimpleName()){
                case "String":
                    return s;

                case "Integer":
                    return Integer.parseInt(s);

                case "Double":
                    return Double.parseDouble(s);
                
                case "Long":
                    return Long.parseLong(s);
            }

        } catch(Exception e){
            return null;
        }

        return null;
    }

    public void openMenuElement(String name){
        for (int i = 0; i < menuElements.length; i++) {
            if (menuElements[i].getName().equals(name)){
                menuElements[i].onOpen.apply(null);
                return;
            }
        }
    }
}
