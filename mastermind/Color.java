package mastermind;

import java.util.Random;

enum Color {

    RED('r', 1),
    BLUE('b', 2),
    YELLOW('y', 3),
    GREEN('g', 4),
    ORANGE('o', 5),
    PURPLE('p', 6);

    private char letter;
    private int number;

    private Color(char letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    private char getLetter() {
        return letter;
    }

    private int getNumber() {
        return number;
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

    public static Color getRandomColor() {
        Random random = new Random();
        int position = random.nextInt(6) + 1;
        return Color.fromNumber(position);
    }

    private static Color fromNumber(int number) {
        for (Color color : Color.values()) {
            if (color.getNumber() == number) {
                return color;
            }
        }
        throw new IllegalArgumentException("Invalid number: " + number);
    }

}
