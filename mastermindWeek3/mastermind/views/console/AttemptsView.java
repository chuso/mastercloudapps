package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private PlayController playController;

	AttemptsView(PlayController proposalController) {
		this.playController = proposalController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.playController.getAttempts()));
	}

}
