package mastermind.controllers;

import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Game;
import mastermind.models.State;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.console.ProposalView;

public class ProposalController extends Controller {

	public ProposalController(Game game, State state) {
		super(game, state);
	}

	@Override
	public void control() {
		ProposalView proposalView = new ProposalView();
		Error error;
		do {
			List<Color> colors = proposalView.readColors();
			error = this.addProposedCombination(colors);
			if (error != null) {
				proposalView.printError(error);
			}
		} while (error != null);
		proposalView.printGame(this.getGame());
		if (this.isWinner()) {
			proposalView.printIsWinner();
		} else if (this.isLoser()) {
			proposalView.printIsLoser();
		}
	}

	private Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			this.game.addProposedCombination(colors);
			if (this.game.isWinner() || this.game.isLooser()) {
				this.state.next();
			}
		}
		return error;	
	}

	private boolean isWinner() {
		return this.game.isWinner();
	}

	private boolean isLoser() {
		return this.game.isLooser();
	}

	private Game getGame() {
		return this.game;
	}

}
