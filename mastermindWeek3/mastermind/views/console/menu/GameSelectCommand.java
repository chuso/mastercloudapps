package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.santaTecla.utils.Console;

class GameSelectCommand extends Command {

    Console console;

    protected GameSelectCommand(String title, StartController startController) {
        super(title, startController);
        this.console = new Console();
    }

    @Override
    protected void execute() {
        console.writeln(this.title);
        ((StartController) this.acceptorController).start(this.title);
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
