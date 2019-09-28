package mastermind;

import java.util.Arrays;

abstract class Combination {

    private Color[] colors;

    public Combination() {
        colors = new Color[4];
    }

    public boolean contains(Color color) {
        return Arrays.asList(getColors()).contains(color);
    }

    protected void setColor(int position, Color color) {
        colors[position] = color;
    }

    protected Color[] getColors() {
        return colors;
    }

}
