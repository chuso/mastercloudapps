package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.StartController;

class NewGameCommand extends Command {

    protected NewGameCommand(StartController startController) {
        super(CommandTitle.NEWGAME_COMMAND.getTitle(), startController);
    }

    @Override
    protected void execute() {
        ((StartController) this.acceptorController).start();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}