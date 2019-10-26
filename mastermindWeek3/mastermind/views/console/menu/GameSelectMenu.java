package mastermindWeek3.mastermind.views.console.menu;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.santaTecla.utils.Menu;

class GameSelectMenu extends Menu {

    GameSelectMenu(StartController startController) {
        String[] gamesNames = startController.getGamesNames();
        for (String title : gamesNames) {
            this.addCommand(new GameSelectCommand(title, startController));
        }
    }

}
