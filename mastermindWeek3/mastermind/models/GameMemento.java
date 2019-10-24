package mastermindWeek3.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermindWeek3.santaTecla.utils.Memento;

public class GameMemento extends Memento {

    private SecretCombination secretCombination;

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attempts;

    public GameMemento() {
        this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
    }

    public void setSecretCombination(SecretCombination secretCombination) {
        this.secretCombination = secretCombination;
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public ProposedCombination getProposedCombination(int index) {
        return this.proposedCombinations.get(index);
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public Result getResult(int index) {
        return this.results.get(index);
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return this.attempts;
    }


}
