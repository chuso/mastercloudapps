package mastermind;

public class CodeMaker {

    private SecretCombination secretCombination;
    private CodeBreaker codeBreaker;

    public CodeMaker(CodeBreaker codeBreaker) {
        this.codeBreaker = codeBreaker;
    }

    public void prepare() {
        this.secretCombination = new SecretCombination();
    }

    public void answer() {
        secretCombination.calculateResult(codeBreaker.getLastProposedCombination());
    }

    public void write() {
        secretCombination.write();
    }

}
