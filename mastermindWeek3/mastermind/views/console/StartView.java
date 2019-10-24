package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.StartController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		startController.start();
		this.console.writeln(MessageView.TITLE.getMessage());
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
	}

}
