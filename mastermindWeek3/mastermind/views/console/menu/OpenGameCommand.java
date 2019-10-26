package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.StartController;

class OpenGameCommand extends Command {

    protected OpenGameCommand(StartController startController) {
        super(CommandTitle.OPENGAME_COMMAND.getTitle(), startController);
    }

    @Override
    protected void execute() {
        new GameSelectMenu((StartController) this.acceptorController).execute();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
