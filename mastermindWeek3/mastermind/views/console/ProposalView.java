package mastermindWeek3.mastermind.views.console;

import mastermindWeek3.mastermind.controllers.PlayController;
import mastermindWeek3.santaTecla.utils.WithConsoleView;
import mastermindWeek3.mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	PlayController playController;

	public ProposalView(PlayController playController) {
		this.playController = playController;
	}

	void writeln() {
		this.console.writeln();
		new AttemptsView(playController).writeln();
		new SecretCombinationView(playController).writeln();
		for (int i = 0; i < playController.getAttempts(); i++) {
			new ProposedCombinationView(playController).write(i);
			new ResultView(playController).writeln(i);
		}
		if (playController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (playController.isLoser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}
