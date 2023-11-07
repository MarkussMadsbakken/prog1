package prog.ov11;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Klasse som representerer et menyElement
 */

public class MenuElement {
    private String name;
    public Function<Void, Void> onOpen;

    /**
     * Konstruktør for MenuElement
     * 
     * @param name   Navnet på menyelementet
     * @param onOpen Funksjonen som kjøres når menyelementet åpnes
     */

    public MenuElement(String name, UnaryOperator<Void> onOpen) {
        this.name = name;
        this.onOpen = onOpen;
    }

    /**
     * Henter navnet på menyelementet
     * 
     * @return navn
     */

    public String getName() {
        return name;
    }
}
