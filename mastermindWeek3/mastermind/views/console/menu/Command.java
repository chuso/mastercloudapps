package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.PlayController;

public abstract class Command extends mastermindWeek3.santaTecla.utils.Command {

    protected PlayController playController;

    protected Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }

}
