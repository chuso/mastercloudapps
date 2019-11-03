package mastermind.views.console;

import java.util.List;

import mastermind.controllers.ProposalController;
import mastermind.models.Game;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.console.ErrorView;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {

	public List<Color> readColors() {
		return new ProposedCombinationView().read();
	}

	public void printError(Error error) {
		new ErrorView(error).writeln();
	}

	public void printGame(Game game) {
		this.console.writeln();
		new AttemptsView().writeln(game.getAttempts());
		new SecretCombinationView().writeln(game.getWidth());
		for (int i = 0; i < game.getAttempts(); i++) {
			new ProposedCombinationView().write(game.getColors(i));
			new ResultView().writeln(
				game.getBlacks(i),
				game.getWhites(i)
			);
		}
	}

	public void printIsWinner() {
		this.console.writeln(MessageView.WINNER.getMessage());
	}

	public void printIsLoser() {
		this.console.writeln(MessageView.LOOSER.getMessage());
	}

}
