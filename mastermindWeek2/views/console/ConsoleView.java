package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Logic;
import mastermindWeek2.utils.YesNoDialog;
import mastermindWeek2.views.View;

public class ConsoleView extends View {

    public ConsoleView(Logic logic) {
        super(logic);
    }

    @Override
    protected void start() {
        Message.TITLE.writeln();
        new SecretCombinationView(logic).writeln();
    }

    @Override
    protected void move() {
        logic.propose(ProposedCombinationReader.read());
        new GameView(logic).writeln();
    }

    @Override
    protected boolean resume() {
        Message.RESUME.write();
        return new YesNoDialog().read();
    }

}
