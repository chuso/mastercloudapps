package mastermind;

enum Color {

    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    ORANGE('o'),
    PURPLE('p');

    private char letter;

    private Color(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public static Color fromLetter(char letter) throws IllegalArgumentException {
        String validLetters = "";
        for (Color color : Color.values()) {
            if (color.getLetter() == letter) {
                return color;
            }
            validLetters = validLetters.concat(
                Character.toString(color.getLetter())
            );
        }
        throw new IllegalArgumentException(
            "Wrong colors, they must be: " + validLetters
        );
    }

}
