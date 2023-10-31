package prog.ov9;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MenuElement {
    private String name;
    public Function<Void, Void> onOpen;

    public MenuElement(String name, UnaryOperator<Void> onOpen) {
        this.name = name;
        this.onOpen = onOpen;
    }

    public String getName() {
        return name;
    }
}
