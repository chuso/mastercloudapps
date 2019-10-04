package mastermindWeek2.models;

import java.util.List;
import java.util.ArrayList;

public class Game {

    private static final int MAX_LONG = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public Game() {
	    this.clear();
    }

    public boolean isFinished() {
        if (isWinner()) {
            return true;
        }
        if (isLoser()) {
            return true;
        }
        return false;
    }

    public boolean isWinner() {
        return this.results.get(this.getAttempts() - 1).isWinner();
    }

    public boolean isLoser() {
        return this.getAttempts() == Game.MAX_LONG;
    }

    public void proposeCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
    }

    public int getAttempts() {
        return proposedCombinations.size();
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public ProposedCombination getProposedCombination(int i) {
        return proposedCombinations.get(i);
    }

    public Result getResult(int i) {
        return results.get(i);
    }

}
