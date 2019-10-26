package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.AcceptorController;

public abstract class Command extends mastermindWeek3.santaTecla.utils.Command {

    protected AcceptorController acceptorController;

    protected Command(String title, AcceptorController acceptorController) {
        super(title);
        this.acceptorController = acceptorController;
    }

}
