package mastermindWeek2.views.console;

import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.controllers.ResumeController;
import mastermindWeek2.controllers.StartController;
import mastermindWeek2.utils.YesNoDialog;
import mastermindWeek2.views.View;

public class ConsoleView extends View {

    public ConsoleView(ProposeController proposeController, ResumeController resumeController, StartController startController) {
        super(proposeController, resumeController, startController);
    }

    @Override
    protected void start() {
        Message.TITLE.writeln();
        new SecretCombinationView(this.startController).writeln();
    }

    @Override
    protected void move() {
        proposeController.propose(ProposedCombinationReader.read());
        new GameView(this.proposeController).writeln();
    }

    @Override
    protected boolean resume() {
        Message.RESUME.write();
        return new YesNoDialog().read();
    }

}
