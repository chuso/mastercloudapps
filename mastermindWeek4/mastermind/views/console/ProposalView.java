package mastermind.views.console;

import java.util.List;

import mastermind.controllers.ProposalController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.console.ErrorView;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

class ProposalView extends WithConsoleView {

	void interact(ProposalController proposalController) {
		Error error;
		do {
			List<Color> colors = this.readColors();
			error = proposalController.addProposedCombination(colors);
			if (error != null) {
				this.printError(error);
			}
		} while (error != null);
		this.printGame(proposalController);
		if (proposalController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (proposalController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

	public List<Color> readColors() {
		return new ProposedCombinationView().read();
	}

	public void printError(Error error) {
		new ErrorView(error).writeln();
	}

	public void printGame(ProposalController proposalController) {
		this.console.writeln();
		new AttemptsView().writeln(proposalController.getAttempts());
		new SecretCombinationView().writeln(proposalController.getWidth());
		for (int i = 0; i < proposalController.getAttempts(); i++) {
			new ProposedCombinationView().write(proposalController.getColors(i));
			new ResultView().writeln(
				proposalController.getBlacks(i),
				proposalController.getWhites(i)
			);
		}
	}

}
