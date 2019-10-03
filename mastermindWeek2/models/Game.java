package mastermindWeek2.models;

import java.util.List;
import java.util.ArrayList;
import mastermindWeek2.utils.WithConsoleModel;
import mastermindWeek2.utils.YesNoDialog;

public class Game extends WithConsoleModel {

    private static final int MAX_LONG = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public Game() {
	    this.clear();
    }

    public void play() {
        do {
            Message.TITLE.writeln();
            this.secretCombination.writeln();
            do {
                ProposedCombination proposedCombination = new ProposedCombination();
                proposedCombination.read();
                this.proposedCombinations.add(proposedCombination);
                this.results.add(this.secretCombination.getResult(proposedCombination));
                this.writeln();
            } while (!isFinished());
        } while (this.isResumed());
    }

    public boolean isFinished() {
        if (this.results.get(this.getAttemps() - 1).isWinner()) {
            Message.WINNER.writeln();
            return true;
        }
        if (this.getAttemps() == Game.MAX_LONG) {
            Message.LOOSER.writeln();
            return true;
        }
        return false;
    }
    
    public boolean isResumed() {
        boolean resumed;
        Message.RESUME.write();
        resumed = new YesNoDialog().read();
        if (resumed) {
            this.clear();
        }
        return resumed;
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
    }

    private void writeln() {
        this.console.writeln();
        Message.ATTEMPTS.writeln(this.getAttemps());
        this.secretCombination.writeln();
        for (int i = 0; i < this.getAttemps(); i++) {
            this.proposedCombinations.get(i).write();
            this.results.get(i).writeln();
        }
    }

    private int getAttemps() {
    return this.proposedCombinations.size();
    }

}
