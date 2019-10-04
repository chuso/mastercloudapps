package mastermindWeek2.controllers;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.SecretCombination;
import mastermindWeek2.models.ProposedCombination;
import mastermindWeek2.models.Result;

public class Logic {

    private Game game;

    private StartController startController;

    private ProposeController proposeController;

    private ResumeController resumeController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.proposeController = new ProposeController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public SecretCombination getSecretCombination() {
        return startController.getSecretCombination();
    }

    public void propose(ProposedCombination proposedCombination) {
        proposeController.propose(proposedCombination);
    }

    public ProposedCombination getProposedCombination(int i) {
        return proposeController.getProposedCombination(i);
    }

    public Result getResult(int i) {
        return proposeController.getResult(i);
    }

    public boolean isWinner() {
        return proposeController.isWinner();
    }

    public boolean isLoser() {
        return proposeController.isLoser();
    }

    public int getAttempts() {
        return proposeController.getAttempts();
    }

    public boolean isGameFinished() {
        return proposeController.isGameFinished();
    }

    public void resume() {
        resumeController.resume();
    }

}
