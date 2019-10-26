package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.PlayController;

public class UndoCommand extends Command {

    public UndoCommand(PlayController playController) {
        super(CommandTitle.UNDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).undo();
    }

    @Override
    public boolean isActive() {
        return ((PlayController) this.acceptorController).undoable();
    }
}
