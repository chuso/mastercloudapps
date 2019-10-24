package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.ProposalController;
import mastermindWeek3.mastermind.views.MessageView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private ProposalController proposalController;

	AttemptsView(ProposalController proposalController) {
		this.proposalController = proposalController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.proposalController.getAttempts()));
	}

}
