package prog.ov10;

import java.util.function.UnaryOperator;

public class MenuElement {
    private String name;
    public UnaryOperator<Void> onOpen;

    public MenuElement(String name, UnaryOperator<Void> onOpen) {
        this.name = name;
        this.onOpen = onOpen;
    }

    public String getName() {
        return name;
    }
}
