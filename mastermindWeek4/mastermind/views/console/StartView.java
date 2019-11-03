package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	void interact(StartController startController) {
		startController.start();
		this.print(startController.getWidth());
	}

	public void print(int combinationWidth) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new SecretCombinationView().writeln(combinationWidth);
	}

}
