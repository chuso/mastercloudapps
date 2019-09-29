package mastermind.code;

public class CodeBreaker {

    private static final int MAX_ATTEMPTS = 10;

    private ProposedCombination[] attempts;
    private int numberOfAttempts;

    public void start() {
        this.attempts = new ProposedCombination[CodeBreaker.MAX_ATTEMPTS];
        numberOfAttempts = 0;
    }

    public void propose() {
        attempts[numberOfAttempts] = new ProposedCombination();
        attempts[numberOfAttempts].read();
        numberOfAttempts++;
    }

    public ProposedCombination getLastProposedCombination() {
        return attempts[numberOfAttempts-1];
    }

    public void writeAttempts() {
        System.out.println(numberOfAttempts + " attempt(s):");
    }

    public void writeProposedCombinations() {
        for (int i = 0; i < numberOfAttempts; i++) {
            attempts[i].write();
        }
    }

    public boolean isWinner() {
        return getLastProposedCombination().isWinner();
    }

    public boolean isLoser() {
        return numberOfAttempts == CodeBreaker.MAX_ATTEMPTS;
    }

    public boolean isResumed() {
        String continueAnswer;
        do {
            System.out.print("Do you want to continue? (y/n): ");
            continueAnswer = System.console().readLine();
        } while (!continueAnswer.matches("[yn]"));
        return continueAnswer.equals("y");
    }

}
