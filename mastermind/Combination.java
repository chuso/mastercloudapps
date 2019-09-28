package mastermind;

abstract class Combination {

    private Color[] colors;

    public Combination() {
        colors = new Color[4];
    }

    protected void setColor(int position, Color color) {
        colors[position] = color;
    }

    protected Color[] getColors() {
        return colors;
    }

}
