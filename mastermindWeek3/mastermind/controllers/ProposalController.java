package mastermindWeek3.mastermind.controllers;

import java.util.List;

import mastermindWeek3.mastermind.models.Session;
import mastermindWeek3.mastermind.types.Color;
import mastermindWeek3.mastermind.types.Error;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = this.session.addProposedCombination(colors);
		if (error == null && (this.session.isWinner() || this.session.isLooser())) {
			this.session.next();
		}
		return error;	
	}

	public boolean isWinner() {
		return this.session.isWinner();
	}

	public boolean isLooser() {
		return this.session.isLooser();
	}
	
	public int getAttempts() {
		return this.session.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.session.getColors(position);
	}

	public int getBlacks(int position) {
		return this.session.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.session.getWhites(position);
	}

}
