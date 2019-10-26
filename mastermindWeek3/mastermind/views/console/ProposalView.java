package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.AcceptorController;
import mastermindWeek3.santaTecla.utils.WithConsoleView;
import mastermindWeek3.mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	AcceptorController acceptorController;

	public ProposalView(AcceptorController playController) {
		this.acceptorController = playController;
	}

	void writeln() {
		this.console.writeln();
		new AttemptsView(acceptorController).writeln();
		new SecretCombinationView(acceptorController).writeln();
		for (int i = 0; i < acceptorController.getAttempts(); i++) {
			new ProposedCombinationView(acceptorController).write(i);
			new ResultView(acceptorController).writeln(i);
		}
		if (acceptorController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (acceptorController.isLoser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}
