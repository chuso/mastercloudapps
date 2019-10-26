package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private AcceptorController acceptorController;

	AttemptsView(AcceptorController proposalController) {
		this.acceptorController = proposalController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.acceptorController.getAttempts()));
	}

}
