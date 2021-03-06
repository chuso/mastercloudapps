package mastermind.code;

import java.util.Arrays;

public class ProposedCombination extends Combination {

    private Result result;

    public void read() {
        char[] combinationChars = readString().toCharArray();
        for (int i = 0; i < combinationChars.length; i++) {
            setColor(i, Color.fromLetter(combinationChars[i]));
        }
    }

    public boolean contains(Color color, int position) {
        return getColors()[position] == color;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isWinner() {
        return result.isWinner();
    }

    public void write() {
        for (int i = 0; i < getColors().length; i++) {
            getColors()[i].write();
        }
        System.out.print(" --> ");
        this.result.write();
    }

    private String readString() {
        Validator validator = new Validator(Combination.SIZE);
        do {
            System.out.print("Propose a combination: ");
            String combinationString = System.console().readLine();
            try {
                validator.check(combinationString);
                return combinationString;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while(true);
    }

    // TODO: replace this Validator with Notification: https://www.martinfowler.com/articles/replaceThrowWithNotification.html
    class Validator {

        private int combinationSize;

        public Validator(int combinationSize) {
            this.combinationSize = combinationSize;
        }

        public void check(String combination) throws IllegalArgumentException {
            if (!checkValidColors(combination)) {
                throw buildInvalidArgumentException("Wrong colors, they must be: rbygop");
            } else if (!checkNonRepeatedColors(combination)) {
                throw buildInvalidArgumentException("Repeated colors");
            } else if (!checkLength(combination)) {
                throw buildInvalidArgumentException("Wrong proposed combination length");
            }
        }

        private boolean checkValidColors(String combination) {
            return combination.matches("[rbygop]+");
        }

        private boolean checkNonRepeatedColors(String combination) {
            char[] characters = combination.toCharArray();
            Arrays.sort(characters);
            String sortedString = new String(characters);
            return !sortedString.matches(".*(\\w)\\1+.*");
        }

        private boolean checkLength(String combination) {
            return combination.length() == combinationSize;
        }

        private IllegalArgumentException buildInvalidArgumentException(String message) {
            return new IllegalArgumentException(message);
        }

    }

}
