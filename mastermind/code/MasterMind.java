package mastermind.code;

public class MasterMind {

    private CodeBreaker codeBreaker;
    private CodeMaker codeMaker;

    public static void main(String[] args) {
        (new MasterMind()).play();
    }

    public MasterMind() {
        codeBreaker = new CodeBreaker();
        codeMaker = new CodeMaker(codeBreaker);
    }

    public void play() {
        do {
            playGame();
        } while (!codeBreaker.isFinished());
    }

    private void playGame() {
        prepareGame();
        do {
            playGameAttempt();
        } while (!isGameFinished());
        printGameResult();
    }

    private void prepareGame() {
        codeMaker.prepare();
        codeBreaker.prepare();
        System.out.println("----- MASTERMIND -----");
        codeMaker.write();
    }

    private void playGameAttempt() {
        codeBreaker.propose();
        codeMaker.answer();
        codeBreaker.writeAttempts();
        codeMaker.write();
        codeBreaker.writeProposedCombinations();
    }

    private boolean isGameFinished() {
        return codeBreaker.isWinner() || codeBreaker.isLoser();
    }

    private void printGameResult() {
        if (codeBreaker.isWinner()) {
            System.out.println("You've won!!! ;-)");
        } else {
            System.out.println("You've lost!!! :-(");
        }
    }
}
