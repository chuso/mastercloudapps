package mastermindWeek2.views.console;

import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.utils.IO;

public class GameView {

    private final ProposeController proposeController;

    public GameView(ProposeController proposeController) {
        this.proposeController = proposeController;
    }

    public void writeln() {
        IO.writeln();
        Message.ATTEMPTS.writeln(proposeController.getAttempts());

        new SecretCombinationView(proposeController).writeln();
        for (int i = 0; i < proposeController.getAttempts(); i++) {
            new ProposedCombinationView(proposeController, i).write();
            new ResultView(proposeController, i).writeln();
        }
        if (proposeController.isWinner()) {
            Message.WINNER.writeln();
        }
        if (proposeController.isLoser()) {
            Message.LOOSER.writeln();
        }
    }
}
