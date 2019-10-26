package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;
import mastermindWeek3.mastermind.views.console.menu.StartMenu;

class StartView extends WithConsoleView {

	void interact(StartController startController) {
		new StartMenu(startController).execute();
		this.console.writeln(MessageView.TITLE.getMessage());

		if (startController.getAttempts() == 0) {
			new SecretCombinationView(startController).writeln();
		} else {
			new ProposalView(startController).writeln();
		}
	}

}
