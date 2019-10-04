package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.State;
import mastermindWeek2.models.Result;
import mastermindWeek2.models.ProposedCombination;

public class ProposeController extends Controller {

    public ProposeController(Game game, State state) {
        super(game, state);
    }

    public void propose(ProposedCombination proposedCombination) {
        this.game.proposeCombination(proposedCombination);
        if (this.game.isFinished()) {
            this.state.next();
        }
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

    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
