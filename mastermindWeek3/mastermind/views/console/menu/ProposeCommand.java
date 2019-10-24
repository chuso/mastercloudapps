package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.santaTecla.utils.Console;
import mastermindWeek3.mastermind.views.ErrorView;

public class ProposeCommand extends Command {

    public ProposeCommand(PlayController playController) {
        super(CommandTitle.PROPOSE_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        Error error;
        do {
            error = this.playController.addProposedCombination(
                new CombinationReader().read()
            );
            if (error != null) {
                new Console().writeln(ErrorView.MESSAGES[error.ordinal()]);
            }
        } while (error != null);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
