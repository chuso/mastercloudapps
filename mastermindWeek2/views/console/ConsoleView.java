package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Controller;
import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.controllers.ResumeController;
import mastermindWeek2.controllers.StartController;
import mastermindWeek2.utils.YesNoDialog;
import mastermindWeek2.views.View;

public class ConsoleView extends View {

    public void interact(Controller controller) {
        controller.accept(this);
    }

    public void visit(ProposeController proposeController) {
        proposeController.propose(ProposedCombinationReader.read());
        new GameView(proposeController).writeln();
    }

    public void visit(ResumeController resumeController) {
        Message.RESUME.write();
        resumeController.resume(new YesNoDialog().read());
    }

    public void visit(StartController startController) {
        startController.start();
        Message.TITLE.writeln();
        new SecretCombinationView(startController).writeln();
    }

}
