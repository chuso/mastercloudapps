package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Logic;
import mastermindWeek2.utils.IO;

public class GameView {

    private final Logic logic;

    public GameView(Logic logic) {
        this.logic = logic;
    }

    public void writeln() {
        IO.writeln();
        Message.ATTEMPTS.writeln(logic.getAttempts());

        new SecretCombinationView(logic).writeln();
        for (int i = 0; i < logic.getAttempts(); i++) {
            new ProposedCombinationView(logic, i).write();
            new ResultView(logic, i).writeln();
        }
        if (logic.isWinner()) {
            Message.WINNER.writeln();
        }
        if (logic.isLoser()) {
            Message.LOOSER.writeln();
        }
    }
}
