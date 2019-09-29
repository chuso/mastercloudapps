package mastermind.code;

import java.util.Arrays;

abstract class Combination {

    protected static final int SIZE = 4;

    private Color[] colors;

    public Combination() {
        colors = new Color[Combination.SIZE];
    }

    protected boolean contains(Color color) {
        return Arrays.asList(getColors()).contains(color);
    }

    protected void setColor(int position, Color color) {
        colors[position] = color;
    }

    protected Color[] getColors() {
        return colors;
    }

}
