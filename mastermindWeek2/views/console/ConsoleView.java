package mastermindWeek2.views.console;

import mastermindWeek2.models.Game;
import mastermindWeek2.models.Error;
import mastermindWeek2.utils.YesNoDialog;
import mastermindWeek2.utils.IO;
import mastermindWeek2.views.View;

public class ConsoleView extends View {

    public ConsoleView(Game game) {
        super(game);
    }

    @Override
    protected void start() {
        Message.TITLE.writeln();
        new SecretCombinationView(game.getSecretCombination()).writeln();
    }

    @Override
    protected void move() {
        Error error;
        do {
            Message.PROPOSED_COMBINATION.write();
            error = this.game.proposeCombination(IO.readString());
            if (error != null) {
                IO.writeln(error.getMessage());
            }
        } while (error != null);
        new GameView(this.game).writeln();
    }

    @Override
    protected boolean resume() {
        Message.RESUME.write();
        return new YesNoDialog().read();
    }

}
