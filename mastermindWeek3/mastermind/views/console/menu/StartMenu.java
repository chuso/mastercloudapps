package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.santaTecla.utils.Menu;

public class StartMenu extends Menu {

    public StartMenu(StartController startController) {
        this.addCommand(new NewGameCommand(startController));
        this.addCommand(new OpenGameCommand(startController));
    }
}
