package mastermindWeek2.views.console;

import mastermindWeek2.models.Game;
import mastermindWeek2.utils.IO;

public class GameView {

    private final Game game;

    public GameView(Game game) {
        this.game = game;    }

    public void writeln() {
        IO.writeln();
        Message.ATTEMPTS.writeln(game.getAttemps());

        new SecretCombinationView(game.getSecretCombination()).writeln();
        for (int i = 0; i < game.getAttemps(); i++) {
            new ProposedCombinationView(game.getProposedCombination(i)).write();
            new ResultView(game.getResult(i)).writeln();
        }
        if (game.isWinner()) {
            Message.WINNER.writeln();
        }
        if (game.isLoser()) {
            Message.LOOSER.writeln();
        }
    }
}
