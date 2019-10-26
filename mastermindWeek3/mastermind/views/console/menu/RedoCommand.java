package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.PlayController;

public class RedoCommand extends Command {

    public RedoCommand(PlayController playController) {
        super(CommandTitle.REDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).redo();
    }

    @Override
    public boolean isActive() {
        return ((PlayController) this.acceptorController).redoable();
    }
}
