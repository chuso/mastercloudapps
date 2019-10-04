package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.Result;
import mastermindWeek2.models.ProposedCombination;

public class ProposeController extends Controller {

    public ProposeController(Game game) {
        super(game);
    }

    public void propose(ProposedCombination proposedCombination) {
        this.game.proposeCombination(proposedCombination);
    }

    public ProposedCombination getProposedCombination(int i) {
        return game.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return game.getResult(i);
    }

    public boolean isWinner() {
        return game.isWinner();
    }

    public boolean isLoser() {
        return game.isLoser();
    }

    public int getAttempts() {
        return game.getAttempts();
    }

    public boolean isGameFinished() {
        return this.game.isFinished();
    }

}
