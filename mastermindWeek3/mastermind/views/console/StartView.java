package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;
import mastermindWeek3.mastermind.views.console.menu.StartMenu;

class StartView extends WithConsoleView {

	private SecretCombinationView secretCombinationView;

	void interact(StartController startController) {
		new StartMenu(startController).execute();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
