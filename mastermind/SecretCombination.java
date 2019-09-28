package mastermind;

public class SecretCombination extends Combination {

    public SecretCombination() {
        super();
        for (int i = 0; i < 4; i++) {
            setColor(i, getRandomColorNotRepeated());
        }
    }

    public void calculateResult(ProposedCombination proposedCombination) {
        int deads = 0;
        int damaged = 0;
        for (int i = 0; i < getColors().length; i++) {
            if (proposedCombination.contains(getColors()[i], i)) {
                deads++;
            } else if (proposedCombination.contains(getColors()[i])) {
                damaged++;
            }
        }
        proposedCombination.setResult(new Result(deads, damaged));
    }

    public void write() {
        System.out.println("****");
    }

    private Color getRandomColorNotRepeated() {
        Color randomColor;
        do {
            randomColor = Color.getRandomColor();
        } while (contains(randomColor));
        return randomColor;
    }

}
