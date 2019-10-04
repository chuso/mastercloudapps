package mastermindWeek2.views.console;

import mastermindWeek2.models.Color;
import mastermindWeek2.utils.IO;

public class ColorView {

    private final Color color;

    ColorView(Color color) {
        this.color = color;
    }

    public void write() {
        IO.write(String.valueOf(color.getInitial()));
    }

}
