package mastermindWeek2.views.console;

import mastermindWeek2.controllers.Controller;
import mastermindWeek2.controllers.ProposeController;
import mastermindWeek2.controllers.ResumeController;
import mastermindWeek2.controllers.StartController;
import mastermindWeek2.utils.YesNoDialog;
import mastermindWeek2.views.View;

public class ConsoleView extends View {

    public void interact(Controller controller) {
        if (controller instanceof StartController) {
            this.start((StartController) controller);
        } else if (controller instanceof ProposeController) {
            this.propose((ProposeController) controller);
        } else {
            this.resume((ResumeController) controller);
        }
    }

    private void start(StartController startController) {
        startController.start();
        Message.TITLE.writeln();
        new SecretCombinationView(startController).writeln();
    }

    private void propose(ProposeController proposeController) {
        proposeController.propose(ProposedCombinationReader.read());
        new GameView(proposeController).writeln();
    }

    private void resume(ResumeController resumeController) {
        Message.RESUME.write();
        resumeController.resume(new YesNoDialog().read());
    }

}
