package mastermindWeek3.mastermind.views.console;

import java.util.List;

import mastermindWeek3.mastermind.controllers.ProposalController;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;
import mastermindWeek3.mastermind.views.console.ErrorView;
import mastermindWeek3.santaTecla.utils.WithConsoleView;
import mastermindWeek3.mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	void interact(ProposalController proposalController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(proposalController).read();
			error = proposalController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		this.console.writeln();
		new AttemptsView(proposalController).writeln();
		new SecretCombinationView(proposalController).writeln();
		for (int i = 0; i < proposalController.getAttempts(); i++) {
			new ProposedCombinationView(proposalController).write(i);
			new ResultView(proposalController).writeln(i);
		}
		if (proposalController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (proposalController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}
